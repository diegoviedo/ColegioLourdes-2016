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
  
  
  
  
  	<%String nombres = (String)session.getAttribute("nombres");%>
  	<%String estado = (String)session.getAttribute("estado");%>
  	
  	<h1>BIENVENIDO  <%=nombres%></h1>
   
   	<%if(estado.equals("NO ACTIVO")){%>
   		su estado es : <%=estado%>
   		su cuenta no puede ingresar datos
   	<%}%>
   	
   <h3> NOTAS </h3>
   
   <form action="cursosDelDocente" method ="get">
    <input type="submit" value ="Agregar Notas">
   </form>
   
   |------------------------------|
    
   <h3> TAREAS </h3>
   
   <form action="agregarTarea" method ="get">
    <input type="submit" value ="Agregar Tarea">
   </form>
   
    <form action="verTareas" method ="get">
    <input type="submit" value ="Ver Tareas">
   </form>
  
  	
   |------------------------------| <br><br>
   
   <form action="cerrarSesion" method ="get">
    <input type="submit" value ="Cerrar Sesion">
   </form>
   
   
   	
   
   
   
  </body>
</html>