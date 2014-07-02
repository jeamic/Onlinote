package controleur.connexion;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.List;

import modele.base.actionsdao.DAOEleve;
import modele.base.actionsdao.DAOMatiere;
import modele.base.actionsdao.DAOMessagerie;
import modele.base.actionsdao.DAOPersonne;
import modele.base.dao.Matiere;
import modele.base.dao.Messagerie;
import modele.base.dao.Personne;
import modele.utils.ConnexionJDBC;
import modele.vue.dao.DAOVueClasse;
import modele.vue.dao.DAOVueCours;
import modele.vue.dao.DAOVuePersonne;
import modele.vue.dao.DAOVueMessage;
import modele.vue.dao.DAOVueNote;
import modele.vue.dao.DAOVueParent;

import org.apache.log4j.LogManager;

import controleur.administration.GestionClasse;
import controleur.cours.GestionCours;
import controleur.cours.GestionMatiere;
import controleur.cours.GestionNotes;
import controleur.messages.GestionMessages;
import controleur.parent.GestionParent;
import controleur.prof.GestionProf;
import vue.fenetre.ConnexionGUI;

public class Onlinote {
	/**
	 * Log4j logger
	 */
	static org.apache.log4j.Logger log4j =  LogManager.getLogger(ConnexionJDBC.class.getName());
	
	/**
	 * Create the application.
	 */
	private Onlinote() {
		new ConnexionGUI();
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Onlinote();					
				} catch (Exception e) {
					log4j.info(e.getMessage(), e);
				}
			}
		});
	}
	
	public static void relancer() {
	    try {
            new Onlinote();
        } catch (Exception e) {
            log4j.info(e.getMessage(), e);
        }
	    
	}
}
