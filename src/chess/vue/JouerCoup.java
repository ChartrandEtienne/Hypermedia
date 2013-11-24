package chess.vue;

import javax.servlet.http.*;
import javax.servlet.*;
import java.util.ArrayList;
import java.util.HashMap;
import chess.modele.*;
import org.apache.log4j.Logger;



public class JouerCoup extends HttpServlet { 

    private static Logger logger = Logger.getLogger(JouerCoup.class);
	public void doPost(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, java.io.IOException {
        processRequest(request, reponse);
    }

	public void doGet(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, java.io.IOException {
        processRequest(request, reponse);
    }

	public void processRequest(HttpServletRequest request, HttpServletResponse reponse) {
        reponse.setContentType("text/html");
        try {
            getServletContext().log("JouerCoup!");
            java.io.PrintWriter out = reponse.getWriter();
//            out.println("SomeUserId");
            String usr_id = (request.getSession().getAttribute("usr_id") == null) ? "UNLOG" : request.getSession().getAttribute("usr_id").toString();
            HashMap<String, Usager> connectes = (HashMap<String, Usager>)getServletContext().getAttribute("connectes");
            Usager usagerCourant = connectes.get(usr_id);

            HashMap<String, Partie> parties = (HashMap<String, Partie>)getServletContext().getAttribute("parties");

            Echiquier en_cours = parties.get(usr_id).getEchiquier();
            Partie partie_en_cours = parties.get(usr_id);

            String couleur = ((usagerCourant == partie_en_cours.getUsager1()) ? "blanc" : "noir");

//            String debutx = (request.getAttribute("debutx") == null) ? "" : request.getAttribute("debutx").toString();
//            getServletContext().log("debutx: " + debutx);
//            String debuty = (request.getAttribute("debuty") == null) ? "" : request.getAttribute("debuty").toString();
//            String finx = (request.getAttribute("finx") == null) ? "" : request.getAttribute("finx").toString();
//            String finy = (request.getAttribute("finy") == null) ? "" : request.getAttribute("finy").toString();

            String debutx = (request.getParameter("debutx") == null) ? "" : request.getParameter("debutx").toString();
            getServletContext().log("debutx: " + debutx);
            String debuty = (request.getParameter("debuty") == null) ? "" : request.getParameter("debuty").toString();
            String finx = (request.getParameter("finx") == null) ? "" : request.getParameter("finx").toString();
            String finy = (request.getParameter("finy") == null) ? "" : request.getParameter("finy").toString();

            Position debut = new Position(Integer.parseInt(debutx), Integer.parseInt(debuty));

            Position fin = new Position(Integer.parseInt(finx), Integer.parseInt(finy));

//            getServletContext().log("debut: " + debut.toString());
//            getServletContext().log("fin: " + fin.toString());
            logger.info("debut: " + debut.toString());
            logger.info("fin: " + fin.toString());

//            getServletContext().log("deplacer2 log: " + en_cours.deplacer2(debut, fin, couleur));
            if (en_cours.deplacer3(debut, fin, couleur)) {
                logger.info("coup confirme");
            } else {
                logger.info("coup invalide");
            }

            // eventuellement: supprimer les invitation VERS les deux joueurs
            // alors qu'ils acceptent cette partie   

        } catch (Exception e) {
            getServletContext().log("exception dans AccepterPartie: " + e.getMessage());
        }
    }
}

