package modele.basedao;

import java.sql.Date;
import java.sql.Time;

public class Cours implements java.io.Serializable {
	
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
	public int getId_cours() {
		return idCours;
	}
	public void setId_cours(int idCours) {
		this.idCours = idCours;
	}
	public String getMatiere() {
		return matiere;
	}
	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}
	public int getId_salle() {
		return idSalle;
	}
	public void setId_salle(int idSalle) {
		this.idSalle = idSalle;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public Date getHeure_debut() {
		return heureDebut;
	}
	public void setHeure_debut(Date heureDebut) {
		this.heureDebut = heureDebut;
	}
	public Time getDuree() {
		return duree;
	}
	public void setDuree(Time duree) {
		this.duree = duree;
	}
	
}
