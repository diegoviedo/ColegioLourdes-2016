<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="epis.unsa.comunicado"%>

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
  
  
  
  
  
 <h3>INFORMACION DEL COMUNICADO</h3>
 
  <%comunicado c = (comunicado) request.getAttribute("comunicado");%>
  
	<form action="guardarModificacionComunicado" method ="get">
		ID :<%=c.getId() %><br>
		<input type="hidden" name="idComunicado"  value=<%=c.getId() %>  >
		
	   <textarea rows="4" cols="50" name="comunicado">
		<%=c.getComunicado() %>
		</textarea><br>
  	 	
   		
    <input type="submit" value ="GUARDAR">
   </form>		

  </body>
</html>
