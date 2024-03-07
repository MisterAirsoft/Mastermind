import javax.swing.*;
import java.awt.*;
 
public class VuePropositions extends JPanel {
    Modele modele;
    Color[][] couleur_jouer;
     
     
    public void paint(Graphics g){
         
         
        int size= 100/modele.DIFFICULTE;
        g.setColor(new Color(80,80,100));
        g.fillRect(0, 0, 200, 500);
        
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
        			
        			if ((modele.propositions[y].getColor(x)!=null) && (x==3)) {
        				for (int p=0; p < modele.DIFFICULTE; p++) {
        					g.setColor(Color.BLACK);
                            g.fillOval(220+p%2*size/2, 10+y*size*2+(p/2)*size/2, size/2, size/2);
        				}
        				
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
