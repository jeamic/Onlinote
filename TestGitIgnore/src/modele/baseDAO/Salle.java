package modele.baseDAO;

public class Salle {
	private int id_salle;
	
	public Salle () {}
	public Salle (int id_salle) {
		this.id_salle = id_salle;
	}
	public int getId_salle() {
		return id_salle;
	}
	public void setId_salle(int id_salle) {
		this.id_salle = id_salle;
	}
	
}