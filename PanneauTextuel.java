/**
 * @author Flamant Antonin - Daspremont Elodie | Serie 4
 */
package flechette;

import java.util.Scanner;

public class PanneauTextuel implements Panneau{
	private static Scanner scanner = new Scanner(System.in);
	String nomDuJeu;
	String auteurs; 
	
	public PanneauTextuel(String nomDuJeu, String auteurs){
		this.nomDuJeu = nomDuJeu;
		this.auteurs = auteurs;
	}
	
	@Override
	public Flechette viserEtLancerFlechette() {
		// Pensez a utiliser la methode lireEntierComprisEntre() de la classe UtilitairesJeux
		System.out.println("Votre flechette à la main, vous fixez intesément la cible, concentré.");
		System.out.println("Quelle Zone visez-vous ? Entrez un nombre entre 0 et 25.");
		int zone=UtilitairesJeux.lireEntierComprisEntre(1, 50, "Inférieur à 0 ou supérieur à 50 ?!");
		System.out.println("Quelle section visez-vous ? Entrez un nombre entre 1 et 20.");
		int section=UtilitairesJeux.lireEntierComprisEntre(1, 20, "Inférieur à 1 ou supérieur à 20 ?!");
		Flechette arrow = new Flechette(section, zone);
		
		return arrow;
	}
	
	@Override
	public void afficherMessageDebutJeu() {
		System.out.println("*****************************************************************");
		System.out.println("    Bienvenue au jeu de flechette - "+nomDuJeu);
		System.out.println("     programme par "+auteurs);
		System.out.println("*****************************************************************");
	}

	@Override
	public void afficherMessageFinJeu() {
		System.out.println("Le jeu est fini ! Bon retrour chez vous. Ou vous laisserez-vous tenter par une autre partie ?");
	}

	@Override
	public void afficherJoueurDebutTour(Joueur joueur, int numeroTour) {
		String PS = "\n	Et n'oubliez pas que l'arbitre n'accepte que les bitCoins...";
		System.out.println("Tour n° " + numeroTour + ". C'est au tour de " + joueur.getNom() + ". Bonne chance!" + PS);
	}
	@Override
	public void afficherJoueurFinTour(Joueur joueur, int numeroTour) {
		System.out.println("Le joueur " + joueur.getNom() + " a completé sa volée pour le tour n°" + numeroTour + ". Au suivant!");
	}
	
	@Override
	public void afficherGagnant(Joueur gagnant) {
		String PS = "\n Youuuuuuuu are the chaaaaaaaampion, my frieeeeend!";
		System.out.println("Congratz! Joueur " + gagnant.getNom() + " pour votre victoire avec " + gagnant.getPoints() + " points!" + PS);
	}
	
	@Override
	public void afficherJoueurs(Joueur[] joueurs) {
		String whoSThere = "Les joueurs sont les suivants : \n";
		for(Joueur joueur : joueurs) {
			whoSThere+=" * " + joueur.getNom() + "\n";
		}
		System.out.println(whoSThere);
	}

	@Override
	public void afficherDebutTour(int numeroTour) {
		System.out.println("Début du tour n°" + numeroTour);
	}

	@Override
	public void afficherFinTour(int numeroTour) {
		System.out.println("Fin du tour n°" + numeroTour);	
	}

	@Override
	public void afficherJoueurDebutFlechette(Joueur joueur, int numeroFlechette) {
		System.out.println(joueur.getNom() + " vous en êtes à votre " + numeroFlechette + "eme flechette! Utilisez-la a bon escient !");	
	}

	@Override
	public void afficherJoueurFinFlechette(Joueur joueur, int numeroFlechette) {
		System.out.println(joueur.getNom() + ", vous avez utilisé toutes votre " + numeroFlechette + "eme flechette pour ce tour.");
	}

	@Override
	public void afficherFlechette(Flechette flechette) {
		System.out.println("Votre fléchette, lancée en zone " + flechette.getZone() + " et en secteur " + flechette.getSecteur() + " vous a rapporté " + flechette.donnerPoints() + "points.");		
	}


	@Override
	public void afficherMessageInfo(String message) {
		System.out.println("Info ! " + message);		
	}

	@Override
	public void afficherMessageWarning(String message) {
		System.out.println("Vous avez déclenché un warning ! -> " + message);				
	}	

	@Override
	public void afficherRecommandationPourJoueur(Joueur joueur, Flechette[] flechetteRecommandee) {
		// TODO Auto-generated method stub
		
	}

}