<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="epis.unsa.docente"%>
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
  
  
  
  
  
 <h3>INFORMACION DEL DOCENTE</h3>
 
  <%docente doc = (docente) request.getAttribute("doc");%>
   <%List<curso> cursos = (List<curso>) request.getAttribute("cursos");%>
  
	<form action="guardarModificacionDocente" method ="get">
		ID :<%=doc.getId() %><br>
		<input type="hidden" name="idDocente"  value=<%=doc.getId() %>  >
	   Codigo <input type="text" placeholder="Codigo" name="codigo" value= <%=doc.getCodigo() %>><br>
	   Contraseña <input type="text" placeholder="Contraseña" name="contrasena" value=<%=doc.getContrasena() %>><br>
	   Nombres <input type="text" placeholder="Nombres" name="nombres" value=<%=doc.getNombres() %>><br>
	   Apellidos <input type="text" placeholder="Apellidos" name="apellidos" value=<%=doc.getApellidos() %>><br>
	   Direccion <input type="text" placeholder="Direccion" name="direccion" value=<%=doc.getDireccion() %>><br>
	   
 
   	   Sexo
	   <select name="sexo">
			<option <%if(doc.getSexo().equals("masculino")){%> selected <%}%> value="masculino">Masculino</option>
			<option <%if(doc.getSexo().equals("femenino")){%> selected <%}%> value="femenino">Femenino</option>
		</select><br>
   		
		Tutor Año : <br>
   			
   			<input type="checkbox" 
			<%for(int i=0;i<doc.getAnhos().size();i++){ %>
			<%if(doc.getAnhos().get(i).equals("1RO")){%>
			checked
			<%}} %>
			 name="anhos" value="1RO"> 1RO <br>
   			
   			<input type="checkbox"  
   			<%for(int i=0;i<doc.getAnhos().size();i++){ %>
			<%if(doc.getAnhos().get(i).equals("2DO")){%>
			checked
			<%}} %>
   			name="anhos" value="2DO"> 2DO <br>
   			
   			<input type="checkbox"  
   			<%for(int i=0;i<doc.getAnhos().size();i++){ %>
			<%if(doc.getAnhos().get(i).equals("3RO")){%>
			checked
			<%}} %>
   			name="anhos" value="3RO"> 3RO <br>
   			
   			<input type="checkbox"  
   			<%for(int i=0;i<doc.getAnhos().size();i++){ %>
			<%if(doc.getAnhos().get(i).equals("4TO")){%>
			checked
			<%}} %>
   			name="anhos" value="4TO"> 4TO <br>
   			
   			<input type="checkbox"  
   			<%for(int i=0;i<doc.getAnhos().size();i++){ %>
			<%if(doc.getAnhos().get(i).equals("5TO")){%>
			checked
			<%}} %>
   			name="anhos" value="5TO"> 5TO <br>	
   		
   		Cursos: <br>
   		<%for(curso p :cursos){%> 
   			<%if(p.getEstado().equals("ACTIVO")){%>   
			<input type="checkbox"  
			<%for(int i=0;i<doc.getCursos().size();i++){ %>
			<%if(doc.getCursos().get(i).equals(String.valueOf(p.getId()))){%>
			checked
			<%}} %>
			name="cursos" value=<%=p.getId() %>> <%=p.getNombreCurso() %>
			<br>
			<%}%>	
   		  <%}%>
   		
   		
   		
   		Estado
   		<select name="estado">
			<option <%if(doc.getEstado().equals("ACTIVO")){%> selected <%}%> value="ACTIVO">ACTIVO</option>
			<option <%if(doc.getEstado().equals("NO ACTIVO")){%> selected <%}%> value="NO ACTIVO">NO ACTIVO</option>
		</select><br>
   		
   		
   		
   		
   		
   		Agregar foto: 
   		<input type="file"  name="archivo"><br>
   
   
  	 	
    
    <input type="submit" value ="GUARDAR">
   </form>		

  </body>
</html>
