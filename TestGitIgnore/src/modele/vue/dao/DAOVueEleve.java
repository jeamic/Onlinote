package modele.vue.dao;

public class DAOVueEleve {

    private int idEleve;
    private int idClasse;
    private String nom;
    private String prenom;
    private String adresse;
    private String email;
    private int idParent1;
    private int idParent2;
    
    public DAOVueEleve () {
    }
    
    public DAOVueEleve (int id, int idClasse, String nom, String prenom, String adresse, String email, int idParent1, int idParent2) {
        this.idEleve = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.idParent1 = idParent1;
        this.idParent2 = idParent2;
        this.idClasse = idClasse;
    }

    public int getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(int idClasse) {
        this.idClasse = idClasse;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdParent1() {
        return idParent1;
    }

    public void setIdParent1(int idParent1) {
        this.idParent1 = idParent1;
    }

    public int getIdParent2() {
        return idParent2;
    }

    public void setIdParent2(int idParent2) {
        this.idParent2 = idParent2;
    }


}
