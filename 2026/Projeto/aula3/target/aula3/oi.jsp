<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Oi</title>
</head>
    <%
    int oi = (Integer) request.getAttribute("oi2");
    String nome = (String)request.getAttribute("nome2");
    out.println("<p>Bem vindo, " + nome + " </p>");
    for (int i = 0; i < oi; i++){
        out.println("<p>oi " + (i+1) + "</p>");
    }
    %>
</body>
</html>