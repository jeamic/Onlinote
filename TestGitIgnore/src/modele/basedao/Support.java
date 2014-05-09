package modele.basedao;

public class Support implements java.io.Serializable {
	private String nomSupport;
	
	public Support () {
	}
	public Support (String nomSupport) {
		this.nomSupport = nomSupport;
	}
	public String getNomSupport() {
		return nomSupport;
	}
	public void setNomSupport(String nomSupport) {
		this.nomSupport = nomSupport;
	}

}
