package epis.unsa;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

	@SuppressWarnings("serial")
	public class verTareas extends HttpServlet{
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse resp)
				throws ServletException, IOException {		
			HttpSession misesion= request.getSession();
			ArrayList<String> cursosDocente = (ArrayList<String>)misesion.getAttribute("cursos");
			ArrayList<curso> cursosFormulario = new ArrayList<curso>();
			
			
			final PersistenceManager pm = PMF.get().getPersistenceManager();
			final Query q = pm.newQuery(curso.class);
			
				try{
					@SuppressWarnings("unchecked")
					List<curso> cursos = (List<curso>) q.execute();
					
					for(int i=0;i<cursosDocente.size();i++){
						curso c = pm.getObjectById(curso.class,Long.parseLong(cursosDocente.get(i)));
						if(c.getEstado().equals("ACTIVO"))
							cursosFormulario.add(c);
					}
					
					
					
					
					request.setAttribute("cursos", cursosFormulario);
					RequestDispatcher rd = request.getRequestDispatcher("verTareas.jsp");
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

	
