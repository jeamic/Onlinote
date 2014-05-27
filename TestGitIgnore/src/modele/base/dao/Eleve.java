package modele.base.dao;

public class Eleve implements java.io.Serializable {
	
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    private int idParent1;
    private int idParent2;
	private int idClasse;
	private int idEleve;
	
	public Eleve () {
	}
	public Eleve (int idParent1, int idParent2, int idClasse, int idEleve) {
	    this.idParent1 = idParent1;
	    this.idParent2 = idParent2;
		this.idClasse = idClasse;
		this.idEleve  = idEleve;
	}

	public int getIdParent1() {
        return idParent1;
    }
    public void setIdParent1(int idParent1) {
        this.idParent1 = idParent1;
    }
    public int getIdParent2() {
        return idParent2;
    }
    public void setIdParent2(int idParent2) {
        this.idParent2 = idParent2;
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
