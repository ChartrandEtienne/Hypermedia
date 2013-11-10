package chess.vue;
// import chess.modele.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import parsing.*;
import org.apache.log4j.Logger;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import com.mysql.jdbc.Driver;


public class InitSalon extends HttpServlet { 
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
            out.println("<html>");
            out.println("<head>");
            out.println("<title>salon</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Bienvenue au salon</h1>");
            out.println(request.getParameter("joueurId"));
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            System.out.println("exception: " + e.getMessage());
        }
    }
}

/*
	public void doGet(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, java.io.IOException {
    String concat = "3lulz";
    try {
         Class.forName("com.mysql.jdbc.Driver");
//        "jdbc:mysql://repos.insttech.washington.edu:3306/johndoe?user=johndoe&password=jddb"
        Connexion.setUrl("jdbc:mysql://localhost:3306/forum?user=root&password=4dmin");
        Connection cnx = Connexion.getInstance();
        concat = concat + ", cnx: " + cnx.toString();

        String req = "SELECT url FROM post WHERE usager = 1";

        Statement stm = cnx.createStatement();
        concat = concat + ", stm: " + stm.toString() + ", ";

        
        ResultSet rs = stm.executeQuery(req);
        while (rs.next()) {
            concat = concat + rs.getString("url");
        }
    } catch (Exception e) {
        System.out.println("exception: " + e.getMessage());
        concat = concat + "error: " + e.getMessage() + "; " + e.toString();
    }

        ServletContext context = getServletContext();
        context.log("ca marche?");
        String recu = request.getParameter("banane");
        context.log("simple, message recu: " + recu);
        HttpSession sess = request.getSession(false);
        sess.setAttribute("message", "recu: " + recu);
        sess.setAttribute("urls", concat);
        request.getRequestDispatcher("/Test2.jsp").forward(request, reponse);
        /*
        reponse.setContentType("text/html");
        java.io.PrintWriter out = reponse.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>wtf</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>resultat</h1>");
        out.println(request.getParameter("banane"));
        out.println("</body>");
        out.println("</html>");
	}
	public void doPost(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, java.io.IOException {
        doGet(request, reponse);
    }
}
*/
