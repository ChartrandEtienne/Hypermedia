package chess.vue;

import javax.servlet.http.*;
import javax.servlet.*;
import java.util.ArrayList;
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

            ArrayList<Usager> connectes = (ArrayList<Usager>)getServletContext().getAttribute("connectes");

            String usr_id = (request.getSession().getAttribute("usr_id") == null) ? "" : request.getSession().getAttribute("usr_id").toString();

            getServletContext().log("INVALIDATE usr_id: " + usr_id);

            for (int i = 0; i < connectes.size(); i++) {

                getServletContext().log("iter 1");
                if (connectes.get(i).getId().equals(usr_id)) {

                    getServletContext().log("TROUVE");
                    connectes.remove(i);
                }
            }

            request.getSession().invalidate();
            /*
            if (request.getSession().getAttribute("usr_id") == null) {
                getServletContext().log("NULL NULL NULL");
            }

            HttpSession session = request.getSession();
            if (session!=null) {
                session.invalidate();
            }
            // request.getSession().invalidate();
            */


        } catch (Exception e) {
            getServletContext().log("exception dans SetUsrId: " + e.getMessage());
        }
    }
}
