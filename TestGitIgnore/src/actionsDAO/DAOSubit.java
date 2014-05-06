package actionsDAO;

public class DAOSubit {
	private int id_controle;
	private int id_eleve;
	private String matiere;
	private double note;
	
	public DAOSubit () {}
	public DAOSubit (int id_controle, int id_eleve, String matiere, double note) {
		this.id_controle = id_controle;
		this.id_eleve    = id_eleve;
		this.matiere 	 = matiere;
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
	public String getMatiere() {
		return matiere;
	}
	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}
	public double getNote() {
		return note;
	}
	public void setNote(double note) {
		this.note = note;
	}
	
}
