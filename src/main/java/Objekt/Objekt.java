package Objekt;

public abstract class Objekt {
    protected String ISBN;
    protected String titel;
    protected String[] genre;
    protected String plats;
    protected String utgivningsÅr;
    protected String lånedatum;
    protected String slutDatum;
    protected boolean tillgänglig;
    protected int lånePeriod;

    public Objekt(String ISBN, String titel, String[] genre, String plats, String utgivningsÅr, String lånedatum, String slutDatum, boolean tillgänglig, int lånePeriod) {
        this.ISBN = ISBN;
        this.titel = titel;
        this.genre = genre;
        this.plats = plats;
        this.utgivningsÅr = utgivningsÅr;
        this.lånedatum = lånedatum;
        this.slutDatum = slutDatum;
        this.tillgänglig = tillgänglig;
        this.lånePeriod = lånePeriod;
    }
}
