package Objekt;

public class Film extends Objekt {
    private String regissör;
    private int åldersBegränsning;
    private String produktionsLand;
    private String skådespelare;
    private String produktionsBolag;

    public Film(String ISBN, String titel, String[] genre, String plats, String utgivningsÅr, String lånedatum, String slutDatum, boolean tillgänglig, int lånePeriod, String regissör, int åldersBegränsning, String produktionsLand, String skådespelare, String produktionsBolag) {
        super(ISBN, titel, genre, plats, utgivningsÅr, lånedatum, slutDatum, tillgänglig, lånePeriod);
        this.regissör = regissör;
        this.åldersBegränsning = åldersBegränsning;
        this.produktionsLand = produktionsLand;
        this.skådespelare = skådespelare;
        this.produktionsBolag = produktionsBolag;
    }
}
