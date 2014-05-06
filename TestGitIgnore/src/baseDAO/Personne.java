package baseDAO;

public class Personne {

	private int id_personne;
	private String nom;
	private String prenom;
	private String adresse;
	private String mot_de_passe;
	private String email;
	private String type_p;
	
	public Personne () {}
	public Personne (int id_personne, String nom, String prenom, String adresse, String mot_de_passe, String email, String type_p) {
		this.id_personne  = id_personne;
		this.nom 		  = nom;
		this.prenom 	  = prenom;
		this.adresse 	  = adresse;
		this.mot_de_passe = mot_de_passe;
		this.email		  = email;
		this.type_p 	  = type_p;
	}
	public int getId_personne() {
		return id_personne;
	}
	public void setId_personne(int id_personne) {
		this.id_personne = id_personne;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getMot_de_passe() {
		return mot_de_passe;
	}
	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getType_p() {
		return type_p;
	}
	public void setType_p(String type_p) {
		this.type_p = type_p;
	}
	
	
}
