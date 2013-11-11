package chess.vue;


import javax.servlet.http.*;
import javax.servlet.*;
import java.util.ArrayList;
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
            
            ArrayList<Usager> connectes = (ArrayList<Usager>)getServletContext().getAttribute("connectes");

            String usr_id = (request.getSession().getAttribute("usr_id") == null) ? "UNLOG" : request.getSession().getAttribute("usr_id").toString();


            String concat = "<table>";

            if (usr_id.equals("UNLOG")) {

                for (Usager usr : connectes) {
                    concat = concat + "<li>" + usr.getId() + "</li>";
    //                getServletContext().log("usr: " + usr.getId());
                }

            } else {
                Usager usagerCourant = null;
                // trouver l'usager lui-meme dans le putain de tableau

                for (Usager usr : connectes) {
                    if (usr_id.equals(usr.getId())) {
                        usagerCourant = usr;
                    }
                }
                
                if (usagerCourant == null) {
                    usagerCourant = new Usager(usr_id);
                }

                for (Usager usr : connectes) {
                    // si c'est l'usager lui-meme, on bouge
                    if (usr.getId().equals(usr_id)) {
                        continue;
                    }
                    // si l'usager a deje ete invite par cette personne
                    boolean en_attente = false;

                }
                
            }
            
            java.io.PrintWriter out = reponse.getWriter();
            concat = concat  + "</table>";
            out.write(concat);
             

        } catch (Exception e) {
            getServletContext().log("exception: " + e.getMessage());
        }
    }
}
