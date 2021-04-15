package Objekt;

public class Film extends Objekt {
    private String regissör;
    private int åldersBegränsning;
    private String produktionsLand;
    private String skådespelare;
    private String produktionsBolag;

    public Film(String ISBN, String titel, String genre, String plats, String utgivningsÅr, String lånedatum, String slutDatum, boolean tillgänglig, int lånePeriod, String regissör, int åldersBegränsning, String produktionsLand, String skådespelare, String produktionsBolag) {
        super(ISBN, titel, genre, plats, utgivningsÅr, lånedatum, slutDatum, tillgänglig, lånePeriod);
        this.regissör = regissör;
        this.åldersBegränsning = åldersBegränsning;
        this.produktionsLand = produktionsLand;
        this.skådespelare = skådespelare;
        this.produktionsBolag = produktionsBolag;
    }

    public String getRegissör() {
        return regissör;
    }

    public void setRegissör(String regissör) {
        this.regissör = regissör;
    }

    public int getÅldersBegränsning() {
        return åldersBegränsning;
    }

    public void setÅldersBegränsning(int åldersBegränsning) {
        this.åldersBegränsning = åldersBegränsning;
    }

    public String getProduktionsLand() {
        return produktionsLand;
    }

    public void setProduktionsLand(String produktionsLand) {
        this.produktionsLand = produktionsLand;
    }

    public String getSkådespelare() {
        return skådespelare;
    }

    public void setSkådespelare(String skådespelare) {
        this.skådespelare = skådespelare;
    }

    public String getProduktionsBolag() {
        return produktionsBolag;
    }

    public void setProduktionsBolag(String produktionsBolag) {
        this.produktionsBolag = produktionsBolag;
    }
}
