package chess.modele;
import java.util.ArrayList;

public class Usager {
    private String id;
    private ArrayList<Usager> aInvite;
    public String toString() {
        return "[joueur: "+ id + "]";
    }
    public Usager(String _id) {
        aInvite = new ArrayList<Usager>();
        id = _id;
    }
    public String getId() {
        return id;
    }
    public ArrayList<Usager> getInvitations() {
        return aInvite;
    }
    public void supprimerInvivations() {
        aInvite = new ArrayList<Usager>();
    }
}
