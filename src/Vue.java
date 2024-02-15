
import javax.swing.*;
import java.awt.*;

public class Vue extends JFrame {
    Modele modele;
    VueClavier vueClavier;
    VuePropositions vuePropositions;

    public Vue(Modele modele) {
        this.modele = modele;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Mastermind Game");

        vueClavier = new VueClavier(modele);
        vuePropositions = new VuePropositions(modele);

        setLayout(new BorderLayout());
        add(vueClavier, BorderLayout.NORTH);
        add(vuePropositions, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void mettreAJourAffichage() {
        vuePropositions.mettreAJour();
    }

    public void afficherMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Message", JOptionPane.INFORMATION_MESSAGE);
    }
}

