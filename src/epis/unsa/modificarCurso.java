package epis.unsa;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;



@SuppressWarnings("serial")
public class modificarCurso extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {

		
		String boton  = req.getParameter("boton");
		String idCurso = req.getParameter("idCurso");
		Long id = Long.parseLong(idCurso);


		if(boton.equals("ELIMINAR")){
					req.setAttribute("idCurso", idCurso);
					RequestDispatcher rd = req.getRequestDispatcher("/eliminarCurso");
					rd.forward(req, resp);	
		}else{		
				PersistenceManager pm = PMF.get().getPersistenceManager();
				curso c = pm.getObjectById(curso.class,id);
				req.setAttribute("curso", c);
				RequestDispatcher rd = req.getRequestDispatcher("/verInfoCurso.jsp");
				rd.forward(req, resp);
				pm.close();
		}
		
		
		
	}
}
