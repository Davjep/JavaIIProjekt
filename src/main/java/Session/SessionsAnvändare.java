package Session;

public class SessionsAnvändare {
    //Klass som definierar ifall användaren som kör programmet är inloggad eller ej.
    private static boolean inloggad = false;

    public static void setInloggad() {
        inloggad = true;
    }

    public static boolean isInloggad() {
        return inloggad;
    }
}
