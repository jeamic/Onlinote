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
	public int getIdPersonne() {
		return idPersonne;
	}
	public void setIdPersonne(int idPersonne) {
		this.idPersonne = idPersonne;
	}
	public int getIdMessage() {
		return idMessage;
	}
	public void setIdMessage(int idMessage) {
		this.idMessage = idMessage;
	}

	
	
}
