<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="epis.unsa.alumno"%>

<%@ page import="java.util.List"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- The HTML 4.01 Transitional DOCTYPE declaration-->
<!-- above set at the top of the file will set     -->
<!-- the browser's rendering engine into           -->
<!-- "Quirks Mode". Replacing this declaration     -->
<!-- with a "Standards Mode" doctype is supported, -->
<!-- but may lead to some differences in layout.   -->

<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>hHello App Engine</title>
 
 <script src="http://code.jquery.com/jquery-latest.js">
	
</script>
<script>

	$(document).ready(
			function() {
		$('#sb').click(function(event) {
			var nombreCursoVar = $('#nombreCurso').val();
			
			$.post('agregarCurso', {
				curso : nombreCursoVar,
				
			}, function(responseText) {
				$('#frase').html(responseText);
			});
		});
	});
</script>
 
 
 
  </head>
  <body>
  
 <h3>AGREGAR CURSO</h3>
 
	<form id="form1">
		Nombre del Curso  <input type="text" placeholder="Nombre del Curso" id="nombreCurso">
		<input type="button" id="sb" value="AGREGAR CURSO" />
		<br> 
		<div id="frase"></div>
		
	</form>

  	
  
	<form action="comoAdministrador.jsp" method ="get">
    <input type="submit" value ="Regresar al menu">
   </form>

 	|------------------------------| <br><br>
   
   <form action="cerrarSesion" method ="get">
    <input type="submit" value ="Cerrar Sesion">
   </form>
 	
    
    
  </body>
</html>
