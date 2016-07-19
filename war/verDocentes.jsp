<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="epis.unsa.docente"%>

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
  </head>

  <body>
  
  
  
  
  
 <h3>LISTA DE DOCENTES</h3>
 

  	<table width=600px>
		<tr>
		<td align="center"> ID </td>
		<td align="center"> NOMBRE  </td>			
		<td align="center"> APELLIDOS </td>
		<td align="center"> ANHOS </td>
		<td align="center"> ESTADO </td>
		
		
		</tr>
  
  <%List<docente> docentes = (List<docente>) request.getAttribute("docentes");%>
  <%for(docente p :docentes){%>
  
			<tr>
			<td align="center" ><%=p.getId() %></td>
			<td align="center" ><%=p.getNombres() %></td>		
			<td align="center" ><%=p.getApellidos() %></td>		
			<td align="center">-
			<%for(int i=0;i<p.getAnhos().size();i++){%>
			<%=p.getAnhos().get(i)%>-
			<%}%>
			</td>
			<td align="center"><%=p.getEstado() %></td>
			<td align='center'><form style='height:5px'  action="modificarDocente"><input type="hidden" name="idDocente"  value=<%=p.getId() %>><input style='width:110px'  type="submit" name="boton" value ="MODIFICAR"/></form></td>	
			<td align='center'><form style='height:5px'  action="modificarDocente"><input type="hidden" name="idDocente"  value=<%=p.getId() %>><input style='width:110px'  type="submit" name="boton" value ="ELIMINAR"/></form></td>	
				
			</tr>
		
  <%}%>
  
  </table>

   
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
