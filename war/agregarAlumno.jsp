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
   <h1> AGREGAR ALUMNO </h1>
   
   <form action="agregarAlumno" method ="get">
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
   		Año
	   <select name="anho">
			<option value="1RO" >1RO</option>
			<option value="2DO">2DO</option>
			<option value="3RO">3RO</option>
			<option value="4TO">4TO</option>
			<option value="5TO" >5TO</option>
		</select><br>
   		
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
