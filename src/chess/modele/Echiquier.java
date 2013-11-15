package chess.modele;


public class Echiquier {
	int max= 8;
    // a qui de jouer?
    private String tour;
    Piece[][] listPieces = new Piece[8][8];
    Position posPieceCourante;

    public String getTour() {
        return tour;
    }
	
    public Echiquier() 
		{
            tour = "blanc";
			Piece[] pieceB= {new Tour("blanc"), new Cavalier("blanc"), new Fou("blanc"), new Roi("blanc"), new Reine("blanc"), new Fou("blanc"), new Cavalier("blanc"), new Tour("blanc") };
			Piece[] pieceN= {new Tour("noir"),  new Cavalier("noir"),  new Fou("noir"),  new Reine("noir"), new Roi("noir"),   new Fou("noir"),  new Cavalier("noir"),  new Tour("noir")  };
		
			listPieces[0]= pieceB;
			listPieces[7]= pieceN;
			for (int j=0; j< max; j++)
				{
					listPieces[1][j]= new Pion("blanc");
					listPieces[6][j]= new Pion("noir");
				}
		}

    public String deplacer2(Position debut, Position fin, String couleur) {
        Piece aDeplacer = listPieces[debut.ligne][debut.Colonne];
        if (aDeplacer == null) {
            return "aDeplacer null";
        } else if (aDeplacer.validerDep(debut, fin) && (tour == couleur)) {
            listPieces[debut.ligne][debut.Colonne] = null;
            listPieces[fin.ligne][fin.Colonne] = aDeplacer;
            tour = ((tour == "noir") ? "blanc" : "noir");
            return "FAIT";
        } else {
            return ((tour == couleur) ? "validerDep faux" : "tour == couleur faux");
        }
    }
	
	public boolean deplacer( Position posB)
		{   if (listPieces[posPieceCourante.ligne][posPieceCourante.Colonne] == null)
				{
					return false;
				}
                
			else if (listPieces[posPieceCourante.ligne][posPieceCourante.Colonne].validerDep(posPieceCourante, posB))
				{ 	
					listPieces[posB.ligne][posB.Colonne]= listPieces[posPieceCourante.ligne][posPieceCourante.Colonne];
					listPieces[posPieceCourante.ligne][posPieceCourante.Colonne]= null;
					return true;
				}
				else return false;
		}
	
	public void selectionnee(Position pos)
		{	posPieceCourante= pos;
		
		}
        public Piece get(int i, int j)
        {
            return this.listPieces[i][j];
        }

    public Piece[][] getListPieces() {
        return listPieces;
    }

    public Position getPosPieceCourante() {
        return posPieceCourante;
    }

    public void setListPieces(Piece[][] listPieces) {
        this.listPieces = listPieces;
    }

    public void setPosPieceCourante(Position posPieceCourante) {
        this.posPieceCourante = posPieceCourante;
    }
        

}
