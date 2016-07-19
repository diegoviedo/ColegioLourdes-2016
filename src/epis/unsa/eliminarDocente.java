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

@SuppressWarnings("serial")
public class eliminarDocente extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		String idDocente = (String) req.getAttribute("idDocente");
		Long id = Long.parseLong(idDocente);
		System.out.println(id);
		resp.setContentType("text/html");
		PersistenceManager pm = PMF.get().getPersistenceManager();

			Query q = pm.newQuery(docente.class);
			try{
		
					docente d =  pm.getObjectById(docente.class,id);
					pm.deletePersistent(d);
					
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
