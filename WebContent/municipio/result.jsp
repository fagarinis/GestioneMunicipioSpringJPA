<%@page import="it.prova.gestionemunicipiospringjpa.model.Municipio"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="author" content="matteodigge">
<title>Risultati</title>
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
</head>
<body>
	<div class="container">

   <%@ include file="../header.jsp" %>
  	
  	<div class="page-header">
	  <h3>Pagina dei Risultati</h3>
	</div>
  	
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Denominazione</th>
				<th>Action</th>
			</tr>
		</thead>
		<% List<Municipio> listaMunicipi = (List<Municipio>)request.getAttribute("listaMunicipiAttributeName"); 
			for(Municipio municipioItem:listaMunicipi){ %>
			<tr>
				<td><%=municipioItem.getDescrizione() %></td>
				<td>
					<a href="VisualizzaDettaglioMunicipioServlet?idMunicipio=<%=municipioItem.getId() %>" class="btn btn-info">Dettaglio</a>
					<a href="PrepareUpdateMunicipioServlet?idMunicipio=<%=municipioItem.getId() %>" class="btn btn-info">Modifica</a>
					<a href="PrepareDeleteMunicipioServlet?idMunicipio=<%=municipioItem.getId() %>" class="btn btn-info">Elimina</a>
				</td>
			</tr>
				
		<%	}
		
		%>
	
	</table>
	
	<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<a href="PrepareInsertMunicipioServlet"
					class="btn btn-primary btn-md">Inserisci Nuovo Elemento</a>
			</div>
		</div>

	<%@ include file="../footer.jsp" %>
	
	</div>

</body>
</html>