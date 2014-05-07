package modele.baseDAO;

public class Choix_Option {
	
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
