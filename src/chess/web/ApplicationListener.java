package chess.web;

// import java.util.Collection;
import java.util.HashMap;
import java.util.ArrayList;
import chess.modele.Usager;
import chess.modele.Partie;
//import java.util.List;
//import java.util.Map;
//import java.util.Map.Entry;
//import java.util.Set;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

public class ApplicationListener implements ServletContextListener {

//     @Override // whatever?
    public void contextInitialized(ServletContextEvent src) {

        src.getServletContext().log("CONTEXT INITIALIZED");
        /*
        Connexion.setUrl(sce.getServletContext().getInitParameter("urlBd"));
        try {
            Class.forName(sce.getServletContext().getInitParameter("piloteJdbc"));
        } catch (ClassNotFoundException ex) {
            
        }
        */
        /*

        List<Utilisateur> connectes = new LinkedList<Utilisateur>();
        Map<String, String> invitations = new HashMap<String,String>();
        Map<String, Partie> parties = new HashMap<String,Partie>();
        invitations.put("Toto", "Titi");
        sce.getServletContext().setAttribute("connectes", connectes);
        sce.getServletContext().setAttribute("invitations", invitations);
        sce.getServletContext().setAttribute("parties", parties);
        */
        src.getServletContext().setAttribute("connectes", new HashMap<String, Usager>());
        src.getServletContext().setAttribute("parties", new HashMap<String, Partie>());
    }

//    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
        /*
        sce.getServletContext().removeAttribute("connectes");
        sce.getServletContext().removeAttribute("invitations");
        sce.getServletContext().removeAttribute("parties");
        */
        
    }
}
