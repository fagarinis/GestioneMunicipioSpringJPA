<%@ page import="it.prova.gestionemunicipiospringjpa.model.Municipio" %>
<%@ page import="it.prova.gestionemunicipiospringjpa.model.Abitante" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="author" content="MohamedMohamedAli">
<title>Aggiorna abitante</title>
</head>
<body>

<% List<Municipio> municipi = (List<Municipio>) request.getAttribute("listaMunicipiAttributeName");
   Abitante abitante = (Abitante) request.getAttribute("abitanteAttr");
%>

<div class="container">

   <%@ include file="../header.jsp" %>
      
    <div class="page-header">
	  <h3>Aggiorna abitante</h3>
	</div>

      	<form class="form-horizontal" action="ExecuteUpdateAbitanteServlet" method="post">
      	<input type="hidden" id="nomeInputId" name="idAbitante" value=<%=abitante.getId() %>>
      		<div class="form-group">
      			<label class="control-label col-sm-2" for="nomeInputId">Nome:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="nomeInputId" name="nomeInput" value="<%=abitante.getNome() %>">
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="cognomeInputId">Cognome:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="cognomeInputId" name="cognomeInput" value="<%=abitante.getCognome() %>" >
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="etaInputId">Età:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="etaInputId" name="etaInput" value="<%=abitante.getEta() %>" >
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="indirizzoInputId">Indirizzo:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="indirizzoInputId" name="indirizzoInput" value="<%=abitante.getResidenza() %>" >
			 	</div>
  			</div>
			<div class="form-group">
      			<label class="control-label col-sm-2" for="municipioInputId">Municipio:</label>
	    		<div class="col-sm-4">
	    		
					<select class="form-control" name="idMunicipio" >
					<%for(Municipio m:municipi){ %>
					<!-- rende selezionato di default il municipio dell'abitante prima della modifica -->
					<option <%if(m.getId() == abitante.getMunicipio().getId()){%> selected <%} %>
					class="form-control" value="<%=m.getId()%>">
					<%=m.getDescrizione() %>
					</option>
					<%} %>
					
					</select>
					
			 	</div>
  			</div>
  			
  			<div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <button type="submit" class="btn btn-primary btn-md">Aggiorna</button>
		      </div>
		    </div>
		</form>
		
    </div><!-- /.container -->

</body>
</html>