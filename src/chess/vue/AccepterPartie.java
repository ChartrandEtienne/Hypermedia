package chess.vue;

import javax.servlet.http.*;
import javax.servlet.*;
import java.util.ArrayList;
import java.util.HashMap;
import chess.modele.Usager;
import chess.modele.Partie;

public class AccepterPartie extends HttpServlet { 
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
            String a_accepter = request.getParameter("a_accepter");
            String usr_id = (request.getSession().getAttribute("usr_id") == null) ? "UNLOG" : request.getSession().getAttribute("usr_id").toString();
            HashMap<String, Usager> connectes = (HashMap<String, Usager>)getServletContext().getAttribute("connectes");
            Usager usagerCourant = connectes.get(usr_id);
            Usager usager_a_accepter = connectes.get(a_accepter);
            usagerCourant.supprimerInvitations();
            usager_a_accepter.supprimerInvitations();

            // supprimer les invitation des joueurs, ajouter une partie dans le
            // tableau 

            HashMap<String, Partie> parties = (HashMap<String, Partie>)getServletContext().getAttribute("parties");

            Partie partie = new Partie(usager_a_accepter, usagerCourant);

            parties.put(a_accepter, partie);
            parties.put(usr_id, partie);


            // eventuellement: supprimer les invitation VERS les deux joueurs
            // alors qu'ils acceptent cette partie   

        } catch (Exception e) {
            getServletContext().log("exception dans AccepterPartie: " + e.getMessage());
        }
    }
}
