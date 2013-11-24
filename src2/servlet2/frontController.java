
/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package com.STI.servlet;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usager
 */
@WebServlet(
    name        = "frontController",
    urlPatterns = { "/frontController" }
)
public class frontController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        try {
            String choix = request.getParameter("action");
            RequestDispatcher r     = this.getServletContext().getRequestDispatcher("/index.jsp");

            if (choix != null) {
                if ("login".equals(choix)) {
                    r = this.getServletContext().getRequestDispatcher("/signin");
                    r.forward(request, response);
                    return;
                }

                if ("ConnectUser".equals(choix.trim())) {
                    r = this.getServletContext().getRequestDispatcher("/ConnectUser");
                    r.forward(request, response);
                    return;
                }

                if ("lgt".equals(choix)) {
                    r = this.getServletContext().getRequestDispatcher("/signout");
                    r.forward(request, response);
                    return;
                }
                if ("Refresh".equals(choix)) {
                    r = this.getServletContext().getRequestDispatcher("/Refresh");
                    r.forward(request, response);
                    return;
                }

                if ("Inscription".equals(choix)) {
                    r = this.getServletContext().getRequestDispatcher("/Subscription");
                    r.forward(request, response);
                    return;
                }
                
                if ("invit".equals(choix)) {
                    r = this.getServletContext().getRequestDispatcher("/Invit");
                    r.forward(request, response);
                    return;
                }

                if ("subscription".equals(choix)) {
                    r = this.getServletContext().getRequestDispatcher("/index.jsp");
                    r.forward(request, response);
                    return;
                }

                if ("play".equals(choix)) {
                    r = this.getServletContext().getRequestDispatcher("/play");
                    r.forward(request, response);
                    return;
                }
                if ("Game".equals(choix))
                {
                    r = this.getServletContext().getRequestDispatcher("/Game");  
                    r.forward(request, response);                 
                    return;
                }

                if ("regles".equals(choix))
                {
                r = this.getServletContext().getRequestDispatcher("/index.jsp"); 
                r.forward(request, response);     
                return;
                } 

                if ("request".equals(choix)) {
                    r = this.getServletContext().getRequestDispatcher("/Request");
                    r.forward(request, response);
                    return;
                }
                if ("acceuil".equals(choix))
                {
                    r = this.getServletContext().getRequestDispatcher("/index.jsp");  
                    r.forward(request, response);                   
                    return;
                }
                if ("profil".equals(choix))
                {
                    r = this.getServletContext().getRequestDispatcher("/AfficherProfil");  
                    r.forward(request, response);                 
                    return;
                }
                if ("changeProfil".equals(choix))
                {
                    r = this.getServletContext().getRequestDispatcher("/ProfilUpdate");  
                    r.forward(request, response);                 
                }
            }
        }
        finally {            
            out.close();
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
