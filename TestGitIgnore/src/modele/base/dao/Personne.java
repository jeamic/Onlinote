package modele.base.dao;

public class Personne implements java.io.Serializable {

	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    private int idPersonne;
	private String nom;
	private String prenom;
	private String adresse;
	private String motDePasse;
	private String email;
	private String typeP;
	
		public Personne() {
    }
	public Personne (int idPersonne, String nom, String prenom, String adresse, String motDePasse, String email, String typeP) {
		this.idPersonne  = idPersonne;
		this.nom 		  = nom;
		this.prenom 	  = prenom;
		this.adresse 	  = adresse;
		this.motDePasse = motDePasse;
		this.email		  = email;
		this.typeP 	  = typeP;
	}

    public int getIdPersonne() {
		return idPersonne;
	}
	public void setIdPersonne(int idPersonne) {
		this.idPersonne = idPersonne;
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
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTypeP() {
		return typeP;
	}
	public void setTypeP(String typeP) {
		this.typeP = typeP;
	}
}
