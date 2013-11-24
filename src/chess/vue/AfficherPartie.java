package chess.vue;

import javax.servlet.http.*;
import javax.servlet.*;
import java.util.ArrayList;
import java.util.HashMap;
import chess.modele.*;
// import chess.modele.Usager;
// import chess.modele.Partie;

import org.apache.log4j.Logger;

public class AfficherPartie extends HttpServlet { 

    private static Logger logger = Logger.getLogger(AfficherPartie.class);

	public void doPost(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, java.io.IOException {
        processRequest(request, reponse);
    }

	public void doGet(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, java.io.IOException {
        processRequest(request, reponse);
    }

	public void processRequest(HttpServletRequest request, HttpServletResponse reponse) {
        reponse.setContentType("text/html");

        logger.info("LOGGER WHAT UP NIGGAS");

//         getServletContext().log("what up");

        try {
            
            HashMap<String, Partie> parties = (HashMap<String, Partie>)getServletContext().getAttribute("parties");

//            getServletContext().log("AfficherPartie parties: " + parties.toString());

            String usr_id = (request.getSession().getAttribute("usr_id") == null) ? "UNLOG" : request.getSession().getAttribute("usr_id").toString();

            java.io.PrintWriter out = reponse.getWriter();

            Partie partie_en_cours = parties.get(usr_id);
            if (partie_en_cours == null) {
                getServletContext().log("partie_en_cours null; usr_id = " + usr_id);
                return;
            }

            Echiquier ech = partie_en_cours.getEchiquier();
            if (ech == null) {
                out.println("");  
                return;
            }
            
            String couleur = (partie_en_cours.getUsager1().getId() == usr_id) ? "blanc" : "noir";

            out.println("<p id='couleur'>couleur: " + couleur + "</p><p>tour: " + ech.getTour() + "</p>");

            

            out.println("<table id='tableDeJeu' border='1'>");
            for (int i=0; i<8;i++) {
                out.println("<tr>");
                for (int j=0; j<8; j++) {
                    Piece piece = ech.get(i, j); 
                    if (piece != null) {
                        out.println("<td><div class='case' posx = '" + j + "' posy='" + i + "'>" + piece.afficherPiece() + "</div>");
                    } else {
                        out.println("<td><div class='case' posx = '" + j + "' posy='" + i + "'>0</div>");
                    }
                    out.println("</td>");
                }
                out.println("</tr>");
            }
            out.println("</table>");


        } catch (Exception e) {
            getServletContext().log("AfficherPartie exception: " + e.getMessage());
        }
    }
}
