package chess.modele;

public class Tour extends Piece{
	
	public Tour(String couleur)
	{this.couleur= couleur;
		
	}
    public String afficherPiece() {
        return "T " + ((couleur.equals("noir")) ? "n" : "y");
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
