package chess.web;

import java.util.HashMap;
import java.util.ArrayList;
import chess.modele.Usager;
import chess.modele.Partie;
import chess.modele.Utilisateur;
import chess.jdbc.Connexion;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.File;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

public class ApplicationListener implements ServletContextListener {

//     @Override // whatever?
    public void contextInitialized(ServletContextEvent src) {
//j        ServletContext context = event.getServletContext();
        ServletContext ctx = src.getServletContext();
         
        System.setProperty("rootPath", ctx.getRealPath("/"));
        String log4jConfig = ctx.getInitParameter("log4j-config");
        if (log4jConfig == null) {
            System.err.println("No log4j-config init param, initializing log4j with BasicConfigurator");
            BasicConfigurator.configure();
        } else {
            String webAppPath = ctx.getRealPath("/");
            String log4jProp = webAppPath + log4jConfig;
            File log4jConfigFile = new File(log4jProp);
            if (log4jConfigFile.exists()) {
                System.out.println("Initializing log4j with: " + log4jProp);
                DOMConfigurator.configure(log4jProp);
            } else {
                System.err.println(log4jProp + " file not found, initializing log4j with BasicConfigurator");
                src.getServletContext().log(log4jProp + " file not found, initializing log4j with BasicConfigurator");
                BasicConfigurator.configure();
            }
        }
        System.out.println("log4j configured properly");
   
        Connexion.setUrl(src.getServletContext().getInitParameter("urlBd"));
        Connexion.setUser(src.getServletContext().getInitParameter("user"));
        Connexion.setPassword(src.getServletContext().getInitParameter("password"));
        try {
            Class.forName(src.getServletContext().getInitParameter("piloteJdbc"));
        } catch (ClassNotFoundException ex) {
            src.getServletContext().log("classnotfound: " + ex.getMessage());    
        }
 
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
        src.getServletContext().setAttribute("utilisateurs", new HashMap<String, Utilisateur>());
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
