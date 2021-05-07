package Session;

public class SessionsAnvändare {
    //Klass som definierar ifall användaren som kör programmet är inloggad eller ej.
    private static boolean inloggad = false;
    private static String inloggadEmail;

    public static String getInloggadEmail() {
        return inloggadEmail;
    }

    public void setInloggadEmail(String inloggadEmail) {
        this.inloggadEmail = inloggadEmail;
    }

    public static void setInloggad() {
        inloggad = true;
    }

    public static boolean isInloggad() {
        return inloggad;
    }
}


