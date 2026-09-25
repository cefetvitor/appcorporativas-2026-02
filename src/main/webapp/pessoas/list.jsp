<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="br.cefetrj.appcorp.model.Pessoa" %>
<%
    List<Pessoa> pessoas = (List<Pessoa>) request.getAttribute("pessoas");
    if (pessoas == null) {
        response.sendRedirect(request.getContextPath() + "/pessoas");
        return;
    }
%>
<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pessoas</title>
</head>
<body>
    <h1>Pessoas</h1>
    <p><a href="<%= request.getContextPath() %>/pessoas/form.jsp">Cadastrar nova pessoa</a></p>
    <% if (pessoas.isEmpty()) { %>
        <p>Nenhuma pessoa cadastrada.</p>
    <% } else { %>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Data de Nascimento</th>
                    <th>Data de Cadastro</th>
                    <th>Última Alteração</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
            <% for (Pessoa pessoa : pessoas) { %>
                <tr>
                    <td><%= pessoa.getId() %></td>
                    <td><%= pessoa.getNome() %></td>
                    <td><%= pessoa.getDataNascimento() %></td>
                    <td><%= pessoa.getDataCadastro() %></td>
                    <td><%= pessoa.getDataUltimaAlteracao() %></td>
                    <td><a href="<%= request.getContextPath() %>/pessoa/edicao?id=<%= pessoa.getId() %>">Editar</a></td>
                </tr>
            <% } %>
            </tbody>
        </table>
    <% } %>
</body>
</html>
