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
                    <%@include file="parts/perfil_resp.jsp"%>
                    
                    <!-- Menu Principal -->
                    <div class="col p-3">
                        <!-- Título -->
                        <div class="row mb-3 text-center">
                            <h2>Seja bem-vindo ao ambiente do responsável!</h2>
                            <p><b>Escolha uma das opções para acessar as informações do seu aluno:</b></p>
                        </div>
                        
                        <div class="row justify-content-center"> <!-- Primeira linha -->
                            <div class="col m-2 p-3 botao_ambiente"> <!-- Aluno -->
                                <a href="ambiente_resp_aluno.jsp">
                                    <img class="mb-3" src="img/icones/IconeAluno.png" alt="Meu Aluno"/>
                                    <strong class="fs-5">Meu Aluno</strong>
                                </a>
                            </div>
                            <div class="col m-2 p-3 botao_ambiente"> <!-- Chat -->
                                <a href="ambiente_resp_chat.jsp">
                                    <img class="mb-3" src="img/icones/iconeChat.png" alt="Chat"/>
                                    <strong class="fs-5">Chat Escolar</strong>
                                </a>
                            </div>
                        </div>
                        
                        <!-- Opções -->
                        <div class="row justify-content-center"> <!-- Segunda linha -->
                            <div class="col m-2 p-3 botao_ambiente"> <!-- Matérias -->
                                <a href="ambiente_resp_materias.jsp">
                                    <img class="mb-3" src="img/icones/IconeMaterias.png" alt="Matérias"/>
                                    <strong class="fs-5">Matérias</strong>
                                </a>
                            </div>
                            <div class="col m-2 p-3 botao_ambiente"> <!-- Professores -->
                                <a href="ambiente_resp_professores.jsp">
                                    <img class="mb-3" src="img/icones/IconeProfessor.png" alt="Professor"/>
                                    <strong class="fs-5">Professores</strong>
                                </a>
                            </div>
                            <div class="col m-2 p-3 botao_ambiente"> <!-- Horarios -->
                                <a href="ambiente_resp_horarios.jsp">
                                    <img class="mb-3" src="img/icones/IconeHorarios.png" alt="Professor"/>
                                    <strong class="fs-5">Horários</strong>
                                </a>
                            </div>                           
                        </div>
                        
                        <div class="row justify-content-center"> <!-- Terceira linha -->
                            <div class="col m-2 p-3 botao_ambiente"> <!-- Turma -->
                                <a href="ambiente_resp_turma.jsp">
                                    <img class="mb-3" src="img/icones/IconeTurma2.png" alt="Turma"/>
                                    <strong class="fs-5">Turma</strong>
                                </a>
                            </div>
                            <div class="col m-2 p-3 botao_ambiente"> <!-- Boletim -->
                                <a href="ambiente_resp_boletim.jsp">
                                    <img class="mb-3" src="img/icones/IconeBoletim.png" alt="Boletim"/>
                                    <strong class="fs-5">Boletim</strong>
                                </a>
                            </div>
                            <div class="col m-2 p-3 botao_ambiente"> <!-- Atividades -->
                                <a href="ambiente_resp_atividades.jsp">
                                    <img class="mb-3" src="img/icones/IconeAtividades.png" alt="Atividades"/>
                                    <strong class="fs-5">Atividades</strong>
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

