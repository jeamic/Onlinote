package baseDAO;

public class Controles {
	
	private int id_controle;
	private String enonce;
	private String corrige;
	private int note_max;
	private String coefficient;
	
	public Controles () {}
	public Controles (int id_controle, String enonce, String corrige, int note_max, String coefficient) {
		this.id_controle = id_controle;
		this.enonce		 = enonce;
		this.corrige 	 = corrige;
		this.note_max 	 = note_max;
		this.coefficient = coefficient;
	}
	public int getId_controle() {
		return id_controle;
	}
	public void setId_controle(int id_controle) {
		this.id_controle = id_controle;
	}
	public String getEnonce() {
		return enonce;
	}
	public void setEnonce(String enonce) {
		this.enonce = enonce;
	}
	public String getCorrige() {
		return corrige;
	}
	public void setCorrige(String corrige) {
		this.corrige = corrige;
	}
	public int getNote_max() {
		return note_max;
	}
	public void setNote_max(int note_max) {
		this.note_max = note_max;
	}
	public String getCoefficient() {
		return coefficient;
	}
	public void setCoefficient(String coefficient) {
		this.coefficient = coefficient;
	}
	
	
}
