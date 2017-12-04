package flechette;

public class JoueurXX1 extends Joueur {
	private boolean toujoursEnCourse;
	
	public boolean isToujoursEnCourse() {
		return toujoursEnCourse;
	}

	public void setToujoursEnCourse(boolean toujoursEnCourse) {
		this.toujoursEnCourse = toujoursEnCourse;
	}

	public JoueurXX1(String nomJoueur, int capital) {
		super(nomJoueur,capital);
	}

	@Override
	public boolean estMieuxClasse(Joueur autreJoueur) {
		// TODO Auto-generated method stub
		return false;
	}

}
