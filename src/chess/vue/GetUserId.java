package chess.vue;

import javax.servlet.http.*;
import javax.servlet.*;

public class GetUserId extends HttpServlet { 
	public void doPost(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, java.io.IOException {
        processRequest(request, reponse);
    }

	public void doGet(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, java.io.IOException {
        processRequest(request, reponse);
    }

	public void processRequest(HttpServletRequest request, HttpServletResponse reponse) {
        reponse.setContentType("text/html");

        getServletContext().log("what up");

        try {
            
            java.io.PrintWriter out = reponse.getWriter();
//            out.println("SomeUserId");
            Object usr_id = request.getSession().getAttribute("usr_id");
            System.out.println("what the fuck2 ");
            

//            out.println(usr_id.toString());
            out.println((usr_id == null) ? "null" : usr_id.toString());

        } catch (Exception e) {
            System.out.println("exception: " + e.getMessage());
        }
    }
}
