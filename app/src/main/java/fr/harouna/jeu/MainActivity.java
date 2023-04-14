package fr.harouna.jeu;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import fr.harouna.jeu.beans.Partie;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TV_MSG = "vous avez gagné la parie. BRAVO !!";

    private ImageView iv_j1;
    private ImageView iv_j2;

    private TextView tv_tour;
    private TextView tv_scorej1;
    private TextView tv_scorej2;
    private TextView tv_de1;
    private TextView tv_de2, tv_resultat;

    private Button bt_lancer, bt_relancer;

    private LinearLayout liner_bloc_de, liner_resultat;

    private Partie partie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
    }

    @Override
    public void onClick(View v) {
        if (v == bt_lancer) {
            //lancer joueur courant
            partie.getProchainJoueur().lancer();

            //calcul du score
            if (partie.getProchainJoueur().getScoreDes() >= Partie.getValeurAAtteindre())
                partie.getProchainJoueur().setScore(partie.getProchainJoueur().getScore() + 1);

            //changement de joueur
            partie.changerJoueur();

            //incrémentation de tour
            if (partie.getProchainJoueur() == partie.getJoueur1())
                partie.setNum_tour(partie.getNum_tour() + 1);

            rafraichirIHM();

        } else if (v == bt_relancer) {
            relancer();
        }
    }

    private void relancer() {
        partie = new Partie("Toto", "Tata");

        liner_bloc_de.setVisibility(View.VISIBLE);
        bt_lancer.setVisibility(View.VISIBLE);

        liner_resultat.setVisibility(View.GONE);
        bt_relancer.setVisibility(View.GONE);

        tv_resultat.setText("");

        rafraichirIHM();
    }

    private void rafraichirIHM() {
        tv_scorej1.setText("" + partie.getJoueur1().getScore());
        tv_scorej2.setText("" + partie.getJoueur2().getScore());

        if (partie.getNum_tour() >= Partie.getNbTourMax() + 1) {
            Toast.makeText(this, "GAME OVER", Toast.LENGTH_SHORT).show();
            liner_bloc_de.setVisibility(View.GONE);
            bt_lancer.setVisibility(View.GONE);

            liner_resultat.setVisibility(View.VISIBLE);
            bt_relancer.setVisibility(View.VISIBLE);

            if (partie.gagnant() == partie.getJoueur1()) {
                tv_resultat.setText(partie.getJoueur1().getNom() + ", " + TV_MSG);
            } else if (partie.gagnant() == partie.getJoueur2()) {
                tv_resultat.setText(partie.getJoueur2().getNom() + ", " + TV_MSG);
            } else {
                TextView tv_msg = findViewById(R.id.tv_msg);
                tv_resultat.setText("Egalité");
            }
            return;
        }

        tv_tour.setText("" + partie.getNum_tour());


        if (partie.getProchainJoueur() == partie.getJoueur1()) {
            iv_j1.setVisibility(View.VISIBLE);
            iv_j2.setVisibility(View.INVISIBLE);

            tv_de1.setText(partie.getJoueur2().getScoreDe1() + "");
            tv_de2.setText(partie.getJoueur2().getScoreDe2() + "");
        } else {
            iv_j1.setVisibility(View.INVISIBLE);
            iv_j2.setVisibility(View.VISIBLE);

            tv_de1.setText(partie.getJoueur1().getScoreDe1() + "");
            tv_de2.setText(partie.getJoueur1().getScoreDe2() + "");
        }


    }

    private void findViews() {
        tv_tour = (TextView) findViewById(R.id.tv_tour);
        tv_scorej1 = (TextView) findViewById(R.id.tv_scorej1);
        tv_de1 = (TextView) findViewById(R.id.tv_de1);
        tv_de2 = (TextView) findViewById(R.id.tv_de2);
        tv_scorej2 = (TextView) findViewById(R.id.tv_scorej2);
        tv_resultat = (TextView) findViewById(R.id.tv_resultat);

        iv_j1 = (ImageView) findViewById(R.id.iv_j1);
        iv_j2 = (ImageView) findViewById(R.id.iv_j2);

        bt_lancer = (Button) findViewById(R.id.bt_lancer);
        bt_relancer = (Button) findViewById(R.id.bt_relancer);

        liner_bloc_de = findViewById(R.id.liner_bloc_des);
        liner_resultat = findViewById(R.id.liner_resultat);

        bt_lancer.setOnClickListener(this);
        bt_relancer.setOnClickListener(this);

        partie = new Partie("Toto", "Tata");

        tv_tour.setText("" + partie.getNum_tour());
    }


}