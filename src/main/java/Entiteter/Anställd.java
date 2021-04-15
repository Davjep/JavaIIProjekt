package Entiteter;

public class Anställd extends Entitet {
    private String anställningsID;
    private boolean chef;

    public Anställd(String namn, String personNr, String adress, String email, String telefonNr, String anställningsID, boolean chef) {
        super(namn, personNr, adress, email, telefonNr);
        this.anställningsID = anställningsID;
        this.chef = chef;
    }

    public String getAnställningsID() {
        return anställningsID;
    }

    public void setAnställningsID(String anställningsID) {
        this.anställningsID = anställningsID;
    }

    public boolean isChef() {
        return chef;
    }

    public void setChef(boolean chef) {
        this.chef = chef;
    }
}
