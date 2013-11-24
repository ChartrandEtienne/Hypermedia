
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

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author eikichie
 */
@WebServlet(
    name        = "ConnectUser",
    urlPatterns = { "/ConnectUser" }
)
public class ConnectUser extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        
        String resultat="";
        
        List<Utilisateur> ConnectedUsers = (List<Utilisateur>)this.getServletContext().getAttribute("connectes");
        int size= ConnectedUsers.size();
        if (size>0)
        { for (int i=0; i<size; i++)
            {
                resultat +="<table>";
                Utilisateur user = (Utilisateur)ConnectedUsers.get(i);
                String name= (String)request.getSession().getAttribute("connecte"); 
                if (!user.getName().equals(name))
                    {
                        resultat += "<tr> <td> <a href='Inviter.exe?action=request&&invited="+user.getName() +"' >"+user.getName()+"</a></td></tr>";
                    }//fin de la verification de la personne connectée pr ne pas la réafficher 
            }resultat += "</table>";
        }else{resultat = "aucun joueur connectés";}//fin de la lecture de la liste des connectés voulant jouer
        
       System.out.println(""+resultat);
         response.getWriter().write("liste des joueurs <br />"+resultat);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
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
     * Handles the HTTP
     * <code>POST</code> method.
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }    // </editor-fold>
}


//~ Formatted by Jindent --- http://www.jindent.com
