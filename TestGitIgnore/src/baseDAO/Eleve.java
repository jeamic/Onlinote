package baseDAO;

public class Eleve {
	
	private int id_parent;
	private int id_classe;
	private int id_eleve;
	
	public Eleve () {}
	public Eleve (int id_parent, int id_classe, int id_eleve) {
		this.id_parent = id_parent;
		this.id_classe = id_classe;
		this.id_eleve  = id_eleve;
	}
	public int getId_parent() {
		return id_parent;
	}
	public void setId_parent(int id_parent) {
		this.id_parent = id_parent;
	}
	public int getId_classe() {
		return id_classe;
	}
	public void setId_classe(int id_classe) {
		this.id_classe = id_classe;
	}
	public int getId_eleve() {
		return id_eleve;
	}
	public void setId_eleve(int id_eleve) {
		this.id_eleve = id_eleve;
	}
	
	
}
