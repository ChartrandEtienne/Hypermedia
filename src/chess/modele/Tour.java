package chess.modele;
import org.apache.log4j.Logger;


public class Tour extends Piece{
	
    private static Logger logger = Logger.getLogger(Tour.class);
	public Tour(String couleur)
	{this.couleur= couleur;
		
	}
    public String afficherPiece() {
        return "T " + ((couleur.equals("noir")) ? "n" : "b");
    }

	public boolean validerDep(Position debut, Position fin, Echiquier ech, String couleur) {
        if (debut.getColonne() == fin.getColonne()) {
            logger.info("deplacement par la ligne");
            for (int i = Math.min(debut.getLigne(), fin.getLigne()) + 1; i < Math.max(debut.getLigne(), fin.getLigne()); i += 1) {
                if (ech.getPiece(new Position(debut.getColonne(), i)) != null) {
                    logger.info("piece dans le chemin: (" + i + ", " + debut.getLigne() + ")");
                    return false;
                }
            }
            return true;
        } else if (debut.getLigne() == fin.getLigne()) {
           logger.info("deplacement par la colonne");
            for (int i = Math.min(debut.getColonne(), fin.getColonne()) + 1; i < Math.max(debut.getColonne(), fin.getColonne()); i += 1) {
                if (ech.getPiece(new Position(i, debut.getLigne())) != null) {
                    logger.info("piece dans le chemin: (" + debut.getLigne() + ", " + i + ")");
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
		if (((diffLigne==0)&&(diffColonne!=0))||((diffLigne!=0)&&(diffColonne==0)))
			return true;
		return false;
	}else 
                    return false;
        }

	@Override
	public boolean manger(Position posDepart, Position posFinal) {
		// TODO Auto-generated method stub
		return false;
	}


}
