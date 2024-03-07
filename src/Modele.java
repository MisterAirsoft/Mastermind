
import java.awt.Color;
import java.util.Random;

public class Modele {
    public static final Color[] COULEURS = {Color.YELLOW, Color.GREEN, Color.BLUE, Color.MAGENTA,
            Color.RED, Color.ORANGE, Color.WHITE, Color.BLACK};
    public static final int DIFFICULTE = 4;

    Rangee combinaison;
    Rangee[] propositions;
    int tentative;
    boolean partieTerminee;

    public Modele() {
        combinaison = tirerCombinaison();
        propositions = new Rangee[10];
        tentative = 0;
        partieTerminee = false;
    }

    private Rangee tirerCombinaison() {
        Random random = new Random();
        Rangee combinaison = new Rangee();

        for (int i = 0; i < DIFFICULTE; i++) {
            combinaison.jetons[i] = COULEURS[random.nextInt(COULEURS.length)];
        }

        return combinaison;
    }

    public void nouvelleProposition() {
        propositions[tentative] = new Rangee();
    }

    public void completerProposition(Color couleur) {
        if (tentative < 10 && !partieTerminee) {
            if (propositions[tentative] == null) {
                nouvelleProposition();
            }
            int indexJeton = 0;
            // Trouver le premier jeton vide dans la proposition actuelle
            while (indexJeton < DIFFICULTE && propositions[tentative].jetons[indexJeton] != null) {
                indexJeton++;
            }
            // Vérifier si la proposition actuelle n'est pas encore pleine
            if (indexJeton < DIFFICULTE) {
                propositions[tentative].jetons[indexJeton] = couleur;
            }
            // Si la proposition actuelle est pleine, passer à la prochaine proposition
            if (indexJeton == DIFFICULTE - 1) {
                tentative++;
            }
        }
    }

    public void evaluerProposition() {
        int noirs = 0;
        int blancs = 0;
        boolean[] correctementPlace = new boolean[DIFFICULTE];
        boolean[] dejaCompte = new boolean[DIFFICULTE];

        for (int i = 0; i < DIFFICULTE; i++) {
            if (propositions[tentative].jetons[i].equals(combinaison.jetons[i])) {
                noirs++;
                correctementPlace[i] = true;
                dejaCompte[i] = true;
            }
        }

        for (int i = 0; i < DIFFICULTE; i++) {
            if (!correctementPlace[i]) {
                for (int j = 0; j < DIFFICULTE; j++) {
                    if (!dejaCompte[j] && propositions[tentative].jetons[i].equals(combinaison.jetons[j])) {
                        blancs++;
                        dejaCompte[j] = true;
                        break;
                    }
                }
            }
        }

        propositions[tentative].resultat = new Resultat(noirs, blancs);

        if (noirs == DIFFICULTE) {
            partieTerminee = true;
        } else if (tentative == 9) {
            partieTerminee = true;
        } else {
            tentative++;
        }
    }

    public void annulerDernierJeton() {
        if (tentative > 0 && !partieTerminee) {
            propositions[tentative - 1].jetons[tentative - 1] = null;
        }
    }

    public void demarrerNouvelleProposition() {
        if (tentative < 10 && !partieTerminee) {
            nouvelleProposition();
        }
    }
}
