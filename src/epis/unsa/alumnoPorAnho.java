package epis.unsa;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class alumnoPorAnho extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	//private ArrayList<Persona> personas = new ArrayList<>();
	private ArrayList<String> recursos = new ArrayList<>();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		response.setContentType( "text/html; charset=iso-8859-1" );
		PrintWriter out = response.getWriter();
		
		String anho = request.getParameter("anho");
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(alumno.class);
		if(!anho.equals("--")){
		out.print("<h3>LISTA DE ALUMNOS DEL "+anho+" ANHO");
		out.print("<table width=600px>"+
		"<tr>"+
		"<td align='center'> ID </td>"+		
		"<td align='center'> CODIGO </td>"+
		"<td align='center'> NOMBRES </td>"+
		"<td align='center'> APELLIDOS </td>"+
		"<td align='center'> ESTADO </td>"+
		"</tr>");
		
		
		try{
			
			List<alumno> alumnos = (List<alumno>) q.execute();
				for(alumno p: alumnos){
					if(p.getAnho().equals(anho)){
						out.print("<form action='asd'>");
						//out.print("<input type='submit' name='boton' value ='MODIFICAR'>");
						out.print("</form>");
				out.print("<tr>"+
				
				"<td align='center' >"+p.getId()+"</td>"+
				"<td align='center' >"+p.getCodigo()+"</td>"+			
				"<td align='center'>"+p.getNombres()+"</td>"+	
				"<td align='center'>"+p.getApellidos()+"</td>"+	
				"<td align='center'>"+p.getEstado()+"</td>"+	
				
				"<td align='center'><form style='height:5px'  action='modificarAlumno'><input type='hidden' name='idAlumno'  value='"+p.getId()+"'><input style='width:110px'  type='submit' name='boton' value ='MODIFICAR'/></form></td>"+	
				"<td align='center'><form style='height:5px'  action='modificarAlumno'><input type='hidden' name='idAlumno'  value='"+p.getId()+"'><input style='width:110px'  type='submit'  name='boton' value ='ELIMINAR'/></form></td>"+	
				"</tr>");	
				
					}
			}
				
			out.print("</table>");
	
		}catch(Exception e){
			
		}finally{
			pm.close();
			 q.closeAll();
		}
		
		
	}
	}
}
