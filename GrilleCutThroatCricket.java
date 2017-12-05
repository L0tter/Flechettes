/**
 * @author Flamant Antonin - Daspremont Elodie | Serie 4
 */
package flechette;

public class GrilleCutThroatCricket extends Grille {

	public GrilleCutThroatCricket(int nombreJoueurs) {
		super(nombreJoueurs);
	}
	@Override
	public JoueurCutThroatCricket donnerJoueur(int numero){
		return (JoueurCutThroatCricket)super.donnerJoueur(numero);
	}
	public boolean finJeu(){
		//TODO
		return false;
	}

}
