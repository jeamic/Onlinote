package modele.basedao;

public class Documente implements java.io.Serializable {
	private int idSupport;
	private String nom_support;
	
	public Documente () {
	}
	public Documente (int idSupport, String nom_support) {
		this.idSupport  = idSupport;
		this.nom_support = nom_support;
	}
	public int getId_support() {
		return idSupport;
	}
	public void setId_support(int idSupport) {
		this.idSupport = idSupport;
	}
	public String getNom_support() {
		return nom_support;
	}
	public void setNom_support(String nom_support) {
		this.nom_support = nom_support;
	}

}
