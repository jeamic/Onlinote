package modele.basedao;

public class Subit implements java.io.Serializable {
	private int idControle;
	private int idEleve;
	private int idCours;
	private double note;
	
	public Subit () {
	}
	public Subit (int idControle, int idEleve, int idCours, double note) {
		this.idControle = idControle;
		this.idEleve    = idEleve;
		this.idCours 	 = idCours;
		this.note 		 = note;
	}
	public int getId_controle() {
		return idControle;
	}
	public void setId_controle(int idControle) {
		this.idControle = idControle;
	}
	public int getId_eleve() {
		return idEleve;
	}
	public void setId_eleve(int idEleve) {
		this.idEleve = idEleve;
	}
	public int getId_cours() {
		return idCours;
	}
	public void setId_cours(int idCours) {
		this.idCours = idCours;
	}
	public double getNote() {
		return note;
	}
	public void setNote(double note) {
		this.note = note;
	}
	
}
