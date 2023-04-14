package fr.harouna.jeu.beans;

public class Joueur {

    private String nom;
    private int score;
    private Gobelet gobelet;

    public Joueur(String nom) {
        this.nom = nom;
        gobelet = new Gobelet();
        score = 0;
    }

    public void lancer() {
        gobelet.lancer();
    }

    public int getScoreDe1() {
        return gobelet.getScoreDe1();
    }

    public int getScoreDe2() {
        return gobelet.getScoreDe2();
    }

    public int getScoreDes() {
        return gobelet.getScoreDe1() + gobelet.getScoreDe2();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Gobelet getGobelet() {
        return gobelet;
    }

    public void setGobelet(Gobelet gobelet) {
        this.gobelet = gobelet;
    }
}
