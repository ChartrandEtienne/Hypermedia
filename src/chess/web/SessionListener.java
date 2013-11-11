package chess.web;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;
import java.util.HashMap;
import chess.modele.Usager;

public class SessionListener implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent e) {
        System.out.println(e.toString());
        e.getSession().getServletContext().log("what the fuck");
    }
    public void sessionDestroyed(HttpSessionEvent e) {
        e.getSession().getServletContext().log("e: " + e.toString());
        e.getSession().getServletContext().log("what the fuck2");
        
    }
}
