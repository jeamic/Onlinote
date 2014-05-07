package modele.baseDAO;

public class Compose implements java.io.Serializable {
	
	private int id_personne;
	private int id_message;

	public Compose () {}
	public Compose (int id_personne, int id_message) {
		this.id_personne = id_personne;
		this.id_message	 = id_message;
	}
	public int getId_personne() {
		return id_personne;
	}
	public void setId_personne(int id_personne) {
		this.id_personne = id_personne;
	}
	public int getId_message() {
		return id_message;
	}
	public void setId_message(int id_message) {
		this.id_message = id_message;
	}
	
	
}
