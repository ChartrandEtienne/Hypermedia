
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ilyes
 */
public class Logout extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // déconnexion
        HttpSession session = request.getSession(true);
        String      name    = (String) session.getAttribute("connecte");
        Userdao     dao     = new Userdao(Connexion.getInstance());
        Utilisateur user    = dao.read(name);

        dao.updateConnect(user, 0);
        dao.updatePlay(user, 0);
        session.removeAttribute("connecte");
        // enlever le joueur de la listes des personnes connectes et voulant jouer
        List<Utilisateur> connectes = (List<Utilisateur>) this.getServletContext().getAttribute("connectes");
            connectes.remove(user);
        this.getServletContext().setAttribute("connectes", connectes);
         // supprimer toutes les invitations qui ont été faites a la derniere session.
        Map<String,String> invitation = (HashMap<String,String>) this.getServletContext().getAttribute("invitations");
            invitation.clear();
        this.getServletContext().setAttribute("invitations", invitation);
        this.getServletContext().removeAttribute("Gamers");
        
        
        RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp");

        r.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    public String getServletInfo() {
        return "Short description";
    }    // </editor-fold>
}


//~ Formatted by Jindent --- http://www.jindent.com
