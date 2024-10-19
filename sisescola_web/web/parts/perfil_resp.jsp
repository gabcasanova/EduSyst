<%-- 
    Document   : alunoPerfil
    Created on : 10 de ago. de 2024, 22:30:05
    Author     : con_c
--%>

<%@page import="model.Responsavel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.File"%>
<%@page import="model.Aluno"%>
<%@page import="selections.Select"%>

<!DOCTYPE html>
<!-- Barra Lateral / Perfil do Usuário -->
<div class="col-3 p-3 user_bar d-flex flex-row flex-wrap justify-content-center align-items-stretch align-content-between">
    <%
        // Se responsavel existir, mostrar informações:
        Responsavel responsavel = (Responsavel) session.getAttribute("responsavel"); // Transformar atributo em objeto responsavel
        if (responsavel != null) {
            Select selection = new Select();
            
            String pfpPadrao = "img/perfis/pfp_default.png";
            String localPfp = "/img/perfis/pfp_resp_" + responsavel.getId() + ".png"; 
            File responsavelPfp = new File(getServletContext().getRealPath(localPfp)); // Caminho completo no servidor
            boolean pfpExiste = responsavelPfp.exists(); 
    %>
        <div>
            <div class="text-center m-2 mb-3">
                <!-- Definir foto de perfil -->
                <%if (pfpExiste) { %>
                    <img class="pfp" src="<%= request.getContextPath() + localPfp %>" alt="foto do responsavel"/>
                <%}else { %>
                    <img class="pfp" src="<%= pfpPadrao %>" alt="foto do responsavel"/>
                <%} %>
            </div>
            <p class="text-center">Responsavel</p>
            <h2 class="text-center"><%= responsavel.getNome() %></h2>

            <p class="text-center mt-5"><strong><i class="fa-solid fa-user-graduate"></i> Suas Informações:</strong></p>
            <ul class="lista_info">
                <li><strong>CPF: </strong><%= responsavel.getCpf() %></li>
                <li><strong>Email: </strong><%= responsavel.getEmail() %></li>
                <li><strong>Data de Nascimento: </strong><%= responsavel.getDataNasc() %></li>
                <li><strong>Endereço: </strong><%= responsavel.getEndereco() %></li>
                <li><strong>Telefone: </strong><%= responsavel.getTelefone() %></li>
                <li><strong>Gênero: </strong><%= responsavel.getGenero() %></li>
                <li><br></li>
                
            </ul>
        </div>
    <%
        }
    %>

    <!-- Logout -->
    <div>
        <a href="ambiente_resp_config.jsp"> 
            <input type="submit" class="btn btn-secondary w-100 py-2 mt-5" value="Configurações"/>
        </a>
        <form action="Logout" method="get">
            <input type="submit" class="btn btn-warning w-100 py-2 mt-2" value="Sair do Sistema"/>
        </form>
    </div>
</div>
