package modele.base.dao;

public class EstSpecialise {
	private int idProf;
	private String specialite;
	
	public EstSpecialise () {
	}
	public EstSpecialise (int idProf, String specialite) {
		this.idProf = idProf;
		this.specialite    = specialite;
	}
	public int getIdProf() {
		return idProf;
	}
	public void setIdProf(int idProf) {
		this.idProf = idProf;
	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	
}
