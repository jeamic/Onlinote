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
	private Date heureDebut;
	private Time duree;
	
	public Cours () {
	}
	public Cours (int idCours, String matiere, int idSalle, String commentaire, Date heureDebut, Time duree) {
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
	public Date getheureDebut() {
		return heureDebut;
	}
	public void setheureDebut(Date heureDebut) {
		this.heureDebut = heureDebut;
	}
	public Time getDuree() {
		return duree;
	}
	public void setDuree(Time duree) {
		this.duree = duree;
	}
	
}
