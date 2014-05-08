package modele.baseDAO;

public class Categorie {
	private String categorie;
	
	public Categorie () {}
	public Categorie (String categorie) {
		this.categorie = categorie;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	
}
