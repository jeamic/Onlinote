package modele.basedao;

public class Devoirs implements java.io.Serializable {
	
	int idDevoir;
	String categorie;
	String description;
	
	public Devoirs() {
	}
	public Devoirs (int idDevoir, String categorie, String description) {
		this.idDevoir = idDevoir;
		this.categorie 	 = categorie;
		this.description = description;
	}
	public int getId_devoir() {
		return idDevoir;
	}
	public void setId_devoir(int idDevoir) {
		this.idDevoir = idDevoir;
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
