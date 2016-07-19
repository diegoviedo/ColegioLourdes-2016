package epis.unsa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;


@SuppressWarnings("serial")
public class iniciarSesionAdministrador extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		
		String codigo = req.getParameter("codigo");
		String contrasena = req.getParameter("pass");
		PersistenceManager pm = PMF.get().getPersistenceManager();
		resp.setContentType("text/html");
		
		Query q = pm.newQuery(administrador.class);
		
		try{
			
			List<administrador> administradores = (List<administrador>) q.execute();
			
			
			for(administrador a: administradores){
				if(a.getCodigo().equals(codigo)&&a.getContrasena().equals(contrasena)){
					HttpSession misesion= req.getSession(true);
					misesion.setAttribute("nombres",a.getNombres());
					misesion.setAttribute("apellidos",a.getApellidos());
					misesion.setAttribute("tipo","administrador");
					
				}
				
					resp.sendRedirect("comoAdministrador.jsp");
				
			}

		}catch(Exception e){
			System.out.println(e);
		}finally{
			pm.close();
			 q.closeAll();
	
		}
		
		
		
	
	}
}
