package epis.unsa;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;

import epis.unsa.PMF;
import epis.unsa.alumno;

@SuppressWarnings("serial")
public class eliminarCurso extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		String idCurso = (String) req.getAttribute("idCurso");
		Long id = Long.parseLong(idCurso);
		System.out.println(id);
		resp.setContentType("text/html");
		PersistenceManager pm = PMF.get().getPersistenceManager();

			Query q = pm.newQuery(curso.class);
			try{
		
					curso c =  pm.getObjectById(curso.class,id);
					pm.deletePersistent(c);
					
				try{
					
					RequestDispatcher rd = req.getRequestDispatcher("/comoAdministrador.jsp");
					rd.forward(req, resp);
				}catch(Exception e){
					System.out.println(e);
				}finally{
					if( pm.currentTransaction().isActive() ){
						pm.currentTransaction().rollback();
				    }
				}	
				
				
				
			
			}catch(Exception e){
				System.out.println(e);
			}finally{
				 q.closeAll();
			}
			

		
		
		
		
		
		
	}
}
