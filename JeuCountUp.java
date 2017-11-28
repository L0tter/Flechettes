/**
 * @author Flamant Antonin - Daspremont Elodie | Serie 4
 */
package flechette;

import java.util.Scanner;

public class JeuCountUp {

	private static Scanner scanner = new Scanner(System.in);
	private static GrilleCountUp grille;
	private static Panneau panneau;
	private static String auteurs = " les auteurs "; // mettez vos noms ici!

	public static void main(String[] args) {

		System.out.println("Bienvenue a un Count Up");

		// configuration du jeu
		// A ne pas modifier

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
		
		// TODO
		// appel nbreTours x la methode faireTour()

	}

	private static void faireTour(int numeroTour) {
		// TODO
		// appel nbreJoueurs x la methode faireVolee()
	}

	
	private static void faireVolee(JoueurCountUp joueur) {
		panneau.afficherJoueurDebutTour(joueur, numeroTour); // TODO
		int fleche=1;
		while(fleche<=3) {
			panneau.afficherJoueurDebutFlechette(joueur, fleche);
			Flechette arrow = panneau.viserEtLancerFlechette();
			joueur.setPoints(arrow.donnerPoints());
			fleche++;
			panneau.afficherJoueurFinFlechette(joueur, fleche);
		}
		panneau.afficherJoueurFinTour(joueur, numeroTour);
	}
}
