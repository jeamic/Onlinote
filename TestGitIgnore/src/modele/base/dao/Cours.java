package modele.base.dao;

import java.sql.Date;
import java.sql.Time;

public class Cours implements java.io.Serializable {
	
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    private int idCours;
	private String matiere;
	private int idSalle;
	private String commentaire;
	private String heureDebut;
	private String duree;
	
	public Cours () {
	}
	public Cours (int idCours, String matiere, int idSalle, String commentaire, String heureDebut, String duree) {
		this.matiere 	 = matiere;
		this.idSalle 	 = idSalle;
		this.idCours 	 = idCours;
		this.commentaire = commentaire;
		this.heureDebut = heureDebut;
		this.duree 		 = duree;
	}
	public int getidCours() {
		return idCours;
	}
	public void setidCours(int idCours) {
		this.idCours = idCours;
	}
	public String getMatiere() {
		return matiere;
	}
	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}
	public int getidSalle() {
		return idSalle;
	}
	public void setidSalle(int idSalle) {
		this.idSalle = idSalle;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public String getheureDebut() {
		return heureDebut;
	}
	public void setheureDebut(String heureDebut) {
		this.heureDebut = heureDebut;
	}
	public String getDuree() {
		return duree;
	}
	public void setDuree(String duree) {
		this.duree = duree;
	}
	
}
