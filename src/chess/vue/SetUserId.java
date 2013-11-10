package chess.vue;

import javax.servlet.http.*;
import javax.servlet.*;

public class SetUserId extends HttpServlet { 
	public void doPost(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, java.io.IOException {
        processRequest(request, reponse);
    }

	public void doGet(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, java.io.IOException {
        processRequest(request, reponse);
    }

	public void processRequest(HttpServletRequest request, HttpServletResponse reponse) {
        reponse.setContentType("text/html");

        try {
             
            java.io.PrintWriter out = reponse.getWriter();
//            out.println("SomeUserId");
            String nu_usr_id = request.getParameter("joueurId");
            if (nu_usr_id == "null") {
                request.getSession().invalidate();
            } else {
//              request.getSession().setAttribute("usr_id", request.getParameter("joueurId"));
                request.getSession().setAttribute("usr_id", nu_usr_id);
            }

//            out.println((usr_id == null) ? "null" : usr_id);
//            out.println("ok.");
            out.println("ok: " + request.getAttribute("joueurId"));
            System.out.println("what the fuck");

        } catch (Exception e) {
            System.out.println("exception: " + e.getMessage());
        }
    }
}
