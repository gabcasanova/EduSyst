<%-- 
    Document   : Login Aluno
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
                    <div class="flex align-content-center col-5 m-3">
                        
                        <!-- Formulário de Login -->
                        <form action="Controller" method="post">
                            <!-- Identificação do Form -->
                            <input type="hidden" name="nomeFormulario" value="login_aluno"> 
                            
                            <!-- Mostrar erro -->
                            <% if (request.getAttribute("errorMessage") != null) { %>
                                <div id="liveAlertBtn" class="alert alert-danger text-center mb-5" role="alert">
                                    <%= request.getAttribute("errorMessage") %>
                                </div>
                            <% } %>
                            
                            <div class="text-center mb-5">
                                <img src="img/icones/IconeAluno.png" class="m-1" alt="Aluno"/>
                                <h1 class="h1 mb-3 fw-normal">Aluno,</h1>
                                <p><em>por favor entre com seus dados.</em></p>                                
                            </div>
                            
                            <div class="mb-5">
                                <div class="form-floating mb-4">
                                    <input maxlength="14" name="cpf" class="form-control" id="cpf" placeholder="111.111.111-11">
                                    <label for="floatingInput">CPF</label>
                                </div>
                                <div class="form-floating mb-4">
                                    <input name="email" type="email" class="form-control" id="floatingInput" placeholder="name@example.com">
                                    <label for="floatingInput">Endereço de email</label>
                                </div>
                                <div class="form-floating mb-4">
                                    <input name="senha" type="password" class="form-control" id="floatingPassword" placeholder="Senha">
                                    <label for="floatingPassword">Senha</label>
                                </div>

                                <div class="form-check text-start my-3 mb-4">
                                    <input class="form-check-input" type="checkbox" value="remember-me" id="flexCheckDefault">
                                    <label class="form-check-label" for="flexCheckDefault">
                                        Lembrar minha senha
                                    </label>
                                </div>
                            </div>
                            
                            <button class="btn btn-primary w-100 py-2 botaoLaranja mb-3" type="submit"><i class="fa-solid fa-right-to-bracket"></i> Entrar</button>
                        </form>
                        
                        
                    </div>
                </div>
            </div>
        </main>
                            
        <script>
            /* Formatar CPF automaticamente.*/
            const cpfInput = document.getElementById('cpf');

            cpfInput.addEventListener('input', function(e) {
                let value = cpfInput.value.replace(/\D/g, ''); // Remove tudo o que não for dígito
                // value = value.replace(/(\d{3})(\d)/, '$1.$2'); // Coloca o primeiro ponto
                // value = value.replace(/(\d{3})(\d)/, '$1.$2'); // Coloca o segundo ponto
                // value = value.replace(/(\d{3})(\d{1,2})$/, '$1-$2'); // Coloca o traço

                cpfInput.value = value;
            });
        </script>

        <!-- Rodapé -->
        <%@include file="parts/footer.jsp"%>
    </body>
</html>

