<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="br.com.smart2.dao.*" %>
<%@ page import="br.com.smart2.model.*"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>


<!DOCTYPE html>

<%

HttpSession Session = request.getSession();
PizzaDao dao = new PizzaDao();
List pizza = dao.listar();		
Session.setAttribute("pizza", pizza);

//Bebida session

HttpSession sessionB = request.getSession();
BebidaDao bdao = new BebidaDao();
List bebida = bdao.listar();
sessionB.setAttribute("bebida", bebida);



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
				<form action="inserir" method="post">
				
					<div class="form-group">
						<label for="_nome">Sabor:</label>
						<input type="text" class="form-control" id="_sabor" name="sabor" required>
					</div>
					
					<div class="form-group">
						<label for="_tamanho">Valor:</label>
						<input type="number" class="form-control" id="_valor" name="valor" required>
					</div>
					
					<div class="form-group">
						<label for="_preco">Tamanho:</label>
						<input type="text" step="0.10" class="form-control" id="_tamanho" name="tamanho" required>
					</div>
					
					<div class="form-group">
						<label for="_descricao">Descrição:</label>
						<input type="text" step="0.10" class="form-control" id="_descricao" name="descricao" required>
					</div>
					
					<label for="_bebida">Bebida:</label>
					<div class="form-group">
					<select class="form-control" name="bebida">
					 <c:forEach items="${bebida}" var="b">
						<option value="${b.id}">${b.nome}</option>
					 </c:forEach>	
					</select>
					</div>
					
					
					<button class="btn btn-dark">Enviar</button>
				</form>
			</fieldset>
		</div>
		
		<hr>
		
		<div class="row">
			<a href="cadastroBebida.jsp" class="btn btn-dark">Cadastro Bebida[]</a>
		</div>
		
		
		<div class="mt-5">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>id</th>
						<th>Sabor</th>
						<th>Valor</th>
						<th>Tamanho</th>
						<th>Bebida</th>
						<th>descrição</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="pizza" items="${pizza}">
						<tr>
							<td>${pizza.id}</td>
							<td>${pizza.sabor}</td>
							<td>${pizza.valor}</td>
							<td>${pizza.tamanho}</td>
							<td>${pizza.bebida.id}</td>
							<td>${pizza.descricao}</td>
							<td><a href="deletar?id=${pizza.id}" class="btn btn-danger">Excluir</a></td>
							<td><a href="buscarPizza?id=${pizza.id}" class="btn btn-primary">Editar</a></td>
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