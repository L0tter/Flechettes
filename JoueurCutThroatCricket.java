/**
 * @author Flamant Antonin - Daspremont Elodie | Serie 4
 */
package flechette;

import org.omg.CORBA.ORBPackage.InconsistentTypeCode;

public class JoueurCutThroatCricket extends Joueur {
	private boolean zonesFermees;
	private int[] zones;
		// [15,16,17,18,19,20,bull(25)]
	public JoueurCutThroatCricket(String nom, int points) {
		super(nom, points);
		this.zonesFermees=false;
		this.zones=new int[7];
	}

	public void ajouterPoints(int mallus) { // Au plus un joueur a de points, au pire
		int totPoints=this.getPoints()+mallus;
		this.setPoints(totPoints);
	}
	
	@Override
	public boolean estMieuxClasse(Joueur autreJoueur) {
		// TODO Auto-generated method stub
		return false;
	}

	public Flechette flechetteRecommandee(int pointToMark) {
		// TODO
		
		return null;
	}
}
