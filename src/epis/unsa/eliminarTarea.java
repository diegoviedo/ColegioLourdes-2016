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
public class eliminarTarea extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		String idTarea = (String) req.getAttribute("idTarea");
		Long id = Long.parseLong(idTarea);
		System.out.println(id);
		resp.setContentType("text/html");
		PersistenceManager pm = PMF.get().getPersistenceManager();

			Query q = pm.newQuery(docente.class);
			try{
		
					tarea d =  pm.getObjectById(tarea.class,id);
					pm.deletePersistent(d);
					
				try{
					
					RequestDispatcher rd = req.getRequestDispatcher("/comoDocente.jsp");
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
