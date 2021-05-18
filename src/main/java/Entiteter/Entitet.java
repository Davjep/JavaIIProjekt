package Entiteter;

public abstract class Entitet {

    protected String förNamn;
    protected String efterNamn;
    protected String telefonNr;
    protected String gatuAdress;
    protected String postNr;
    protected String email;
    protected String personNr;
    protected String lösenord;


    private static boolean inloggad = false;
    private static String inloggadEmail;
    private static String setID;

    public Entitet() {
    }

    public Entitet(String förNamn, String efterNamn, String gatuAdress, String postNr, String email, String personNr, String telefonNr, String lösenord) {
        this.förNamn = förNamn;
        this.efterNamn = efterNamn;
        this.personNr = personNr;
        this.gatuAdress = gatuAdress;
        this.postNr = postNr;
        this.email = email;
        this.telefonNr = telefonNr;
        this.lösenord = lösenord;
    }

    public static String getInloggadEmail() {
        return inloggadEmail;
    }

    public static void setInloggadEmail(String inloggadEmail) {
        Entitet.inloggadEmail = inloggadEmail;
    }

    public static void setInloggad() {
        inloggad = true;
    }

    public static boolean getInloggad() {
        return inloggad;
    }

    public static void loggaUt() {
        inloggad = false;
        Entitet.setInloggadEmail(null);
        Anställd.setAnställd(false);
    }

    public String getFörNamn() {
        return förNamn;
    }

    public void setFörNamn(String förNamn) {
        this.förNamn = förNamn;
    }

    public String getEfterNamn() {
        return efterNamn;
    }

    public void setEfterNamn(String efterNamn) {
        this.efterNamn = efterNamn;
    }

    public String getLösenord() {
        return lösenord;
    }

    public void setLösenord(String lösenord) {
        this.lösenord = lösenord;
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

    public String getPersonNr() {
        return personNr;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefonNr() {
        return telefonNr;
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


