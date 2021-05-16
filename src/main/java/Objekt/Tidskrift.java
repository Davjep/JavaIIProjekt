package Objekt;

public class Tidskrift extends Objekt {
    private String skribent;
    private String utgivare;

    public Tidskrift(String titel, String genre, String plats, String utgivningsÅr, String lånedatum, String slutDatum, boolean tillgänglig, int lånePeriod, String skribent, String utgivare) {
        super(titel, genre, plats, utgivningsÅr, lånedatum, slutDatum, tillgänglig, lånePeriod);
        this.skribent = skribent;
        this.utgivare = utgivare;
    }

    public String getSkribent() {
        return skribent;
    }

    public void setSkribent(String skribent) {
        this.skribent = skribent;
    }

    public String getUtgivare() {
        return utgivare;
    }

    public void setUtgivare(String utgivare) {
        this.utgivare = utgivare;
    }
}
