package modele.base.dao;

public class Eleve implements java.io.Serializable {
	
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    private int idParent;
	private int idClasse;
	private int idEleve;
	
	public Eleve () {
	}
	public Eleve (int idParent, int idClasse, int idEleve) {
		this.idParent = idParent;
		this.idClasse = idClasse;
		this.idEleve  = idEleve;
	}
	public int getidParent() {
		return idParent;
	}
	public void setidParent(int idParent) {
		this.idParent = idParent;
	}
	public int getidClasse() {
		return idClasse;
	}
	public void setidClasse(int idClasse) {
		this.idClasse = idClasse;
	}
	public int getidEleve() {
		return idEleve;
	}
	public void setidEleve(int idEleve) {
		this.idEleve = idEleve;
	}
	
	
}
