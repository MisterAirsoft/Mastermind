
import javax.swing.*;
import java.awt.*;

public class VuePropositions extends JPanel {
    Modele modele;
    JButton[][] boutons;

    public VuePropositions(Modele modele) {
        this.modele = modele;
        boutons = new JButton[10][Modele.DIFFICULTE];
        setLayout(new GridLayout(10, Modele.DIFFICULTE));

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < Modele.DIFFICULTE; j++) {
                boutons[i][j] = new JButton();
                boutons[i][j].setPreferredSize(new Dimension(40, 40));
                add(boutons[i][j]);
            }
        }
    }

    public void mettreAJour() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < Modele.DIFFICULTE; j++) {
                if (modele.propositions[i] != null && modele.propositions[i].jetons[j] != null) {
                	  boutons[i][j].setBackground(modele.propositions[i].jetons[j]);
                }
            }
        }
    }
}
