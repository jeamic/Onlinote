package modele.basedao;

public class EstSpecialise {
	private int idProf;
	private String specialite;
	
	public EstSpecialise () {
	}
	public EstSpecialise (int idProf, String specialite) {
		this.idProf = idProf;
		this.specialite    = specialite;
	}
	public int getId_prof() {
		return idProf;
	}
	public void setId_prof(int idProf) {
		this.idProf = idProf;
	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	
}
