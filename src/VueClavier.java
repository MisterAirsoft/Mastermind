import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VueClavier extends JPanel {
    Modele modele;
    JButton[] boutons;

    public VueClavier(Modele modele) {
        this.modele = modele;
        boutons = new JButton[Modele.COULEURS.length];
        setLayout(new FlowLayout());
        
        for (int i = 0; i < Modele.COULEURS.length; i++) {
            JButton bouton = new JButton();
            bouton.setBackground(Modele.COULEURS[i]);
            bouton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton source = (JButton) e.getSource();
                    Color couleurSelectionnee = source.getBackground();
                    modele.completerProposition(couleurSelectionnee);
                    // Mettre à jour uniquement la couleur du bouton cliqué
                    source.setBackground(couleurSelectionnee);
                }
            });
            boutons[i] = bouton;
            add(bouton);
        }
    }

    public JButton[] getBoutons() {
        return boutons;
    }
}

