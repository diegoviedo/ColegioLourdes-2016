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

public class alumnoPorAnhoNota extends HttpServlet {
	
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
		String curso = request.getParameter("curso");
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(alumno.class);
		Query q1 = pm.newQuery(nota.class);
		
		if(!anho.equals("--") && !curso.equals("--")){
			Long idCur = Long.parseLong(curso);
		out.print("<h3>LISTA DE ALUMNOS DEL "+anho+" ANHO");
		
		out.print("<form action='asa'>");
		out.print("</form>");
		
		
		out.print("<form action='guardarNotas'>");
		out.print("<table width=600px>"+
		"<tr>"+
		"<td align='center'> ID </td>"+		
		"<td align='center'> CODIGO </td>"+
		"<td align='center'> NOMBRES </td>"+
		"<td align='center'> APELLIDOS </td>"+
		"<td align='center'> NOTA </td>"+
		"</tr>");
		
		int nota;
		try{
			List<alumno> alumnos = (List<alumno>) q.execute();
			List<nota> notas = (List<nota>) q1.execute();
			
			for(alumno a : alumnos){
					out.print("<tr>");
				nota=0;
				if(a.getAnho().equals(anho)){
					for(nota n: notas){
						curso c = pm.getObjectById(curso.class,n.getIdCurso());
						if(n.getIdAlumno().equals(a.getId())&&n.getIdCurso().equals(idCur))
							nota=n.getNota();
					}
					out.print("<td align='center' >"+a.getId()+"</td>");	
					out.print("<td align='center' >"+a.getCodigo()+"</td>");
					out.print("<td align='center' >"+a.getNombres()+"</td>");
					
					out.print("<td align='center' >"+a.getApellidos()+"</td>");	
					out.print("<td align='center' >");
					out.print("<input type='hidden' name='idAlumno'  value='"+a.getId()+"'>");
					out.print("<select name='nota'>");
					out.print("<option>--</option>");
					for(int i=0;i<21;i++){
						out.print("<option value='"+i+"'");
						if(nota==i)
							out.print("selected");
						out.print(">"+i+"</option>");
					}
					out.print("</select>");
					out.print("</td></tr>");	
					
					}
			}
			
			out.print("</table><br>");
			out.print("<input type='hidden' name='curso' value ='"+curso+"'>");
			out.print("<input type='submit' name='boton' value ='GUARDAR NOTAS'>");
			
			
			out.print("</form>");
		}catch(Exception e){
			
		}finally{
			pm.close();
			q.closeAll();
			q1.closeAll();
			 
		}
		
		
	}
	}
}
