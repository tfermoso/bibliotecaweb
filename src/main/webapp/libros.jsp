<%@ page import="com.formacom.biblioteca.Modelos.Usuario" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tarde
  Date: 30/03/2023
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Biblioteca</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="static/css/index.css">
</head>
<body class="container">

<nav class="navbar navbar-dark bg-dark">
    <h1 class="navbar-brand">Libros jstl</h1><a class="navbar-brand" href="#"><%=((Usuario)request.getAttribute("usuario")).getNombre()%></a>
</nav>
<form class="form col-6" action="" method="post">
    <div class="form-group">
        <label class="form-label" for="titulo">Título</label>
        <input type="text" class="form-control" name="titulo" >
    </div>
    <div class="form-group">
        <label class="form-label" for="codigo">Código</label>
        <input type="text" class="form-control" name="codigo" >
    </div>
    <div class="form-group">
        <label class="form-label" for="genero">Género</label>
        <input type="text" class="form-control" name="genero" >
    </div>
    <input type="submit" value="Nuevo libro" class="btn btn-success">
</form>
<hr>
<table class="table table-dark">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Código</th>
        <th scope="col">Título</th>
        <th scope="col">Género</th>
    </tr>
    </thead>
    <tbody>
<c:forEach items="${libros}" var="libro">
    <tr>
        <td>${libro.id}</td>
        <td>${libro.titulo}</td>
        <td>${libro.codigo}</td>
        <td>${libro.genero}</td>
    </tr>
</c:forEach>
    </tbody>
</table>
</body>
</html>
