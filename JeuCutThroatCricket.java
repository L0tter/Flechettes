/**
 * @author Flamant Antonin - Daspremont Elodie | Serie 4
 */
package flechette;
import java.util.Scanner;

import ui.ClassementPanel;

public class JeuCutThroatCricket {

		private static Scanner scanner = new Scanner(System.in);
		private static GrilleCutThroatCricket grille;
		private static Panneau panneau;
		private static String auteurs = " Flamant Antonin && Daspremont Elodie ";

		public static void main(String[] args) {
			System.out.println("Bienvenue a un Cut Throat Cricket!");
			
			/**System.out.println("Entrez le capital de départ des joueurs");
			int capital = scanner.nextInt();*/
			/* Fournit
			 Création des joueurs et remplissage de la grille - taille de la grille = nombre de joueurs
			*/
			System.out.print("Entrez le nombre de joueurs : ");
			int nbreJoueurs = UtilitairesJeux.lireEntierPositif("Le nombre de joueurs est de minimum 1");
			grille = new GrilleCutThroatCricket(nbreJoueurs);

			System.out.println("Entrez les noms des joueurs selon l'ordre du jeu : ");
			for (int numJoueur = 1; numJoueur <= nbreJoueurs; numJoueur++) {
				System.out.print("Entrez le nom du joueur " + numJoueur + " : ");
				String nomJoueur = UtilitairesJeux.lireStringNonVide("Le nom doit contenir au moins une lettre");
				JoueurCutThroatCricket joueur = new JoueurCutThroatCricket(nomJoueur,0);
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
				panneau = new PanneauTextuel("CutThroatCricket", auteurs);
			}
			else {
				panneau = PanneauGraphique.createPanneauGraphique("CutThroatCricket", auteurs, nbreJoueurs);
			}
			
			
			// DEBUT JEU
			panneau.afficherMessageDebutJeu();
			panneau.afficherJoueurs(grille.classement());
			
			System.out.println("Il y aura donc " + nbreTours + " tours.");
			
			for(int i=1; i<=nbreTours ; i++) { // Faire plusieur Tours
				panneau.afficherDebutTour(i);
				faireTour(i);
				panneau.afficherFinTour(i);
			}
			if(grille.donnerGagnant()==null) {
				System.out.print("Pas de gagnant, bande de looser!");
			}
			else{
				panneau.afficherGagnant(grille.donnerGagnant());
			}
			panneau.afficherMessageFinJeu();
		}
	public static void faireTour(int numeroTour) {
		for(int i=1;i<=numeroTour;i++) {
			panneau.afficherDebutTour(i);
			for(int j=1;j<=grille.nombreJoueurs();j++) {
				panneau.afficherJoueurDebutTour(grille.donnerJoueur(j), i);
				faireVolee(grille.donnerJoueur(j));
				panneau.afficherJoueurFinTour(grille.donnerJoueur(j), i);
				//Verifier conditions de victoires globales
				if(grille.finJeu()) {
					panneau.afficherGagnant(grille.donnerGagnant());
					panneau.afficherMessageFinJeu();
				}
			}
			panneau.afficherFinTour(i);
			panneau.afficherJoueurs(grille.classement());
		}
	}//TODO
	public static void faireVolee(JoueurCutThroatCricket joueur) {
		for(int f=1; f<=3;f++) {
			panneau.afficherJoueurDebutFlechette(joueur, f);
			Flechette arrow = panneau.viserEtLancerFlechette();
			
			if(secteurToHit(arrow.getSecteur())) { 
			// SI le secteur est 15,16,17,18,19,20,25
				if(joueur.estFerme(arrow.getSecteur())) {
				// Si secteur ferme, il inflige mallus
				// Ne retire pas de points au joueur
					infligerMallus(arrow);
				}
				else {
				 // Augmentation compteur
					joueur.incSecteur(arrow.getSecteur(), arrow.getZone());
					joueur.ajouterPoints(arrow.donnerPoints());
				}
			}
			else { 
			// Flechette ne fait que lui donner des points car hors zone a marquer.
				joueur.ajouterPoints(arrow.donnerPoints());
			}
			
			panneau.afficherJoueurFinFlechette(joueur, f);
		}
	}
	public static boolean secteurToHit(int secteur) {
		switch (secteur) {
		case 15:case 16: case 17: case 18: case 19: case 20: case 25:
			return true;
		default:
			return false;
		}
	}
	public static void infligerMallus(Flechette f) {
		JoueurCutThroatCricket[] mallus = grille.ontPasFerme(f.getSecteur());
		for(JoueurCutThroatCricket j : mallus) {
			j.ajouterPoints(f.donnerPoints());
		}
	}
}
