package modele.baseDAO;

public class Classe implements java.io.Serializable{
	
	private int id_classe;
	private String nom_classe;
	private int id_prof_principal;
	
	public Classe () {}
	public Classe (int id_classe, String nom_classe, int id_prof_principal) {
		this.id_classe 			= id_classe;
		this.nom_classe 		= nom_classe;
		this.id_prof_principal 	= id_prof_principal;
	}
	public int getId_classe() {
		return id_classe;
	}
	public void setId_classe(int id_classe) {
		this.id_classe = id_classe;
	}
	public String getNom_classe() {
		return nom_classe;
	}
	public void setNom_classe(String nom_classe) {
		this.nom_classe = nom_classe;
	}
	public int getId_prof_principal() {
		return id_prof_principal;
	}
	public void setId_prof_principal(int id_prof_principal) {
		this.id_prof_principal = id_prof_principal;
	}
	
}
