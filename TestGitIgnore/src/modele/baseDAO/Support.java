package modele.baseDAO;

public class Support implements java.io.Serializable {
	private String nom_support;
	
	public Support () {}
	public Support (String nom_support) {
		this.nom_support = nom_support;
	}
	public String getNom_support() {
		return nom_support;
	}
	public void setNom_support(String nom_support) {
		this.nom_support = nom_support;
	}
}
