package epis.unsa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;



@SuppressWarnings("serial")
public class modificarTarea extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {

		
		String boton  = req.getParameter("boton");
		String idTarea = req.getParameter("idTarea");
		Long id = Long.parseLong(idTarea);


		if(boton.equals("ELIMINAR")){
					req.setAttribute("idTarea", idTarea);
					RequestDispatcher rd = req.getRequestDispatcher("/eliminarTarea");
					rd.forward(req, resp);	
		}else{		
			
			 PersistenceManager pm = PMF.get().getPersistenceManager();
			 Query q = pm.newQuery(curso.class);
			HttpSession misesion= req.getSession();
			ArrayList<String> cursosDocente = (ArrayList<String>)misesion.getAttribute("cursos");
			ArrayList<curso> cursos = new ArrayList<curso>();
			String meses [] ={ "Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto",
					"Setiembre","Octubre","Noviembre","Diciembre"};
			Date a = new Date();
			String mes = String.valueOf(a.getMonth());
			String dia = String.valueOf(a.getDate());
			String hora = String.valueOf(a.getHours());
			String minuto = String.valueOf(a.getMinutes());
			
			
			
		//	q.setOrdering("id descending");
				
					
					for(String c :cursosDocente){
						curso cur = pm.getObjectById(curso.class,Long.parseLong(c));
						cursos.add(cur);
					}
				
				tarea t = pm.getObjectById(tarea.class,id);
				
				
				req.setAttribute("cursos", cursos);
				req.setAttribute("meses", meses);
				
				req.setAttribute("tarea", t);
				RequestDispatcher rd = req.getRequestDispatcher("/verInfoTarea.jsp");
				rd.forward(req, resp);
				pm.close();
		}
		
		
		
	}
}
