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
			var codigoVar = $('#codigo').val();
			var contrasenaVar = $('#contrasena').val();
			var nombresVar = $('#nombres').val();
			var apellidosVar = $('#apellidos').val();
			
			
			$.post('agregarAdministrador', {
				codigo : codigoVar,
				contrasena : contrasenaVar,
				nombres : nombresVar,
				apellidos : apellidosVar,
				
				
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
		Codigo  <input type="text" placeholder="Codigo" id="codigo"><br>
		Contrasenha  <input type="text" placeholder="Contrasena" id="contrasena"><br>
		Nombres  <input type="text" placeholder="Nombres" id="nombres"><br>
		Apellidos  <input type="text" placeholder="Apellidos" id="apellidos"><br>
		
		<input type="button" id="sb" value="AGREGAR ADMINISTRADOR" />
		<br> 
		<div id="frase"></div>
		
	</form>

  	
  
  
  
  <!-- 
  <input type='button' name='boton' value='Boton' style='width:70px; height:50px'>
   --> 
  
  </body>
</html>
