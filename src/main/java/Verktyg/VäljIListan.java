package Verktyg;

import java.util.ArrayList;

public class VäljIListan {

    public String väljValdRad(String val) {

        //Variabler för att identifiera ISBN i resultatlista Stringen
        int förstaIndex = val.indexOf(" ");
        int sistaIndex = val.indexOf(",");

        ArrayList IDarray = new ArrayList();

        for (int i = (förstaIndex + 1); i < sistaIndex; i++){
            char ISBNchar = val.charAt(i);
            IDarray.add(ISBNchar);
        }

        String ISBNoutput = "0";
        for (int i = 0; i < IDarray.toArray().length; i++){
            ISBNoutput += IDarray.get(i);
        }

        StringBuilder fullID = new StringBuilder(ISBNoutput).deleteCharAt(0);
        return fullID.toString();
    }
}
