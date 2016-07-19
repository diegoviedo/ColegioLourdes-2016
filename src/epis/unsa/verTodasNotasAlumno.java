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
	public class verTodasNotasAlumno extends HttpServlet{
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse resp)
				throws ServletException, IOException {		
			HttpSession misesion= request.getSession();
			Long id = (Long)misesion.getAttribute("idAlumno");


			ArrayList<String> notas = new ArrayList<String>();
			ArrayList<curso> cursosF = new ArrayList<curso>();
			
			final PersistenceManager pm = PMF.get().getPersistenceManager();
			 Query qq = pm.newQuery(curso.class);
			 Query q = pm.newQuery(nota.class);
			
			
				try{
				//	@SuppressWarnings("unchecked")

					List<curso> cursos = (List<curso>) qq.execute();
					List<nota> ns = (List<nota>) q.execute();
	/*				
					for(curso c : cursos){
						
					for(nota n : ns){
						
						
							
							if(id.equals(n.getIdAlumno()) && n.getIdCurso().equals(c.getId())){
								cursosF.add(c);
								notas.add(String.valueOf(n.getNota()));
							}else{
								cursosF.add(c);
								notas.add("--");
							}
						}
					
					
					
						
					}*/
					
					for(curso c : cursos){
						notas.add("--");
					}
					
					System.out.println(notas.size());
					
					for(int i=0;i<cursos.size();i++){
						for(int j=0;j<ns.size();j++){
							
							if(id.equals(ns.get(j).getIdAlumno()) && cursos.get(i).getId().equals(ns.get(j).getIdCurso())){
								notas.set(i,String.valueOf(ns.get(j).getNota()));
							}
							
							
							
						}
					}
					
					
					
					
					
					
					request.setAttribute("cursos", cursos);
					request.setAttribute("notas", notas);
					RequestDispatcher rd = request.getRequestDispatcher("verTodasNotasAlumno.jsp");
					rd.forward(request, resp);
				}catch(Exception e){
					System.out.println(e);
				}finally{
					if( pm.currentTransaction().isActive() ){
						pm.currentTransaction().rollback();
				    }
					q.closeAll();
					qq.closeAll();
					pm.close();
				}
						
		}
	}

	
