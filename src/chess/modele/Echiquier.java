package chess.modele;
import org.apache.log4j.Logger;


public class Echiquier {
    private Logger logger = Logger.getLogger(Echiquier.class);
	int max= 8;
    // a qui de jouer?
    private String tour;
    Piece[][] listPieces = new Piece[8][8];
    Position posPieceCourante;

    public String getTour() {
        return tour;
    }
    
    public Piece getPiece(Position pos) {
        return listPieces[pos.getLigne()][pos.getColonne()];
    }


    String diag;

    // les bordel d'attaques speciales du bordel de pion
    public boolean validerDeplacementPion(Position debut, Position fin, Piece pion) {
        // 1) un pion partant de sa case originale peut avancer de deux cases,
        // mais pas si quelqu'un est present 

        diag = " debut:" + debut.toString() + ", fin: " + fin.toString() + ", ";

        if (pion.getCouleur().equals("blanc")) {
            if (debut.getColonne() == fin.getColonne()) {
                if (((fin.getLigne() - debut.getLigne()) == 1) && (listPieces[fin.getLigne()][fin.getColonne()] == null)) {
                    return true;
                }
                // le pion est a sa case depart, le deplacement est de deux
                // cases, les deux cases sont vides
                if (((fin.getLigne() - debut.getLigne()) == 2) && (listPieces[fin.getLigne()][fin.getColonne()] == null) && (listPieces[fin.getLigne() - 1][fin.getColonne()] == null) && (debut.getLigne() == 1)) {
                    return true;
                }
            // 2) un pion capture une case en avant et sur le cote.
            } else if (Math.abs(debut.getColonne() - fin.getColonne()) == 1) {
                diag = diag + " diff colonnes = 1 ";
                if (((fin.getLigne() - debut.getLigne()) == 1) && (listPieces[fin.getLigne()][fin.getColonne()] != null)) {
                    return true;
                }
            }
        } else if (pion.getCouleur().equals("noir")) {
            if (debut.getColonne() == fin.getColonne()) {
                if (((fin.getLigne() - debut.getLigne()) == -1) && (listPieces[fin.getLigne()][fin.getColonne()] == null)) {
                    return true;
                }
                // le pion est a sa case depart, le deplacement est de deux
                // cases, les deux cases sont vides
                if (((fin.getLigne() - debut.getLigne()) == -2) && (listPieces[fin.getLigne()][fin.getColonne()] == null) && (listPieces[fin.getLigne() - 1][fin.getColonne()] == null) && (debut.getLigne() == 6)) {
                    return true;
                }
            // 2) un pion capture une case en avant et sur le cote.
            } else if (Math.abs(debut.getColonne() - fin.getColonne()) == 1) {
                diag = diag + " diff colonnes = 1 ";
                if (((fin.getLigne() - debut.getLigne()) == -1) && (listPieces[fin.getLigne()][fin.getColonne()] != null)) {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
        return false;
    }
	
    public Echiquier() 
		{
            diag = "";
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

    public boolean deplacer3(Position debut, Position fin, String couleur) {
        logger.info("deplacer3");
        Piece aDeplacer = listPieces[debut.ligne][debut.Colonne];
        if (aDeplacer == null) {
            logger.info("piece invalide");
            return false;
        } else if (tour == couleur) {
            if (aDeplacer.validerDep(debut, fin, this, couleur)) {
                listPieces[debut.ligne][debut.Colonne] = null;
                listPieces[fin.ligne][fin.Colonne] = aDeplacer;
                tour = ((tour == "noir") ? "blanc" : "noir");
                logger.info("coup reussi");
                return true;
            } else {
                logger.info("coup non valide");
                return false;
            }
        } else {
            logger.info("mauvais tour");
            return false;
        }
    }

    public String deplacer2(Position debut, Position fin, String couleur) {
        logger.info("deplacer2");
        Piece aDeplacer = listPieces[debut.ligne][debut.Colonne];
        if (aDeplacer == null) {
            return "aDeplacer null";
        } else if ((aDeplacer instanceof Pion) && (tour == couleur)) {
                if (validerDeplacementPion(debut, fin, aDeplacer)) {
                    listPieces[debut.ligne][debut.Colonne] = null;
                    listPieces[fin.ligne][fin.Colonne] = aDeplacer;
                    tour = ((tour == "noir") ? "blanc" : "noir");
                    return "FAIT";
                }

                return "what" + " diag: " + diag;

        } else if (aDeplacer.validerDep(debut, fin) && (tour == couleur)) {
            listPieces[debut.ligne][debut.Colonne] = null;
            listPieces[fin.ligne][fin.Colonne] = aDeplacer;
            tour = ((tour == "noir") ? "blanc" : "noir");
            return "FAIT";
        } else {
            return ((tour == couleur) ? "validerDep faux" : "tour == couleur faux") + " diag: " + diag;
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
