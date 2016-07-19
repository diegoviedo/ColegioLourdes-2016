package epis.unsa;
import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

	@SuppressWarnings("serial")
	public class verComunicados extends HttpServlet{
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse resp)
				throws ServletException, IOException {		
			
			final PersistenceManager pm = PMF.get().getPersistenceManager();
			final Query q = pm.newQuery(comunicado.class);
				try{
					@SuppressWarnings("unchecked")
					List<comunicado> comunicados = (List<comunicado>) q.execute();
					request.setAttribute("comunicados", comunicados);
					RequestDispatcher rd = request.getRequestDispatcher("verComunicados.jsp");
					rd.forward(request, resp);
				}catch(Exception e){
					System.out.println(e);
				}finally{
					if( pm.currentTransaction().isActive() ){
						pm.currentTransaction().rollback();
				    }
					q.closeAll();
					pm.close();
				}
						
		}
	}

	
