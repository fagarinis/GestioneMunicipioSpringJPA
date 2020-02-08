<%@page import="it.prova.gestionemunicipiospringjpa.model.Municipio" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="author" content="cirotrent">
<title>Cancella Municipio</title>
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
</head>
<body>
	<div class="container">

		<%@ include file="/header.jsp"%>

		<div class="page-header">
			<h3>Cancellazione</h3>
		</div>

		<%Municipio municipio = (Municipio) request.getAttribute("deletemunicipio"); %>
		<form action="ExecuteDeleteMunicipioServlet" method="post">
			<div class="container-fluid">
				<dl class="row">
					<dt class="col-sm-3 text-right">Id</dt>
					<dd class="col-sm-9"><%=municipio.getId()%></dd>
				</dl>
				<dl class="row">
					<dt class="col-sm-3 text-right">Descrizione</dt>
					<dd class="col-sm-9"><%=municipio.getDescrizione()%></dd>
				</dl>
				<dl class="row">
					<dt class="col-sm-3 text-right">Codice</dt>
					<dd class="col-sm-9"><%=municipio.getCodice()%></dd>
				</dl>
				<dl class="row">
					<dt class="col-sm-3 text-right">Ubicazione</dt>
					<dd class="col-sm-9"><%=municipio.getUbicazione()%></dd>
				</dl>
			</div>

			<input type=hidden name="idmunicipiodacancellare"
				value="<%=municipio.getId() %>">
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary btn-md">Cancella</button>
				</div>
			</div>
		</form>
		<%@ include file="../footer.jsp"%>
	</div>
	

</body>
</html>