package Objekt;

public class Bok extends Objekt {
    private String författare;
    private String utgivare;
    private String kategori;

    public Bok(String ISBN, String titel, String genre, String plats, String utgivningsÅr, String lånedatum, String slutDatum, boolean tillgänglig, int lånePeriod, String författare, String utgivare, String kategori) {
        super(ISBN, titel, genre, plats, utgivningsÅr, lånedatum, slutDatum, tillgänglig, lånePeriod);
        this.författare = författare;
        this.utgivare = utgivare;
        this.kategori = kategori;
    }

    public String getFörfattare() {
        return författare;
    }

    public String getUtgivare() {
        return utgivare;
    }

    public String getKategori() {
        return kategori;
    }

    public void setFörfattare(String författare) {
        this.författare = författare;
    }

    public void setUtgivare(String utgivare) {
        this.utgivare = utgivare;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
}
