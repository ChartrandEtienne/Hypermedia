package chess.modele;

public class Reine extends Piece {

	public Reine(String couleur) {
		this.couleur= couleur;
	}
    public String afficherPiece() {
        return "R " + ((couleur.equals("noir")) ? "n" : "y");
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
