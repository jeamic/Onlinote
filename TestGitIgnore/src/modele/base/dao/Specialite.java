package modele.base.dao;

public class Specialite implements java.io.Serializable {
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String specialite;
	
	public Specialite () {
	}
	public Specialite (String specialite) {
		this.specialite = specialite;
	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
}
