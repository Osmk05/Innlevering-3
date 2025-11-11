package no.hvl.dat100.oppgave3;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;

public class Blogg {

    private Innlegg[] innleggtabell;
    private int nesteledig;

    public Blogg() {
        nesteledig = 0;
        innleggtabell = new Innlegg[20];
    }

    public Blogg(int lengde) {
        nesteledig = 0;
        innleggtabell = new Innlegg[lengde];
    }

    public int getAntall() {
        return nesteledig;
    }

    public Innlegg[] getSamling() {
        return innleggtabell;
    }

    public int finnInnlegg(Innlegg innlegg) {

        int index = -1;
        int i = 0;
        while (i < nesteledig && index < 0) {
            if (innleggtabell[i].erLik(innlegg)) {
                index = i;
            } else {
                i++;
            }
        }

        return index;
    }

    public boolean finnes(Innlegg innlegg) {
        return (finnInnlegg(innlegg) >= 0);
    }

    public boolean ledigPlass() {
        return (nesteledig < innleggtabell.length);
    }

    public boolean leggTil(Innlegg innlegg) {
        boolean lagttil = false;
        if (!finnes(innlegg) && ledigPlass()){
            innleggtabell[nesteledig] = innlegg;
            nesteledig++;
            lagttil = true;
        }
        return lagttil;
    }

    public String toString() {
        String s = "";
        for (int i = 0;  i < nesteledig; i++){
            s += innleggtabell[i].toString();
        }
        return nesteledig + "\n" + s;
    }

    // valgfrie oppgaver nedenfor

    public void utvid() {
        throw new UnsupportedOperationException(TODO.method());
    }

    public boolean leggTilUtvid(Innlegg innlegg) {

        throw new UnsupportedOperationException(TODO.method());

    }

    public boolean slett(Innlegg innlegg) {

        throw new UnsupportedOperationException(TODO.method());
    }

    public int[] search(String keyword) {

        throw new UnsupportedOperationException(TODO.method());

    }
}