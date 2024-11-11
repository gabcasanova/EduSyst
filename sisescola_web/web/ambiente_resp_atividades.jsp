<%-- 
    Document   : pagina_padrao
    Created on : 4 de jul. de 2024, 18:41:57
    Author     : con_c
--%>

<%@page import="java.time.Year"%>
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
                            <h2>Matérias</h2>
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
                                    
                                    String sql = "select distinct professores.nome, atividades.Nome_Materia, atividades.Etapa, "
                                    + "atividades.Nome_Atividade, atividades.Texto_Atividade, atividades.Link_Atividade "
                                    + "from atividades "
                                    + "inner join turmas on turmas.id_turma = atividades.turma_id "
                                    + "inner join turmas_alunos on turmas_alunos.turma_id = turmas.id_turma "
                                    + "inner join alunos on alunos.id_aluno = turmas_alunos.aluno_id "
                                    + "inner join responsaveis on responsaveis.Id_Responsavel = alunos.Responsavel_id "
                                    + "inner join professores on professores.id_professor = atividades.professor_id "
                                    + "where alunos.responsavel_id =" + responsavel.getId()
                                    + " and atividades.ano=" + Year.now().getValue();
                                    rs = stmt.executeQuery(sql); // Executar o comando SQL.
                            %>

                            <table class="table table-striped">
                                <tr>
                                    <th>Professor</th>
                                    <th>Matéria</th>
                                    <th>Bim.</th>
                                    <th>Nome</th>
                                    <th>Texto</th>
                                    <th>Link</th>
                                </tr>
                                <%
                                    // Inserir informações do banco de dados.
                                    while (rs.next()) {
                                %>
                                        <tr>
                                            <td><%= rs.getString("professores.nome") %></td>
                                            <td><%= rs.getString("atividades.Nome_Materia") %></td>
                                            <td><%= rs.getString("atividades.Etapa") %></td>
                                            <td><%= rs.getString("atividades.Nome_Atividade") %></td>
                                            <td><%= rs.getString("atividades.Texto_Atividade") %></td>
                                            <td>Acesso do link somente para alunos.</td>
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

