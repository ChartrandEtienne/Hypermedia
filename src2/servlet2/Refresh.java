/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.STI.servlet;

import com.STI.entite.Partie;
import com.STI.entite.Utilisateur;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author eikichie
 */
@WebServlet(name = "Refresh", urlPatterns = {"/Refresh"})
public class Refresh extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String resultat= "{";
        String rConnectUsers="";
        String invitation= "Vous &ecirctes invit&eacutes par : ";
        
        List<Utilisateur> ConnectedUsers = (List<Utilisateur>)this.getServletContext().getAttribute("connectes");
        Map<String, String> invitations = (HashMap<String, String>)this.getServletContext().getAttribute("invitations");
        Map<String, Partie> parties = (HashMap<String,Partie>) this.getServletContext().getAttribute("parties");
        
        int sizeConnectUsers= ConnectedUsers.size();
        if (sizeConnectUsers>0)
        {   rConnectUsers +="<table>";
                String name= (String)request.getSession().getAttribute("connecte");
            for (int i=0; i<sizeConnectUsers; i++)
            {
                Utilisateur user = (Utilisateur)ConnectedUsers.get(i);
                if (!user.getName().equals(name))
                    {
                        rConnectUsers += "<tr> <td> <a href='Inviter.exe?action=request&&invited="+user.getName() +"' >"+user.getName()+"</a></td></tr>";
                    }//fin de la verification de la personne connectée pr ne pas la réafficher 
            }
            rConnectUsers += "</table>";
        }else{rConnectUsers = "aucun joueur connect&eacutes";}//fin de la lecture de la liste des connectés voulant jouer
        
        
        resultat += " \"ConnectUsers\": \""+rConnectUsers+"\",";
        
        
         ///////////////////////////////////////////////////invitation
            if (invitations.containsKey((String) request.getSession().getAttribute("connecte")))
                {  String invited= (String)request.getSession().getAttribute("connecte");
                     
                    String lien= invitations.get((String) request.getSession().getAttribute("connecte"));
                    
                    String[] tabInvite = lien.split(",");
                    for(int i=0; i<tabInvite.length; i++)
                    {
                        tabInvite[i]= "<a href='startParty.exe?action=Game&&players="+tabInvite[i]+","+invited+"' >"+tabInvite[i]+"</a>";
                        invitation+= tabInvite[i]+", "; 
                    }
                    resultat += " \"invitation\": \""+invitation+"\",";//invitation+",";
               }
            else {
                
                    resultat += " \"invitation\": \"\",";//invitation+",";
            }
           
            
    ///////////////////////////////////////////////partie
            String PartieName= (String)request.getParameter("players");

           /* Partie p = new Partie();
            partie.put(PartieName, p);
            this.getServletContext().setAttribute("parties", partie);*/
            
          //  this.getServletContext().setAttribute("echec",p.getTable());
           //
            String sParties = "";
            Set e = parties.keySet();
            Iterator<String> it = e.iterator();
            while (it.hasNext())
            {
                String x = it.next();
                sParties += x+"<br />";
            }
            
            resultat += " \"parties\": \""+sParties+"\"";//invitation+",";
            resultat+= "}";
             
            response.getWriter().write(resultat);
            
            if (( this.getServletContext().getAttribute("CreateGame") != null)&&
                ("true".equals((String)this.getServletContext().getAttribute("indice"))))
            {
                Map<String, Partie> partie = (HashMap<String,Partie>) this.getServletContext().getAttribute("parties"); 
                Partie p = new Partie();
                partie.put(PartieName, p);
                String joueurs= (String)this.getServletContext().getAttribute("CreateGame");
                this.getServletContext().setAttribute("parties", partie);
                this.getServletContext().setAttribute("echec",p.getTable());
                this.getServletContext().setAttribute("Gamers", joueurs);
                this.getServletContext().setAttribute("indice", "false");
            }

            
            
           
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
    }// </editor-fold>
}
