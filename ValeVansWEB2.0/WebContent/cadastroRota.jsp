<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="static/css/estilos.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro Rota</title>
</head>
<body>

	<header>
		<nav></nav>
		<jsp:include page="menu.jsp"></jsp:include>
	</header>
	
	<div class="main">
		<form id="cad" action="CadRota" method="post">
		
			<input type="text" name="idVan" required="required" placeholder="Insira o id da van">
			
			<input type="text" name="bairro" required="required" placeholder="Insira o bairro">
			
			<input type="text" name="instituicao" required="required" placeholder="Insira o Instituição">
			<select  name="periodo">
			<option>Selecione um periodo</option>
				<option value="manha">Manhã</option>
				<option value="tarde">Tarde</option>
				<option value="noite">Noite</option>
			</select>
			<input type="submit" value="Cadastrar">

		
		</form>
				
			
	</div>
	
	<footer>
		
	</footer>





</body>
</html>