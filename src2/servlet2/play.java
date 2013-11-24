
/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package com.STI.servlet;

//~--- non-JDK imports --------------------------------------------------------

import com.STI.dao.Userdao;
import com.STI.entite.Utilisateur;
import com.STI.jdbc.Connexion;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Usager
 */
@WebServlet(
    name        = "play",
    urlPatterns = { "/play" }
)
public class play extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession(true);
        Userdao     dao     = new Userdao(Connexion.getInstance());
        String      name    = (String) session.getAttribute("connecte");
        Utilisateur user    = dao.read(name);

        if ("ready".equals(request.getParameter("activity"))) {
            dao.updatePlay(user, 1);
            
            session.setAttribute("play", "yes");
            List<Utilisateur> connectes = (List<Utilisateur>) this.getServletContext().getAttribute("connectes");
            if (connectes.contains(user)){}
            else{
            connectes.add(user);
            this.getServletContext().setAttribute("connectes", connectes);}
        }

        if ("observer".equals(request.getParameter("activity"))) {
            dao.updatePlay(user, 0);
            session.setAttribute("play", "observer");
            List<Utilisateur> connectes = (List<Utilisateur>) this.getServletContext().getAttribute("connectes");
            connectes.remove(user);
        
            this.getServletContext().setAttribute("connectes", connectes);
        }

        this.getServletContext().getRequestDispatcher("/index.jsp?action=acceuil").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }    // </editor-fold>
}


//~ Formatted by Jindent --- http://www.jindent.com
