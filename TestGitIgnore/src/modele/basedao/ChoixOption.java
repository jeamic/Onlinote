package modele.basedao;

public class ChoixOption implements java.io.Serializable {
	
	private String libelle;
	
	public ChoixOption () {
	}
	public ChoixOption (String libelle) {
		this.libelle = libelle;
	}
	
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
}
