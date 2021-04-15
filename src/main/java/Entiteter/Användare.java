package Entiteter;

public class Användare extends Entitet {
    private String användarID;
    private String typ;
    private int ålder;

    public Användare (String namn, String personNr, String adress, String email, String telefonNr, String användarID, String typ, int ålder) {
        super(namn, personNr, adress, email, telefonNr);
        this.användarID = användarID;
        this.ålder = ålder;
        this.typ = typ;
    }

    public void setAnvändarID(String användarID) {
        this.användarID = användarID;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public void setÅlder(int ålder) {
        this.ålder = ålder;
    }

    public String getAnvändarID() {
        return användarID;
    }

    public String getTyp() {
        return typ;
    }

    public int getÅlder() {
        return ålder;
    }
}
