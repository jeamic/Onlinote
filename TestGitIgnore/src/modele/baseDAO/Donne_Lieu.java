package modele.baseDAO;

public class Donne_Lieu implements java.io.Serializable {
	int id_cours;
	int id_devoir;
	
	public Donne_Lieu () {}
	public Donne_Lieu (int id_cours, int id_devoir) {
		this.id_cours 	= id_cours;
		this.id_devoir  = id_devoir;
	}
	public int getId_cours() {
		return id_cours;
	}
	public void setId_cours(int id_cours) {
		this.id_cours = id_cours;
	}
	public int getId_devoir() {
		return id_devoir;
	}
	public void setId_devoir(int id_devoir) {
		this.id_devoir = id_devoir;
	}
	
}
