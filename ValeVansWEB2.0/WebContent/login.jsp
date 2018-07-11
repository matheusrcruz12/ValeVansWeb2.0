<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="static/css/estilos.css">
    <script type="text/javascript" src='static/js/script.js'></script>
</head>
<body>
<header>
	<nav> </nav>
</header>
<div id="main" >
	<form id="central" action="Autenticador" method="post">
	
		'<input type="email" name="loginEmail" required='required' placeholder="Insira seu email...">
			
			<input type="password" name="loginSenha" required='required' placeholder="Insira sua senha..."> 
			 
			<input class="btn" type="submit" value="Logar">
			<label>Não possuo uma conta : <a href="cadastro.jsp">Criar Conta</a> </label>
	</form>
</div>
<footer>
	
</footer>
</body>
</html>