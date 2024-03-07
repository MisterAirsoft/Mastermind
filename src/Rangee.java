import java.awt.Color;

public class Rangee {
    Color[] jetons;
    Resultat resultat;

    public Rangee() {
        jetons = new Color[4];
        resultat = new Resultat(0, 0);
    }
    public Color getColor(int x) {
    	return jetons[x];
    	
    }
    public String toString() {
    	String a_envoyer="";
    	for (Color g : jetons) {
    		if (g!=null) {
    			a_envoyer+=g.toString()+" ";
    		}
    		else {
    			a_envoyer+="null ";
    		}
    	}
    	return a_envoyer;
    	
    }
}
