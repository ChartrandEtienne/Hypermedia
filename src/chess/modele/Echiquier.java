package chess.modele;


public class Echiquier {
	int max= 8;
    Piece[][] listPieces = new Piece[8][8];
    Position posPieceCourante;
	
    public Echiquier() 
		{
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
