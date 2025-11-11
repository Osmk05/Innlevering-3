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

        for (int i = 0; i < nesteledig; i++) {
            if (innleggtabell[i].erLik(innlegg)) {
                return i;
            }
        }
        return -1;
    }

    public boolean finnes(Innlegg innlegg) {
        return finnInnlegg(innlegg) >= 0;
    }

    public boolean ledigPlass() {
        return nesteledig < innleggtabell.length;
    }

    public boolean leggTil(Innlegg innlegg) {

        if (!finnes(innlegg) && ledigPlass()) {
            innleggtabell[nesteledig] = innlegg;
            nesteledig++;
            return true;
        }
        return false;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < nesteledig; i++) {
            s += innleggtabell[i].toString();
        }
        return nesteledig + "\n" + s;
    }

    // valgfrie oppgaver nedenfor

    public void utvid() {
        Innlegg[] nyTabell = new Innlegg[innleggtabell.length * 2];
        for (int i = 0; i < nesteledig; i++) {
            nyTabell[i] = innleggtabell[i];
        }
        innleggtabell = nyTabell;
    }

    public boolean leggTilUtvid(Innlegg innlegg) {
        if (finnes(innlegg)) {
            return false;
        }
        if (!ledigPlass()) {
            utvid();
        }
        innleggtabell[nesteledig] = innlegg;
        nesteledig++;
        return true;
    }

    public boolean slett(Innlegg innlegg) {
        int pos = finnInnlegg(innlegg);
        if (pos >= 0) {
            nesteledig--;
            innleggtabell[pos] = innleggtabell[nesteledig];
            innleggtabell[nesteledig] = null;
            return true;
        } else {
            return false;
        }
    }

    public int[] search(String keyword) {

        throw new UnsupportedOperationException(TODO.method());

    }
}