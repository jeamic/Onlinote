package modele.base.dao;

public class Enseigne implements java.io.Serializable {
	
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
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
	public int getIdCours() {
		return idCours;
	}
	public void setIdCours(int idCours) {
		this.idCours = idCours;
	}
	public int getIdClasse() {
		return idClasse;
	}
	public void setIdClasse(int idClasse) {
		this.idClasse = idClasse;
	}
	public int getIdPersonne() {
		return idPersonne;
	}
	public void setIdPersonne(int idPersonne) {
		this.idPersonne = idPersonne;
	}

}
