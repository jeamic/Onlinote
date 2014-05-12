package modele.basedao;

public class Salle implements java.io.Serializable {
	private int idSalle;
	private String nomSalle;
	
	public String getNomSalle() {
        return nomSalle;
    }
    public void setNomSalle(String nomSalle) {
        this.nomSalle = nomSalle;
    }
    public Salle () {
	}
	public Salle (int idSalle) {
		this.idSalle = idSalle;
	}
	public int getIdSalle() {
		return idSalle;
	}
	public void setIdSalle(int idSalle) {
		this.idSalle = idSalle;
	}	
}
