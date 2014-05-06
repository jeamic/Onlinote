package baseDAO;

public class Message {
	private int id_message;
	private String objet;
	private String destinataires;
	private String contenu;
	private boolean lu;
	
	public Message (){}
	public Message (int id_message, String objet, String destinataires, String contenu, boolean lu) {
		this.id_message 	= id_message;
		this.objet 			= objet;
		this.destinataires	= destinataires;
		this.contenu		= contenu;
		this.lu 			= lu;
	}
	public int getId_message() {
		return id_message;
	}
	public void setId_message(int id_message) {
		this.id_message = id_message;
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
