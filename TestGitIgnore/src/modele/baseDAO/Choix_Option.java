package modele.baseDAO;

public class Choix_Option implements java.io.Serializable {
	
	private String libelle;
	
	public Choix_Option () {}
	public Choix_Option (String libelle) {
		this.libelle = libelle;
	}
	
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
}
