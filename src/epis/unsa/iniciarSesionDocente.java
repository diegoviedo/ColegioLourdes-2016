package epis.unsa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.*;


@SuppressWarnings("serial")
public class iniciarSesionDocente extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		
		String codigo = req.getParameter("codigo");
		String contrasena = req.getParameter("pass");
		PersistenceManager pm = PMF.get().getPersistenceManager();
		resp.setContentType("text/html");
		
		Query q = pm.newQuery(docente.class);
		Query q1 = pm.newQuery(curso.class);
		ArrayList<curso> cursosFormulario = new ArrayList<curso>();
		try{
			
			List<docente> docentes = (List<docente>) q.execute();
			List<curso> cursos = (List<curso>) q1.execute();
			
			for(docente p: docentes){
				if(p.getCodigo().equals(codigo)&&p.getContrasena().equals(contrasena)){
					HttpSession misesion= req.getSession(true);
					misesion.setAttribute("nombres",p.getNombres());
					misesion.setAttribute("apellidos",p.getApellidos());
					misesion.setAttribute("codigo",p.getCodigo());
					misesion.setAttribute("anhos",p.getAnhos());
					misesion.setAttribute("tipo","docente");
					misesion.setAttribute("cursos",p.getCursos());
					misesion.setAttribute("estado", p.getEstado());
				}
				
				resp.sendRedirect("comoDocente.jsp");
				
			}

		}catch(Exception e){
			System.out.println(e);
		}finally{
			pm.close();
			 q.closeAll();
			 q1.closeAll();
		}
		
		
		
	
	}
}
