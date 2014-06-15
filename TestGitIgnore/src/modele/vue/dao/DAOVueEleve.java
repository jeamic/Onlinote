package modele.vue.dao;

import java.util.Date;

import modele.base.actionsdao.DAOPersonne;
import modele.base.dao.Personne;

public class DAOVueEleve {

    private int idEleve;
    private int idClasse;
    private String nom;
    private String prenom;
    private String adresse;
    private String email;
    private int idParent1;
    private int idParent2;
    private Date dateNaiss;
    
    public DAOVueEleve () {
    }
    
    public DAOVueEleve (Personne eleve, int idClasse, int idParent1, int idParent2) {
        this.idEleve = eleve.getIdPersonne();
        this.nom = eleve.getNom();
        this.prenom = eleve.getPrenom();
        this.adresse = eleve.getAdresse();
        this.email = eleve.getEmail();
        this.dateNaiss = eleve.getDateNaiss();
        this.idParent1 = idParent1;
        this.idParent2 = idParent2;
        this.idClasse = idClasse;
    }

    public Date getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(Date dateNaiss) {
        this.dateNaiss = dateNaiss;
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
