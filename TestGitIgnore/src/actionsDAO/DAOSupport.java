package actionsDAO;

public class DAOSupport {
	private String nom_support;
	
	public DAOSupport () {}
	public DAOSupport (String nom_support) {
		this.nom_support = nom_support;
	}
	public String getNom_support() {
		return nom_support;
	}
	public void setNom_support(String nom_support) {
		this.nom_support = nom_support;
	}
}
