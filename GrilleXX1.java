package flechette;

public class GrilleXX1 extends Grille {
	public GrilleXX1(int nombreJoueurs){
		super(nombreJoueurs);
	}

	@Override
	public JoueurXX1 donnerJoueur(int numero){
		return (JoueurXX1)super.donnerJoueur(numero);
	}
	
	public Joueur[] classement() {
		return new Joueur[0];
	}
	// TODO : overrride classement : ce n'est pas la meme chose ici.
	// Celui qui a le moins de points > celui qui en a le plus
	// Sauf si 1 : dernier car ne peut plus gagner -> Ces joueurs là ont un attribut "toujoursEnCourse" FALSE
}
