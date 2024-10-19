<%-- 
    Document   : pagina_padrao
    Created on : 4 de jul. de 2024, 18:41:57
    Author     : con_c
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.util.*" %>
<%@page import="util.DBUtil" %> <!-- Import your DB utility class -->
<!DOCTYPE html>
<html>
    <head>
        <%@include file="parts/meta.jsp"%>

        <!-- Carregar bibliotecas -->
        <link rel="stylesheet" href="styles/bootstrap.min.css">
        <script src="js/bootstrap.bundle.min.js"></script>
        <script src="https://kit.fontawesome.com/19e40268ee.js" crossorigin="anonymous"></script>

        <title>EduSyst</title>
        <link rel="stylesheet" href="styles/styles.css">
    </head>

    <body>
        <!-- Barra de Navegação -->
        <%@include file="parts/header.jsp"%>

        <!-- Página -->
        <main>
            <div class="container">
                <div id="pagina" class="row justify-content-md-center min-vh-100">
                    <!-- Barra Lateral / Perfil do Usuário -->
                    <%@include file="parts/perfil_aluno.jsp"%>
                    
                    <!-- Menu Principal -->
                    <div class="col p-3">
                        <!-- Título -->
                        <div class="row mb-5 text-center">
                            <h2>Minha Turma</h2>
                            <a href="ambiente_aluno.jsp"><i class="fa-solid fa-arrow-left"></i> Voltar ao ambiente do aluno</a>
                        </div>
                        
                        <!-- Gerar Tabela com Código MYSQL -->
                        <div class="row p-3">
                            <%  if (aluno != null) {
                                Connection conn = null;
                                Statement stmt = null;
                                ResultSet rs = null;
                                
                                try {
                                
                                    conn = DBUtil.getConnection(); // Conectar com o banco de dados.
                                    stmt = conn.createStatement(); // Preparar um comando SQL.

                                    String sql = "SELECT alunos.nome, alunos.email, turmas.classe FROM alunos "
                                    + "INNER JOIN turmas_alunos ON turmas_alunos.aluno_id = alunos.id_aluno "
                                    + "INNER JOIN turmas ON turmas.id_turma = turmas_alunos.turma_id "
                                    + "WHERE turmas_alunos.turma_id IN ( "
                                    + "SELECT turma_id FROM turmas_alunos WHERE aluno_id = " + aluno.getId() + ");";
                                    rs = stmt.executeQuery(sql); // Executar o comando SQL.
                            %>

                            <table class="table table-striped">
                                <tr>
                                    <th>Aluno</th>
                                    <th>Email</th>
                                    <th>Classe</th>
                                </tr>
                                <%
                                    // Inserir informações do banco de dados.
                                    while (rs.next()) {
                                %>
                                        <tr>
                                            <td><%= rs.getString("alunos.nome") %></td>
                                            <td><%= rs.getString("alunos.email") %></td>
                                            <td><%= rs.getString("turmas.classe") %></td>
                                        </tr>
                                <%
                                        }
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    } finally {
                                        // Close resources
                                        if (rs != null) rs.close();
                                        if (stmt != null) stmt.close();
                                        if (conn != null) conn.close();
                                    }

                                    }
                                %>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </main>

        <!-- Rodapé -->
        <%@include file="parts/footer.jsp"%>
    </body>
</html>

