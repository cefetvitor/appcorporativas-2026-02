<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="br.cefetrj.appcorp.model.Pessoa" %>
<%
    // Preenchido pelo GetPessoaServlet em caso de edição; null em um novo cadastro
    Pessoa pessoa = (Pessoa) request.getAttribute("pessoa");
    boolean edicao = pessoa != null;
%>
<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><%= edicao ? "Editar Pessoa" : "Cadastrar Pessoa" %></title>
</head>
<body>
    <h1><%= edicao ? "Editar Pessoa" : "Cadastrar Pessoa" %></h1>
    <form action="<%= request.getContextPath() %>/pessoas" method="post">
        <% if (edicao) { %>
            <input type="hidden" name="id" value="<%= pessoa.getId() %>">
        <% } %>
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" required
               value="<%= edicao ? pessoa.getNome() : "" %>">
        <br>
        <label for="dataNascimento">Data de Nascimento:</label>
        <input type="date" id="dataNascimento" name="dataNascimento" required
               value="<%= edicao ? pessoa.getDataNascimento() : "" %>">
        <br>
        <input type="submit" value="<%= edicao ? "Salvar Alterações" : "Cadastrar Pessoa" %>">
    </form>
    <p><a href="<%= request.getContextPath() %>/pessoas">Voltar para a lista</a></p>
</body>
</html>
