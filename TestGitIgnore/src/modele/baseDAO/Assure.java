package modele.baseDAO;

public class Assure {
	
	private String specialite;
	private int id_classe;
	private String matiere;
	
	public Assure () {}
	public Assure (String specialite, int id_classe, String matiere) {
		this.specialite = specialite;
		this.id_classe 	= id_classe;
		this.matiere 	= matiere;
	}
	
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	public int getId_classe() {
		return id_classe;
	}
	public void setId_classe(int id_classe) {
		this.id_classe = id_classe;
	}
	public String getMatiere() {
		return matiere;
	}
	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}
}
