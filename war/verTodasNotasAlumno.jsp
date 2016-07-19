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
 
 
  </head>






  <body>
  
 
  <%String nombres = (String)session.getAttribute("nombres");%>
  	
  	<h1>BIENVENIDO  <%=nombres%></h1>
  	
  	<%List<curso> cursos = (List<curso>)request.getAttribute("cursos");%>
  	<%ArrayList<String> notas = (ArrayList<String>)request.getAttribute("notas");%>

  
  <h2>TODAS LAS NOTAS</h2>
  
  	<table width=600px>
		<tr>
		<td align="center"> CURSO </td>
		<td align="center"> NOTA </td>			
		
		
		</tr>
  
  
  <%for(int i=0;i<cursos.size();i++){%>
  
			<tr>
			<td align="center" ><%=cursos.get(i).getNombreCurso() %></td>
			<td align="center" ><%=notas.get(i) %></td>			
			
			</tr>
  <%}%>
  </table>
  <br>
   <form action="comoAlumno.jsp" method ="get">
    <input type="submit" value ="Regresar al menu">
   </form>
  
  
	|------------------------------| <br><br>
   
   <form action="cerrarSesion" method ="get">
    <input type="submit" value ="Cerrar Sesion">
   </form>
 
  </body>
</html>
