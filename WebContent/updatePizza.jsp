<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    

<%
HttpSession session1 = request.getSession();

session1.getAttribute("pizza");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Pizza</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<div class="container">

		<div class="col-4">
			<fieldset>
				<form action="atualizar?id=${pizza.id}" method="post">
				
				
				
					<div class="form-group">
						<label for="_nome">Sabor:</label>
						<input type="text" class="form-control" value="${pizza.sabor}" id="_sabor" name="sabor" required>
					</div>
					
					<div class="form-group">
						<label for="_tamanho">Valor:</label>
						<input type="number" class="form-control" value="${pizza.valor}" id="_valor" name="valor" required>
					</div>
					
					<div class="form-group">
						<label for="_preco">Tamanho:</label>
						<input type="text" step="0.10" class="form-control" value="${pizza.tamanho}" id="_tamanho" name="tamanho" required>
					</div>
					
					<div class="form-group">
						<label for="_descricao">Descrição:</label>
						<input type="text" step="0.10" class="form-control" value="${pizza.descricao}" id="_descricao" name="descricao" required>
					</div>
					
					<label for="_bebida">Bebida:</label>
					<div class="form-group">
					<select class="form-control" name="bebida">
					 <c:forEach items="${bebida}" var="b"  value="${pizza.bebida}">
						<option value="${b.id}">${b.nome}</option>
					 </c:forEach>	
					</select>
					</div>
					
					
					<button class="btn btn-dark">Atualizar</button>
				</form>
			</fieldset>
		</div><br><br><br>
		
	
			<a href="cadastroPizza.jsp" class="btn btn-dark">Voltar</a>
		
		</div>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>