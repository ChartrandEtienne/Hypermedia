
/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package com.STI.servlet;

//~--- non-JDK imports --------------------------------------------------------

import com.STI.dao.*;
import com.STI.dao.Userdao;
import com.STI.entite.Utilisateur;
import com.STI.jdbc.Connexion;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String u = request.getParameter("nom"),
               p = request.getParameter("mdp");

        if ((u == null) || u.trim().equalsIgnoreCase("")) {

            // Utilisateur inexistant
            request.setAttribute("message", "le nom d'utilisateur est obligatoire");

            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/login.jsp");

            r.forward(request, response);

            return;
        }

        try {
            Class.forName(this.getServletContext().getInitParameter("piloteJdbc"));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        Connexion.setUrl(this.getServletContext().getInitParameter("urlBd"));

        Userdao     dao  = new Userdao(Connexion.getInstance());
        Utilisateur user = dao.read(u.trim());

        if (user == null) {

            // Utilisateur inexistant
            request.setAttribute("message", "Utilisateur " + u + " inexistant.");

            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp");

            r.forward(request, response);
        } else if (!user.getMdp().equals(p)) {

            // Mot de passe incorrect
            request.setAttribute("message", "Mot de passe incorrect.");

            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp");

            r.forward(request, response);
        } else {

            // connexion OK
            HttpSession session = request.getSession(true);

            session.setAttribute("connecte", u);
            session.setAttribute("play","no");

            // changer le statut de lutilisateur dans la base de donnée a connecte=true.
            //dao.updateConnect(user, 1);
            
            
            this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }
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
