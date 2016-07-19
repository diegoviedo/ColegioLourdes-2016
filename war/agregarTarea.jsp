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

 
 
  </head>






  <body>
  
 	
  	<%String estado = (String)session.getAttribute("estado");%>
  	
  		<%if(estado.equals("NO ACTIVO")){%>
   		su estado es : <%=estado%>
   		su cuenta no puede ingresar datos
   	<%}%>
  
 	
 	
  
  	<%ArrayList<String> anhos = (ArrayList<String>)session.getAttribute("anhos");%>
  	<%ArrayList<curso> cursos = (ArrayList<curso>)request.getAttribute("cursos");%>
  	<%String [] meses = (String [])request.getAttribute("meses");%>
  	<%String mes = (String)request.getAttribute("mes");%>
  	<%String dia = (String)request.getAttribute("dia");%>
  	<%String hora = (String)request.getAttribute("hora");%>
  	<%String minuto = (String)request.getAttribute("minuto");%>
  	
  
	<form action="guardarTarea">
	Seleccione Anho y Curso :  
		<select name="selecAnho">
				<option>--</option>
			 <%for(String anho :anhos){%>
  				<option value=<%=anho %> ><%=anho %></option>
  				<%}%>	
		</select>
		<select name="selecCurso">
				<option>--</option>
			 <%for(curso c :cursos){%>
			 	<%if(c.getEstado().equals("ACTIVO")){%>
  				<option value=<%=c.getId() %> ><%=c.getNombreCurso() %></option>
  					<%}%>	
  				<%}%>	
		</select><br>
		
		 <textarea rows="4" cols="50" name="tarea">
		</textarea><br>
  	 	TIEMPO LIMITE : <br> MES  :
  	 	<select name ="mes">
  	 	<%for(int i=0;i<meses.length;i++){%>
  	 		<option 
  	 		<%if(i==Integer.parseInt(mes)){%>
  	 		selected
  	 		<%}%>
  	 		value =<%=i%>><%=meses[i]%></option>
  	 		<%}%>
		</select>
  	 	
  	 	DIA  : 
  	 	
		<select name ="dia">
  	 		<%for(int i=1;i<=30;i++){%>
  	 		<option 
  	 		<%if(i==Integer.parseInt(dia)){%>
  	 		selected
  	 		<%}%>
  	 		value =<%=i%>><%=i%></option>
  	 		<%}%>
  	 	</select>
		HORA  : 
		<select name ="hora">
		<%for(int i=0;i<=23;i++){%>
  	 		<option 
  	 		<%if(i==Integer.parseInt(hora)){%>
  	 		selected
  	 		<%}%>
  	 		value =<%=i%>><%=i%></option>
  	 		<%}%>
		</select>
		
		MINUTO  :
		<select name ="minuto">
		<%for(int i=0;i<=59;i++){%>
  	 		<option 
  	 		<%if(i==Integer.parseInt(minuto)){%>
  	 		selected
  	 		<%}%>
  	 		value =<%=i%>><%=i%></option>
  	 		<%}%>
		</select>
		
		
		<%if(estado.equals("ACTIVO")){%>
		<input type="submit"  value="AGREGAR TAREA" />
			<%}%>
		<br> 
		
		
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
