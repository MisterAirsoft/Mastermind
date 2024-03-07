import javax.swing.*;
import java.awt.*;
 
public class VuePropositions extends JPanel {
    Modele modele;
    Color[][] couleur_jouer;
     
     
    public void paint(Graphics g){
         
         
        int size= 100/modele.DIFFICULTE;
        g.drawRect(0, 0, 200, 500);
        
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, 200, 500);
        for (int y = 0; y < 10; y++) {
        	System.out.println(modele.propositions[y]);
        	if ((modele.propositions[y] != null)) {
      
        		for (int x=0; x < modele.DIFFICULTE; x++) {
        			if (modele.propositions[y].getColor(x)!=null) {
        				g.setColor(modele.propositions[y].getColor(x));
                        g.fillOval(10+x*size*2, 10+y*size*2, size, size);
        			}
        		}
        	}
        	
        
        }
        System.out.println("--------------------------------------------------------------");
        
      }
     
    public VuePropositions(Modele modele) {
         
        this.modele = modele;
         
       
 
         
    }
    public void  mettreAJour() {
    	repaint();
    }
 
} 
