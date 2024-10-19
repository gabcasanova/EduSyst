<%-- 
    Document   : alunoPerfil
    Created on : 10 de ago. de 2024, 22:30:05
    Author     : con_c
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.File"%>
<%@page import="model.Aluno"%>
<%@page import="selections.Select"%>

<!DOCTYPE html>
<!-- Barra Lateral / Perfil do Usuário -->
<div class="col-3 p-3 user_bar d-flex flex-row flex-wrap justify-content-center align-items-stretch align-content-between">
    <%
        // Se aluno existir, mostrar informações:
        Aluno aluno = (Aluno) session.getAttribute("aluno"); // Transformar atributo em objeto aluno
        if (aluno != null) {
            Select selection = new Select();
            
            String pfpPadrao = "img/perfis/pfp_default.png";
            String localPfp = "/img/perfis/pfp_aluno_" + aluno.getId() + ".png"; 
            File alunoPfp = new File(getServletContext().getRealPath(localPfp)); // Caminho completo no servidor
            boolean pfpExiste = alunoPfp.exists(); 
    %>
        <div>
            <div class="text-center m-2 mb-3">
                <!-- Definir foto de perfil -->
                <%if (pfpExiste) { %>
                    <img class="pfp" src="<%= request.getContextPath() + localPfp %>" alt="foto do aluno"/>
                <%}else { %>
                    <img class="pfp" src="<%= pfpPadrao %>" alt="foto do aluno"/>
                <%} %>
            </div>
            <p class="text-center">Aluno</p>
            <h2 class="text-center"><%= aluno.getNome() %></h2>

            <p class="text-center mt-5"><strong><i class="fa-solid fa-user-graduate"></i> Suas Informações:</strong></p>
            <ul class="lista_info">
                <li><strong>Turma </strong> <%= selection.obterTurma(aluno.getId()) %></li>
                <li><strong>Etapa: </strong> <%= selection.obterEtapa(aluno.getId()) %></li>
                <li><br></li>
                <li><strong>CPF: </strong><%= aluno.getCpf() %></li>
                <li><strong>Email: </strong><%= aluno.getEmail() %></li>
                <li><strong>Data de Nascimento: </strong><%= aluno.getDataNasc() %></li>
                <li><strong>Endereço: </strong><%= aluno.getEndereco() %></li>
                <li><strong>Telefone: </strong><%= aluno.getTelefone() %></li>
                <li><strong>Gênero: </strong><%= aluno.getGenero() %></li>
                <li><br></li>
                <li><strong>Responsável: </strong> <%= selection.obterResponsavel(aluno.getId()) %></li>                                    
            </ul>
        </div>
    <%
        }
    %>

    <!-- Logout -->
    <div>
        <a href="ambiente_aluno_config.jsp">
            <input type="submit" class="btn btn-secondary w-100 py-2 mt-5" value="Configurações"/>
        </a>
        <form action="Logout" method="get">
            <input type="submit" class="btn btn-warning w-100 py-2 mt-2" value="Sair do Sistema"/>
        </form>
    </div>
</div>
