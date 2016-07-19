package epis.unsa;

import java.io.IOException;

import javax.servlet.http.*;


@SuppressWarnings("serial")
public class cerrarSesion extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		HttpSession misesion= req.getSession();
		System.out.println("CERRO SESION  "+ misesion.getAttribute("nombres"));
		misesion.invalidate(); //Cierra la sesion
		
		resp.sendRedirect("inicio"); 
	}
}
