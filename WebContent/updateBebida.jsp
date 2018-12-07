<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="br.com.smart2.dao.*"%>
<%@ page import="br.com.smart2.model.*"%>
<%@ page import="java.util.List"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="javax.servlet.http.HttpServlet"%>
    
<!DOCTYPE html>
<%

HttpSession session2 = request.getSession();

session2.getAttribute("bebida1");

%>
<html>
<head>
<meta charset="UTF-8">
<title>UPDATE</title>


<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>


	<div class="container">
		<div class="col-4">
		
			<fieldset>
				<form  action="editar?id=${bebida1.id}" method="post">
				
					<div class="form-group">
						<label for="_nome">Nome</label>
						<input type="text" class="form-control" id="_nome" name="nome" value="${bebida1.nome }" required>
					</div>
					
					<div class="form-group">
						<label for="_tamanho">Tamanho</label>
						<input type="text" class="form-control" id="_tamanho" value="${bebida1.tamanho}" name="tamanho" required>
					</div>
					
					<div class="form-group">
						<label for="_preco">Preço</label>
						<input type="number" step="0.10" class="form-control"  value="${bebida1.valor}" id="_preco" name="valor" required>
					</div>
					
					<button class="btn btn-primary">Atualizar</button>
				</form>
			</fieldset>
		</div>
		</div>
	
	
	<a class="btn btn-danger" href="cadastroBebida.jsp">Voltar</a>
	
	
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>


</body>
</html>