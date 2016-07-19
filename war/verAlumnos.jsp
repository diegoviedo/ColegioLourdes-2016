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
 

  	<table width=600px>
		<tr>
		<td align="center"> ID </td>
		<td align="center"> CODIGO </td>			
		<td align="center">NOMBRES</td>
		<td align="center">APELLIDOS</td>
		<td align="center">ESTADO</td>
		
		</tr>
  
  <%List<alumno> alumnos = (List<alumno>) request.getAttribute("alumnos");%>
  <%for(alumno p :alumnos){%>
  
			<tr>
			<td align="center" ><%=p.getId() %></td>
			<td align="center" ><%=p.getCodigo() %></td>			
			<td align="center"><%=p.getNombres() %></td>
			<td align="center"><%=p.getApellidos() %></td>
			<td align="center"><%=p.getEstado() %></td>
			<td align="center"><form style='height:5px;'   action ="ad"><input type="hidden" name="valorOculto"  value="xD"  ><input style='width:110px' type="submit" value ="MODIFICAR"></form></td>
			<td align="center"><input style='width:110px' type="submit" value ="ELIMINAR"></td>
			
			</tr>
		
  <input type="hidden" name="valorOculto"  value="xD"  >
  <%}%>
  </table>
  
  
  
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
