<%-- 
    Document   : UploadPfp
    Created on : 15 de set. de 2024, 14:29:06
    Author     : con_c
--%>

<%@page import="model.Professor"%>
<!-- Esse código aqui está horrível. Primeiro, que ele deveria ser um servlet.
     segundo, ele não deveria repetir o que é basicamente o mesmo código para
     o responsável e o aluno. No entanto, é um domingo de outubro e eu preciso
     terminar esse TCC. Peço perdão

     Se a foto de perfil não está carregando, lembre-se de desabilitar ou
     limpar o cache. -->

<%@page import="model.Responsavel"%>
<%@page import="java.nio.file.StandardCopyOption"%>
<%@page import="java.io.IOException"%>
<%@page import="java.nio.file.Files"%>
<%@page import="java.nio.file.Paths"%>
<%@page import="java.nio.file.Path"%>
<%@page import="java.io.File"%>
<%@page import="model.Aluno"%>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>  

<!-- UPLOAD DA FOTO DO ALUNO!!!! -->
<%
    // Caminho do diretório onde os arquivos serão armazenados
    String localPfp = "/img/perfis/";

    Aluno aluno = (Aluno) session.getAttribute("aluno"); // Transformar atributo em objeto aluno
    if (aluno != null) {
        try {
            // FAZER UPLOAD DO ARQUIVO -------------
            boolean uploaded = false;
        
            // Definindo o tamanho máximo do arquivo (aqui, 10MB)
            int maxFileSize = 5 * 1024 * 1024;

            // Criação da requisição Multipart com o diretório de upload
            MultipartRequest m = new MultipartRequest(request, getServletContext().getRealPath(localPfp), maxFileSize);

            // Obter o nome do arquivo
            String fileName = m.getFilesystemName("file");  // "file" deve ser o nome do campo input no formulário
            if (fileName != null) {
                out.print("Upload realizado com sucesso! Arquivo salvo em: " + getServletContext().getRealPath(localPfp) + "\\" + fileName);
                uploaded = true;
            } else {
                out.print("Nenhum arquivo foi enviado.");
            }
%>
<br>
<br>
<%            
            // RENOMEAR O ARQUIVO ------------------
            boolean renamed = false;
            
            String oldFilePath = getServletContext().getRealPath(localPfp) + "\\" + fileName;
            String newFilePath = getServletContext().getRealPath(localPfp) + "\\" + "pfp_aluno_" + aluno.getId() + ".png";

            Path oldFile = Paths.get(oldFilePath);
            Path newFile = Paths.get(newFilePath);

            try {
                Files.move(oldFile, newFile, StandardCopyOption.REPLACE_EXISTING);
                out.print("Arquivo renomeado com sucesso para: " + newFile.getFileName());
                renamed = true;
            } catch (IOException e) {
                out.print("Erro ao renomear o arquivo: " + e.getMessage());
                e.printStackTrace();
            }
            
            // REDIRECIONAR ---------------------------
            String redirectURL = "ambiente_aluno_config.jsp";
            
            if (renamed && uploaded) {
                response.sendRedirect(redirectURL);
            }

        } catch (Exception e) {
            out.print("Erro no upload: " + e.getMessage());
            e.printStackTrace();
        }
    }
%>
<br>
<br>

<!-- UPLOAD DA FOTO DO RESPONSÁVEL!!!! -->
<%

    Responsavel responsavel = (Responsavel) session.getAttribute("responsavel"); // Transformar atributo em objeto aluno
    if (responsavel != null) {
        try {
            // FAZER UPLOAD DO ARQUIVO -------------
            boolean uploaded = false;
        
            // Definindo o tamanho máximo do arquivo (aqui, 10MB)
            int maxFileSize = 5 * 1024 * 1024;

            // Criação da requisição Multipart com o diretório de upload
            MultipartRequest m = new MultipartRequest(request, getServletContext().getRealPath(localPfp), maxFileSize);

            // Obter o nome do arquivo
            String fileName = m.getFilesystemName("file");  // "file" deve ser o nome do campo input no formulário
            if (fileName != null) {
                out.print("Upload realizado com sucesso! Arquivo salvo em: " + getServletContext().getRealPath(localPfp) + "\\" + fileName);
                uploaded = true;
            } else {
                out.print("Nenhum arquivo foi enviado.");
            }
%>
<br>
<br>
<%            
            // RENOMEAR O ARQUIVO ------------------
            boolean renamed = false;
            
            String oldFilePath = getServletContext().getRealPath(localPfp) + "\\" + fileName;
            String newFilePath = getServletContext().getRealPath(localPfp) + "\\" + "pfp_resp_" + responsavel.getId() + ".png";

            Path oldFile = Paths.get(oldFilePath);
            Path newFile = Paths.get(newFilePath);

            try {
                Files.move(oldFile, newFile, StandardCopyOption.REPLACE_EXISTING);
                out.print("Arquivo renomeado com sucesso para: " + newFile.getFileName());
                renamed = true;
            } catch (IOException e) {
                out.print("Erro ao renomear o arquivo: " + e.getMessage());
                e.printStackTrace();
            }
            
            // REDIRECIONAR ---------------------------
            String redirectURL = "ambiente_resp_config.jsp";
            
            if (renamed && uploaded) {
                response.sendRedirect(redirectURL);
            }

        } catch (Exception e) {
            out.print("Erro no upload: " + e.getMessage());
            e.printStackTrace();
        }
    }
%>
<br>
<br>

<!-- UPLOAD DA FOTO DO PROFESSOR!!!! -->
<%

    Professor professor = (Professor) session.getAttribute("professor"); // Transformar atributo em objeto aluno
    if (professor != null) {
        try {
            // FAZER UPLOAD DO ARQUIVO -------------
            boolean uploaded = false;
        
            // Definindo o tamanho máximo do arquivo (aqui, 10MB)
            int maxFileSize = 5 * 1024 * 1024;

            // Criação da requisição Multipart com o diretório de upload
            MultipartRequest m = new MultipartRequest(request, getServletContext().getRealPath(localPfp), maxFileSize);

            // Obter o nome do arquivo
            String fileName = m.getFilesystemName("file");  // "file" deve ser o nome do campo input no formulário
            if (fileName != null) {
                out.print("Upload realizado com sucesso! Arquivo salvo em: " + getServletContext().getRealPath(localPfp) + "\\" + fileName);
                uploaded = true;
            } else {
                out.print("Nenhum arquivo foi enviado.");
            }
%>
<br>
<br>
<%            
            // RENOMEAR O ARQUIVO ------------------
            boolean renamed = false;
            
            String oldFilePath = getServletContext().getRealPath(localPfp) + "\\" + fileName;
            String newFilePath = getServletContext().getRealPath(localPfp) + "\\" + "pfp_prof_" + professor.getId() + ".png";

            Path oldFile = Paths.get(oldFilePath);
            Path newFile = Paths.get(newFilePath);

            try {
                Files.move(oldFile, newFile, StandardCopyOption.REPLACE_EXISTING);
                out.print("Arquivo renomeado com sucesso para: " + newFile.getFileName());
                renamed = true;
            } catch (IOException e) {
                out.print("Erro ao renomear o arquivo: " + e.getMessage());
                e.printStackTrace();
            }
            
            // REDIRECIONAR ---------------------------
            String redirectURL = "ambiente_prof_config.jsp";
            
            if (renamed && uploaded) {
                response.sendRedirect(redirectURL);
            }

        } catch (Exception e) {
            out.print("Erro no upload: " + e.getMessage());
            e.printStackTrace();
        }
    }
%>
<br>
<br>
<a href="ambiente_aluno_config.jsp"> Voltar ao ambiente. </a>