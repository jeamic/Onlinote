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
	public int getIdCours() {
		return idCours;
	}
	public void setIdCours(int idCours) {
		this.idCours = idCours;
	}
	public int getIdDevoir() {
		return idDevoir;
	}
	public void setIdDevoir(int idDevoir) {
		this.idDevoir = idDevoir;
	}
	
}
