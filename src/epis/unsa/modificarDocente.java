package epis.unsa;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;



@SuppressWarnings("serial")
public class modificarDocente extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {

		
		String boton  = req.getParameter("boton");
		String idDocente = req.getParameter("idDocente");
		Long id = Long.parseLong(idDocente);

		
		if(boton.equals("ELIMINAR")){
					req.setAttribute("idDocente", idDocente);
					RequestDispatcher rd = req.getRequestDispatcher("/eliminarDocente");
					rd.forward(req, resp);	
		}else{	
			PersistenceManager pm = PMF.get().getPersistenceManager();
			Query q = pm.newQuery(curso.class);
			try{
				
			
				List<curso> cursos = (List<curso>) q.execute();
				req.setAttribute("cursos", cursos);
				docente doc = pm.getObjectById(docente.class,id);
				req.setAttribute("doc", doc);
				RequestDispatcher rd = req.getRequestDispatcher("/verInfoDocente.jsp");
				rd.forward(req, resp);
				
			}catch(IOException e){
				System.out.println(e);
			}finally{
				pm.close();
				q.closeAll();
			}
		}
		
		
		
	}
}
