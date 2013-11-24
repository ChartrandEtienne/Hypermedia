package chess.vue;


import javax.servlet.http.*;
import javax.servlet.*;
import org.apache.log4j.Logger;
import chess.modele.Utilisateur;
import chess.modele.Utilisateur;

public class GetUserId extends HttpServlet { 
    private Logger logger = Logger.getLogger(GetUserId.class);
	public void doPost(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, java.io.IOException {
        processRequest(request, reponse);
    }

	public void doGet(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, java.io.IOException {
        processRequest(request, reponse);
    }

	public void processRequest(HttpServletRequest request, HttpServletResponse reponse) {
        reponse.setContentType("text/html");

//        getServletContext().log("what up JAY");

        try {
            
            java.io.PrintWriter out = reponse.getWriter();
//            out.println("SomeUserId");
            Object usr_id = request.getSession().getAttribute("usr_id");
            Utilisateur user = (Utilisateur)request.getSession().getAttribute("utilisateur");
            if (user == null) {
                logger.info("usager non connecte");
                out.println("UNLOG");
                return;
            }

//            System.out.println("what the fuck2 ");
            

//            out.println(usr_id.toString());
//              out.println((usr_id == null) ? "UNLOG" : usr_id.toString());
            logger.info(((usr_id == null) ? "UNLOG" : usr_id.toString()));
            out.println(user.getName());

//            getServletContext().log("GetUserId: " + ((usr_id == null) ? "UNLOG" : usr_id.toString()));

        } catch (Exception e) {
//            System.out.println("exception: " + e.getMessage());
        }
    }
}
