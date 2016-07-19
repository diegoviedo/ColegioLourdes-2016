package epis.unsa;

import java.io.IOException;
import java.util.Date;

import javax.jdo.PersistenceManager;
import javax.servlet.http.*;

import epis.unsa.PMF;

@SuppressWarnings("serial")
public class guardarModificacionTarea extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String idTarea = req.getParameter("idTarea");
		Long id = Long.parseLong(idTarea);
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		
		
		String anho  = req.getParameter("selecAnho");
		String curso  = req.getParameter("selecCurso");
		
		String tarea  = req.getParameter("tarea");
		String mes  = req.getParameter("mes");
		String dia  = req.getParameter("dia");
		String hora  = req.getParameter("hora");
		String minuto  = req.getParameter("minuto");
		Date a = new Date();
		String fecha = a.toString();
		
		
		
		
		try{
			tarea t = pm.getObjectById(tarea.class,id);
			t.setAnho(anho);
			t.setIdCurso(Long.parseLong(curso));
			t.setTarea(tarea);
			t.setMes(mes);
			t.setDia(dia);
			t.setHora(hora);
			t.setMinuto(minuto);
			t.setFecha(fecha);
			
			pm.makePersistent(t);
			
			
			resp.sendRedirect("comoDocente.jsp");
			
			
			
		}catch(Exception e){
			System.out.println(e);
			
		}finally{
			pm.close();
		}
		
		
		
	}
}
