/**
 * @author Flamant Antonin - Daspremont Elodie | Serie 4
 */
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
		panneau.afficherMessageDebutJeu();
		panneau.afficherJoueurs(grille.classement());
		
		System.out.println("Il y aura donc " + nbreTours + " tours. Vous commencez à " + capital + " points. Have fun!");
		
		for(int i=1; i<=nbreTours ; i++) { // Faire plusieur Tours
			panneau.afficherDebutTour(i);
			faireTour(i);
			panneau.afficherFinTour(i);
		}
		panneau.afficherGagnant(grille.donnerGagnant());
		panneau.afficherMessageFinJeu();
	}
	public static void faireTour(int numTour) {
		panneau.afficherDebutTour(numTour);
		for (int i = 1; i <= grille.nombreJoueurs(); i++) {
			if (grille.donnerJoueur(i).getPoints()!=1){
				panneau.afficherJoueurDebutTour(grille.donnerJoueur(i), numTour);
				faireVolee(grille.donnerJoueur(i));
				if (grille.finJeu()){
					if(grille.tousA1()){
						panneau.afficherMessageWarning("Tout le monde a perdu.");
						panneau.afficherGagnant(null);
					}else{
						panneau.afficherGagnant(grille.donnerGagnant());
					}
					panneau.afficherFinTour(numTour);
					panneau.afficherMessageFinJeu();
				}
				panneau.afficherJoueurFinTour(grille.donnerJoueur(i), numTour);
				panneau.afficherJoueurs(grille.classement());
			}
		}
		panneau.afficherFinTour(numTour);
	}
	
	public static void faireVolee(JoueurXX1 joueur) {
		boolean jouer = joueur.getPoints()!=1; // Si points == 1 : ne vaut pas la peine de jouer 
		int sumMarked=0; // totalise les flechettes
		boolean wasDouble;
		// Si a encore des fléchettes
		for(int f=1;f<=3 && joueur.getPoints()>0 && jouer;f++) {	// Lancer des flechette jusqu'a la dernière ou jusqu'a tomber en négatif
			Flechette recom = joueur.flechetteRecommandee(joueur.getPoints()-sumMarked);
			panneau.afficherRecommandationPourJoueur(joueur, recom);
			
			panneau.afficherJoueurDebutFlechette(joueur, f);
			Flechette arrow = panneau.viserEtLancerFlechette();
			
			if((joueur.getPoints()-(sumMarked+arrow.donnerPoints())<0) ) {jouer=false;} // Si les points tombent en negatif le joueur casse sa volée
			sumMarked+=arrow.donnerPoints();
			
			if(arrow.getZone()==2) {wasDouble=true;}
			else {wasDouble=false;}
			
			if(wasDouble && (joueur.getPoints()-sumMarked)==0) { // La dernière flechette est un double et a permi d'arriver a 0
				//Conditions de fin de jeu
				joueur.retirerPoints(sumMarked);
				jouer=false; // Ne joue plus : responsabilité faireTour de rechercher et afficher gagnant.
			}
			if(f==3 && wasDouble && jouer && joueur.getPoints()>0) { // Décrementation des points, le jeu continue.
				joueur.retirerPoints(sumMarked);
			}
			panneau.afficherJoueurFinFlechette(joueur, f);
		}
		
	}
	

}
