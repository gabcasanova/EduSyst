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
                            <h2>Aplicar Notas</h2>
                            <a href="ambiente_prof.jsp"><i class="fa-solid fa-arrow-left"></i> Voltar ao ambiente do professor</a>
                        </div>
                            
                        <!-- TABELA DE NOTAS -->
                        <hr>
                        <div class="row p-3 text-center">
                            <h3 class="mb-4">Notas Lançadas:</h3>
                            
                            <%  if (professor != null) {
                                Connection conn = null;
                                Statement stmt = null;
                                ResultSet rs = null;
                                
                                try {
                                
                                    conn = DBUtil.getConnection(); // Conectar com o banco de dados.
                                    stmt = conn.createStatement(); // Preparar um comando SQL.

                                    String sql =  "select distinct notas.nome_materia, alunos.nome, turmas.classe, "
                                    + "notas.primeira_etapa, notas.segunda_etapa, notas.terceira_etapa, notas.quarta_etapa, "
                                    + "IF( "
                                        + "notas.Primeira_Etapa IS NOT NULL AND "
                                        + "notas.Segunda_Etapa IS NOT NULL AND "
                                        + "notas.Terceira_Etapa IS NOT NULL AND "
                                        + "notas.Quarta_Etapa IS NOT NULL, " 
                                        + "TRUNCATE( ("
                                            + "notas.Primeira_Etapa + notas.Segunda_Etapa + notas.Terceira_Etapa + notas.Quarta_Etapa"
                                        + ") / 4, 1),"
                                        
                                    + "'Indisponível') AS media, "
                                    + "IF( "
                                        + "notas.Primeira_Etapa IS NOT NULL AND "
                                        + "notas.Segunda_Etapa IS NOT NULL AND "
                                        + "notas.Terceira_Etapa IS NOT NULL AND "
                                        + "notas.Quarta_Etapa IS NOT NULL, "
                                        + "IF( "
                                            + "TRUNCATE( ("
                                                + "notas.Primeira_Etapa + notas.Segunda_Etapa + notas.Terceira_Etapa + notas.Quarta_Etapa"
                                            + ") / 4, 1) >= 5.6, 'Aprovado', 'Reprovado'), "
                                        + "'Indisponível') AS situacao from alunos "
                                        + "inner join turmas_alunos on turmas_alunos.aluno_id = alunos.id_aluno "
                                        + "inner join turmas on turmas.id_turma = turmas_alunos.turma_id "
                                        + "inner join notas on alunos.id_aluno = notas.aluno_id "
                                        + "inner join professores on professores.id_professor = notas.professor_id "
                                        + "where turmas.ano = " + Year.now().getValue()
                                        + " and professores.id_professor = " + professor.getId()
                                        + " order by notas.nome_materia, alunos.nome asc;";
                                rs = stmt.executeQuery(sql);
                            %>

                            <table class="table table-striped">
                                <tr>
                                    <th>Matéria</th>
                                    <th>Nome</th>
                                    <th>Turma</th>
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
                                            <td><%= rs.getString("notas.nome_materia") %></td>
                                            <td><%= rs.getString("alunos.nome") %></td>
                                            <td><%= rs.getString("turmas.classe") %></td>
                                            <td><%= rs.getString("notas.primeira_etapa") %></td>
                                            <td><%= rs.getString("notas.segunda_etapa") %></td>
                                            <td><%= rs.getString("notas.terceira_etapa") %></td>
                                            <td><%= rs.getString("notas.quarta_etapa") %></td>
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
                        <hr>
                        
                        <!-- LANÇAMENTO DE NOTAS -->
                        <div class="row p-3">
                            <h3 class="mb-4 text-center">Lançar (ou editar) uma Nota:</h3>
                            <p class="text-center">Selecione a turma, o aluno e a matéria para o lançamento da nota. Se algum bimestre for deixado em branco, a nota anterior, se disponível no sistema, será mantida.</p>
                            
                            <form class="text-center" action="LancarNota" method="get">
                                <!-- Enviar ID do professor -->
                                <input type="hidden" name="professorId" value="<%= professor.getId() %>">      
                                
                                <div class="row mb-3">
                                    <div class="col-3"> <!-- TURMA -->
                                        <label class="form-label" for="cars">Turma:</label>
                                        <select class="form-select" name="turma" id="turma" required>
                                            <option value="" selected disabled hidden>Escolha uma turma</option>
                                        </select>
                                    </div>
                                    
                                    <div class="col"> <!-- ALUNO -->
                                        <label class="form-label" for="cars">Aluno:</label>
                                        <select class="form-select" name="aluno" id="aluno" required disabled>
                                            <option value="" selected disabled hidden>Escolha um aluno</option>
                                        </select>
                                    </div>
                                </div>
                                
                                <div class="row">
                                    <div class="col-3"> <!-- TURMA -->
                                        <label class="form-label" for="cars">Matéria:</label>
                                        <select class="form-select" name="materia" id="materia" required disabled>
                                            <option value="" selected disabled hidden>Escolha uma matéria</option>
                                        </select>
                                    </div>
                                    
                                    <div class="col"> <!-- 1o Bim. -->
                                        <label class="form-label" for="cars">1º Bimestre:</label>
                                        <input class="form-control" type="number" step="0.1" id="primeira_etapa" name="primeira_etapa" min="0" max="10" disabled>
                                    </div>
                                    <div class="col"> <!-- 2o Bim. -->
                                        <label class="form-label" for="cars">2º Bimestre:</label>
                                        <input class="form-control" type="number" step="0.1" id="segunda_etapa" name="segunda_etapa" min="0" max="10" disabled>
                                    </div>
                                    <div class="col"> <!-- 1o Bim. -->
                                        <label class="form-label" for="cars">3º Bimestre:</label>
                                        <input class="form-control" type="number" step="0.1" id="terceira_etapa" name="terceira_etapa" min="0" max="10" disabled>
                                    </div>
                                    <div class="col"> <!-- 2o Bim. -->
                                        <label class="form-label" for="cars">4º Bimestre:</label>
                                        <input class="form-control" type="number" step="0.1" id="quarta_etapa" name="quarta_etapa" min="0" max="10" disabled>
                                    </div>
                                </div>
                                
                                <br><br>
                                <input class="btn btn-light" type="submit" value="Enviar">
                            </form>
                        </div>
                        
                    </div>
                </div>
            </div>
        </main>

        <!-- Rodapé -->
        <%@include file="parts/footer.jsp"%>
    </body>
    
    <!-- Server-side logic -->
    <% if (professor != null) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection(); // Conectar com o banco de dados.
            stmt = conn.createStatement(); // Preparar um comando SQL.

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
            
            // Generate options for 'aluno'
            String sql_alunos = "select distinct alunos.nome, alunos.email, responsaveis.nome, responsaveis.email, turmas.classe, turmas.ano from alunos "
            + "inner join responsaveis on responsaveis.Id_Responsavel = alunos.Responsavel_ID "
            + "inner join turmas_alunos on turmas_alunos.Aluno_ID = alunos.Id_Aluno "
            + "inner join turmas on turmas.Id_Turma = turmas_alunos.Turma_ID "
            + "inner join Horarios_Materias on Horarios_Materias.Turma_ID = turmas.Id_Turma "
            + "inner join horarios on horarios.Id_Horario = horarios_materias.Horario_ID "
            + "inner join professores_horarios on professores_horarios.Horario_ID = horarios.Id_Horario "
            + "inner join professores on professores.Id_Professor = professores_horarios.Professor_ID "
            + "where professores.Id_Professor =" + professor.getId()
            + " and turmas.ano = " + Year.now().getValue()
            // + " and turmas.classe = " + "901"
            + " order by turmas.ano, turmas.classe, alunos.nome asc";
            rs = stmt.executeQuery(sql_alunos); // Executar o comando SQL.

            while (rs.next()) {
    %>
                <script>
                    alunoOption = document.createElement('option');
                    alunoOption.value = "<%= rs.getString("alunos.nome")%>";
                    alunoOption.innerHTML = "<%= rs.getString("alunos.nome") + " - " + rs.getString("turmas.classe") %>";
                    document.getElementById("aluno").appendChild(alunoOption);
                    // document.getElementById("aluno").removeAttribute("disabled");
                </script>
    <%
            }
            
            // Generate options for 'matéria'
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
        let alunoSelect = document.getElementById("aluno");
        let materiaSelect = document.getElementById("materia");
        
        let primeiraEtapa = document.getElementById("primeira_etapa")
        let segundaEtapa = document.getElementById("segunda_etapa")
        let terceiraEtapa = document.getElementById("terceira_etapa")
        let quartaEtapa = document.getElementById("quarta_etapa")
        
        // FILTRAR ALUNOS COM BASE EM TURMA
        function obterAlunos() {
            let currentTurma = turmaSelect.value;
            alunoSelect.removeAttribute("disabled")    
            
            for (var i = 0; i < alunoSelect.length; i++) {
                let nomeAluno = alunoSelect.options[i].text;
                let turmaAluno = nomeAluno.split(" - ")[1]; // Split by " - " to get the turma part

                if (turmaAluno !== currentTurma) {
                    alunoSelect.options[i].disabled = true; // Disable the option
                    alunoSelect.options[i].style.display = 'none'; // Hide the option
                } else {
                    alunoSelect.options[i].disabled = false;
                    alunoSelect.options[i].style.display = 'block';
                }
            }
            
            alunoSelect.selectedIndex = 0;
            materiaSelect.selectedIndex = 0;
            
            materiaSelect.disabled = true;
            primeiraEtapa.disabled = true;
            segundaEtapa.disabled = true;
            terceiraEtapa.disabled = true;
            quartaEtapa.disabled = true;
        }
        turmaSelect.addEventListener("change", obterAlunos);
        
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
        alunoSelect.addEventListener("change", obterMaterias);
        
        // DEIXAR NOTAS EDITÁVEIS
        function liberarNotas() {
            primeiraEtapa.disabled = false;
            segundaEtapa.disabled = false;
            terceiraEtapa.disabled = false;
            quartaEtapa.disabled = false;
        }
        materiaSelect.addEventListener("change", liberarNotas);
    </script>
</html>

