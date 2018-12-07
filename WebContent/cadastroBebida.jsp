<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="br.com.smart2.dao.*" %>
<%@ page import="br.com.smart2.model.*"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="javax.servlet.http.HttpSession" %>


<!DOCTYPE html>

<%

HttpSession Session = request.getSession();


List<Bebida> bebida = new ArrayList<>();
	BebidaDao dao = new BebidaDao();
	
	bebida = dao.listar();


Session.setAttribute("bebidas", bebida);

%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
  
	<div class="container">
		<div class="col-4">
			<fieldset>
				<form action="adicionar" method="post">
				
					<div class="form-group">
						<label for="_nome">Nome</label>
						<input type="text" class="form-control" id="_nome" name="nome" required>
					</div>
					
					<div class="form-group">
						<label for="_tamanho">Tamanho</label>
						<input type="number" class="form-control" id="_tamanho" name="tamanho" required>
					</div>
					
					<div class="form-group">
						<label for="_preco">Preço</label>
						<input type="number" step="0.10" class="form-control" id="_preco" name="valor" required>
					</div>
					
					<button class="btn btn-dark">Enviar</button>
				</form>
			</fieldset>
		</div>
		
		<hr>
		
		<div class="row">
			<a href="cadastroPizza.jsp" class="btn btn-dark">Cadastro Pizza[]</a>
		</div>
		
		
		<div class="mt-5">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>id</th>
						<th>Nome</th>
						<th>Tamanho</th>
						<th>Preço</th>
						<th>Excluir</th>
						<th>Editar</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="bebida" items="${bebidas}">
						<tr>
							<td>${bebida.id}</td>
							<td>${bebida.nome}</td>
							<td>${bebida.tamanho}</td>
							<td>${bebida.valor}</td>
							<td><a href="excluir?id=${bebida.id}" class="btn btn-danger">Excluir</a></td>
							<td><a href="buscarBebida?id=${bebida.id}" class="btn btn-primary">Editar</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>