package chess.modele;
// import chess.modele.*; // ???


public class Partie {
    private Usager joueurBlanc;
    private Usager joueurNoir;
    private Echiquier echiquier;
    public Partie() {
        joueurNoir = null;
        joueurBlanc = null;
        echiquier = null;
    }
    public Partie(Usager _a, Usager _b) {
        echiquier = new Echiquier();
        joueurNoir = _a;
        joueurBlanc = _b;
    }
    public String toString() {
        return "[partie: " + joueurNoir.toString() + ", " + joueurBlanc.toString() + "]";
    }    
    public Echiquier getEchiquier() {
        return echiquier;
    }
    public Usager getUsager1() {
        return joueurBlanc;
    }
    public Usager getUsager2() {
        return joueurNoir;
    }

}
