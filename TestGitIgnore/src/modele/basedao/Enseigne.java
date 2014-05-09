package modele.basedao;

public class Enseigne implements java.io.Serializable {
	
	private int idCours;
	private int idClasse;
	private int idPersonne;
	
	public Enseigne () {
	}
	public Enseigne (int idCours, int idClasse, int idPersonne) {
		this.idCours = idCours;
		this.idClasse 	= idClasse;
		this.idPersonne 	= idPersonne;
	}
	public int getId_cours() {
		return idCours;
	}
	public void setId_cours(int idCours) {
		this.idCours = idCours;
	}
	public int getId_classe() {
		return idClasse;
	}
	public void setId_classe(int idClasse) {
		this.idClasse = idClasse;
	}
	public int getId_personne() {
		return idPersonne;
	}
	public void setId_personne(int idPersonne) {
		this.idPersonne = idPersonne;
	}
	
}
