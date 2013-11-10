package chess.web;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;
import chess.modele.Usager;

public class SessionListener implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent e) {
        System.out.println(e.toString());
    }
    public void sessionDestroyed(HttpSessionEvent e) {
        System.out.println(e.toString());
        ArrayList<Usager> connectes = (ArrayList<Usager>)e.getSession().getServletContext().getAttribute("connectes");
        for (int i = 0; i < connectes.size(); i++) {
            // XXX
            // bug probable ici
            if (connectes.get(i).getId() == e.getSession().getAttribute("usr_id").toString()) {
                connectes.remove(i);
            }
        }
    }
}
