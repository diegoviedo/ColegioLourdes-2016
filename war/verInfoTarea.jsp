<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="epis.unsa.tarea"%>
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
  	
  	<h3>INFORMACION DE LA TAREA</h3>
 
  	<%tarea t = (tarea)request.getAttribute("tarea");%>
  	<%ArrayList<String> anhos = (ArrayList<String>)session.getAttribute("anhos");%>
  	<%ArrayList<curso> cursos = (ArrayList<curso>)request.getAttribute("cursos");%>
  	<%String [] meses = (String [])request.getAttribute("meses");%>
  	
  
	<form action="guardarModificacionTarea">
	
	<input type='hidden' name='idTarea'  value=<%=t.getId()%>>
	Seleccione Anho y Curso :  
		<select name="selecAnho">
			 <%for(String anho :anhos){%>
  					<option 
  					<%if(anho.equals(t.getAnho())){%>
  					selected
  					<%}%>
  				value=<%=anho %> ><%=anho%></option>
  				<%}%>	
		</select>
		<select name="selecCurso">
			 <%for(curso c :cursos){%>
			 	<%if(c.getEstado().equals("ACTIVO")){%>
  				<option 
  				<%if(t.getidCurso().equals(c.getId())){%>
  					selected
  					<%}%>
  				value=<%=c.getId() %> ><%=c.getNombreCurso() %></option>
  					<%}%>	
  				<%}%>	
		</select><br>
		
		 <textarea rows="4" cols="50" name="tarea"><%=t.getTarea()%>
		</textarea><br>
  	 	TIEMPO LIMITE : <br> MES  :
  	 	<select name ="mes">
  	 	<%for(int i=0;i<meses.length;i++){%>
  	 		<option 
  	 		<%if(i==Integer.parseInt(t.getMes())){%>
  	 		selected
  	 		<%}%>
  	 		value =<%=i%>><%=meses[i]%></option>
  	 		<%}%>
		</select>
  	 	
  	 	DIA  : 
  	 	
		<select name ="dia">
  	 		<%for(int i=1;i<=30;i++){%>
  	 		<option 
  	 		<%if(i==Integer.parseInt(t.getDia())){%>
  	 		selected
  	 		<%}%>
  	 		value =<%=i%>><%=i%></option>
  	 		<%}%>
  	 	</select>
		HORA  : 
		<select name ="hora">
		<%for(int i=0;i<=23;i++){%>
  	 		<option 
  	 		<%if(i==Integer.parseInt(t.getHora())){%>
  	 		selected
  	 		<%}%>
  	 		value =<%=i%>><%=i%></option>
  	 		<%}%>
		</select>
		
		MINUTO  :
		<select name ="minuto">
		<%for(int i=0;i<=59;i++){%>
  	 		<option 
  	 		<%if(i==Integer.parseInt(t.getMinuto())){%>
  	 		selected
  	 		<%}%>
  	 		value =<%=i%>><%=i%></option>
  	 		<%}%>
		</select>
		
		
		
		<input type="submit"  value="GUARDAR CAMBIOS" />
		<br> 
		
		
	</form>

 
  </body>
</html>
