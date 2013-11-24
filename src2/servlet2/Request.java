/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.STI.servlet;

import com.STI.dao.Userdao;
import com.STI.entite.Utilisateur;
import com.STI.jdbc.Connexion;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author s4d3k
 */
public class Request extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession(true);
        
        String invited = request.getParameter("invited"),
               hote = (String) session.getAttribute("connecte");
        //Userdao dao   = new Userdao(Connexion.getInstance()); 
        
        
        
        //Utilisateur user= (Utilisateur)dao.read(playerOne);
        Map<String, String> invitations = (HashMap<String, String>)this.getServletContext().getAttribute("invitations");
        /*
        if (invitations==null)
        {
            invitations = new HashMap<String,String>();
            this.getServletContext().setAttribute("invitations", invitations);
        }*/
        if (invitations.containsKey(invited))
        {
            invitations.put(invited,invitations.get(invited)+","+hote);
        }
        else
            invitations.put(invited,hote);

        
        this.getServletContext().setAttribute("invitations", invitations);
        System.out.println("Taille de la map invitation : "+invitations.size());
        
        this.getServletContext().setAttribute("invited", invited);
        this.getServletContext().getRequestDispatcher("/index.jsp?action=acceuil").forward(request, response);
        
        /*dao.updateInvit(user, 1);
        
        request.setAttribute("invitation", playerTwo+ " vous invite à jouer une partie.");
        request.setAttribute("leJoueur", playerOne);
        
        this.getServletContext().getRequestDispatcher("/ConnectUser").forward(request, response);*/
        

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
    }// </editor-fold>
}
