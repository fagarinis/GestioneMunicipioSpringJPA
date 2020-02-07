<%@page import="it.prova.gestionemunicipiospringjpa.model.Abitante"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cancella Abitante</title>
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
</head>
<body>

	<%		//test
			//Abitante abitanteInPagina = new Abitante("mario", "rossi", 25, "via mosca");
		Abitante abitanteInPagina = (Abitante) request.getAttribute("abitanteInput");
	%>

	<div class="container">
	
		
		<%@ include file="/header.jsp"%> 

		<div class="page-header">
			<h3>Pagina di conferma cancellazione</h3>
		</div>
		<div class="container-fluid">
			<dl class="row">
				<dt class="col-sm-3 text-right">Id</dt>
				<dd class="col-sm-9"><%=abitanteInPagina.getId()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Nome</dt>
				<dd class="col-sm-9"><%=abitanteInPagina.getNome()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Cognome</dt>
				<dd class="col-sm-9"><%=abitanteInPagina.getCognome()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Eta</dt>
				<dd class="col-sm-9"><%=abitanteInPagina.getEta() %></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Residenza</dt>
				<dd class="col-sm-9"><%=abitanteInPagina.getResidenza() %></dd>
			</dl>

		</div>
		
		
		<form action = "ExecuteDeleteAbitanteServlet" method ="post">
			<input type = "hidden" name = "idAbitante" value = "<%=abitanteInPagina.getId()%>" >
			
			<input class="container-fluid" type ="submit" value ="Cancella">
		</form>

	</div>

</body>
</html>