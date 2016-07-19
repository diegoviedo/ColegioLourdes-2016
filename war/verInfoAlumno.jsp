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
  </head>






  <body>
  
  
  
  
  
 <h3>INFORMACION DEL ALUMNO</h3>
 
  <%alumno alum = (alumno) request.getAttribute("alum");%>
  
	<form action="guardarModificacionAlumno" method ="get">
		ID :<%=alum.getId() %><br>
		<input type="hidden" name="idAlum"  value=<%=alum.getId() %>  >
	   Codigo <input type="text" placeholder="Codigo" name="codigo" value= <%=alum.getCodigo() %>><br>
	   Contraseña <input type="text" placeholder="Contraseña" name="contrasena" value=<%=alum.getContrasena() %>><br>
	   Nombres <input type="text" placeholder="Nombres" name="nombres" value=<%=alum.getNombres() %>><br>
	   Apellidos <input type="text" placeholder="Apellidos" name="apellidos" value=<%=alum.getApellidos() %>><br>
	   Direccion <input type="text" placeholder="Direccion" name="direccion" value=<%=alum.getDireccion() %>><br>
	   
 
   	   Sexo
	   <select name="sexo">
			<option <%if(alum.getSexo().equals("masculino")){%> selected <%}%> value="masculino">Masculino</option>
			<option <%if(alum.getSexo().equals("femenino")){%> selected <%}%> value="femenino">Femenino</option>
		</select><br>
   		Año
	   <select name="anho">
			<option <%if(alum.getAnho().equals("1RO")){%> selected <%}%> value="1RO" >1RO</option>
			<option <%if(alum.getAnho().equals("2DO")){%> selected <%}%> value="2DO">2DO</option>
			<option <%if(alum.getAnho().equals("3RO")){%> selected <%}%> value="3RO">3RO</option>
			<option <%if(alum.getAnho().equals("4TO")){%> selected <%}%> value="4TO">4TO</option>
			<option <%if(alum.getAnho().equals("5TO")){%> selected <%}%> value="5TO" >5TO</option>
		</select><br>
   		
   		
   		Estado
   		<select name="estado">
			<option <%if(alum.getEstado().equals("ACTIVO")){%> selected <%}%> value="ACTIVO">ACTIVO</option>
			<option <%if(alum.getEstado().equals("NO ACTIVO")){%> selected <%}%> value="NO ACTIVO">NO ACTIVO</option>
		</select><br>
   		
   		
   		
   		
   		
   		Agregar foto: 
   		<input type="file"  name="archivo"><br>
   
   
  	 	
    
    <input type="submit" value ="GUARDAR">
   </form>		

  </body>
</html>
