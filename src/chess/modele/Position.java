package chess.modele;

public class Position {

	int Colonne;
	int ligne; 
	 
	public Position(int x, int y ) {
		this.Colonne= x;
		this.ligne = y;
	}
	
	
	
	public String toString()
	{
		return "("+this.Colonne+","+this.ligne+")";
	}



	public int getColonne() {
		return Colonne;
	}



	public void setColonne(int colonne) {
		Colonne = colonne;
	}



	public int getLigne() {
		return ligne;
	}



	public void setLigne(int ligne) {
		this.ligne = ligne;
	}
	

}
