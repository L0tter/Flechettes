/**
 * @author Flamant Antonin - Daspremont Elodie | Serie 4
 */
package flechette;

public class JoueurCountUp extends Joueur{
	
	public JoueurCountUp(String nom) {
		super(nom);
	}
	
	/**
	 * ajoute des points aux points du joueur
	 * @param points les points a ajouter
	 */
	public void ajouterPoints(int points){ // Les points sont récupérés d'un objet flechette précédemment instancié
		int totPoints=this.getPoints()+points;
		this.setPoints(totPoints);
	}

	@Override
	public boolean estMieuxClasse(Joueur autreJoueur) {
		if(this.getPoints()>autreJoueur.getPoints()) { 
			return true;
		}
		return false; // Si ceJoueur<=JoueurComparé
	}
	
}
