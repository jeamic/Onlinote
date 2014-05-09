package modele.basedao;

public class Eleve implements java.io.Serializable {
	
	private int idParent;
	private int idClasse;
	private int idEleve;
	
	public Eleve () {
	}
	public Eleve (int idParent, int idClasse, int idEleve) {
		this.idParent = idParent;
		this.idClasse = idClasse;
		this.idEleve  = idEleve;
	}
	public int getId_parent() {
		return idParent;
	}
	public void setId_parent(int idParent) {
		this.idParent = idParent;
	}
	public int getId_classe() {
		return idClasse;
	}
	public void setId_classe(int idClasse) {
		this.idClasse = idClasse;
	}
	public int getId_eleve() {
		return idEleve;
	}
	public void setId_eleve(int idEleve) {
		this.idEleve = idEleve;
	}
	
	
}
