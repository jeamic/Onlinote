package actionsDAO;

public class DAOSe_Fait_Sur {
	private String categorie;
	private String nom_support;
	
	public DAOSe_Fait_Sur () {}
	public DAOSe_Fait_Sur (String categorie, String nom_support) {
		this.categorie 	 = categorie;
		this.nom_support = nom_support;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public String getNom_support() {
		return nom_support;
	}
	public void setNom_support(String nom_support) {
		this.nom_support = nom_support;
	}
}
