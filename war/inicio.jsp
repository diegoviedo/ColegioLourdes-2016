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
    <title>Hello App Engine</title>
  </head>

  <body>
  
  
 
   
 	<h1> INICIAR SESION </h1>
   
   <form action="iniciarSesion" method ="get">
    CODIGO: <input type="text" name="codigo"><br>
    PASSWORD: <input type="password" name="pass"><br>
    <input type="submit" name="boton" value ="OK">
   </form>
   
 	
	 
	 <h3> COMUNICADOS </h3>
	 
	  <%if(!request.getAttribute("comunicados").equals(null)){%>
	 <%List<comunicado> comunicados = (List<comunicado>) request.getAttribute("comunicados");%>
  		  <%for(comunicado c :comunicados){%>

			<ul>
				<li><%=c.getComunicado()%><br>
					publicado por: <%=c.getNombresAdm()%> <%=c.getApellidosAdm()%> <br>
					fecha : <%=c.getFecha()%> 
			</ul>
		
  <%}%>
  <%}%>
 
 
 
   
  </body>
</html>