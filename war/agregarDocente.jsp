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
  </head>

  <body>
   <h1> AGREGAR DOCENTE </h1>
   <%List<curso> cursos = (List<curso>) request.getAttribute("cursos");%>
   <form action="agregarDocente" method ="get">
	   Codigo <input type="text" placeholder="Codigo" name="codigo"><br>
	   Contraseña <input type="text" placeholder="Contraseña" name="contrasena"><br>
	   Nombres <input type="text" placeholder="Nombres" name="nombres"><br>
	   Apellidos <input type="text" placeholder="Apellidos" name="apellidos"><br>
	   Direccion <input type="text" placeholder="Direccion" name="direccion"><br>
	   
 
   	   Sexo
	   <select name="sexo">
			<option value="masculino">Masculino</option>
			<option value="femenino">Femenino</option>
		</select><br>
   		
   		Tutor Año : <br>
   			<input type="checkbox"  name="anhos" value="1RO"> 1RO <br>
   			<input type="checkbox"  name="anhos" value="2DO"> 2DO <br>
   			<input type="checkbox"  name="anhos" value="3RO"> 3RO <br>
   			<input type="checkbox"  name="anhos" value="4TO"> 4TO <br>
   			<input type="checkbox"  name="anhos" value="5TO"> 5TO <br>	
   		
   		
   		Cursos: <br>
   		<%for(curso p :cursos){%> 
   			<%if(p.getEstado().equals("ACTIVO")){%>   
			<input type="checkbox"  name="cursos" value=<%=p.getId() %>> <%=p.getNombreCurso() %>
			<br>
			<%}%>	
   		  <%}%>
   		
   		
	  	Correo <input type="text" placeholder="Correo" name="correo"><br>
	  	Telefono <input type="text" placeholder="Telefono" name="telefono"><br>
	   
   		
   		
   		Agregar foto: 
   		<input type="file"  name="archivo"><br>
   
   
  	 	
    
    <input type="submit" value ="REGISTRAR">
    
   </form>
   
   
       <br><br>
	<form action="comoAdministrador.jsp" method ="get">
    <input type="submit" value ="Regresar al menu">
   </form>

 	|------------------------------| <br><br>
   
   <form action="cerrarSesion" method ="get">
    <input type="submit" value ="Cerrar Sesion">
   </form>
 	
    
   
  </body>
</html>
