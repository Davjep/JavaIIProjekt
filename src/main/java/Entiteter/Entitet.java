package Entiteter;

public abstract class Entitet {

    protected String namn;
    protected String personNr;
    protected String gatuAdress;
    protected String postNr;
    protected String email;
    protected String telefonNr;
    protected void loggaIn(){

    }

    public String getPostNr() {
        return postNr;
    }

    public void setPostNr(String postNr) {
        this.postNr = postNr;
    }

    public void setGatuAdress(String adress) {
        this.gatuAdress = gatuAdress;
    }

    public String getGatuAdress() {
        return gatuAdress;
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


