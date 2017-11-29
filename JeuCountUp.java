/**
 * @author Flamant Antonin - Daspremont Elodie | Serie 4
 */
package flechette;

import java.util.Scanner;

import ui.ClassementPanel;

public class JeuCountUp {

	private static Scanner scanner = new Scanner(System.in);
	private static GrilleCountUp grille;
	private static Panneau panneau;
	private static String auteurs = " Flamant Antonin && Daspremont Elodie "; // mettez vos noms ici!

	public static void main(String[] args) {

		System.out.println("Bienvenue a un Count Up");

		// configuration du jeu
		// A ne pas modifier

		
		/* Fournit
		 Création des joueurs et remplissage de la grille - taille de la grille = nombre de joueurs
		*/
		System.out.print("Entrez le nombre de joueurs : ");
		int nbreJoueurs = UtilitairesJeux.lireEntierPositif("Le nombre de joueurs est de minimum 1");
		grille = new GrilleCountUp(nbreJoueurs);

		System.out.println("Entrez les noms des joueurs selon l'ordre du jeu : ");
		for (int numJoueur = 1; numJoueur <= nbreJoueurs; numJoueur++) {
			System.out.print("Entrez le nom du joueur " + numJoueur + " : ");
			String nomJoueur = UtilitairesJeux.lireStringNonVide("Le nom doit contenir au moins une lettre");
			JoueurCountUp joueur = new JoueurCountUp(nomJoueur);
			grille.ajouterJoueur(joueur, numJoueur);
		}

		/* Fournit
		  Nombre de Tours et choix de l'interface
		 */
		System.out.print("Entrez le nombre de tours : ");
		int nbreTours = UtilitairesJeux.lireEntierPositif("Le nombre de tours est de minimum 1");

		System.out.print("Voulez-vous utiliser une interface graphique?(O/N) : ");
		char utiliserGui = UtilitairesJeux.lireOouN("Tapez O ou N : ");

		if (utiliserGui == 'N')
			panneau = new PanneauTextuel("Count Up", auteurs);
		else
			panneau = PanneauGraphique.createPanneauGraphique("Count up", auteurs, nbreJoueurs);

		
		
		// DEBUT JEU
		
		panneau.afficherMessageDebutJeu();
		panneau.afficherJoueurs(grille.classement());
		
		System.out.println("Il y aura donc " + nbreTours + " tours. Have fun!");
		for(int i=1; i<=nbreTours ; i++) { // Faire plusieur Tours
			panneau.afficherDebutTour(i);
			faireTour(i);
			panneau.afficherFinTour(i);
		}
		
		Joueur[] classement = grille.classement();
		int gagnants=0;
		/* 
		 * Pour Désigner des ex-aequo : mis en commentaire car ClassementPanel ne gere pas l'affichage simultané de plusieurs gagnants
		 * 
		while(classement[gagnants].getPoints()==classement[gagnants+1].getPoints()) {
			gagnants++;
		}
		*/
		for(int i=0;i<=gagnants && i<classement.length;i++) { // Prevu pour l'affichage eventuel de plusieurs gagnants. Vérification inutile si un seul -> panneau.afficherGagnant(classement[0]);
			panneau.afficherGagnant(classement[i]);
		}
		panneau.afficherMessageFinJeu();

	}

	private static void faireTour(int numeroTour) {
		for (int j = 1; j <= grille.nombreJoueurs(); j++){
			panneau.afficherJoueurDebutTour(grille.donnerJoueur(j), numeroTour);
			JeuCountUp.faireVolee(grille.donnerJoueur(j));
			panneau.afficherJoueurFinTour(grille.donnerJoueur(j), numeroTour);
		}
	}
	
	private static void faireVolee(JoueurCountUp joueur) {
		int fleche=0;
		while(fleche<3) {
			panneau.afficherJoueurDebutFlechette(joueur, fleche); // Vous aller lancer la flechette
			Flechette arrow = panneau.viserEtLancerFlechette();
			joueur.ajouterPoints(arrow.donnerPoints());
			fleche++;
			panneau.afficherJoueurFinFlechette(joueur, fleche); // Vous avez lancé la flechette
		}
	}
}
