package chess.modele;

public class Cavalier extends Piece {

	public Cavalier(String couleur) {
		this.couleur= couleur;
	}

    public String afficherPiece() {
        return "C " + ((couleur.equals("noir")) ? "n" : "b");
    }
	@Override
	public boolean validerDep(Position debut, Position fin, Echiquier ech, String couleur) {
        // what?
		int diffColonne= fin.Colonne-debut.Colonne;
		int diffLigne= fin.ligne-debut.ligne;
		if(this.validerEchec(fin)){
		if ((((diffLigne==1)||(diffLigne==-1))&&((diffColonne==2)||(diffColonne==-2)))||
			(((diffLigne==2)||(diffLigne==-2))&&((diffColonne==1)||(diffColonne==-1))))
			return true;
		return false;
        } else return false; 
    }

	public boolean validerDep(Position posDepart, Position posFinal) {
		int diffColonne= posFinal.Colonne-posDepart.Colonne;
		int diffLigne= posFinal.ligne-posDepart.ligne;
		if(this.validerEchec(posFinal)){
		if ((((diffLigne==1)||(diffLigne==-1))&&((diffColonne==2)||(diffColonne==-2)))||
			(((diffLigne==2)||(diffLigne==-2))&&((diffColonne==1)||(diffColonne==-1))))
			return true;
		return false;
                }else return false; 
        }
        

	@Override
	public boolean manger(Position posDepart, Position posFinal) {
		// TODO Auto-generated method stub
		return false;
	}





}
