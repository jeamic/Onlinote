package modele.base.dao;

public class Subit_examen implements java.io.Serializable {
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    private int idControle;
	private int idEleve;
	private int idCours;
	private double note;
	
	public Subit_examen () {
	}
	public Subit_examen (int idControle, int idEleve, int idCours, double note) {
		this.idControle = idControle;
		this.idEleve    = idEleve;
		this.idCours 	 = idCours;
		this.note 		 = note;
	}
	public int getidControle() {
		return idControle;
	}
	public void setidControle(int idControle) {
		this.idControle = idControle;
	}
	public int getidEleve() {
		return idEleve;
	}
	public void setidEleve(int idEleve) {
		this.idEleve = idEleve;
	}
	public int getidCours() {
		return idCours;
	}
	public void setidCours(int idCours) {
		this.idCours = idCours;
	}
	public double getNote() {
		return note;
	}
	public void setNote(double note) {
		this.note = note;
	}
}
