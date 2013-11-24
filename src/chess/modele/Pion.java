package chess.modele;
import org.apache.log4j.Logger;



public class Pion extends Piece {
  
    private static Logger logger = Logger.getLogger(Pion.class);
	
	public Pion(String couleur)
		{this.couleur = couleur;
		}
    public String afficherPiece() {
        return "P " + ((couleur.equals("noir")) ? "n" : "b");
    }


	public boolean validerDep(Position debut, Position fin, Echiquier ech, String couleur) {
        // 1) un pion partant de sa case originale peut avancer de deux cases,
        // mais pas si quelqu'un est present 
        logger.info("validerDep, debut: (" + debut.getColonne() + ", " + debut.getLigne() + "), fin: (" + fin.getColonne() + ", " + fin.getLigne() + ")");

        if (couleur.equals("blanc")) {
            logger.info("blanc");
            if (debut.getColonne() == fin.getColonne()) {
                logger.info("meme colonne");
                if (((fin.getLigne() - debut.getLigne()) == 1) && (ech.getPiece(fin) == null)) {
                    return true;
                }
                // le pion est a sa case depart, le deplacement est de deux
                // cases, les deux cases sont vides
                if (((fin.getLigne() - debut.getLigne()) == 2) && (ech.getPiece(fin) == null) && (ech.getPiece(new Position(fin.getColonne(), fin.getLigne() - 1))== null) && (debut.getLigne() == 1)) {
                    return true;
                }
            }
            // 2) un pion capture une case en avant et sur le cote.
            if (Math.abs(debut.getColonne() - fin.getColonne()) == 1) {
                logger.info(" diff colonnes = 1 ");
                if (((fin.getLigne() - debut.getLigne()) == 1) && (ech.getPiece(fin) != null)) {
                    return true;
                }
            }
            return false;
        } else {
            logger.info("noir");
            if (debut.getColonne() == fin.getColonne()) {
                logger.info("meme colonne");
                if ((fin.getLigne() - debut.getLigne()) == -1) {
                    logger.info("((fin.getLigne() - debut.getLigne()) == -1)");
                }
                if (((fin.getLigne() - debut.getLigne()) == -1) && (ech.getPiece(fin) == null)) {
                    return true;
                }
                // le pion est a sa case depart, le deplacement est de deux
                // cases, les deux cases sont vides
                if ((fin.getLigne() - debut.getLigne()) == -2) {
                    logger.info("fin - debut getline == -2"); 
                }
                if (ech.getPiece(fin) == null) {
                    logger.info("(ech.getPiece(fin) == null)");
                
                }
                if (ech.getPiece(new Position(fin.getColonne(), fin.getLigne() - 1))== null) {
                    logger.info("(ech.getPiece(new Position(fin.getColonne(), fin.getLigne() - 1))== null)");
                }
                if (debut.getLigne() == 6) {
                    logger.info("(debut.getLigne() == 6)");
                }
                if (((fin.getLigne() - debut.getLigne()) == -2) && (ech.getPiece(fin) == null) && (ech.getPiece(new Position(fin.getColonne(), fin.getLigne() + 1))== null) && (debut.getLigne() == 6)) {
                    return true;
                }
            }
            // 2) un pion capture une case en avant et sur le cote.
            if (Math.abs(debut.getColonne() - fin.getColonne()) == 1) {
                logger.info(" diff colonnes = 1 ");
                if (((fin.getLigne() - debut.getLigne()) == -1) && (ech.getPiece(fin) != null)) {
                    return true;
                }
            }
            return false;
        }
    }

	@Override
	public boolean validerDep(Position posDepart, Position posFinal) {
		int diffColonne= posFinal.Colonne-posDepart.Colonne;
		int diffLigne= posFinal.ligne-posDepart.ligne;
		//verifier si cest son premier coups et donc accepter lavance de deux cases
		
		if (this.validerEchec(posFinal)){		// verifier si le deplacement est d'une case de colonne
				if ( (diffLigne==-1) && (diffColonne==0) )
				return true;
				
				
				return false;
	}return false;
        }

	@Override
	public boolean manger(Position posDepart, Position posFinal) {
		int diffColonne= posFinal.Colonne-posDepart.Colonne;
		int diffLigne= posFinal.ligne-posDepart.ligne;
		
		if ((diffLigne==1)&&((diffColonne==1)||(diffColonne==-1)) )
		   {
			return true;
		   }
		return false;
	}

	



	
	
	
}
