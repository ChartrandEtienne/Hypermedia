import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class Bienvenue extends HttpServlet
{
	public void doGet(HttpServletRequest requete, HttpServletResponse reponse)
               throws ServletException, java.io.IOException
	{
		PrintWriter out = reponse.getWriter();
		
		//ServletConfig sc = getServletConfig() ;
		//ServletContext contexte = sc.getServletContext() ;
		String titre = getServletContext().getServletContextName();
		out.println("<head><title>"+titre+"</title></head>");

		out.println("Bonjour et bienvenue a votre premier servlet");
	}
}
