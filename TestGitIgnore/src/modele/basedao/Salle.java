package modele.basedao;

public class Salle implements java.io.Serializable {
	private int idSalle;
	
	public Salle () {
	}
	public Salle (int idSalle) {
		this.idSalle = idSalle;
	}
	public int getIdSalle() {
		return idSalle;
	}
	public void setIdSalle(int idSalle) {
		this.idSalle = idSalle;
	}	
}
