/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package selections;

import java.io.IOException;
import java.io.PrintWriter;
//import java.math.BigDecimal;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.time.Year;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DBUtil;

/**
 *
 * @author con_c
 */
public class LancarNota extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /*protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LancarNota</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LancarNota at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }*/

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Receber dados com base no formulário.
        String ano = Integer.toString(Year.now().getValue());
        String idProfessor = request.getParameter("professorId");
        
        String turma  = request.getParameter("turma");
        String aluno = request.getParameter("aluno");
        String materia = request.getParameter("materia");
        
        String primeira_etapa = request.getParameter("primeira_etapa");
        String segunda_etapa = request.getParameter("segunda_etapa");
        String terceira_etapa = request.getParameter("terceira_etapa");
        String quarta_etapa = request.getParameter("quarta_etapa");
        
        // MySQL
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = DBUtil.getConnection(); // Conectar com o banco de dados.
            stmt = conn.createStatement(); // Preparar um comando SQL.
        
            // Obter id da turma
            String idTurma = null;
            String sql_turma = "select turmas.id_turma from turmas "
                    + "where turmas.classe = " + turma
                    + " and turmas.ano = " + Year.now().getValue();
            rs = stmt.executeQuery(sql_turma); // Executar o comando SQL.
            if (rs.next()) {
                idTurma = rs.getString("turmas.id_turma");
            }
            
            // Obter id do aluno
            String idAluno = null;
            String sql_aluno = "select distinct id_aluno from alunos "
                    + "inner join turmas_alunos on turmas_alunos.Aluno_ID = alunos.Id_Aluno "
                    + "where turmas_alunos.Turma_ID = " + idTurma
                    + " and alunos.nome = '" + aluno + "'";
            rs = stmt.executeQuery(sql_aluno); // Executar o comando SQL.
            if (rs.next()) {
                idAluno = rs.getString("alunos.id_aluno");
            }
            
            if (primeira_etapa == ""){primeira_etapa=null;};
            if (segunda_etapa == ""){segunda_etapa=null;};
            if (terceira_etapa == ""){terceira_etapa=null;};
            if (quarta_etapa == ""){quarta_etapa=null;};
            
            // Mostrar variáveis
            /*try (PrintWriter out = response.getWriter()) {
                out.println("<h1> Id da Turma: " + idTurma + "</h1>");
                out.println("<h1> Id do Aluno: " + idAluno + "</h1>");
                out.println("<h1> Id do Professor: " + idProfessor + "</h1>");
                out.println("<h1> Id do Professor: " + idProfessor + "</h1>");
                out.println("<h1> Ano: " + ano + "</h1>");
                out.println("<h1> Nota 1a etapa: " + primeira_etapa + "</h1>");
                out.println("<h1> Nota 2a etapa: " + segunda_etapa + "</h1>");
                out.println("<h1> Nota 3a etapa: " + terceira_etapa + "</h1>");
                out.println("<h1> Nota 4a etapa: " + quarta_etapa + "</h1>");
            }*/
            
            String sql = "INSERT INTO Notas (Aluno_ID, Professor_ID, Primeira_Etapa, Segunda_Etapa, Terceira_Etapa, Quarta_Etapa, Nome_Materia, Ano) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?) "
            + "ON DUPLICATE KEY UPDATE "
            + "Primeira_Etapa = IF(VALUES(Primeira_Etapa) IS NOT NULL, VALUES(Primeira_Etapa), Primeira_Etapa), "
            + "Segunda_Etapa = IF(VALUES(Segunda_Etapa) IS NOT NULL, VALUES(Segunda_Etapa), Segunda_Etapa), "
            + "Terceira_Etapa = IF(VALUES(Terceira_Etapa) IS NOT NULL, VALUES(Terceira_Etapa), Terceira_Etapa), "
            + "Quarta_Etapa = IF(VALUES(Quarta_Etapa) IS NOT NULL, VALUES(Quarta_Etapa), Quarta_Etapa);";

            // Criar PreparedStatement para evitar SQL Injection e trabalhar com parâmetros
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // Definir os parâmetros para a query
            pstmt.setString(1, idAluno);
            pstmt.setString(2, idProfessor);

            // Se as etapas forem nulas, definimos como null no PreparedStatement
            pstmt.setString(3, primeira_etapa);
            pstmt.setString(4, segunda_etapa);
            pstmt.setString(5, terceira_etapa);
            pstmt.setString(6, quarta_etapa);

            pstmt.setString(7, materia);
            pstmt.setString(8, ano);

            // Executar o comando SQL
            pstmt.executeUpdate();
            
            request.getRequestDispatcher("ambiente_prof_notas.jsp").forward(request, response);
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(LancarNota.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
