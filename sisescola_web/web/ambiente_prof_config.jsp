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
                    <!-- Menu Principal -->
                    <div class="col p-3">
                        <!-- Título -->
                        <div class="row mb-5 text-center">
                            <h2>Configurações</h2>
                            <a href="ambiente_prof.jsp"><i class="fa-solid fa-arrow-left"></i> Voltar ao ambiente do professor</a>
                        </div>
                            
                        
                        <div class="row p-3">
                            <hr>
                            <h3>Informações Pessoais</h3>
                            <p>Para atualizar dados como nome, e-mail, data de nascimento, endereço ou outras informações pessoais,
                            por favor contate o administrador do sistema ou a secretaria do seu colégio.</p>
                            <hr>
                            
                            <h3>Atualizar Foto de Perfil</h3>
                            <p>Escolha uma nova foto de perfil para seu usuário no sistema.</p>
                            <div class="row pt-1 pb-3">
                                <form action = "upload_pfp.jsp" method = "post"
                                    enctype = "multipart/form-data">
                                    <input type="file" name="file" accept=".png,.jpeg,.jpg" size="50" />
                                    <input type="submit" value="Enviar" />
                                </form>
                                <p>Formatos Suportados: <em>.png, .jpg e .jpeg</em></p>
                                <p><small><em>Pode ser necessário que você limpe o cache do seu navegador para que as alterações
                                            demonstrem efeito.</em></small></p>
                                <hr>
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

