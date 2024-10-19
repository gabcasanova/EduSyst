/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AlunoDao;
import dao.ProfessorDao;
import dao.ResponsavelDao;
import model.Aluno;
import model.Professor;
import model.Responsavel;

/**
 *
 * @author con_c
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Receber dados com base no formulário.
        String cpf   = request.getParameter("cpf");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        
        // Link atual da página
        String nomeFormulario = request.getParameter("nomeFormulario");
        
        
        // ALUNO.
        if ("login_aluno".equals(nomeFormulario)) {
            // Criar objeto aluno.
            AlunoDao alunoDao = new AlunoDao();
            Aluno aluno = alunoDao.logarAluno(cpf, email, senha);

            if (aluno != null) {
                HttpSession session = request.getSession();

                session.setAttribute("aluno", aluno);           // Guardar o objeto aluno.
                session.setAttribute("nome", aluno.getNome());  // Definir o nome do aluno
                session.setAttribute("alunoLogado",true);       // Indicar que o aluno está logado.

                response.sendRedirect("ambiente_aluno.jsp");
            } else {
                // Checar se as informações estão corretas.
                boolean cpfExiste = alunoDao.checarSeExiste(cpf);
                if (cpfExiste) {
                    request.setAttribute("errorMessage", "<b>Senha incorreta!</b> Cheque suas informações e tente novamente.");
                } else {
                    request.setAttribute("errorMessage", "<b>CPF não encontrado!</b> Cheque suas informações e tente novamente.");
                }
                request.getRequestDispatcher("login_aluno.jsp").forward(request, response);
            }
        }

        // RESPONSÁVEL.
        if ("login_resp".equals(nomeFormulario)) {
            // Criar objeto responsável.
            ResponsavelDao responsavelDao = new ResponsavelDao();
            Responsavel responsavel = responsavelDao.logarResponsavel(cpf, email, senha);

            if (responsavel != null) {
                HttpSession session = request.getSession();

                session.setAttribute("responsavel", responsavel);     // Guardar o objeto responsável.
                session.setAttribute("nome", responsavel.getNome());  // Definir o nome do responsável
                session.setAttribute("respLogado",true);              // Indicar que o responsável está logado.

                response.sendRedirect("ambiente_resp.jsp");
            } else {
                // Checar se as informações estão corretas.
                boolean cpfExiste = responsavelDao.checarSeExiste(cpf);
                if (cpfExiste) {
                    request.setAttribute("errorMessage", "<b>Senha incorreta!</b> Cheque suas informações e tente novamente.");
                } else {
                    request.setAttribute("errorMessage", "<b>CPF não encontrado!</b> Cheque suas informações e tente novamente.");
                }
                request.getRequestDispatcher("login_resp.jsp").forward(request, response);
            }
        }
        
        // RESPONSÁVEL.
        if ("login_prof".equals(nomeFormulario)) {
            // Criar objeto responsável.
            ProfessorDao professorDao = new ProfessorDao();
            Professor professor = professorDao.logarProfessor(cpf, email, senha);

            if (professor != null) {
                HttpSession session = request.getSession();

                session.setAttribute("professor", professor);       // Guardar o objeto responsável.
                session.setAttribute("nome", professor.getNome());  // Definir o nome do responsável
                session.setAttribute("profLogado",true);            // Indicar que o responsável está logado.

                response.sendRedirect("ambiente_prof.jsp");
            } else {
                // Checar se as informações estão corretas.
                boolean cpfExiste = professorDao.checarSeExiste(cpf);
                if (cpfExiste) {
                    request.setAttribute("errorMessage", "<b>Senha incorreta!</b> Cheque suas informações e tente novamente.");
                } else {
                    request.setAttribute("errorMessage", "<b>CPF não encontrado!</b> Cheque suas informações e tente novamente.");
                }
                request.getRequestDispatcher("login_prof.jsp").forward(request, response);
            }
        }
        
    }
}