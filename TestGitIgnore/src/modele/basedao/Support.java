package modele.basedao;

public class Support implements java.io.Serializable {
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
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
