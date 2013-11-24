package chess.vue;

import javax.servlet.http.*;
import javax.servlet.*;
import java.util.ArrayList;
import java.util.HashMap;
import chess.modele.Usager;
import chess.modele.Utilisateur;
import chess.dao.Userdao;
import chess.jdbc.Connexion;
import org.apache.log4j.Logger;

public class SetUserId extends HttpServlet { 
    private static Logger logger = Logger.getLogger(SetUserId.class);
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
            String nu_usr_id = request.getParameter("joueurId");
            String password = request.getParameter("password");
//            getServletContext().log("req: " + nu_usr_id);

            logger.info("joueurId: " + nu_usr_id + ", password: " + password);


            Class.forName(this.getServletContext().getInitParameter("piloteJdbc"));

            Connexion.setUrl(this.getServletContext().getInitParameter("urlBd"));
            Userdao     dao  = new Userdao(Connexion.getInstance());
            Utilisateur user = dao.read(nu_usr_id.trim());

            if (user == null) {
                logger.info("user/mdp incorrects");
                logger.info("RAPPORTER ERREUR, FGOD'S SAKE");
                return;
            }
/*
            if (nu_usr_id.equals("UNLOG")) {
                request.getSession().invalidate();
                getServletContext().log("invalidate: " + nu_usr_id);
            } else {
            */
//              request.getSession().setAttribute("usr_id", request.getParameter("joueurId"));
            request.getSession().setAttribute("usr_id", nu_usr_id);
            request.getSession().setAttribute("utilisateur", user);

//            getServletContext().log("what the fuck 314: " + nu_usr_id);
            HashMap<String, Usager> connectes = (HashMap<String, Usager>)getServletContext().getAttribute("connectes");
            HashMap<String, Utilisateur> utilisateurs = (HashMap<String, Utilisateur>)getServletContext().getAttribute("utilisateurs");

//            getServletContext().log("what the fuck suite: " + connectes.toString());

            Usager usr = new Usager(nu_usr_id);
//            getServletContext().log("what the fuck suite suite: " + usr.toString());

            connectes.put(nu_usr_id, usr);
            utilisateurs.put(user.getName(), user);

//            out.println((usr_id == null) ? "null" : usr_id);
//            out.println("ok.");
//
//            ArrayList<Usager> connectes = (ArrayList<Usager>)getServletContext().getAttribute("connectes");
//            Usager usr = new Usager(nu_usr_id);

        } catch (Exception e) {
            getServletContext().log("exception dans SetUsrId: " + e.getMessage());
        }
    }
}
