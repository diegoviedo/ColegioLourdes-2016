package epis.unsa;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;



@SuppressWarnings("serial")
public class modificarAlumno extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {

		
		String boton  = req.getParameter("boton");
		String idAlumno = req.getParameter("idAlumno");
		Long id = Long.parseLong(idAlumno);


		if(boton.equals("ELIMINAR")){
					req.setAttribute("idAlumno", idAlumno);
					RequestDispatcher rd = req.getRequestDispatcher("/eliminarAlumno");
					rd.forward(req, resp);	
		}else{		
				PersistenceManager pm = PMF.get().getPersistenceManager();
				alumno alum = pm.getObjectById(alumno.class,id);
				req.setAttribute("alum", alum);
				RequestDispatcher rd = req.getRequestDispatcher("/verInfoAlumno.jsp");
				rd.forward(req, resp);
				pm.close();
		}
		
		
		
	}
}
