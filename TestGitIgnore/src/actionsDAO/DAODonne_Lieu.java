package actionsDAO;

public class DAODonne_Lieu {
	String matiere;
	String categorie;
	
	public DAODonne_Lieu () {}
	public DAODonne_Lieu (String matiere, String categorie) {
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
