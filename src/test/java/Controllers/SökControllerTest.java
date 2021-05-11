package Controllers;

import Objekt.Bok;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SökControllerTest {

    @Test
    void sök() {
        String input = "ISBN: 789456, Titel: titelResultat Författare: författareResultat Ämne: ämnesordResultat";
        int förstaIndex = input.indexOf(" ");
        System.out.println(input.indexOf(" "));
        System.out.println(input.indexOf(","));
        int sistaIndex = input.indexOf(",");
        ArrayList hittaISBNarray = new ArrayList();
        for (int i = (förstaIndex + 1); i < sistaIndex; i++){
            //ArrayList<> ISBNarray = new ArrayList();
            char ISBNchar = input.charAt(i);
            hittaISBNarray.add(ISBNchar);
        }
        System.out.println(hittaISBNarray);
        String ISBNoutput = "0";
        for (int i = 0; i < hittaISBNarray.toArray().length; i++){
            ISBNoutput += hittaISBNarray.get(i);
        }
        System.out.println(ISBNoutput);
        StringBuilder sistaISBN = new StringBuilder(ISBNoutput);
        sistaISBN.deleteCharAt(0);
        System.out.println(sistaISBN);
        Bok.setISBN(sistaISBN.toString());
        System.out.println(Bok.getISBN());
    }
}