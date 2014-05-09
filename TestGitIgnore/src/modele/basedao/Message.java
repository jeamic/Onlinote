package modele.basedao;

public class Message implements java.io.Serializable {
	private int idMessage;
	private String objet;
	private String destinataires;
	private String contenu;
	private boolean lu;
	
	public Message (){
	}
	public Message (int idMessage, String objet, String destinataires, String contenu, boolean lu) {
		this.idMessage 	= idMessage;
		this.objet 			= objet;
		this.destinataires	= destinataires;
		this.contenu		= contenu;
		this.lu 			= lu;
	}
	public int getIdMessage() {
		return idMessage;
	}
	public void setIdMessage(int idMessage) {
		this.idMessage = idMessage;
	}
	public String getObjet() {
		return objet;
	}
	public void setObjet(String objet) {
		this.objet = objet;
	}
	public String getDestinataires() {
		return destinataires;
	}
	public void setDestinataires(String destinataires) {
		this.destinataires = destinataires;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public boolean isLu() {
		return lu;
	}
	public void setLu(boolean lu) {
		this.lu = lu;
	}

}
