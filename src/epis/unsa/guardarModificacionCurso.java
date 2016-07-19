package epis.unsa;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.http.*;

import epis.unsa.PMF;

@SuppressWarnings("serial")
public class guardarModificacionCurso extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String idCurso = req.getParameter("idCurso");
		Long id = Long.parseLong(idCurso);
		String nombreCurso = req.getParameter("nombreCurso");
		String estado = req.getParameter("estado");
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			curso c = pm.getObjectById(curso.class,id);
			c.setNombreCurso(nombreCurso);
			if(estado.equals("ACTIVO"))
				c.activarCurso();
			else
				c.desactivarCurso();
			pm.makePersistent(c);
			
			resp.sendRedirect("comoAdministrador.jsp");
			
			
			
		}catch(Exception e){
			System.out.println(e);
			
		}finally{
			pm.close();
		}
		
		
		
	}
}
