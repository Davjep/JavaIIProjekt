package Objekt;

public class Bok extends Objekt {
    private String författare;
    private String utgivare;
    private String kategori; //TODO Måste lägga kategorityper

    public Bok(String ISBN, String titel, String[] genre, String plats, String utgivningsÅr, String lånedatum, String slutDatum, boolean tillgänglig, int lånePeriod, String författare, String utgivare, String kategori) {
        super(ISBN, titel, genre, plats, utgivningsÅr, lånedatum, slutDatum, tillgänglig, lånePeriod);
        this.författare = författare;
        this.utgivare = utgivare;
        this.kategori = kategori;
    }
}
