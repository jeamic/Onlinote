package modele.basedao;

public class Compose implements java.io.Serializable {
	
	private int idPersonne;
	private int idMessage;

	public Compose () {
	}
	public Compose (int idPersonne, int idMessage) {
		this.idPersonne = idPersonne;
		this.idMessage	 = idMessage;
	}
	public int getId_personne() {
		return idPersonne;
	}
	public void setId_personne(int idPersonne) {
		this.idPersonne = idPersonne;
	}
	public int getId_message() {
		return idMessage;
	}
	public void setId_message(int idMessage) {
		this.idMessage = idMessage;
	}
	
	
}
