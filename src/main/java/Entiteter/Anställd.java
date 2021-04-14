package Entiteter;

public class Anställd extends Entitet {
    private String anställningsID;
    private boolean chef;

    public Anställd(String namn, String personNr, String adress, String email, String telefonNr) {
        super(namn, personNr, adress, email, telefonNr);
    }
}
