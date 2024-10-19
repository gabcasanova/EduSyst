<%-- 
    Document   : pagina_padrao
    Created on : 4 de jul. de 2024, 18:41:57
    Author     : con_c
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="util.DBUtil"%>
<%@ page import="java.sql.*, java.util.*" %>

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
                    <%@include file="parts/perfil_prof.jsp"%>
                    
                    <!-- Menu Principal -->
                    <div class="col p-3">
                        <!-- Título -->
                        <div class="row mb-5 text-center">
                            <h2>Todos os Professores</h2>
                            <a href="ambiente_prof.jsp"><i class="fa-solid fa-arrow-left"></i> Voltar ao ambiente do professor</a>
                        </div>
                            
                        <!-- Gerar Tabela com Código MYSQL -->
                        <div class="row p-3">
                            <%  if (professor != null) {
                                Connection conn = null;
                                Statement stmt = null;
                                ResultSet rs = null;
                                
                                try {
                                
                                    conn = DBUtil.getConnection(); // Conectar com o banco de dados.
                                    stmt = conn.createStatement(); // Preparar um comando SQL.

                                    String sql = "select professores.nome, professores.email from professores order by professores.nome asc;";
                                    rs = stmt.executeQuery(sql); // Executar o comando SQL.
                            %>

                            <table class="table table-striped">
                                <tr>
                                    <th>Nome</th>
                                    <th>Email</th>
                                </tr>
                                <%
                                    // Inserir informações do banco de dados.
                                    while (rs.next()) {
                                %>
                                        <tr>
                                            <td><%= rs.getString("professores.nome") %></td>
                                            <td><%= rs.getString("professores.email") %></td>
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

