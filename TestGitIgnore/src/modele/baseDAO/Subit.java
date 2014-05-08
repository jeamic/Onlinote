package modele.baseDAO;

public class Subit implements java.io.Serializable {
	private int id_controle;
	private int id_eleve;
	private int id_cours;
	private double note;
	
	public Subit () {}
	public Subit (int id_controle, int id_eleve, int id_cours, double note) {
		this.id_controle = id_controle;
		this.id_eleve    = id_eleve;
		this.id_cours 	 = id_cours;
		this.note 		 = note;
	}
	public int getId_controle() {
		return id_controle;
	}
	public void setId_controle(int id_controle) {
		this.id_controle = id_controle;
	}
	public int getId_eleve() {
		return id_eleve;
	}
	public void setId_eleve(int id_eleve) {
		this.id_eleve = id_eleve;
	}
	public int getId_cours() {
		return id_cours;
	}
	public void setId_cours(int id_cours) {
		this.id_cours = id_cours;
	}
	public double getNote() {
		return note;
	}
	public void setNote(double note) {
		this.note = note;
	}
	
}
