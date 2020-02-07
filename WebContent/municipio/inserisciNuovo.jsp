
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserisci Municipio</title>
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
</head>
<body>

	<div class="container">
	<%@ include file="/header.jsp" %>
 	
 	<!-- header -->
 	<div class="page-header">
    <h3>Inserisci Municipio</h3>
    </div>
 	
 	<form action="ExecuteInsertMunicipioServlet" method="post">
    <div class="form-group">
      			<label class="control-label col-sm-2" for="descrizioneInputId">DESCRIZIONE:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="descrizioneInputId" name="descrizioneInput" >
			 	</div>
			 	</div>
			 	<div class="form-group">
      			<label class="control-label col-sm-2" for="codiceInputId">CODICE:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="codiceInputId" name="codiceInput" >
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="ubicazioneInputId">UBICAZIONE:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="ubicazioneInputId" name="ubicazioneInput" >
			 	</div>
  			</div>
  			<div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <button type="submit" class="btn btn-primary btn-md">Salva</button>
		      </div>
		    </div>
  			</form>
  			
  			<%@ include file="/footer.jsp" %>

</body>
</html>