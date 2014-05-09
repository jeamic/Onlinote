package modele.basedao;

public class DonneLieu implements java.io.Serializable {
	int idCours;
	int idDevoir;
	
	public DonneLieu () {
	}
	public DonneLieu (int idCours, int idDevoir) {
		this.idCours 	= idCours;
		this.idDevoir  = idDevoir;
	}
	public int getId_cours() {
		return idCours;
	}
	public void setId_cours(int idCours) {
		this.idCours = idCours;
	}
	public int getId_devoir() {
		return idDevoir;
	}
	public void setId_devoir(int idDevoir) {
		this.idDevoir = idDevoir;
	}
	
}
