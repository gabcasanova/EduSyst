<%-- 
    Document   : pagina_padrao
    Created on : 4 de jul. de 2024, 18:41:57
    Author     : con_c
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
                        <div class="row mb-3">
                            <h2 class="text-center">Seja bem-vindo ao ambiente do aluno!</h2>
                        </div>
                        
                        <!-- Opções -->
                        <div class="row justify-content-center"> <!-- Primeira linha -->
                            <div class="col m-2 p-3 botao_ambiente"> <!-- Matérias -->
                                <a href="ambiente_aluno_materias.jsp">
                                    <img class="mb-3" src="img/icones/IconeMaterias.png" alt="Matérias"/>
                                    <strong class="fs-5">Minhas Matérias</strong>
                                </a>
                            </div>
                            <div class="col m-2 p-3 botao_ambiente"> <!-- Professores -->
                                <a href="ambiente_aluno_professores.jsp">
                                    <img class="mb-3" src="img/icones/IconeProfessor.png" alt="Professor"/>
                                    <strong class="fs-5">Meus Professores</strong>
                                </a>
                            </div>
                            <div class="col m-2 p-3 botao_ambiente"> <!-- Horarios -->
                                <a href="ambiente_aluno_horarios.jsp">
                                    <img class="mb-3" src="img/icones/IconeHorarios.png" alt="Professor"/>
                                    <strong class="fs-5">Meus Horários</strong>
                                </a>
                            </div>                           
                        </div>
                        
                        <div class="row justify-content-center"> <!-- Segunda linha -->
                            <div class="col m-2 p-3 botao_ambiente"> <!-- Turma -->
                                <a href="ambiente_aluno_turma.jsp">
                                    <img class="mb-3" src="img/icones/IconeTurma2.png" alt="Turma"/>
                                    <strong class="fs-5">Minha Turma</strong>
                                </a>
                            </div>
                            <div class="col m-2 p-3 botao_ambiente"> <!-- Boletim -->
                                <a href="ambiente_aluno_boletim.jsp">
                                    <img class="mb-3" src="img/icones/IconeBoletim.png" alt="Boletim"/>
                                    <strong class="fs-5">Meu Boletim</strong>
                                </a>
                            </div>
                            <div class="col m-2 p-3 botao_ambiente"> <!-- Atividades -->
                                <a href="ambiente_aluno_atividades.jsp">
                                    <img class="mb-3" src="img/icones/IconeAtividades.png" alt="Atividades"/>
                                    <strong class="fs-5">Minhas Atividades</strong>
                                </a>
                            </div>
                        </div>
                        
                        <div class="row justify-content-center"> <!-- Terceira linha -->
                            <div class="col m-2 p-3 botao_ambiente"> <!-- Chat -->
                                <a href="ambiente_aluno_chat.jsp">
                                    <img class="mb-3" src="img/icones/iconeChat.png" alt="Chat"/>
                                    <strong class="fs-5">Chat Escolar</strong>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>

        <!-- Rodapé -->
        <%@include file="parts/footer.jsp"%>
    </body>
</html>

