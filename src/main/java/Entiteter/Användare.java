package Entiteter;

public class Användare extends Entitet {
    private String användarID;
    private String typ;
    private int ålder;
    String lösenord;

    public Användare (String namn, String personNr, String adress, String email, String telefonNr, String användarID, String typ, int ålder, String lösenord) {
        super(namn, personNr, adress, email, telefonNr);
        this.användarID = användarID;
        this.ålder = ålder;
        this.typ = typ;
        this.lösenord = lösenord;
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

    public String getLösenord() {
        return lösenord;
    }

    public void setLösenord(String lösenord) {
        this.lösenord = lösenord;
    }
}
