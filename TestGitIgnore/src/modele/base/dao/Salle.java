package modele.base.dao;

public class Salle implements java.io.Serializable {
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    private int idSalle;
	private String nomSalle;

    public Salle () {
	}
	public Salle (int idSalle, String nomSalle) {
		this.idSalle = idSalle;
		this.nomSalle = nomSalle;
	}
	public int getIdSalle() {
		return idSalle;
	}
	public void setIdSalle(int idSalle) {
		this.idSalle = idSalle;
	}
    public String getNomSalle() {
        return nomSalle;
    }
    public void setNomSalle(String nomSalle) {
        this.nomSalle = nomSalle;
    }
}
