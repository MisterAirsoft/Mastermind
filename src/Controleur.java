import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class Controleur {
    Modele modele;
    Vue vue;

    public Controleur(Modele modele, Vue vue) {
        this.modele = modele;
        this.vue = vue;

        for (JButton bouton : vue.vueClavier.getBoutons()) {
            bouton.addActionListener(e -> {
                vue.mettreAJourAffichage();
            });
        }

        vue.vuePropositions.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    modele.annulerDernierJeton();
                    vue.mettreAJourAffichage();
                }
            }
        });
    }

    public void gererChoixUtilisateur() {
        if (modele.partieTerminee) {
            vue.afficherMessage("La partie est déjà terminée. Pour commencer une nouvelle partie, veuillez redémarrer l'application.");
            return;
        }

        if (modele.tentative < Modele.DIFFICULTE) {
            vue.afficherMessage("cliquez sur OK pour commencer ");
            return;
        }

        modele.evaluerProposition();
        vue.mettreAJourAffichage();

        if (modele.partieTerminee && modele.tentative < 10) {
            vue.afficherMessage("Félicitations ! Vous avez trouvé la combinaison secrète.");
        }

        if (modele.partieTerminee && modele.tentative == 10) {
            vue.afficherMessage("Désolé, vous n'avez pas réussi à trouver la combinaison secrète. La partie est terminée.");
        }
    }
}
