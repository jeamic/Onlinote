package modele.basedao;

public class Suit implements java.io.Serializable {
	private int idEleve;
	private String libelle;
	
	public Suit () {
	}
	public Suit (int idEleve, String libelle) {
		this.idEleve = idEleve;
		this.libelle  = libelle;
	}
	public int getId_eleve() {
		return idEleve;
	}
	public void setId_eleve(int idEleve) {
		this.idEleve = idEleve;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
}
