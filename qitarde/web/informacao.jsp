<%-- 
    Document   : informacao
    Created on : 24 de mai. de 2023, 15:12:48
    Author     : QI
--%>

<%@page import="model.Titular" %>
<%
    Titular uSession = (Titular)session.getAttribute("userNameSession");
%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>informaçâo calculadoramobi</title>
    <link rel="stylesheet" href="estilo2.css">
</head>
<body>
    <%@include file="session/verify.jsp" %>
    
    <div id="h2header">
        <a href="index.html" id="link"><h2>calculadoramobi.com.br</h2></a>
    </div>
    <fieldset id="info">
        <h2>CALCULADORA</h2>
        <input type="text" name="texto" placeholder="Digite seu gasto de energia" id="input1">
        <input type="text" name="texto" placeholder="Digite seu gasto de água" id="input2">
        <input type="text" name="texto" placeholder="Digite seu gasto de comida" id="input3">
        <input type="text" name="texto" placeholder="Digite seu salário" id="input4"><br>
        <input type="button" value="CALCULE" id="calcule">
    </fieldset>
</body>
