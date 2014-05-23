package modele.base.dao;

public class Suit implements java.io.Serializable {
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    private int idEleve;
	private String libelle;
	
	public Suit () {
	}
	public Suit (int idEleve, String libelle) {
		this.idEleve = idEleve;
		this.libelle  = libelle;
	}
	public int getIdEleve() {
		return idEleve;
	}
	public void setIdEleve(int idEleve) {
		this.idEleve = idEleve;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}
