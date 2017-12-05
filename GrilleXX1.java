package flechette;

public class GrilleXX1 extends Grille {
	public GrilleXX1(int nombreJoueurs){
		super(nombreJoueurs);
	}

	@Override
	public JoueurXX1 donnerJoueur(int numero){
		return (JoueurXX1)super.donnerJoueur(numero);
	}
	
	public boolean tousA1(){
		for (int i = 1; i <= nombreJoueurs(); i++) {
			if (donnerJoueur(i).getPoints() != 1 ) return false;
		}
		return true;
	}
	
	public JoueurXX1 donnerGagnant(){
		if (!(tousA1())){
			for (int i = 1; i <= nombreJoueurs(); i++) {
				if (donnerJoueur(i).getPoints() == 0 ) return donnerJoueur(i);
			}
		}
		return null;
	}
	
	public boolean finJeu(){
		if (tousA1()) return true;
		if (donnerGagnant() != null) return true;	
		return false;
	}
}
