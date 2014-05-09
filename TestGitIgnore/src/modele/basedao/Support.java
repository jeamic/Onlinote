package modele.basedao;

public class Support implements java.io.Serializable {
	private String nomSupport;
	
	public Support () {
	}
	public Support (String nomSupport) {
		this.nomSupport = nomSupport;
	}
	public String getNom_support() {
		return nomSupport;
	}
	public void setNom_support(String nomSupport) {
		this.nomSupport = nomSupport;
	}
}
