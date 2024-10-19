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
                            <h2>Meus Horários</h2>
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

                                    String sql = "select horarios.Dia_Semana, horarios.Turno, horarios.Inicio, horarios.Fim, materias.Nome, professores.Nome, turmas.Classe from professores "
                                    + "inner join professores_horarios on professores.Id_Professor = professores_horarios.Professor_ID "
                                    + "inner join horarios on horarios.Id_Horario = professores_horarios.Horario_ID "
                                    + "inner join horarios_materias on horarios_materias.Horario_ID = horarios.Id_Horario "
                                    + "inner join materias on materias.Id_Materia = horarios_materias.Materia_ID "
                                    + "inner join turmas on turmas.Id_Turma = horarios_materias.Turma_ID "
                                    + "inner join turmas_alunos on turmas_alunos.Turma_ID = turmas.Id_Turma "
                                    + "inner join alunos on alunos.Id_Aluno = turmas_alunos.Aluno_ID "
                                    + "where alunos.Id_Aluno =" + aluno.getId() + ";";
                                    rs = stmt.executeQuery(sql); // Executar o comando SQL.
                            %>

                            <table class="table table-striped">
                                <tr>
                                    <th>Dia da Semana</th>
                                    <th>Turno</th>
                                    <th>Início</th>
                                    <th>Fim</th>
                                    <th>Matéria</th>
                                    <th>Professor</th>
                                    <th>Classe</th>
                                </tr>
                                <%
                                    // Inserir informações do banco de dados.
                                    while (rs.next()) {
                                %>
                                        <tr>
                                            <td><%= rs.getString("horarios.Dia_Semana") %></td>
                                            <td><%= rs.getString("horarios.Turno") %></td>
                                            <td><%= rs.getString("horarios.Inicio") %></td>
                                            <td><%= rs.getString("horarios.Fim") %></td>
                                            <td><%= rs.getString("materias.nome") %></td>
                                            <td><%= rs.getString("professores.Nome") %></td>
                                            <td><%= rs.getString("turmas.Classe") %></td>
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

