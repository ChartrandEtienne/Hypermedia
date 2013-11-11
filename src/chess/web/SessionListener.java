package chess.web;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;
import chess.modele.Usager;

public class SessionListener implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent e) {
        System.out.println(e.toString());
        e.getSession().getServletContext().log("what the fuck");
    }
    public void sessionDestroyed(HttpSessionEvent e) {
        e.getSession().getServletContext().log("e: " + e.toString());
        e.getSession().getServletContext().log("what the fuck2");
        
        /*
        ArrayList<Usager> connectes = (ArrayList<Usager>)e.getSession().getServletContext().getAttribute("connectes");

        e.getSession().getServletContext().log("connectes:" + connectes.toString());
        e.getSession().getServletContext().log("usr_id: " + e.getSession().getAttribute("usr_id").toString());

        e.getSession().getServletContext().log("connectes size: " + connectes.size());

        for (int i = 0; i < connectes.size(); i++) {

            e.getSession().getServletContext().log("iter 1");
            if (connectes.get(i).getId() == e.getSession().getAttribute("usr_id").toString()) {
                connectes.remove(i);
            }
        }
    */
    }
}
