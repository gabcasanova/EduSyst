<%-- 
    Document   : pagina_padrao
    Created on : 4 de jul. de 2024, 18:41:57
    Author     : con_c
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="util.DBUtil"%>
<%@page import="model.Aluno"%> 
<%@ page import="java.sql.*, java.util.*" %>

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
                        <div class="row mb-5 text-center">
                            <h2>Meu Aluno</h2>
                            
                            <%
                                // CRIAR OBJETO ALUNO através da chave estrangeira do responsável
                                Aluno aluno = null;
                                aluno = new Aluno();
                                
                                String sql = "select * from alunos where alunos.responsavel_id = ?";
                                String idResp = Integer.toString(responsavel.getId());
                                
                                try (Connection conn = DBUtil.getConnection()) { // Tentar conexão com o banco de dados.
                                    PreparedStatement stmt = conn.prepareStatement(sql);
                                    stmt.setString(1, idResp);         // definir os parametros da query com base

                                    ResultSet rs = stmt.executeQuery(); // executar a query MYSQL.

                                    // Criar objeto aluno com base nas informações do banco de dados
                                    if (rs.next()) {
                                        aluno = new Aluno();
                                        aluno.setId(rs.getInt("Id_Aluno"));
                                        aluno.setIdResponsavel(rs.getInt("Responsavel_Id"));
                                        //aluno.setIdTurma(rs.getInt("Turma_Id"));
                                        aluno.setCpf(rs.getString("CPF"));
                                        aluno.setNome(rs.getString("nome"));
                                        aluno.setEmail(rs.getString("email"));
                                        aluno.setDataNasc(rs.getString("data_nasc"));
                                        aluno.setEndereco(rs.getString("endereco"));
                                        aluno.setTelefone(rs.getString("telefone"));
                                        aluno.setGenero(rs.getString("genero"));
                                        aluno.setSenha(rs.getString("senha"));
                                    }
                                } catch (SQLException e) {
                                    e.printStackTrace(); // Printar erro caso uma exception ocorra.
                                }
                            %>
                            
                            <a href="ambiente_resp.jsp"><i class="fa-solid fa-arrow-left"></i> Voltar ao ambiente do aluno</a>
                        </div>
                            
                        <!-- MOSTRAR INFORMAÇÕES DO ALUNO -->
                        <div class="row p-3 fs-2 text-center">
                            <p><b>CPF: </b><%=aluno.getCpf()%></p>
                            <p><b>Nome: </b><%=aluno.getNome()%></p>
                            <p><b>Email: </b><%=aluno.getEmail()%></p>
                            <p><b>Data de Nascimento: </b><%=aluno.getDataNasc()%></p>
                            <p><b>Endereço: </b><%=aluno.getEndereco()%></p>
                            <p><b>Gênero: </b><%=aluno.getGenero()%></p>
                            <p><b>Telefone: </b><%=aluno.getTelefone()%></p>
                        </div>
                           
                    </div>
                </div>
            </div>
        </main>

        <!-- Rodapé -->
        <%@include file="parts/footer.jsp"%>
    </body>
</html>

