<%-- 
    Document   : Barra de navegação.
    Created on : 4 de jul. de 2024, 18:11:58
    Author     : Gabriel Casanova.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<nav id="barra_navegacao" class="navbar navbar-dark sticky-top navbar-expand-lg" data-bs-theme="dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="index.jsp"><img id="logo" src="img/edusyst_logo.png"></a>

        <!-- Botão toggler (responsivo, aparece no mobile)-->
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
            data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
            aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <!-- Links -->
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                <li class="nav-item"> <!-- Home -->
                    <!--<a class="nav-link active" aria-current="page" href="index.html">Home</a>-->
                    <a class="nav-link" href="index.jsp">Home</a>
                </li>
                <li class="nav-item"> <!-- Sobre Nós -->
                    <a class="nav-link" href="sobre.jsp">Sobre Nós</a>
                </li>
                <li class="nav-item"> <!-- Fale Conosco -->
                    <a class="nav-link" href="#">Fale Conosco</a>
                </li>

                <!-- Dropdown Institucional -->
                <li class="nav-item dropdown">
                    <a id="login_link" class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                        aria-expanded="false">
                        <i class="fa-solid fa-right-to-bracket"></i> Área Institucional
                    </a>
                    <ul class="dropdown-menu dropdown-menu-end">
                        <li><a class="dropdown-item" href="login_aluno.jsp">Sou Aluno</a></li>
                        <li><a class="dropdown-item" href="login_resp.jsp">Sou Responsável</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="login_prof.jsp">Sou Professor</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
