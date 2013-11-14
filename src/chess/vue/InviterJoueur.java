package chess.vue;

import javax.servlet.http.*;
import javax.servlet.*;
import java.util.ArrayList;
import java.util.HashMap;
import chess.modele.Usager;

public class InviterJoueur extends HttpServlet { 
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
            String a_inviter = request.getParameter("a_inviter");
            getServletContext().log("a_inviter: " + a_inviter);
            String usr_id = (request.getSession().getAttribute("usr_id") == null) ? "UNLOG" : request.getSession().getAttribute("usr_id").toString();

            // choper l'usager courant et a_inviter dans le hash des joueurs
            HashMap<String, Usager> connectes = (HashMap<String, Usager>)getServletContext().getAttribute("connectes");
            Usager usagerCourant = connectes.get(usr_id);
            Usager usager_a_inviter = connectes.get(a_inviter);
            getServletContext().log("connectes: " + connectes.toString());
            getServletContext().log("usager_a_inviter: " + usager_a_inviter.toString());

            if (usager_a_inviter != null) {
                usagerCourant.ajouterInvite(usager_a_inviter);
                getServletContext().log(a_inviter + " proprement adde dans les invitations");
            } else {
                getServletContext().log("erreur dans InviterJoueur: " + a_inviter + " n'est pas dans le hash des connectes");
                 
            }
//            getServletContext().log("req: " + nu_usr_id);


        } catch (Exception e) {
            getServletContext().log("exception dans InviterJoueur: " + e.getMessage());
        }
    }
}
