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
                    <div class="row justify-content-md-center text-center m-5">
                        <h1 class="display-2">Sobre Nós</h1>
                        
                        <div class="row m-5 ps-5 pe-5">
                        <p>Conheça a equipe por trás do EduSyst, projeto idealizado como nosso Trabalho de Conclusão de Curso  
                            (TCC) de Técnico em Informática do Instituto Superior de Educação do Rio de Janeiro - ISERJ/FAETEC.
                            Foram nove meses de muita colaboração, planejamento e noites sem dormir, com orientação fantástica
                            por parte dos nossos professores. Nos orgulhamos do resultado dessa aventura e esperamos que você 
                            também!
                        </p>
                        </div>
                        
                        <div class="col-3 text-center">
                            <img class="pfp" src="img/home/sobre_casanova.jfif " alt="alt"/>
                            <h1>Gabriel Casanova</h1>
                            <p class="textoProf">Líder do projeto e desenvolvedor especializado em Java Web & Android. 
                                Responsável pela criação do website e do aplicativo mobile do EduSyst, 
                                coordenando as principais decisões técnicas e estratégicas do projeto.
                            </p>
                        </div>
                        
                        <div class="col-3 text-center">
                            <img class="pfp" src="img/home/sobre_ferreira.jpg " alt="alt"/>
                            <h1>Gabriel da S. Ferreira</h1>
                            <p class="textoProf">Desenvolvedor MySQL e gestor do banco de dados. Foi o idealizador 
                                e criador da estrutura de dados do EduSyst, cuidando da modelagem, otimização e gerenciamento 
                                das bases de dados.
                            </p>
                        </div>
                        
                        
                        <div class="col-3 text-center">
                            <img class="pfp" src="img/home/sobre_barney.jpg " alt="alt"/>
                            <h1>Gabriel <small>"Barney"</small> Henrique</h1>
                            <p class="textoProf">Responsável pela documentação do projeto. Seu trabalho envolve 
                                a organização, elaboração e manutenção da documentação técnica do EduSyst, 
                                assegurando clareza para todas as partes envolvidas.
                            </p>
                        </div>
                    
                    
                        <div class="col-3 text-center">
                            <img class="pfp" src="img/home/sobre_matheus.png " alt="alt"/>
                            <h1>Matheus Menezes</h1>
                            <p class="textoProf">Desenvolvedor Java Desktop, responsável por implementar e manter 
                                o sistema desktop do EduSyst, garantindo sua funcionalidade e integração com as demais 
                                plataformas do sistema.
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </main>

        <!-- Rodapé -->
        <%@include file="parts/footer.jsp"%>
    </body>
</html>

