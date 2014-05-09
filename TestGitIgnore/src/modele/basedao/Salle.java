package modele.basedao;

public class Salle implements java.io.Serializable {
	private int idSalle;
	
	public Salle () {
	}
	public Salle (int idSalle) {
		this.idSalle = idSalle;
	}
	public int getId_salle() {
		return idSalle;
	}
	public void setId_salle(int idSalle) {
		this.idSalle = idSalle;
	}
	
}
