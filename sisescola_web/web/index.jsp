<%-- 
    Document   : Página principal.
    Created on : 4 de jul. de 2024, 17:53:32
    Author     : Gabriel Casanova
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

                    <!-- Carrossel de Imagens-->
                    <div class="col-lg-8 mt-4 mb-2">
                        <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel" >
                            <div class="carousel-indicators">
                                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0"
                                    class="active" aria-current="true" aria-label="Slide 1"></button>
                                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"
                                    aria-label="Slide 2"></button>
                                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2"
                                    aria-label="Slide 3"></button>
                                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="3"
                                    aria-label="Slide 4"></button>
                            </div>
                            <div class="carousel-inner carr">
                                <div class="carousel-item active"> 
                                    <img src="img/home/carrossel_professores.jpg" class="d-block w-100" alt="...">
                                    <div class="carrLegenda carousel-caption d-none d-md-block ">
                                        <h5>Pensado em Professores</h5>
                                        <p>Facilite o planejamento de aulas e a gestão de turmas com ferramentas intuitivas.</p>
                                    </div>
                                </div>
                                <div class="carousel-item">
                                    <img src="img/home/carrossel_alunos.jpg" class="d-block w-100" alt="...">
                                    <div class="carrLegenda carousel-caption d-none d-md-block ">
                                        <h5>Perfeito para Alunos</h5>
                                        <p>Recursos interativos que tornam o aprendizado mais dinâmico e envolvente.</p>
                                    </div>
                                </div>
                                <div class="carousel-item">
                                    <img src="img/home/carrossel_diretores.jpg" class="d-block w-100" alt="...">
                                    <div class="carrLegenda carousel-caption d-none d-md-block ">
                                        <h5>Organização para a Direção e Coordenação</h5>
                                        <p>Soluções integradas para uma gestão escolar eficiente e organizada.</p>
                                    </div>
                                </div>
                                <div class="carousel-item">
                                    <img src="img/home/carrossel_pais.jpg" class="d-block w-100" alt="...">
                                    <div class="carrLegenda carousel-caption d-none d-md-block ">
                                        <h5>Acompanhe a Vida Acadêmica do Seu Filho</h5>
                                        <p>Tenha acesso a notas, frequência e mais informações em tempo real.</p>
                                    </div>
                                </div>
                            </div>
                            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators"
                                data-bs-slide="prev">
                                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                <span class="visually-hidden">Previous</span>
                            </button>
                            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators"
                                data-bs-slide="next">
                                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                <span class="visually-hidden">Next</span>
                            </button>
                        </div>
                    </div>

                    <!-- Texto -->
                    <div class="row m-4">
                        <h1>Nossos Objetivos</h1>
                        <div class="row">
                            <div class="col p-5">
                                <p class="textoProf">No cenário atual da educação, a necessidade de uma gestão escolar eficiente e acessível tornou-se fundamental para garantir um ambiente educacional produtivo e transparente. É nesse contexto que surge o <strong>EduSyst, um sistema escolar online projetado para atender às demandas específicas das escolas públicas de ensino medio. Com a visão de proporcionar uma experiência integrada e simplificada, o EduSyst visa revolucionar a maneira como alunos, professores e administradores interagem e gerenciam suas atividades acadêmicas, promovendo uma gestão mais ágil, transparente e eficaz em todos os aspectos da vida escolar.</strong></p>
                                <p class="textoProf">Atualmente nas escolas os procedimentos são predominantemente manuais e descentralizados. Os alunos frequentemente precisam consultar suas notas e horários de aula pessoalmente com os professores ou através de listas afixadas em murais. Os professores, por sua vez, costumam registrar as notas e enviar tarefas através de papel ou e-mail, muitas vezes enfrentando dificuldades na comunicação com os alunos e na organização das informações. Os diretores e secretários lidam com uma quantidade significativa de papelada, incluindo matrículas, registros acadêmicos e relatórios administrativos, o que pode levar a atrasos e erros na gestão escolar. Em resumo, os processos atuais são caracterizados por uma falta de integração e eficiência, resultando em uma experiência desafiadora tanto para os alunos quanto para os profissionais da educação.</p>
                            </div>
                            <div class="col-2">
                                <img class="img-fluid" src="img/home/edusyst_areia.png">
                            </div>
                        </div>

                        <h1 class="text-end">Porque EduSyst?</h1>
                        <div class="row">
                            <div class="col-2">
                                <img class="img-fluid" src="img/home/iconeescola.webp">
                            </div>
                            <div class="col p-5">
                                <p class="textoProf"><strong>O principal objetivo do EduSyst é oferecer uma plataforma abrangente e intuitiva que atenda às diversas necessidades do ambiente escolar. Desde a facilidade de acesso às informações acadêmicas por parte dos alunos até a gestão eficiente das turmas e das atividades pedagógicas pelos professores, o sistema busca otimizar todos os processos envolvidos na administração escolar.</strong> Além disso, o EduSyst visa simplificar as tarefas administrativas dos diretores e secretários, proporcionando uma visão panorâmica e detalhada do funcionamento da escola, contribuindo assim para a melhoria contínua da qualidade da educação oferecida. O sistema opera de forma integrada, oferecendo uma plataforma abrangente e acessível para alunos, professores e administradores.</p> 
                                <!--<p class="textoProf">No centro dessa infraestrutura está o site público, que serve como um ponto de acesso centralizado. Tanto alunos quanto professores podem fazer login e acessar suas contas individuais. Os professores têm acesso a funcionalidades específicas, como a consulta de matérias e turmas atribuídas e a possibilidade de atribuir notas aos alunos diretamente na plataforma. Por outro lado, os alunos têm à disposição a consulta de matérias, notas, grade de horários e materiais de estudo. A geração automática de boletins, com base nas notas dos alunos, tanto no site quanto no aplicativo móvel exclusivo para alunos, simplifica o acompanhamento do desempenho acadêmico.</p>-->
                                <h4><strong>Essas funcionalidades combinadas oferecem uma experiência integrada e eficiente, atendendo às diversas necessidades do ambiente escolar moderno.</strong></h4>
                            </div>
                        </div>

                        <div class="row">
                            <img style="max-width: 350px;" class="mx-auto img-fluid" src="img/home/colegas.webp">
                            <img style="max-width: 350px;" class="mx-auto img-fluid" src="img/home/professor_grafico.png">
                            <img style="max-width: 350px;" class="mx-auto img-fluid" src="img/home/professor_grafico2.png">
                        </div>
                    </div>
                </div>
            </div>
        </main>

        <!-- Rodapé -->
        <%@include file="parts/footer.jsp"%>
    </body>
</html>
