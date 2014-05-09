package modele.basedao;

public class Documente implements java.io.Serializable {
	private int idSupport;
	private String nomSupport;
	
	public Documente () {
	}
	public Documente (int idSupport, String nomSupport) {
		this.idSupport  = idSupport;
		this.nomSupport = nomSupport;
	}
	public int getIdSupport() {
		return idSupport;
	}
	public void setIdSupport(int idSupport) {
		this.idSupport = idSupport;
	}
	public String getNom_support() {
		return nomSupport;
	}
	public void setNom_support(String nomSupport) {
		this.nomSupport = nomSupport;
	}

}
