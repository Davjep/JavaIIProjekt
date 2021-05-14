package Objekt;

public abstract class Objekt {
    protected String titel;
    protected String genre;
    protected String plats;
    protected String utgivningsÅr;
    protected String lånedatum;
    protected String slutDatum;
    protected boolean tillgänglig;
    protected int lånePeriod;
    protected static String ID;

    public Objekt() {

    }

    public Objekt(String titel, String genre, String plats, String utgivningsÅr, String lånedatum, String slutDatum, boolean tillgänglig, int lånePeriod) {
        this.titel = titel;
        this.genre = genre;
        this.plats = plats;
        this.utgivningsÅr = utgivningsÅr;
        this.lånedatum = lånedatum;
        this.slutDatum = slutDatum;
        this.tillgänglig = tillgänglig;
        this.lånePeriod = lånePeriod;
    }

    public static String getID() {
        return ID;
    }

    public static void setID(String ID) {
        Objekt.ID = ID;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPlats(String plats) {
        this.plats = plats;
    }

    public void setUtgivningsÅr(String utgivningsÅr) {
        this.utgivningsÅr = utgivningsÅr;
    }

    public void setLånedatum(String lånedatum) {
        this.lånedatum = lånedatum;
    }

    public void setSlutDatum(String slutDatum) {
        this.slutDatum = slutDatum;
    }

    public void setTillgänglig(boolean tillgänglig) {
        this.tillgänglig = tillgänglig;
    }

    public void setLånePeriod(int lånePeriod) {
        this.lånePeriod = lånePeriod;
    }

    public String getTitel() {
        return titel;
    }

    public String getGenre() {
        return genre;
    }

    public String getPlats() {
        return plats;
    }

    public String getUtgivningsÅr() {
        return utgivningsÅr;
    }

    public String getLånedatum() {
        return lånedatum;
    }

    public String getSlutDatum() {
        return slutDatum;
    }

    public boolean isTillgänglig() {
        return tillgänglig;
    }

    public int getLånePeriod() {
        return lånePeriod;
    }
}
