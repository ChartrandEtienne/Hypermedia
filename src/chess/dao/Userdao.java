package chess.dao;

import chess.modele.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;




public class Userdao extends Dao<Utilisateur> {
    
public Userdao(Connection c)
	{
		super(c);
	}
                
	@Override
	public boolean create(Utilisateur x) {
	Statement stm = null;
		try 
		{
                        String req = "INSERT INTO `user` (`nom` , `mdp`, `courriel`, `connect`,`play`, `invit`) "
                                + "VALUES ('"+x.getName()+"','"+x.getMdp()+"','"+x.getCourriel()+"', 0, 0, 0);";
			stm = cnx.createStatement(); 
			int n= stm.executeUpdate(req);
			if (n>0)
			{
				stm.close();
				return true;
			}
		}
		catch (SQLException exp)
		{
		}
		finally
		{
			if (stm!=null)
			try {
				stm.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}			
		}
		return false;


	}

	@Override
	public boolean delete(Utilisateur x) {
		
		Statement stm = null;
		try 
		{
			stm = cnx.createStatement(); 
			int n= stm.executeUpdate("DELETE FROM user WHERE nom='"+x.getName()+"' AND mdp='"+x.getMdp()+"'");
			if (n>0)
			{
				stm.close();
				return true;
			}
		}
		catch (SQLException exp)
		{
		}
		finally
		{
			if (stm!=null)
			try {
				stm.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}			
		}
		return false;
	}

        @Override
        public Utilisateur read(String n) {
        
        
		try 
		{
			Statement stm = cnx.createStatement(); 
			ResultSet r = stm.executeQuery("SELECT * FROM user WHERE nom = '"+n+"'");
			if (r.next())
			{
				Utilisateur c = new Utilisateur(r.getString("nom"),r.getString("mdp"), r.getString("courriel"), r.getBoolean("connect"),  r.getBoolean("play"), r.getBoolean("invit") );
				r.close();
				stm.close();
				return c;
			}
		}
		catch (SQLException exp)
		{
		}
		return null;
    }

        @Override
        public boolean updateConnect(Utilisateur x, int connecte) {
            Statement stm = null;
		try 
		{   
			String req = "UPDATE user SET connect = '"+connecte+"' " +
							" WHERE nom = '"+x.getName().trim()+"' ;";
		
			stm = cnx.createStatement(); 
			int n= stm.executeUpdate(req);
			if (n>0)
			{
				stm.close();
				return true;
			}
		}
                catch (SQLException exp)
		{
		}
		finally
		{
			if (stm!=null)
			try {
				stm.close();
			} catch (SQLException e) {
		
				e.printStackTrace();
			}			
		}
		return false;
                }
        public boolean updatePlay(Utilisateur x, int play) {
            Statement stm = null;
		try 
		{
			String req = "UPDATE user SET play = '"+play+"'" +
							" WHERE nom = '"+x.getName()+"'";
			
			stm = cnx.createStatement(); 
			int n= stm.executeUpdate(req);
			if (n>0)
			{
				stm.close();
				return true;
			}
		}
		catch (SQLException exp)
		{
		}
		finally
		{
			if (stm!=null)
			try {
				stm.close();
			} catch (SQLException e) {
	
				e.printStackTrace();
			}			
		}
		return false;
        }
        public boolean updateInvit(Utilisateur x, int invit) {
            Statement stm = null;
		try 
		{
			String req = "UPDATE user SET invit = '"+invit+"'" +
							" WHERE nom = '"+x.getName()+"'";
			
			stm = cnx.createStatement(); 
			int n= stm.executeUpdate(req);
			if (n>0)
			{
				stm.close();
				return true;
			}
		}
		catch (SQLException exp)
		{
		}
		finally
		{
			if (stm!=null)
			try {
				stm.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}			
		}
		return false;
        }

        @Override
        public List<Utilisateur> findAll() {
            List<Utilisateur> l = new LinkedList<Utilisateur>();
            try 
		{       
			Statement stm = cnx.createStatement(); 
			ResultSet r = stm.executeQuery("SELECT * FROM user WHERE  play=1");
			while (r.next())
			{
				Utilisateur u = new Utilisateur(r.getString("nom"),r.getString("mdp"));
                                l.add(u);
                                 
                        }       r.close();
				stm.close();
		}
		catch (SQLException exp)
		{
                    
                    return l;
		}
                
		return l;
        }
        
        public List<Utilisateur> findAllInvit() {
            List<Utilisateur> l = new LinkedList<Utilisateur>();
            try 
		{       
			Statement stm = cnx.createStatement(); 
			ResultSet r = stm.executeQuery("SELECT * FROM user WHERE  invit=1");
			while (r.next())
			{
				Utilisateur u = new Utilisateur(r.getString("nom"),r.getString("mdp"));
                                l.add(u);
                                 
                        }       r.close();
				stm.close();
		}
		catch (SQLException exp)
		{
                    
                    return l;
		}
                
		return l;
        }
        
        
        @Override
	public boolean updateUserInfo(Utilisateur x) {
	Statement stm = null;
		try 
		{
                    String req = "UPDATE user SET   `mdp` =  '"+x.getMdp()+"',  `courriel` =  '"+x.getCourriel()+"', "
                                                              + "`connect` =  0, `play` =  0, `invit` =  0 WHERE `nom` =  '"+x.getName()+"';";
			stm = cnx.createStatement(); 
			int n= stm.executeUpdate(req);
			if (n>0)
			{
				stm.close();
				return true;
			}
		}
		catch (SQLException exp)
		{
		}
		finally
		{
			if (stm!=null)
			try {
				stm.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}			
		}
		return false;


	}

   
       
        
       
}
