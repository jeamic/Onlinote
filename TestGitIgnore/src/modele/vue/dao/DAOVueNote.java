package modele.vue.dao;

public class DAOVueNote {
    private int idEleve;
    private double note;
    private double noteMax;
    private double coefficient;
    private int trimestre;
    private String matiere;
    
    public DAOVueNote() {
        
    }
    
    public DAOVueNote(int idEleve, double note, double noteMax, double coefficient, int trimestre, String matiere) {
        this.idEleve = idEleve;
        this.note    = note;
        this.trimestre = trimestre;
        this.noteMax = noteMax;
        this.coefficient = coefficient;
        this.matiere = matiere;
    }


    public int getIdEleve() {
        return idEleve;
    }


    public void setIdEleve(int idEleve) {
        this.idEleve = idEleve;
    }


    public double getNote() {
        return note;
    }


    public void setNote(double note) {
        this.note = note;
    }


    public double getNoteMax() {
        return noteMax;
    }


    public void setNoteMax(double noteMax) {
        this.noteMax = noteMax;
    }


    public double getCoefficient() {
        return coefficient;
    }


    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }


    public int getTrimestre() {
        return trimestre;
    }


    public void setTrimestre(int trimestre) {
        this.trimestre = trimestre;
    }


    public String getMatiere() {
        return matiere;
    }


    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }
    
}