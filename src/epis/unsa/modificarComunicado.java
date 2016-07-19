package epis.unsa;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;



@SuppressWarnings("serial")
public class modificarComunicado extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {

		
		String boton  = req.getParameter("boton");
		String idComunicado = req.getParameter("idComunicado");
		Long id = Long.parseLong(idComunicado);


		if(boton.equals("ELIMINAR")){
					req.setAttribute("idComunicado", idComunicado);
					RequestDispatcher rd = req.getRequestDispatcher("/eliminarComunicado");
					rd.forward(req, resp);	
		}else{		
				PersistenceManager pm = PMF.get().getPersistenceManager();
				comunicado c = pm.getObjectById(comunicado.class,id);
				req.setAttribute("comunicado", c);
				RequestDispatcher rd = req.getRequestDispatcher("/verInfoComunicado.jsp");
				rd.forward(req, resp);
				pm.close();
		}
		
		
		
	}
}
