package modele.baseDAO;

public class Devoirs implements java.io.Serializable {
	
	int id_devoir;
	String categorie;
	String description;
	
	public Devoirs() {}
	public Devoirs (int id_devoir, String categorie, String description) {
		this.id_devoir = id_devoir;
		this.categorie 	 = categorie;
		this.description = description;
	}
	public int getId_devoir() {
		return id_devoir;
	}
	public void setId_devoir(int id_devoir) {
		this.id_devoir = id_devoir;
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
