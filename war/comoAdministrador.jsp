<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- The HTML 4.01 Transitional DOCTYPE declaration-->
<!-- above set at the top of the file will set     -->
<!-- the browser's rendering engine into           -->
<!-- "Quirks Mode". Replacing this declaration     -->
<!-- with a "Standards Mode" doctype is supported, -->
<!-- but may lead to some differences in layout.   -->

	
	<%String nombres = (String)session.getAttribute("nombres");%>
	<%String apellidos = (String)session.getAttribute("apellidos");%>
	
<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title></title>
  </head>

  <body>
  
  <h1>BIENVENIDO ADMINISTRADOR  <%=nombres%>   <%=apellidos%>    </h1>
  
  
   <h3> ALUMNOS </h3>
   
   <form action="agregarAlumno.jsp" method ="get">
    <input type="submit" value ="Agregar Alumno">
   </form>
   
   
    <form action="verAlumnos" method ="get">
    <input type="submit" value ="Ver Alumnos">
   </form>
   
   
   <h3> CURSOS </h3>
   
   <form action="agregarCurso.jsp" method ="get">
    <input type="submit" value ="AgregarCursos">
   </form>
   
   
    <form action="verCursos" method ="get">
    <input type="submit" value ="Ver Cursos">
   </form>
   
   <h3> DOCENTES </h3>
   
   <form action="cursosParaDocente" method ="get">
    <input type="submit" value ="Agregar Docente">
   </form>
   
   
    <form action="verDocentes" method ="get">
    <input type="submit" value ="Ver Docente">
   </form>
   
   
   
   
   
   
   
   <h3> COMUNICADOS </h3>
   
   <form action="agregarComunicado.jsp" method ="get">
    <input type="submit" value ="Agregar Comunicado">
   </form>
	
	 <form action="verComunicados" method ="get">
    <input type="submit" value ="Ver Comunicados">
   </form>
   
   
    
  	
   |------------------------------| <br><br>
   
   <form action="cerrarSesion" method ="get">
    <input type="submit" value ="Cerrar Sesion">
   </form>
   
   
   
   
  </body>
</html>
