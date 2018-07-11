<%@page import="api.modelo.Rota"%>
<%@page import="java.util.List"%>
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
		<%
			List<Rota> listaRota = (List<Rota>)request.getAttribute("listaRotas");	
		%>
		<table border="1">
		<tr bgcolor="#eaeaea">
			<th>RotaID</th>
			<th>Bairro</th>
			<th>Instituição</th>
			<th>Periodo</th>
			<th>VanID</th>
			<th>Excluir</th>
			<th>Alterar</th>
		</tr>
		<%
		for (Rota r: listaRota){
			/*out.println("RotaID: "+ r.getId()+" Bairro: "+ r.getBairroSaida()+" Instituição: "+ r.getInstDestino()+ 
					" Periodo: "+ r.getPeriodo()+" VanID: "+r.getIdVan());*/
			
		%>
		<tr>
			<th><%= r.getId() %></th>
			<th><%= r.getBairroSaida() %></th>
			<th><%= r.getInstDestino() %></th>
			<th><%= r.getPeriodo() %></th>
			<th><%= r.getIdVan() %></th>
			<th><a href="BuscaRotas?acao=del&id=<%= r.getId()%>">Excluir</a></th>
			<th><a href="BuscaRotas?acao=alt&id=<%= r.getId()%>">Alterar</a></th>
		</tr>
		
		<%
		
		%>
		
		<%
		}
		%>
		</table>
				
			
	</div>
	
	<footer>
		
	</footer>





</body>
</html>