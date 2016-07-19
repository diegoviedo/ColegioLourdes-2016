package epis.unsa;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class verTareaAlumnoPorCurso extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	//private ArrayList<Persona> personas = new ArrayList<>();
	private ArrayList<String> recursos = new ArrayList<>();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		response.setContentType( "text/html; charset=iso-8859-1" );
		PrintWriter out = response.getWriter();
		HttpSession misesion= request.getSession();
		String anho = (String)misesion.getAttribute("anho");
		String curso = request.getParameter("curso");
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		
		
		Query q = pm.newQuery(tarea.class);
		if(!curso.equals("--")){
		curso c = pm.getObjectById(curso.class,Long.parseLong(curso));	
		out.print("<h3>TAREA DEL CURSO DE : " + c.getNombreCurso()+"</h3>");
		out.print("<table width=600px>"+
		"<tr>"+
		"<td align='center'> ID </td>"+		
		"<td align='center'> TAREA </td>"+
		"<td align='center'> FECHA DE PUBLICACION </td>"+
		"<td align='center'> FECHA LIMITE </td>"+
		"<td align='center'> ESTADO </td>"+
		"<td align='center'> SUBIR ARCHIVO </td>"+
		
		"</tr>");
		
		Date date = new Date();
		try{
			
			q.setOrdering("id descending");
			List<tarea> tareas = (List<tarea>) q.execute();
				for(tarea t: tareas){
					
					String activo = "TIEMPO EXPIRADO";
					if(t.getAnho().equals(anho) && t.getidCurso().equals(Long.parseLong(curso))){
						
						
						if(Integer.parseInt(t.getMes())-date.getMonth()>0)
							activo="TIEMPO NO EXPIRADO";
						else
							if(Integer.parseInt(t.getMes())-date.getMonth()==0)
								if(Integer.parseInt(t.getDia())-date.getDate()>0)
									activo="TIEMPO NO EXPIRADO";
								else
									if(Integer.parseInt(t.getDia())-date.getDate()==0)
										if(Integer.parseInt(t.getHora())-date.getHours()>0)
											activo="TIEMPO NO EXPIRADO";
										else
											if(Integer.parseInt(t.getHora())-date.getHours()==0)
												if(Integer.parseInt(t.getMinuto())-date.getMinutes()>0)
													activo="TIEMPO NO EXPIRADO";
						
						
						
						
						
						String ceroMes="";
						String ceroDia="";
						String ceroHora="";
						String ceroMinuto="";
						int mes = Integer.parseInt(t.getMes())+1;
						if(mes<10)ceroMes="0";
						if(t.getDia().length()==1)ceroDia="0";
						if(t.getHora().length()==1)ceroHora="0";
						if(t.getMinuto().length()==1)ceroMinuto="0";
						
						out.print("<form action='asd'>");
						out.print("</form>");
				out.print("<tr>"+
				
				"<td align='center' >"+t.getId()+"</td>"+
				"<td align='center' >"+t.getTarea()+"</td>"+			
				"<td align='center'>"+t.getFecha()+"</td>"+	
				"<td align='center'>"+ceroMes+mes+"-"+ceroDia+t.getDia()+"   "+ceroHora+t.getHora()+":"+ceroMinuto+t.getMinuto()+"</td>"+	
				"<td align='center'>"+activo+"</td>");	
				
				
				if(activo.equals("TIEMPO NO EXPIRADO"))
					out.print("<td align='center'><input type='file'  name='archivo' value='Subir Tarea'></td>");	
				else
					out.print("<td align='center'>No puede subir archivo</td>");	
					
				
				
				out.printf("</tr>");	
				break;
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
