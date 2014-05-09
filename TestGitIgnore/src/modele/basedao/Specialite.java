package modele.basedao;

public class Specialite implements java.io.Serializable {
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
