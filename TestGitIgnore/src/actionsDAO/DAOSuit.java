package actionsDAO;

public class DAOSuit {
	private int id_eleve;
	private String libelle;
	
	public DAOSuit () {}
	public DAOSuit (int id_eleve, String libelle) {
		this.id_eleve = id_eleve;
		this.libelle  = libelle;
	}
	public int getId_eleve() {
		return id_eleve;
	}
	public void setId_eleve(int id_eleve) {
		this.id_eleve = id_eleve;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
}
