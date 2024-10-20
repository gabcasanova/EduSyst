<%-- 
    Document   : pagina_padrao
    Created on : 4 de jul. de 2024, 18:41:57
    Author     : con_c
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="util.DBUtil"%>
<%@page import="model.Aluno"%> 
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
                    <%@include file="parts/perfil_resp.jsp"%>
                    
                    <!-- Menu Principal -->
                    <div class="col p-3">
                        <!-- Título -->
                        <div class="row mb-5 text-center">
                            <h2>Boletim</h2>
                            <a href="ambiente_resp.jsp"><i class="fa-solid fa-arrow-left"></i> Voltar ao ambiente do aluno</a>
                        </div>
                            
                        <!-- Gerar Tabela com Código MYSQL -->
                        <div class="row p-3">
                            <%  if (responsavel != null) {
                                Connection conn = null;
                                Statement stmt = null;
                                ResultSet rs = null;
                                
                                try {
                                
                                    conn = DBUtil.getConnection(); // Conectar com o banco de dados.
                                    stmt = conn.createStatement(); // Preparar um comando SQL.

                                    String sql =  "select distinct notas.Nome_Materia, turmas.Classe, professores.Nome, "
                                                + "notas.Primeira_Etapa, notas.Segunda_Etapa, notas.Terceira_Etapa, notas.Quarta_Etapa, "
                                                
                                                + "IF( "
                                                    + "notas.Primeira_Etapa IS NOT NULL "
                                                    + "AND notas.Segunda_Etapa IS NOT NULL "
                                                    + "AND notas.Terceira_Etapa IS NOT NULL "
                                                    + "AND notas.Quarta_Etapa IS NOT NULL, "
                                                    + "TRUNCATE(("
                                                        + "notas.Primeira_Etapa + notas.Segunda_Etapa + "
                                                        + "notas.Terceira_Etapa + notas.Quarta_Etapa"
                                                    + ") / 4, 1), 'Indisponível'"
                                                + ") as `media`, "
                                                
                                                + "IF( "
                                                    + "notas.Primeira_Etapa IS NOT NULL "
                                                    + "AND notas.Segunda_Etapa IS NOT NULL "
                                                    + "AND notas.Terceira_Etapa IS NOT NULL "
                                                    + "AND notas.Quarta_Etapa IS NOT NULL, "
                                                    + "IF( "
                                                        + "TRUNCATE(("
                                                            + "notas.Primeira_Etapa + notas.Segunda_Etapa + "
                                                            + "notas.Terceira_Etapa + notas.Quarta_Etapa"
                                                        + ") / 4, 1) >= 6, 'Aprovado', 'Reprovado'"
                                                    + "), 'Indisponível'"
                                                + ") as `situacao` "
                                                
                                    + "from professores "
                                    + "inner join professores_horarios on professores.Id_Professor = professores_horarios.Professor_ID "
                                    + "inner join horarios on horarios.Id_Horario = professores_horarios.Horario_ID "
                                    + "inner join horarios_materias on horarios_materias.Horario_ID = horarios.Id_Horario "
                                    + "inner join materias on materias.Id_Materia = horarios_materias.Materia_ID "
                                    + "inner join turmas on turmas.Id_Turma = horarios_materias.Turma_ID "
                                    + "inner join turmas_alunos on turmas_alunos.Turma_ID = turmas.Id_Turma "
                                    + "inner join alunos on alunos.Id_Aluno = turmas_alunos.Aluno_ID "
                                    + "inner join notas on notas.Aluno_Id = alunos.Id_Aluno "
                                    + "inner join responsaveis on responsaveis.Id_Responsavel = alunos.Responsavel_id "
                                    + "and notas.Professor_ID = professores.Id_Professor where alunos.responsavel_id =" + responsavel.getId() + ";";
                                rs = stmt.executeQuery(sql);
                            %>

                            <table class="table table-striped">
                                <tr>
                                    <th>Matéria</th>
                                    <th>Professor</th>
                                    <th>Classe</th>
                                    <th>1 Bim.</th>
                                    <th>2 Bim.</th>
                                    <th>3 Bim.</th>
                                    <th>4 Bim.</th>
                                    <th>Media Anual</th>
                                    <th>Situação</th>
                                </tr>
                                <%
                                    // Inserir informações do banco de dados.
                                    while (rs.next()) {
                                %>
                                        <tr>
                                            <td><%= rs.getString("notas.Nome_Materia") %></td>
                                            <td><%= rs.getString("professores.Nome") %></td>
                                            <td><%= rs.getString("turmas.classe") %></td>
                                            <td><%= rs.getString("notas.Primeira_Etapa") %></td>
                                            <td><%= rs.getString("notas.Segunda_Etapa") %></td>
                                            <td><%= rs.getString("notas.Terceira_Etapa") %></td>
                                            <td><%= rs.getString("notas.Quarta_Etapa") %></td>
                                            <td><%= rs.getString("media") %></td>
                                            <td><%= rs.getString("situacao") %></td>
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

