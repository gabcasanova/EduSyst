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
                    <%@include file="parts/perfil_prof.jsp"%>
                    
                    <!-- Menu Principal -->
                    <div class="col p-3">
                        <!-- Título -->
                        <div class="row mb-3 text-center">
                            <h2>Seja bem-vindo ao ambiente do professor!</h2>
                            <!--<p><b>Escolha uma das opções para acessar as informações do seu aluno:</b></p>-->
                        </div>
                        
                        <div class="row justify-content-center"> <!-- Primeira linha -->
                            <div class="col m-2 p-3 botao_ambiente"> <!-- Aluno -->
                                <a href="ambiente_prof_aluno.jsp">
                                    <img class="mb-3" src="img/icones/IconeAluno.png" alt="Meu Aluno"/>
                                    <strong class="fs-5">Meus Alunos</strong>
                                </a>
                            </div>
                            
                            <div class="col m-2 p-3 botao_ambiente"> <!-- Turmas -->
                                <a href="ambiente_prof_turmas.jsp">
                                    <img class="mb-3" src="img/icones/IconeTurma2.png" alt="Matérias"/>
                                    <strong class="fs-5">Minhas Turmas</strong>
                                </a>
                            </div>
                            
                            <div class="col m-2 p-3 botao_ambiente"> <!-- Chat -->
                                <a href="ambiente_prof_chat.jsp">
                                    <img class="mb-3" src="img/icones/iconeChat.png" alt="Chat"/>
                                    <strong class="fs-5">Chat Escolar</strong>
                                </a>
                            </div>
                        </div>
                        
                        <!-- Opções -->
                        <div class="row justify-content-center"> <!-- Segunda linha -->
                            <div class="col m-2 p-3 botao_ambiente"> <!-- Horários -->
                                <a href="ambiente_prof_horarios.jsp">
                                    <img class="mb-3" src="img/icones/IconeHorarios.png" alt="Turma"/>
                                    <strong class="fs-5">Meus Horários</strong>
                                </a>
                            </div>
                            
                            <div class="col m-2 p-3 botao_ambiente"> <!-- Boletim -->
                                <a href="ambiente_prof_notas.jsp">
                                    <img class="mb-3" src="img/icones/IconeBoletim.png" alt="Matérias"/>
                                    <strong class="fs-5">Aplicar Notas</strong>
                                </a>
                            </div>
                            
                            <div class="col m-2 p-3 botao_ambiente"> <!-- Atividades -->
                                <a href="ambiente_prof_atividades.jsp">
                                    <img class="mb-3" src="img/icones/IconeAtividades.png" alt="Matérias"/>
                                    <strong class="fs-5">Aplicar Atividades</strong>
                                </a>
                            </div>
                        </div>
                        
                        <div class="row justify-content-center"> <!-- Terceira linha -->
                            <div class="col m-2 p-3 botao_ambiente"> <!-- Turma -->
                                <a href="ambiente_prof_outros.jsp">
                                    <img class="mb-3" src="img/icones/IconeProfessor.png" alt="Turma"/>
                                    <strong class="fs-5">Outros Professores</strong>
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

