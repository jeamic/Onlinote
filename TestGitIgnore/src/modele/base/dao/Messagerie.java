package modele.base.dao;

public class Messagerie implements java.io.Serializable {
	
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    private int idPersonne;
	private int idMessage;
	private int envoiOuRecu;

	public Messagerie () {
	}
	public Messagerie (int idPersonne, int idMessage, int envoiOuRecu) {
		this.idPersonne = idPersonne;
		this.idMessage	 = idMessage;
		this.envoiOuRecu = envoiOuRecu;
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
    public int getEnvoiOuRecu() {
        return envoiOuRecu;
    }
    public void setEnvoiOuRecu(int envoiOuRecu) {
        this.envoiOuRecu = envoiOuRecu;
    }
	
}
