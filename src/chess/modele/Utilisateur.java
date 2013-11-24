package chess.modele;

public class Utilisateur {
	
	int id;
	String name;
    String mdp;
	String courriel;
        boolean connecte;
        boolean play;
        boolean invit;

    public void setInvit(boolean invit) {
        this.invit = invit;
    }

    public boolean isInvit() {
        return invit;
    }
        
        
	Partie[] partie;
	
	public Utilisateur(String n, String m, String c, boolean connecte, boolean play, boolean invit)
	{
		this.name = n;
                this.mdp = m;
		this.courriel = c;
                this.connecte = connecte;
                this.play = play;
                this.invit = invit;
	}
	public Utilisateur(String n, String m)
	{
		this(n,m, "Courriel", false, false, false);
	}
        
        public Utilisateur(String n, String m, String c){
                this(n,m, c, false, false, false);
        }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }
        

    public void setConnecte(boolean connecte) {
        this.connecte = connecte;
    }

    public void setPlay(boolean play) {
        this.play = play;
    }

    public boolean isConnecte() {
        return connecte;
    }

    public boolean isPlay() {
        return play;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
	
        public boolean jouer(Partie p)
	{
		p = new Partie();
		return true;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
        

        public boolean equals(Object x)
        { if (x instanceof Utilisateur)
            {
                Utilisateur xy = (Utilisateur) x;
                if (xy.getName().equals(this.getName()))
                {
                    return true;
                }
            }else { return false;}
        return false;
        }

}
