package Objekt;

public abstract class Objekt {
    protected String titel;
    protected String plats;
    protected String utgivningsÅr;
    protected boolean tillgänglig;
    protected static String ID;

   public Objekt() {

    }

    public Objekt(String titel, String plats, String utgivningsÅr, boolean tillgänglig) {
        this.titel = titel;
        this.plats = plats;
        this.utgivningsÅr = utgivningsÅr;
        this.tillgänglig = tillgänglig;
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

    public void setPlats(String plats) {
        this.plats = plats;
    }

    public void setUtgivningsÅr(String utgivningsÅr) {
        this.utgivningsÅr = utgivningsÅr;
    }

    public void setTillgänglig(boolean tillgänglig) {
        this.tillgänglig = tillgänglig;
    }

    public String getTitel() {
        return titel;
    }

    public String getPlats() {
        return plats;
    }

    public String getUtgivningsÅr() {
        return utgivningsÅr;
    }

    public boolean isTillgänglig() {
        return tillgänglig;
    }
}
