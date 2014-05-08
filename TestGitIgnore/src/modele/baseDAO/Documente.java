package modele.baseDAO;

public class Documente implements java.io.Serializable {
	private int id_support;
	private String nom_support;
	
	public Documente () {}
	public Documente (int id_support, String nom_support) {
		this.id_support  = id_support;
		this.nom_support = nom_support;
	}
	public int getId_support() {
		return id_support;
	}
	public void setId_support(int id_support) {
		this.id_support = id_support;
	}
	public String getNom_support() {
		return nom_support;
	}
	public void setNom_support(String nom_support) {
		this.nom_support = nom_support;
	}

}
