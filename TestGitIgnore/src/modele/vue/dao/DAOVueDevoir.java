package modele.vue.dao;

public class DAOVueDevoir {
    public DAOVueDevoir() {
    }
    
    int idDevoir;
    int idCours;
    String categorie;
    String description;
    
    public DAOVueDevoir (int idCours, int idDevoir, String categorie, String description) {
        this.idCours = idCours;
        this.idDevoir = idDevoir;
        this.categorie   = categorie;
        this.description = description;
    }
    public int getIdDevoir() {
        return idDevoir;
    }
    public void setIdDevoir(int idDevoir) {
        this.idDevoir = idDevoir;
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
