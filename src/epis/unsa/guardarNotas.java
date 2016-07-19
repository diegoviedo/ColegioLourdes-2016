package epis.unsa;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.*;

import epis.unsa.PMF;

@SuppressWarnings("serial")
public class guardarNotas extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		String [] idAlumnos = req.getParameterValues("idAlumno");
		String [] notas = req.getParameterValues("nota");
		String curso  = req.getParameter("curso");
		PersistenceManager pm = PMF.get().getPersistenceManager();

		Query q = pm.newQuery(nota.class);
		List<nota> ns = (List<nota>)q.execute();

		boolean esta;
		try{
			
			

			for(int i=0;i<idAlumnos.length;i++){
				esta= false;
				Long idAlumno = Long.parseLong(idAlumnos[i]);
				Long idCurso = Long.parseLong(curso);
				int nota = Integer.parseInt(notas[i]);
					
					for(nota n : ns){
						if(n.getIdAlumno().equals(idAlumno) && n.getIdCurso().equals(idCurso)){
							n.setNota(nota);
							pm.makePersistent(n);
							esta=true;
						}
					}
					
				if(esta==false){
					nota nuevaNota = new nota(idAlumno,idCurso,nota);
					pm.makePersistent(nuevaNota);
				}
			
				
				
				
			}
			
			
			
			
			
			resp.sendRedirect("comoDocente.jsp");
			
			
			
		}catch(Exception e){
			System.out.println(e);
			
		}finally{
			pm.close();
			q.closeAll();
		}
		
		
		
	}
}
