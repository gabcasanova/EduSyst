<%-- 
    Document   : pagina_padrao
    Created on : 4 de jul. de 2024, 18:41:57
    Author     : con_c
--%>

<%@page import="java.time.Year"%>
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
                            <h2>Minhas Turmas</h2>
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

                                    String sql = "select distinct turmas.ano, turmas.classe, materias.nome from alunos "
                                    + "inner join turmas_alunos on turmas_alunos.Aluno_ID = alunos.Id_Aluno "
                                    + "inner join turmas on turmas.Id_Turma = turmas_alunos.Turma_ID "
                                    + "inner join Horarios_Materias on Horarios_Materias.Turma_ID = turmas.Id_Turma "
                                    + "inner join materias on horarios_materias.Materia_ID = materias.Id_Materia "
                                    + "inner join horarios on horarios.Id_Horario = horarios_materias.Horario_ID "
                                    + "inner join professores_horarios on professores_horarios.Horario_ID = horarios.Id_Horario "
                                    + "inner join professores on professores.Id_Professor = professores_horarios.Professor_ID "
                                    + "where professores.Id_Professor = " + professor.getId() 
                                    + " and turmas.ano = " + Year.now().getValue()
                                    + " order by turmas.ano, turmas.classe, materias.nome asc;";
                                    rs = stmt.executeQuery(sql); // Executar o comando SQL.
                            %>

                            <table class="table table-striped">
                                <tr>
                                    <th>Ano</th>
                                    <th>Turma</th>
                                    <th>Matéria</th>
                                </tr>
                                <%
                                    // Inserir informações do banco de dados.
                                    while (rs.next()) {
                                %>
                                        <tr>
                                            <td><%= rs.getString("turmas.ano") %></td>
                                            <td><%= rs.getString("turmas.classe") %></td>
                                            <td><%= rs.getString("materias.nome") %></td>
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

