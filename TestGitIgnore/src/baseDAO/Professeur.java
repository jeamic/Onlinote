package baseDAO;

public class Professeur {
	private int id_prof;
	private String specialite;
	
	public Professeur () {}
	public Professeur (int id_prof, String specialite) {
		this.id_prof 	= id_prof;
		this.specialite = specialite;
	}
	public int getId_prof() {
		return id_prof;
	}
	public void setId_prof(int id_prof) {
		this.id_prof = id_prof;
	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	
	
}
