package modele.basedao;

public class Classe implements java.io.Serializable{
	
	private int idClasse;
	private String nomClasse;
	private int idProfPrincipal;
	
	public Classe () {
	}
	public Classe (int idClasse, String nomClasse, int idProfPrincipal) {
		this.idClasse 			= idClasse;
		this.nomClasse 		= nomClasse;
		this.idProfPrincipal 	= idProfPrincipal;
	}
	public int getId_classe() {
		return idClasse;
	}
	public void setId_classe(int idClasse) {
		this.idClasse = idClasse;
	}
	public String getNom_classe() {
		return nomClasse;
	}
	public void setNom_classe(String nomClasse) {
		this.nomClasse = nomClasse;
	}
	public int getId_prof_principal() {
		return idProfPrincipal;
	}
	public void setId_prof_principal(int idProfPrincipal) {
		this.idProfPrincipal = idProfPrincipal;
	}
	
}
