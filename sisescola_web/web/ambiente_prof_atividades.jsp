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
                            <h2>Aplicar Atividades</h2>
                            <a href="ambiente_prof.jsp"><i class="fa-solid fa-arrow-left"></i> Voltar ao ambiente do professor</a>
                        </div>
                        
                        <!-- Atividades lançadas -->
                        <div class="row p-3"> 
                            <hr>
                            <h3 class="text-center mb-4">Atividades Lançadas: </h3>
                            
                            <%  if (professor != null) {
                                Connection conn = null;
                                Statement stmt = null;
                                ResultSet rs = null;
                                
                                try {
                                
                                    conn = DBUtil.getConnection(); // Conectar com o banco de dados.
                                    stmt = conn.createStatement(); // Preparar um comando SQL.

                                    String sql =  "select distinct atividades.Id_Atividade, turmas.Classe, "
                                    + "atividades.Nome_Materia, atividades.Etapa, atividades.Nome_Atividade, "
                                    + "atividades.Texto_Atividade, atividades.Link_Atividade "
                                    + "from atividades "
                                    + "inner join turmas on turmas.id_turma = atividades.turma_id "
                                    + "inner join professores on professores.id_professor = atividades.professor_id "
                                    + "and professores.Id_Professor=" + professor.getId();
                                    rs = stmt.executeQuery(sql);
                            %>

                            <table class="table table-striped">
                                <tr>
                                    <th>ID</th>
                                    <th>Turma</th>
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
                                            <td><%= rs.getString("atividades.Id_Atividade") %></td>
                                            <td><%= rs.getString("turmas.Classe") %></td>
                                            <td><%= rs.getString("atividades.Nome_Materia") %></td>
                                            <td><%= rs.getString("atividades.Etapa") %></td>
                                            <td><%= rs.getString("atividades.Nome_Atividade") %></td>
                                            <td><%= rs.getString("atividades.Texto_Atividade") %></td>
                                            <td><a href="http://<%= rs.getString("atividades.Link_Atividade") %>"><%= rs.getString("atividades.Link_Atividade") %></a></td>
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
                        
                        <!-- Formulário -->
                        <div class="row p-3">     
                            <hr>
                            <h3 class="text-center">Lançar uma atividade:</h3>
                            
                            <form class="" action="LancarAtiv" method="get">
                                <!-- Enviar ID do professor -->
                                <input type="hidden" name="professorId" value="<%= professor.getId() %>">    
                                
                                <label class="form-label" for="nomeAtividade">Nome da atividade:</label>
                                <input type="text" class="form-control mb-4" id="nomeAtividade" name="nomeAtividade" required>
                                
                                <label class="form-label" for="textoAtividade">Texto da atividade:</label>
                                <textarea rows="5" class="form-control mb-4" id="textoAtividade" name="textoAtividade" required></textarea>
                                
                                <label class="form-label" for="linkAtividade">Link da atividade:</label>
                                <p><small>Sugestão: crie um formulário utilizando o <a href="http://forms.google.com/" target="blank">Google Forms</a></small></p>
                                <input type="text" class="form-control mb-4" id="linkAtividade" name="linkAtividade">
                                
                                <div class="row text-center">
                                    <div class="col"> <!-- TURMA -->
                                        <label class="form-label" for="turma">Turma: </label>
                                        <select class="form-select" name="turma" id="turma" required>
                                            <option value="" selected hidden>Escolha uma turma</option>
                                        </select>
                                    </div>

                                    <div class="col"> <!-- Matéria -->
                                        <label class="form-label" for="materia">Matéria: </label>
                                        <select class="form-select" name="materia" id="materia" required disabled>
                                            <option value="" selected hidden>Escolha uma matéria</option>
                                        </select>
                                    </div>
                                    
                                    <div class="col"> <!-- Etapa -->
                                        <label class="form-label" for="etapa">Bimestre: </label>
                                        <select class="form-select" name="etapa" id="v" required>
                                            <option value="" selected hidden>Escolha o bimestre:</option>
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                            <option value="4">4</option>
                                        </select>
                                    </div>
                                </div>
                                
                                <div class="text-center">
                                    <br><br>
                                    <input class="btn btn-light" type="submit" value="Lançar">
                                </div>
                            </form>
                        </div>
                                
                        <!-- Deletar -->
                        <div class="row p-3 text-center justify-content-center">
                            <hr>
                            <h3 class>Apagar uma atividade:</h3>
                            <p>Caso deseje apagar uma atividade, informe o seu identificador (ID).
                            
                            <div class ="col-3">
                                <form class="mb-4" action="ApagarAtiv" method="get">
                                    <!-- Enviar ID do professor -->
                                    <input type="hidden" name="professorId" value="<%= professor.getId() %>">    
                                    
                                    <label class="form-label" for="ativNum">ID:</label>
                                    <input class="form-control" type="number" step="1" id="ativNum" name="ativNum" min="1">
                                    
                                    <br><br>
                                    <input class="btn btn-light" type="submit" value="Apagar">
                                </form>
                            </div>
                            <hr>
                        </div>
                    </div>
                </div>
            </div>
        </main>
                    
        <!-- Server-side logic -->
        <% if (professor != null) {
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;

            try {
                conn = DBUtil.getConnection(); // Conectar com o banco de dados.
                stmt = conn.createStatement(); // Preparar um comando SQL.
        %>
        
        <!-- OBTER TURMAS -->
        <%
                // Generate options for 'turma'
                String sql_turmas = "select distinct classe from professores "
                + "inner join professores_horarios on professores_horarios.professor_id = professores.id_professor "
                + "inner join horarios on horarios.id_horario = professores_horarios.horario_id "
                + "inner join horarios_materias on horarios_materias.horario_id = horarios.id_horario "
                + "inner join turmas on turmas.id_turma = horarios_materias.turma_id "
                + "where turmas.ano = " + Year.now().getValue()
                + " and professores.id_professor = " + professor.getId();
                rs = stmt.executeQuery(sql_turmas); // Executar o comando SQL.

                // Output turma options
                while (rs.next()) {
        %>
                    <script>
                        turmaOption = document.createElement('option');
                        turmaOption.value = "<%= rs.getString("classe") %>";
                        turmaOption.innerHTML = "<%= rs.getString("classe") %>";
                        document.getElementById("turma").appendChild(turmaOption);
                    </script>
        <%
                }
        %>
        
        <!-- OBTER MATÉRIAS -->
        <%
                // Generate options for 'turma'
                String sql_materias = "select distinct materias.nome, turmas.classe from professores "
                + "inner join professores_horarios on professores_horarios.professor_id = professores.id_professor "
                + "inner join horarios on horarios.id_horario = professores_horarios.horario_id "
                + "inner join horarios_materias on horarios_materias.horario_id = horarios.id_horario "
                + "inner join materias on materias.id_materia = horarios_materias.materia_id "
                + "inner join turmas on turmas.id_turma = horarios_materias.turma_id "
                + "where professores.Id_Professor =" + professor.getId()
                + " and turmas.ano = " + Year.now().getValue()
                // + " and turmas.classe = " + "901"
                + " order by turmas.classe, materias.nome";
                rs = stmt.executeQuery(sql_materias); // Executar o comando SQL.

                // Output turma options
                while (rs.next()) {
        %>
                    <script>
                        materiaOption = document.createElement('option');
                        materiaOption.value = "<%= rs.getString("materias.nome") %>";
                        materiaOption.innerHTML = "<%= rs.getString("materias.nome") + " - " + rs.getString("turmas.classe") %>";
                        document.getElementById("materia").appendChild(materiaOption);
                        // document.getElementById("materia").removeAttribute("disabled");
                    </script>
        <%
                }
        %>
       
        <!-- FIM -->
        <%
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            }
        } %>

        <script>
            let turmaSelect = document.getElementById("turma");
            let materiaSelect = document.getElementById("materia");
            
            // Resetar se mudar turma
            function reset() {
                materiaSelect.selectedIndex = 0;
                materiaSelect.disabled = true;
            }
            turmaSelect.addEventListener("change", reset);
            
            // FILTRAR MATÉRIAS COM BASE EM TURMA
            function obterMaterias() {
                let currentTurma = turmaSelect.value;
                materiaSelect.removeAttribute("disabled")    

                for (var i = 0; i < materiaSelect.length; i++) {
                    let nomeMateria = materiaSelect.options[i].text;
                    let turmaMateria = nomeMateria.split(" - ")[1]; // Split by " - " to get the turma part

                    if (turmaMateria !== currentTurma) {
                        materiaSelect.options[i].disabled = true; // Disable the option
                        materiaSelect.options[i].style.display = 'none'; // Hide the option
                    } else {
                        materiaSelect.options[i].disabled = false;
                        materiaSelect.options[i].style.display = 'block';
                    }
                }
            }
            
            turmaSelect.addEventListener("change", obterMaterias);

        </script>

        <!-- Rodapé -->
        <%@include file="parts/footer.jsp"%>
    </body>   
</html>

