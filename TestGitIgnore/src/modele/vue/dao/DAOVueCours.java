package modele.vue.dao;

public class DAOVueCours {
    
    private int idCours;
    private String nomProf;
    private String nomClasse;
    private String salle;
    private String matiere;
    
    public DAOVueCours () {
    }
    
    public DAOVueCours (int idCours, String nomProf, String nomClasse, String salle, String matiere) {
        this.idCours = idCours;
        this.nomProf = nomProf;
        this.nomClasse = nomClasse;
        this.salle = salle;
        this.matiere = matiere;
    }

    public int getIdCours() {
        return idCours;
    }

    public void setIdCours(int idCours) {
        this.idCours = idCours;
    }

    public String getNomProf() {
        return nomProf;
    }

    public void setNomProf(String nomProf) {
        this.nomProf = nomProf;
    }

    public String getNomClasse() {
        return nomClasse;
    }

    public void setNomClasse(String nomClasse) {
        this.nomClasse = nomClasse;
    }

    public String getSalle() {
        return salle;
    }

    public void setSalle(String salle) {
        this.salle = salle;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }
    
}
