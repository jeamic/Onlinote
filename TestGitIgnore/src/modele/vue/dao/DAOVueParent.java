package modele.vue.dao;

import java.util.List;

public class DAOVueParent {
    private int idParent;
    private String nom;
    private String prenom;
    private String adresse;
    private String email;
    private List<DAOVueEleve> listeEnfants;
    
    public DAOVueParent () {
    }
    
    public DAOVueParent (int id, String nom, String prenom, String adresse, String email, List<DAOVueEleve> listeEnfants) {
        this.idParent = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.listeEnfants = listeEnfants;
    }

    public int getIdParent() {
        return idParent;
    }

    public void setIdParent(int idParent) {
        this.idParent = idParent;
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

    public List<DAOVueEleve> getListeEnfants() {
        return listeEnfants;
    }

    public void setListeEnfants(List<DAOVueEleve> listeEnfants) {
        this.listeEnfants = listeEnfants;
    }
    
}
