package modele.baseDAO;

public class Devoirs {
	String categorie;
	String description;
	
	public Devoirs() {}
	public Devoirs (String categorie, String description) {
		this.categorie 	 = categorie;
		this.description = description;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
