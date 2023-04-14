package fr.harouna.jeu.beans;

public class Partie {

    private static final int VALEUR_A_ATTEINDRE = 7;
    private static final int NB_TOUR_MAX = 10;
    private Joueur joueur1, joueur2;
    private int num_tour;
    private Joueur prochainJoueur;

    public Partie(String nomJ1, String nomJ2) {
        joueur1 = new Joueur(nomJ1);
        joueur2 = new Joueur(nomJ2);
        num_tour = 1;
        prochainJoueur = joueur1;
    }

    public void changerJoueur() {
        if (prochainJoueur == joueur1)
            prochainJoueur = joueur2;
        else
            prochainJoueur = joueur1;
    }

    public Joueur gagnant() {
        //  Log.w("msg", "j1: " + joueur1.getScore() + " - j2: " + joueur2.getScore());
        if (joueur1.getScore() > joueur2.getScore())
            return joueur1;
        else if (joueur2.getScore() > joueur1.getScore())
            return joueur2;
        return null;
    }

    /**
     * GETTERS ET SETTERs
     **/

    public static int getValeurAAtteindre() {
        return VALEUR_A_ATTEINDRE;
    }

    public static int getNbTourMax() {
        return NB_TOUR_MAX;
    }

    public Joueur getJoueur1() {
        return joueur1;
    }

    public void setJoueur1(Joueur joueur1) {
        this.joueur1 = joueur1;
    }

    public Joueur getJoueur2() {
        return joueur2;
    }

    public void setJoueur2(Joueur joueur2) {
        this.joueur2 = joueur2;
    }

    public int getNum_tour() {
        return num_tour;
    }

    public void setNum_tour(int num_tour) {
        this.num_tour = num_tour;
    }

    public Joueur getProchainJoueur() {
        return prochainJoueur;
    }

    public void setProchainJoueur(Joueur prochainJoueur) {
        this.prochainJoueur = prochainJoueur;
    }
}
