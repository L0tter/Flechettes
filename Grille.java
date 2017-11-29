/**
 * @author Flamant Antonin - Daspremont Elodie | Serie 4
 */
package flechette;

public abstract class Grille {
	
	// La table contient les joueurs selon l'ordre du jeu
	private Joueur[] tableJoueurs;

	/**
	 * construit une table vide pouvant contenir nombreJoueurs joueurs
	 * @param nombreJoueurs le nombre de joueurs participants
	 * @throws IllegalArgumentException : nombreJoueurs invalide : minimum 1 joueur!
	 */
	public Grille(int nombreJoueurs) {
		if(nombreJoueurs<1)
			throw new IllegalArgumentException("Attention, minimum 1 joueur!");
		tableJoueurs = new Joueur[nombreJoueurs];		
	}
	
	public int nombreJoueurs() {
		return tableJoueurs.length;
	}

	/**
	 * ajoute un joueur dans la table
	 * @param joueur le joueur a ajouter
	 * @param numero le numero d'ordre du joueur dans le jeu (numerotation commence a 1)
	 * @throws IllegalArgumentException : joueur ou numero invalide(s)
	 */
	public void ajouterJoueur(Joueur joueur, int numero){
		if (numero < 1) throw new IllegalArgumentException("Numero invalide");
		if (numero > tableJoueurs.length) throw new IllegalArgumentException("Numero invalide");
		if (joueur == null) throw new IllegalArgumentException("Joueur invalide");
		//if (tableJoueurs[numero-1] != null) throw new IllegalArgumentException("Le numero est deja prit");
		tableJoueurs[numero-1] = joueur;
	}
	
	/**
	 * renvoie le joueur dont le numero est passe en parametre
	 * @param numero le numero d'ordre du joueur dans le jeu
	 * @return le joueur
	 * @throws IllegalArgumentException : numero invalide 
	 */
	public Joueur donnerJoueur(int numero){
		if (numero < 1) throw new IllegalArgumentException("Numero invalide");
		if (numero > tableJoueurs.length) throw new IllegalArgumentException("Numero invalide");
		return tableJoueurs[numero-1];
	}
	
	public String toString(){
		String ch ="Voici les points :";
		for (int i = 0; i < tableJoueurs.length; i++) {
			ch += "\n"+tableJoueurs[i];
		}
		return ch;
	}
	
	/**
	 * classement des joueurs (du meilleur au moins bon)
	 * @return une table de joueurs
	 */
	public Joueur[] classement(){		
		Joueur[] tClasse = new Joueur[tableJoueurs.length];
		//Copie de la table
		for (int i = 0; i < tableJoueurs.length; i++) {
			tClasse[i] = tableJoueurs[i];
		}
		//Classement par selection
		for (int i = 0; i < tClasse.length; i++) {
			Joueur meilleur = tClasse[i];
			int index = i;
			for (int j = i+1; j < tClasse.length; j++){
				if (tClasse[j].estMieuxClasse(tClasse[i])){
					meilleur = tClasse[j];
					index = j;
				}
			}
			Joueur temp = tClasse[i];
			tClasse[i] = tClasse[index];
			tClasse[index] = temp;
		}
		return tClasse;
	}
}
