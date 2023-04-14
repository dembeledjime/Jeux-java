package fr.harouna.jeu.beans;

public class Gobelet {

    De de1;
    De de2;

    public Gobelet() {
        de1 = new De();
        de2 = new De();
    }

    public void lancer() {
        de1.lancer();
        de2.lancer();
    }

    public int getScoreDe1() {
        return de1.getValeur();
    }

    public int getScoreDe2() {
        return de2.getValeur();
    }

    public int getScoreDes(){
        return getScoreDe1() + getScoreDe2();
    }
}
