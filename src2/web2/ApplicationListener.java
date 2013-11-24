/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.STI.web;

import com.STI.entite.Partie;
import com.STI.entite.Utilisateur;
import com.STI.jdbc.Connexion;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Web application lifecycle listener.
 * @author Usager
 */
@WebListener()
public class ApplicationListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //throw new UnsupportedOperationException("Not supported yet.");
        Connexion.setUrl(sce.getServletContext().getInitParameter("urlBd"));
        try {
            Class.forName(sce.getServletContext().getInitParameter("piloteJdbc"));
        } catch (ClassNotFoundException ex) {
            
        }
        List<Utilisateur> connectes = new LinkedList<Utilisateur>();
        Map<String, String> invitations = new HashMap<String,String>();
        Map<String, Partie> parties = new HashMap<String,Partie>();
        invitations.put("Toto", "Titi");
        sce.getServletContext().setAttribute("connectes", connectes);
        sce.getServletContext().setAttribute("invitations", invitations);
        sce.getServletContext().setAttribute("parties", parties);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
        sce.getServletContext().removeAttribute("connectes");
        sce.getServletContext().removeAttribute("invitations");
        sce.getServletContext().removeAttribute("parties");
        
    }
}
