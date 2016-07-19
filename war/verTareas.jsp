<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="epis.unsa.alumno"%>
<%@ page import="epis.unsa.curso"%>

<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>

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
			var selecCursoVar = $('#selecCurso').val();
			
			$.post('verTareasPorAnhoYCurso', {
				anho : selecAnhoVar,
				curso : selecCursoVar,
				
			}, function(responseText) {
				$('#tabla').html(responseText);
			});
		});
	});
</script>
 
 
 
  </head>






  <body>
  <%String estado = (String)session.getAttribute("estado");%>
  	
  		<%if(estado.equals("NO ACTIVO")){%>
   		su estado es : <%=estado%>
   		su cuenta no puede ingresar datos
   	<%}%>
  
 
  
  	<%ArrayList<String> anhos = (ArrayList<String>)session.getAttribute("anhos");%>
  	 <%List<curso> cursos = (List<curso>) request.getAttribute("cursos");%>
  
  <h2>SELECCIONE ANHO Y CURSO PARA VER TAREAS</h2>
	<form id="form1">
	
		<select id="selecAnho">
				<option>--</option>
			 <%for(String anho :anhos){%>
  				<option value=<%=anho %> ><%=anho %></option>
  				<%}%>	
		</select>
		<select id="selecCurso">
				<option>--</option>
			 <%for(curso c :cursos){%>
  				<option value=<%=c.getId() %> ><%=c.getNombreCurso() %></option>
  				<%}%>	
		</select>
		
		<%if(estado.equals("ACTIVO")){%>
		<input type="button" id="sb" value="BUSCAR" />
		<%}%>
		<br> 
		<div id="tabla"></div>
		
	</form>
	<form action="comoDocente.jsp" method ="get">
    <input type="submit" value ="Regresar al menu">
   </form>
	

	|------------------------------| <br><br>
   
   <form action="cerrarSesion" method ="get">
    <input type="submit" value ="Cerrar Sesion">
   </form>
 
  </body>
</html>
