package chess.modele;
import java.util.ArrayList;

public class Usager {
    private String id;
    private ArrayList<Usager> aInvite;
    public Usager(String id) {
        aInvite = new ArrayList<Usager>();
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
