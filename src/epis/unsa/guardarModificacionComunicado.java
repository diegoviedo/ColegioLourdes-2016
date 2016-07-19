package epis.unsa;

import java.io.IOException;
import java.util.Date;

import javax.jdo.PersistenceManager;
import javax.servlet.http.*;

import epis.unsa.PMF;

@SuppressWarnings("serial")
public class guardarModificacionComunicado extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String idComunicado = req.getParameter("idComunicado");
		Long id = Long.parseLong(idComunicado);

		String comunicado = req.getParameter("comunicado");
		Date date = new Date();
		String fecha = date.toString(); 
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			comunicado c = pm.getObjectById(comunicado.class,id);
			c.setComunicado(comunicado);
			c.setFecha(fecha);
			
			pm.makePersistent(c);
			
			resp.sendRedirect("comoAdministrador.jsp");
			
			
			
		}catch(Exception e){
			System.out.println(e);
			
		}finally{
			pm.close();
		}
		
		
		
	}
}
