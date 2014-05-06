package baseDAO;

public class Donne_Lieu {
	String matiere;
	String categorie;
	
	public Donne_Lieu () {}
	public Donne_Lieu (String matiere, String categorie) {
		this.matiere 	= matiere;
		this.categorie  = categorie;
	}
	public String getMatiere() {
		return matiere;
	}
	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	
	
}
