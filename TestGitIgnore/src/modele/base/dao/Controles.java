package modele.base.dao;

public class Controles implements java.io.Serializable{
	
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    private int idControle;
	private String enonce;
	private String corrige;
	private int noteMax;
	private String coefficient;
	private String trimestre;
	
	public Controles () {
	}
	public Controles (int idControle, String enonce, String corrige, int noteMax, String coefficient, String trimestre) {
		this.idControle = idControle;
		this.enonce		 = enonce;
		this.corrige 	 = corrige;
		this.noteMax 	 = noteMax;
		this.coefficient = coefficient;
		this.trimestre   = trimestre;
	}
	public String getTrimestre() {
        return trimestre;
    }
    public void setTrimestre(String trimestre) {
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
	public int getNoteMax() {
		return noteMax;
	}
	public void setNoteMax(int noteMax) {
		this.noteMax = noteMax;
	}
	public String getCoefficient() {
		return coefficient;
	}
	public void setCoefficient(String coefficient) {
		this.coefficient = coefficient;
	}
	
}