package Entiteter;

public class Användare extends Entitet {
    private String användarID;
    private String typ;
    private int ålder;
    //private enum typ1 {Student, Forskare, ÖvrigaLåntagare, ÖvrigaUniversitetsAnställda;}

    public Användare (String namn, String personNr, String adress, String email, String telefonNr, String användarID, String typ, int ålder) {
        super(namn, personNr, adress, email, telefonNr);
        this.användarID = användarID;
        this.ålder = ålder;
       // this.typ[0] = "David";
        if (typ.equalsIgnoreCase("Student") ||
                typ.equalsIgnoreCase("Forskare") ||
                typ.equalsIgnoreCase("Övriga Låntagare")||
                typ.equalsIgnoreCase("Övriga Universitetsanställda")) {
            this.typ = typ;
        } else while(){

        }
    }
}
