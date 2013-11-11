package chess.vue;

import javax.servlet.http.*;
import javax.servlet.*;
import java.util.ArrayList;
import java.util.HashMap;
import chess.modele.Usager;

public class Unlog extends HttpServlet { 
	public void doPost(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, java.io.IOException {
        processRequest(request, reponse);
    }

	public void doGet(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, java.io.IOException {
        processRequest(request, reponse);
    }

	public void processRequest(HttpServletRequest request, HttpServletResponse reponse) {
        reponse.setContentType("text/html");
        try {

            getServletContext().log("INVALIDATE");
            getServletContext().log("invalidate: " + request.getSession().getAttribute("usr_id"));
            HashMap<String, Usager> connectes = (HashMap<String, Usager>)request.getSession().getServletContext().getAttribute("connectes");
            String usr_id = (request.getSession().getAttribute("usr_id") == null) ? "" : request.getSession().getAttribute("usr_id").toString();
//            String usr_id = "xkcd";
            connectes.remove(usr_id);
            getServletContext().log("CONNECTES: " + connectes.toString());
;



            request.getSession().invalidate();


        } catch (Exception e) {
            getServletContext().log("exception dans SetUsrId: " + e.getMessage());
        }
    }
}
