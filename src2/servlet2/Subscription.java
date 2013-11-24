package com.STI.servlet;

//~--- non-JDK imports --------------------------------------------------------

import com.STI.dao.Userdao;
import com.STI.entite.Utilisateur;
import com.STI.jdbc.Connexion;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author s4d3k
 */
public class Subscription extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");

        String      userName = request.getParameter("nomForm"),
                    password = request.getParameter("mdpForm"),
                    email    = request.getParameter("courriel");
        Utilisateur u        = new Utilisateur(userName, password, email);
        Userdao     dao      = new Userdao(Connexion.getInstance());

        if (dao.create(u)) {
            System.out.println("utilisateur crée");
        } else {
            System.out.println("utilisateur non crée");
        }

        this.getServletContext().getRequestDispatcher("/index.jsp?action=acceuil").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Subscription.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Subscription.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }    // </editor-fold>
}


//~ Formatted by Jindent --- http://www.jindent.com
