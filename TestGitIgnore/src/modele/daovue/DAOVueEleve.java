package modele.daovue;

public class DAOVueEleve {

    private int idEleve;
    private String nom;
    private String prenom;
    private String adresse;
    private String motDePasse;
    private String email;
    private int idParent;
    
    public DAOVueEleve () {
    }
    
    public DAOVueEleve (int idEleve, String nom, String prenom, String adresse, String motDePasse, String email, int idParent) {
        this.idEleve = idEleve;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.motDePasse = motDePasse;
        this.email = email;
        this.idParent = idParent;
    }

    public int getIdEleve() {
        return idEleve;
    }

    public void setIdEleve(int idEleve) {
        this.idEleve = idEleve;
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

    public int getIdParent() {
        return idParent;
    }

    public void setIdParent(int idParent) {
        this.idParent = idParent;
    }
}
