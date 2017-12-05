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
			
			System.out.println("Entrez le capital de départ des joueurs");
			int capital = scanner.nextInt();
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
				JoueurCutThroatCricket joueur = new JoueurCutThroatCricket(nomJoueur,capital);
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

		}
public static void faireTour(int numeroTour) {}
public static void faireVolee() {}


}
