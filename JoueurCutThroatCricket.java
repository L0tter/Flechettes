/**
 * @author Flamant Antonin - Daspremont Elodie | Serie 4
 */
package flechette;

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
		if (aMoinsDePointsQue(autreJoueur)) return true;
		return aToutFerme();
	}
	
	public boolean aMoinsDePointsQue(Joueur autreJoueur) {
		if (this.getPoints() >= autreJoueur.getPoints())
			return false;
		return true;
	}
	
	public Flechette flechetteRecommandee(int pointToMark) {
		// TODO		
		return null;
	}
	public void incSecteur(int secteur, int increment) {
		if(secteur!=25) {
			secteur=secteur-15; // Transformation en indice du tableau zones
		}
		else {secteur=6;} // Transformation en indice du tableau zones
		zones[secteur]+=increment;
	}
	public boolean estFerme(int zone){
		if (zone > 25 || zone < 15 || (zone <= 24 && zone >= 21)) return false;
		if (zone != 25){
			zone-=15;
		}else{
			zone = 6;
		}
		if (zones[zone] >= 3) return true;
		return false;
	}
	
	public boolean aToutFerme() {
		boolean retour=true;
		for(int i=15;i<=20;i++) {
			if (!(estFerme(i))) 
				return false;
		}
		if(!estFerme(25)) {
			retour=false;
		}
		return retour;
	}
	public int nombreZonesFermees() {
		int compteur = 0;
		for (int i = 0; i < zones.length; i++) {
			if (estFerme(i)) {
				compteur++;
			}
		}
		return compteur;
	}
}
