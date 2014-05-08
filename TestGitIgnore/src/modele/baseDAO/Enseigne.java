package modele.baseDAO;

public class Enseigne implements java.io.Serializable {
	
	private int id_cours;
	private int id_classe;
	private int id_personne;
	
	public Enseigne () {}
	public Enseigne (int id_cours, int id_classe, int id_personne) {
		this.id_cours = id_cours;
		this.id_classe 	= id_classe;
		this.id_personne 	= id_personne;
	}
	public int getId_cours() {
		return id_cours;
	}
	public void setId_cours(int id_cours) {
		this.id_cours = id_cours;
	}
	public int getId_classe() {
		return id_classe;
	}
	public void setId_classe(int id_classe) {
		this.id_classe = id_classe;
	}
	public int getId_personne() {
		return id_personne;
	}
	public void setId_personne(int id_personne) {
		this.id_personne = id_personne;
	}
	
}
