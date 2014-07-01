package modele.base.dao;

public class Controles implements java.io.Serializable{
	
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    private int idControle;
	private String enonce;
	private String corrige;
	private double noteMax;
	private double coefficient;
	private int trimestre;
	private String titre;
	
	public Controles () {
	}
	public Controles (int idControle, String enonce, String corrige, double noteMax, double coefficient, int trimestre, String titre) {
		this.idControle = idControle;
		this.enonce		 = enonce;
		this.corrige 	 = corrige;
		this.noteMax 	 = noteMax;
		this.coefficient = coefficient;
		this.trimestre   = trimestre;
		this.titre       = titre;
	}
	public int getTrimestre() {
        return trimestre;
    }
    public void setTrimestre(int trimestre) {
        this.trimestre = trimestre;
    }
    public int getIdControle() {
		return idControle;
	}
	public void setIdControle(int idControle) {
		this.idControle = idControle;
	}
	public String getEnonce() {
		return enonce;
	}
	public void setEnonce(String enonce) {
		this.enonce = enonce;
	}
	public String getCorrige() {
		return corrige;
	}
	public void setCorrige(String corrige) {
		this.corrige = corrige;
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
    public String getTitre() {
        return titre;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }
	
}
