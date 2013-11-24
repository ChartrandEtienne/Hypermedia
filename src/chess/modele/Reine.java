package chess.modele;
import org.apache.log4j.Logger;


public class Reine extends Piece {

    private static Logger logger = Logger.getLogger(Reine.class);
	public Reine(String couleur) {
		this.couleur= couleur;
	}
    public String afficherPiece() {
        return "R " + ((couleur.equals("noir")) ? "n" : "b");
    }

	public boolean validerDep(Position debut, Position fin, Echiquier ech, String couleur) {
        if ((debut.getLigne() == fin.getLigne()) && (debut.getColonne() == fin.getColonne())) {
            logger.info("deplacement par la ligne");
            for (int i = Math.min(debut.getLigne(), fin.getLigne()) + 1; i < Math.max(debut.getLigne(), fin.getLigne()); i += 1) {
                if (ech.getPiece(new Position(i, debut.getColonne())) != null) {
                    logger.info("piece dans le chemin: (" + i + ", " + debut.getLigne() + ")");
                    return false;
                }
            }
            return true;
        } else if ((debut.getColonne() == fin.getColonne()) && (debut.getLigne() == fin.getLigne())) {
           logger.info("deplacement par la colonne");
            for (int i = Math.min(debut.getColonne(), fin.getColonne()) + 1; i < Math.max(debut.getColonne(), fin.getColonne()); i += 1) {
                if (ech.getPiece(new Position(debut.getLigne(), i)) != null) {
                    logger.info("piece dans le chemin: (" + debut.getLigne() + ", " + i + ")");
                    return false;
                }
            }
            return true;

        } else if (Math.abs(debut.getColonne() - fin.getColonne()) == Math.abs(Math.abs(debut.getColonne() - fin.getColonne()))) {
            logger.info("deplacement en biaisa correct");
            for (int col = Math.min(debut.getColonne(), fin.getColonne()) + 1, lig = Math.min(debut.getLigne(), fin.getLigne()) + 1; col < Math.max(debut.getColonne(), fin.getColonne()); col += 1, lig += 1) {
                if (ech.getPiece(new Position(lig, col)) != null) {
                    logger.info("piece dans le chemin: (" + lig + ", " + col + ")");
                    return false;
                }
            }
            return true;
        } else {
            logger.info("deplacement de biais");
            return false;
        }
    }

	@Override
	public boolean validerDep(Position posDepart, Position posFinal) {
		int diffColonne= posFinal.Colonne-posDepart.Colonne;
		int diffLigne= posFinal.ligne-posDepart.ligne;
		if(this.validerEchec(posFinal)){
		if ((diffLigne==diffColonne)||(diffLigne== -diffColonne)||
			((diffColonne==0)&&(diffLigne!=0))||((diffLigne==0)&&(diffColonne!=0)))
			return true;
		return false;
	}
                return false;
        }

	@Override
	public boolean manger(Position posDepart, Position posFinal) {
		
		return false;
	}


}
