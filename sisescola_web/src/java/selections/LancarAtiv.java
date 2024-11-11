/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package selections;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Year;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.DBUtil;

/**
 *
 * @author Aluno
 */
@WebServlet(name = "LancarAtiv", urlPatterns = {"/LancarAtiv"})
public class LancarAtiv extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LancarAtiv</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LancarAtiv at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        String idProfessor = request.getParameter("professorId");
        
        String nomeAtividade = request.getParameter("nomeAtividade");
        String textoAtividade = request.getParameter("textoAtividade");
        String linkAtividade = request.getParameter("linkAtividade");
        String etapa  = request.getParameter("etapa");
        String ano = Integer.toString(Year.now().getValue());
        String turma  = request.getParameter("turma");
        String materia = request.getParameter("materia");
        
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
            
            // Executar statement
            String sql = "insert into atividades "
                       + "(professor_id, nome_atividade, texto_atividade, link_atividade, etapa, ano, turma_id, nome_materia) "
                       + "values (?, ?, ?, ?, ?, ?, ?, ?)";
            
            // Criar PreparedStatement para evitar SQL Injection e trabalhar com parâmetros
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            // Definir os parâmetros para a query
            pstmt.setString(1, idProfessor);
            pstmt.setString(2, nomeAtividade);
            pstmt.setString(3, textoAtividade);
            pstmt.setString(4, linkAtividade);
            pstmt.setString(5, etapa);
            pstmt.setString(6, ano);
            pstmt.setString(7, idTurma);
            pstmt.setString(8, materia);
            
            // Executar o comando SQL
            pstmt.executeUpdate();
            request.getRequestDispatcher("ambiente_prof_atividades.jsp").forward(request, response);
            
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
