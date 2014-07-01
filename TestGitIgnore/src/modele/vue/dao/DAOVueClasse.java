package modele.vue.dao;

import java.util.List;

public class DAOVueClasse {
    private int idClasse;
    private String nomClasse;
    private int idProfPrincipal;
    
    public DAOVueClasse(int idClasse, String nomClasse, int idProfPrincipal) {
        this.idClasse = idClasse;
        this.nomClasse = nomClasse;
        this.idProfPrincipal = idProfPrincipal;
    }

    public int getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(int idClasse) {
        this.idClasse = idClasse;
    }

    public String getNomClasse() {
        return nomClasse;
    }

    public void setNomClasse(String nomClasse) {
        this.nomClasse = nomClasse;
    }

    public int getIdProfPrincipal() {
        return idProfPrincipal;
    }

    public void setIdProfPrincipal(int idProfPrincipal) {
        this.idProfPrincipal = idProfPrincipal;
    }
    
    
}
