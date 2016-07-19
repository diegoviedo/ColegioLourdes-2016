<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="epis.unsa.curso"%>

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
  </head>






  <body>
  
  
  
  
  
 <h3>INFORMACION DEL CURSO</h3>
 
  <%curso c = (curso) request.getAttribute("curso");%>
  
	<form action="guardarModificacionCurso" method ="get">
		ID :<%=c.getId() %><br>
		<input type="hidden" name="idCurso"  value=<%=c.getId() %>  >
	   Nombre del Curso  <input type="text" placeholder="Nombre del Curso" name="nombreCurso" value=<%=c.getNombreCurso() %>><br>
	     Estado
   		<select name="estado">
			<option <%if(c.getEstado().equals("ACTIVO")){%> selected <%}%> value="ACTIVO">ACTIVO</option>
			<option <%if(c.getEstado().equals("NO ACTIVO")){%> selected <%}%> value="NO ACTIVO">NO ACTIVO</option>
		</select><br>
   		
   		
    <input type="submit" value ="GUARDAR">
   </form>		

  </body>
</html>
