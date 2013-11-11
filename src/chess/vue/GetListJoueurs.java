package chess.vue;


import javax.servlet.http.*;
import javax.servlet.*;
import java.util.ArrayList;
import java.util.HashMap;
import chess.modele.Usager;

public class GetListJoueurs extends HttpServlet { 
	public void doPost(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, java.io.IOException {
        processRequest(request, reponse);
    }

	public void doGet(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, java.io.IOException {
        processRequest(request, reponse);
    }

	public void processRequest(HttpServletRequest request, HttpServletResponse reponse) {
        reponse.setContentType("text/html");

//         getServletContext().log("what up");

        try {
            
            HashMap<String, Usager> connectes = (HashMap<String, Usager>)getServletContext().getAttribute("connectes");

            String usr_id = (request.getSession().getAttribute("usr_id") == null) ? "UNLOG" : request.getSession().getAttribute("usr_id").toString();


            String concat = "<table border='1'>";

            if (usr_id.equals("UNLOG")) {

                for (Usager usr : connectes.values()) {
                    concat = concat + "<li>" + usr.getId() + "</li>";
    //                getServletContext().log("usr: " + usr.getId());
                }

            } else {
                // trouver l'usager lui-meme dans le putain de tableau

                /*
                for (Usager usr : connectes) {
                    if (usr_id.equals(usr.getId())) {
                        usagerCourant = usr;
                    }
                }
                */
                
                Usager usagerCourant = connectes.get(usr_id);
                if (usagerCourant == null) {
                    usagerCourant = new Usager(usr_id);
                }

                for (Usager usr : connectes.values()) {
                    // si c'est l'usager lui-meme, on bouge
                    if (usr.getId().equals(usr_id)) {
                        continue;
                    }
                    // si l'usager a deje ete invite par cette personne
//                    String en_attente = (.containsKey(usr.getId())) ? "<td>...en attente..</td>" : "";
                    String en_attente = "";
                    for (Usager usr2 : usagerCourant.getInvitations()) {
                        if (usr2.getId().equals(usr.getId())) {
                            en_attente = "<td>...en attente..</td>";
                        }
                    }
                    // et finalement si on peut accepter l'invitation
                    String est_invite = "";
                    for (Usager usr2 : usr.getInvitations()) {
                        if (usr2 == usagerCourant) {
                            est_invite = "<td class='accepter' id='" + usr.getId() + "'>accepter?</td>";
                        }
                    }
                    String inviter = "";
                    if ((est_invite + en_attente).equals("")) {
                        inviter = "<td class='inviter' id='" + usr.getId() + "'>inviter?</td>";
                    }
                    String entry = "<tr><td>" + usr.getId() + "</td>" + est_invite + inviter + en_attente;
                    concat = concat + entry + "</tr>";
//                    getServletContext().log("CONCAT: " + concat);

                }
                
            }
            
//            getServletContext().log("connectes: " + connectes.toString());
            java.io.PrintWriter out = reponse.getWriter();
            concat = concat  + "</table>";
            out.write(concat);
             

        } catch (Exception e) {
            getServletContext().log("exception: " + e.getMessage());
        }
    }
}
