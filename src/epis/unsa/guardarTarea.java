package epis.unsa;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.*;

import epis.unsa.PMF;

@SuppressWarnings("serial")
public class guardarTarea extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		HttpSession misesion= req.getSession();
		String nombreDocente= (String) misesion.getAttribute("nombres");
		
		String anho  = req.getParameter("selecAnho");
		String curso  = req.getParameter("selecCurso");
		String tarea  = req.getParameter("tarea");
		String mes  = req.getParameter("mes");
		String dia  = req.getParameter("dia");
		String hora  = req.getParameter("hora");
		String minuto  = req.getParameter("minuto");
		Date a = new Date();
		String fecha = a.toString();
		PersistenceManager pm = PMF.get().getPersistenceManager();

		try{
			
			tarea nuevaTarea = new tarea(nombreDocente,anho,Long.parseLong(curso),tarea,mes,dia,hora,minuto,fecha);
			pm.makePersistent(nuevaTarea);
				
			resp.sendRedirect("comoDocente.jsp");
				
		}catch(Exception e){
			System.out.println(e);
			
		}finally{
			pm.close();
		}
		
		
		
	}
}
