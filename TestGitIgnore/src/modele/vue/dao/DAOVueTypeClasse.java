package modele.vue.dao;

public class DAOVueTypeClasse {

    
    String typeClasse;
    int nombre;

    public DAOVueTypeClasse (String typeClasse, int nombre) {
        this.typeClasse = typeClasse;
        this.nombre = nombre;
    }

    public String getTypeClasse() {
        return typeClasse;
    }

    public void setTypeClasse(String typeClasse) {
        this.typeClasse = typeClasse;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

}
