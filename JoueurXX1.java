/**
 * @author Flamant Antonin - Daspremont Elodie | Serie 4
 */
package flechette;

public class JoueurXX1 extends Joueur {
	
	public JoueurXX1(String nomJoueur, int capital) {
		super(nomJoueur,capital);
	}
	public void retirerPoints(int points) {
		int totPoints=this.getPoints()-points;
		this.setPoints(totPoints);
	}
	public Flechette flechetteRecommandee(int pointToMark) {
		// Si points à marquer <=50  et nombre pair : il existe une fléchette recommandée
		if(pointToMark<=50 && pointToMark%2==0) {
			return new Flechette(pointToMark/2, 2);
		}
		return null;
	}
	
	@Override
	public boolean estMieuxClasse(Joueur autreJoueur) {
		if (this.getPoints() < autreJoueur.getPoints()) return true;
		return false;
	}

}
