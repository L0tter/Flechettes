package flechette;

public abstract class test {

	public static void main(String[] args) {
		Joueur ja = new JoueurCountUp("Ja");
		Joueur jb = new JoueurCountUp("Jb");
		Joueur jc = new JoueurCountUp("Jc");
		Joueur jd = new JoueurCountUp("Jd");
		Joueur je = new JoueurCountUp("Je");
		Joueur jf = new JoueurCountUp("Jf");
		Grille grille = new GrilleCountUp(6);
		grille.ajouterJoueur(ja, 1);
		grille.ajouterJoueur(jb, 2);
		grille.ajouterJoueur(jc, 3);
		grille.ajouterJoueur(jd, 4);
		grille.ajouterJoueur(je, 5);
		grille.ajouterJoueur(jf, 6);
		for(int i=1;i<=6;i++) {
			System.out.print(grille.donnerJoueur(i) + " - ");
		}
		
		ja.setPoints(15);
		jb.setPoints(60);
		jc.setPoints(99);
		jd.setPoints(77);
		je.setPoints(1);
		jf.setPoints(96);
		
		System.out.println();
		Joueur[] classement = grille.classement();
		for(int i=0;i<6;i++) {
			System.out.print(classement[i]+ " - "); // Attendu : je ja jb jd jf jc
		}
	}

}
