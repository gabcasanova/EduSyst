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
                        <div class="row mb-5 text-center">
                            <h2>Chat Escolar</h2>
                            <a href="ambiente_prof.jsp"><i class="fa-solid fa-arrow-left"></i> Voltar ao ambiente do professor</a>
                        </div>
                            
                         <!-- Exibir chat -->
                        <div class="row p-3 text-center d-flex justify-content-center align-items-center flex-column">
                            <p><a href=""><i class="fa-solid fa-arrows-rotate"></i> <b>CHECAR POR NOVAS MENSAGENS</b></a></p>
                            <iframe 
                                id="janelaChat" 
                                src="https://www.meumural.com/mural/29621"
                                style="height:350px; width:600px; 
                                       transform: scale(1.5); transform-origin: top center;
                                       margin-bottom: 180px;">
                            </iframe>
                        </div>
                        
                        <!-- Regras do Chat -->
                        <div class="row p-3 text-center">
                            <h1>Regras do Chat</h1>
                            <p>Por favor, leia com atenção essas regras pois são necessárias para manter um
                            ambiente civil e respeitoso no chat.
                            <br>Para mandar uma mensagem, basta se identificar
                            com seu nome e escrever o conteúdo da mensagem.</p>
                            
                            <ul class="text-start" style="max-width: 600px; margin: 0 auto; text-align: left;">
                                <li><strong>Use o seu nome verdadeiro:</strong> Não se faça passar por outras pessoas, como alunos ou professores. Administramos o chat e possuimos o enderço IP de todas as mensagens.</li>
                                <li><strong>Respeito mútuo:</strong> Trate todos os participantes do chat com respeito. Ofensas, insultos ou linguagem abusiva não serão tolerados.</li>
                                <li><strong>Sem spam:</strong> Não envie mensagens repetitivas ou irrelevantes. O spam atrapalha a comunicação de todos.</li>
                                <li><strong>Evite discussões fora do tema:</strong> Mantenha as conversas focadas nos assuntos relevantes ao grupo e ao propósito do chat.</li>
                                <li><strong>Sem conteúdo impróprio:</strong> É proibido compartilhar conteúdo ofensivo, ilegal, ou inapropriado, incluindo imagens ou links.</li>
                                <li><strong>Respeite a privacidade:</strong> Não compartilhe informações pessoais suas ou de outros sem permissão.</li>
                                <li><strong>Use o bom senso:</strong> Antes de enviar uma mensagem, reflita se ela é apropriada para todos os usuários do chat.</li>
                            </ul>
                            
                            
                            <p class="pt-3">O não cumprimento de qualquer uma dessas regras poderá causar <b>banimento</b> 
                               permanente do usuário no ambiente de chat e a impossibilidade de mandar ou receber novas mensagens!</p>
                        </div>
                    </div>
                </div>
            </div>
        </main>

        <!-- Rodapé -->
        <%@include file="parts/footer.jsp"%>
    </body>
</html>

