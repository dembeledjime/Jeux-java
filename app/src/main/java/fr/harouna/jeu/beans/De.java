package fr.harouna.jeu.beans;

import java.util.Random;

public class De {

    private static final int NB_FACE = 6;
    private Random random = new Random();
    private int valeur;


    public void lancer() {
        this.valeur = random.nextInt(NB_FACE) + 1;
    }

    public int getValeur() {
        return valeur;
    }


}
