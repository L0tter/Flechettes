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
		for (int i = 1; i <= nombreJoueurs(); i++) { // Iteration des joueurs
			if (donnerJoueur(i).aToutFerme()){
				for (int j = 1; j <= nombreJoueurs(); j++) {
					if(donnerJoueur(i).getPoints()>donnerJoueur(j).getPoints()) {
						return false; // On a un joueur qui a moins de points -> pas fini
					}
				}
				return true; // Pas de joueurs qui ont moins de points et tout ferme
			}
		}
		return false; // Aucun joueur n'a tout ferme.
	}
	public JoueurCutThroatCricket[] ontPasFerme(int secteur) {
		JoueurCutThroatCricket[] penaliseTemp = new JoueurCutThroatCricket[nombreJoueurs()];
		int tLogi = 0;
		for(int i=1;i<=nombreJoueurs();i++) {
			if(!donnerJoueur(i).estFerme(secteur)) {
				penaliseTemp[tLogi]=donnerJoueur(i);
				tLogi++;
			}
		}
		JoueurCutThroatCricket[] penalise = new JoueurCutThroatCricket[tLogi];
		for(int r=0;r<tLogi;r++) {
			penalise[r]=penaliseTemp[r];
		}
		
		return penalise;
	}
	
	public JoueurCutThroatCricket donnerGagnant() {
		if(finJeu()) {
			for(int i=1;i<=nombreJoueurs();i++) {
				if(donnerJoueur(i).aToutFerme()) { // Test seulement si le joueur a tout ferme
					for(int j=1;j<=nombreJoueurs();j++) {
						if(donnerJoueur(i)!=donnerJoueur(j)) { // ne se compare pas a lui meme
							if(donnerJoueur(i).estMieuxClasse(donnerJoueur(j))){
								return donnerJoueur(i);
							}
						}
					}
				}
			}
		}
		return null;
	}
}
