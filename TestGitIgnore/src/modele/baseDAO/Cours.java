package modele.baseDAO;

import java.sql.Date;
import java.sql.Time;

public class Cours implements java.io.Serializable {
	
	private String matiere;
	private int id_salle;
	private String libelle;
	private String commentaire;
	private Date heure_debut;
	private Time duree;
	
	public Cours () {}
	public Cours (String matiere, int id_salle, String libelle, String commentaire, Date heure_debut, Time duree) {
		this.matiere 	 = matiere;
		this.id_salle 	 = id_salle;
		this.libelle 	 = libelle;
		this.commentaire = commentaire;
		this.heure_debut = heure_debut;
		this.duree 		 = duree;
	}
	public String getMatiere() {
		return matiere;
	}
	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}
	public int getId_salle() {
		return id_salle;
	}
	public void setId_salle(int id_salle) {
		this.id_salle = id_salle;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public Date getHeure_debut() {
		return heure_debut;
	}
	public void setHeure_debut(Date heure_debut) {
		this.heure_debut = heure_debut;
	}
	public Time getDuree() {
		return duree;
	}
	public void setDuree(Time duree) {
		this.duree = duree;
	}
	
	
}
