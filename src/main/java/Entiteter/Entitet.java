package Entiteter;

public abstract class Entitet {

    protected String namn;
    protected String personNr;
    protected String adress;
    protected String email;
    protected String telefonNr;

    public Entitet(String namn, String personNr, String adress, String email, String telefonNr) {
        this.namn = namn;
        this.personNr = personNr;
        this.adress = adress;
        this.email = email;
        this.telefonNr = telefonNr;
    }
    protected void loggaIn(){

    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getAdress() {
        return adress;
    }

    public String getNamn() {
        return namn;
    }

    public String getPersonNr() {
        return personNr;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefonNr() {
        return telefonNr;
    }

    public void setNamn(String namn) {
        this.namn = namn;
    }

    public void setPersonNr(String personNr) {
        this.personNr = personNr;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefonNr(String telefonNr) {
        this.telefonNr = telefonNr;
    }
}
