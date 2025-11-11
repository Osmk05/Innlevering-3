package no.hvl.dat100.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {

        boolean skrevet = false;
        
        try {
            PrintWriter skriver = new PrintWriter(mappe + filnavn);

            skriver.print(samling.toString());

            skrevet = true;

            skriver.close();

        }
        catch (FileNotFoundException e){
            System.out.println("kunne ikke lokalisere fil" + mappe + filnavn + e.getMessage());

            skrevet = false;
        }

        return skrevet;
	}
}
