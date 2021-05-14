package Entiteter;

public class Anställd extends Entitet {
    private static String anställd;
    private boolean chef;

    public Anställd(String förNamn, String efterNamn, String gatuAdress, String postNr, String email, String personNr, String telefonNr, String lösenord, boolean chef) {
        super(förNamn, efterNamn, gatuAdress, postNr, email, personNr, telefonNr, lösenord);
        this.chef = chef;
    }


    public boolean getChef() {
        return chef;
    }

    public void setChef(boolean chef) {
        this.chef = chef;
    }
}
