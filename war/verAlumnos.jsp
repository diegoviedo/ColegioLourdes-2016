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
 <style>
   table, tr, td {
    border: 3px solid black;
    border-collapse: collapse;
    align:center;
}
 </style>
 
 <script src="http://code.jquery.com/jquery-latest.js">
	
</script>
<script>

	$(document).ready(
			function() {
		$('#sb').click(function(event) {
			var selecAnhoVar = $('#selecAnho').val();
			
			$.post('alumnoPorAnho', {
				anho : selecAnhoVar,
				
			}, function(responseText) {
				$('#tabla').html(responseText);
			});
		});
	});
</script>
 
 
 
  </head>






  <body>
  
  
  
  
  
 <h3>LISTA DE ALUMNOS</h3>
 

  
  
  
  
  <h2>SELECCIONE ANHO</h2>
	<form id="form1">
		<select id="selecAnho">
			<option value="--" >-----</option>
			<option value="1RO" >1RO</option>
			<option value="2DO">2DO</option>
			<option value="3RO">3RO</option>
			<option value="4TO">4TO</option>
			<option value="5TO" >5TO</option>
			
		</select>
		<input type="button" id="sb" value="Ver" />
		<br> 
		<div id="tabla"></div>
		
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
