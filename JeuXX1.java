package flechette;
import java.util.Scanner;

import ui.ClassementPanel;

public class JeuXX1 {
	
	private static Scanner scanner = new Scanner(System.in);
	private static GrilleXX1 grille;
	private static Panneau panneau;
	private static String auteurs = " Flamant Antonin && Daspremont Elodie ";

	public static void main(String[] args) {
		System.out.println("Bienvenue a un XX1 double out!");
		
		System.out.println("Entrez le capital de départ des joueurs (leurs points à perdre pour gagner)");
		int capital = scanner.nextInt();
		/* Fournit
		 Création des joueurs et remplissage de la grille - taille de la grille = nombre de joueurs
		*/
		System.out.print("Entrez le nombre de joueurs : ");
		int nbreJoueurs = UtilitairesJeux.lireEntierPositif("Le nombre de joueurs est de minimum 1");
		grille = new GrilleXX1(nbreJoueurs);

		System.out.println("Entrez les noms des joueurs selon l'ordre du jeu : ");
		for (int numJoueur = 1; numJoueur <= nbreJoueurs; numJoueur++) {
			System.out.print("Entrez le nom du joueur " + numJoueur + " : ");
			String nomJoueur = UtilitairesJeux.lireStringNonVide("Le nom doit contenir au moins une lettre");
			JoueurXX1 joueur = new JoueurXX1(nomJoueur,capital);
			grille.ajouterJoueur(joueur, numJoueur);
		}

		/* Fournit
		  Nombre de Tours et choix de l'interface
		 */
		System.out.print("Entrez le nombre de tours : ");
		int nbreTours = UtilitairesJeux.lireEntierPositif("Le nombre de tours est de minimum 1");

		System.out.print("Voulez-vous utiliser une interface graphique?(O/N) : ");
		char utiliserGui = UtilitairesJeux.lireOouN("Tapez O ou N : ");

		if (utiliserGui == 'N') {
			panneau = new PanneauTextuel("XX1 double out", auteurs);
		}
		else {
			panneau = PanneauGraphique.createPanneauGraphique("XX1 double out", auteurs, nbreJoueurs);
		}
		
		
		// DEBUT JEU
	}
	public static void faireTour(int numTour) {
		//invoque faireVolee pour chaque joueur qui est toujours en course
		// si la dernière fléchette jouée est un double
			//Modifier les points
		// aficcher le classement
		
	} //TODO
	
	public static void faireVolee() {
		// Si a encore des fléchettes
		// Doit vérifier si la fléchette est nécessaire
			// (a encore des fléchette && a des points cohérent ( pas 1 ni négatifs ) )
		// Montre la fléchette recommandée. Si null -> ce joueur ne peut plus gagner
		// Doit permettre de transmettre si la dernière fléchette ->jouée<- (pas avortée) était un double
	} //TODO
	
	public static Flechette flechetteRecommandee(int pointsAMarquer /*Issu du joueur*/) {
		
		// Si on ne considère double que la Zone 2 --> Et pour the bull's eye ? Compte-il comme une zone double ?
		for(int secteur=20;secteur>0;secteur--){
			if((pointsAMarquer)-(2*secteur) != 1 && ((pointsAMarquer)-(2*secteur) >= 0) ){
				return new Flechette(secteur, 2);
			}
		}
		return null; // Si on a un return null ça signifie que ce joueur ne peut plus gagner.
	}//TODO
}
