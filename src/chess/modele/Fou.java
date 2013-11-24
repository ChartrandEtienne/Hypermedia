package chess.modele;

import org.apache.log4j.Logger;

//    private static Logger logger = Logger.getLogger(Fou.class);

public class Fou extends Piece{

    private static Logger logger = Logger.getLogger(Fou.class);

	public Fou(String couleur) {
		this.couleur= couleur;
	}
    public String afficherPiece() {
        return "F " + ((couleur.equals("noir")) ? "n" : "b");
    }

	@Override
	public boolean validerDep(Position posDepart, Position posFinal) {
		int diffColonne= posFinal.Colonne-posDepart.Colonne;
		int diffLigne= posFinal.ligne-posDepart.ligne;
		if (this.validerEchec(posFinal)){
		if (((diffLigne==diffColonne)||(diffLigne== -diffColonne)))
			return true;
		return false;
	    } else return false;
                
    }

	public boolean validerDep(Position debut, Position fin, Echiquier ech, String couleur) {
        if (Math.abs(debut.getColonne() - fin.getColonne()) == Math.abs(Math.abs(debut.getColonne() - fin.getColonne()))) {
            logger.info("deplacement en biaisa correct");
            /*
            for (int col = Math.min(debut.getColonne(), fin.getColonne()) + 1, lig = Math.min(debut.getLigne(), fin.getLigne()) + 1; col < Math.max(debut.getColonne(), fin.getColonne()); col += 1, lig += 1) {
                logger.info("scan: (" + 
                if (ech.getPiece(new Position(lig, col)) != null) {
                    logger.info("piece dans le chemin: (" + lig + ", " + col + ")");
                    return false;
                }
            }
            */

            // mettons (5, 1) -> (1, 5)
            
            int basex = fin.getColonne();
            // 1
            int basey = fin.getLigne();
            // 5

            boolean offsetx = basex > debut.getColonne();
            // vrai -> +
            boolean offsety = basey > debut.getLigne();
            // faux -> -

            int longeur = Math.abs(debut.getColonne() - fin.getColonne()) - 1;
            // 4
            
            // 1, 5
            // 2, 4
            // 3, 3
            // 4, 2
            basex = (!offsetx ? basex + 1 : basex - 1);
            basey = (!offsety ? basey + 1 : basey - 1);

            logger.info("basex: " + basex);
            logger.info("basey: " + basey);
            logger.info("offsetx: " + offsetx);
            logger.info("offsety: " + offsety);
            logger.info("longeur: " + longeur);

            for (; longeur > 0; basex = (offsetx ? basex + 1 : basex - 1), basey = (offsety ? basey + 1 : basey - 1), longeur = longeur - 1) {
                logger.info("scan: (" + basex + ", " + basey + ")");
                if (ech.getPiece(new Position(basex, basey)) != null) {
                    logger.info("piece dans le chemin: (" + basex + ", " + basey + ")");
                    return false;
                }
            }

            return true;
        } else {
            logger.info("deplacement pas en biais");
            return false;
        }
    }

	@Override
	public boolean manger(Position posDepart, Position posFinal) {
		// TODO Auto-generated method stub
		return false;
	}



}
