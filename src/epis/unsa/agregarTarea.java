package epis.unsa;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
	public class agregarTarea extends HttpServlet{
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse resp)
				throws ServletException, IOException {		
			
			final PersistenceManager pm = PMF.get().getPersistenceManager();
			final Query q = pm.newQuery(curso.class);
			HttpSession misesion= request.getSession();
			ArrayList<String> cursosDocente = (ArrayList<String>)misesion.getAttribute("cursos");
			ArrayList<curso> cursos = new ArrayList<curso>();
			String meses [] ={ "Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto",
					"Setiembre","Octubre","Noviembre","Diciembre"};
			Date a = new Date();
			String mes = String.valueOf(a.getMonth());
			String dia = String.valueOf(a.getDate());
			String hora = String.valueOf(a.getHours());
			String minuto = String.valueOf(a.getMinutes());
			
			
			
		//	q.setOrdering("id descending");
				try{
					
					for(String c :cursosDocente){
						curso cur = pm.getObjectById(curso.class,Long.parseLong(c));
						cursos.add(cur);
					}
					
					request.setAttribute("meses", meses);
					request.setAttribute("mes", mes);
					request.setAttribute("dia", dia);
					request.setAttribute("hora", hora);
					request.setAttribute("minuto", minuto);
					request.setAttribute("cursos", cursos);
					RequestDispatcher rd = request.getRequestDispatcher("agregarTarea.jsp");
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

	
