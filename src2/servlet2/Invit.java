/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.STI.servlet;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usager
 */
@WebServlet(name = "Invit", urlPatterns = {"/Invit"})
public class Invit extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            

           
           
            Map<String, String> invitations = (HashMap<String, String>)this.getServletContext().getAttribute("invitations");
            /*String s = "Liste des invitations <br />";
            Set e = invitations.keySet();
            Iterator<String> it = e.iterator();
            while (it.hasNext())
            {
                String x = it.next();
                s += x+" invité par "+invitations.get(x) + ";";
            }
            response.getWriter().write(s);
            */
            if (invitations.containsKey((String) request.getSession().getAttribute("connecte")))
            {  String invited= (String)request.getSession().getAttribute("connecte");
                System.out.println("servlet invit"); 
                String lien= invitations.get((String) request.getSession().getAttribute("connecte"));
                String joueurs= "";
                String[] tabInvite = lien.split(",");
                for(int i=0; i<tabInvite.length; i++)
                {
                    tabInvite[i]= "<a href='startParty.exe?action=Game&&players="+tabInvite[i]+invited+"' >"+tabInvite[i]+"</a>";
                    joueurs+= tabInvite[i]+", "; 
                }
                response.getWriter().write("Vous êtes invités par : "+joueurs);
                
            }else {response.getWriter().write("--Aucune invitation--");}
           
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
