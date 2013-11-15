package chess.modele;

public  abstract class Piece {

    public String getCouleur() {
        return couleur;
    }

   String couleur;
    public String afficherPiece() {
        return "p " + ((couleur.equals("noir")) ? "n" : "b");
    }
   public abstract boolean validerDep(Position posDepart, Position posFinal);
   public abstract boolean manger(Position posDepart, Position posFinal);
   public boolean validerEchec(Position posFinal)
   {
       if(((posFinal.getLigne()<=8)&&(posFinal.getColonne()<=8))&&((posFinal.getLigne()>0)&&(posFinal.getColonne()>0))){
           return true;
       }return false;
   }
   
}
