package Objekt;

public class Tidskrift extends Objekt {
    private String skribent;
    private String utgivare;

    public Tidskrift(String ISBN, String titel, String[] genre, String plats, String utgivningsÅr, String lånedatum, String slutDatum, boolean tillgänglig, int lånePeriod, String skribent, String utgivare) {
        super(ISBN, titel, genre, plats, utgivningsÅr, lånedatum, slutDatum, tillgänglig, lånePeriod);
        this.skribent = skribent;
        this.utgivare = utgivare;
    }
}
