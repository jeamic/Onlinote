package controleur.connexion;

import java.awt.EventQueue;

import modele.actionsdao.DAOEleve;
import modele.basedao.Eleve;
import modele.bddconnect.ConnexionJDBC;

import org.apache.log4j.LogManager;

import controleur.eleve.GestionEleve;
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
		
		
		/*
		 * @test get all eleve
		 * 
		GestionEleve test = new GestionEleve();
		test.GetAllEleve();
		
		Eleve el = new Eleve();
		
		DAOEleve eleve = new DAOEleve();
		el = eleve.find("qu.girard@gmail.com");
		
		System.out.println(el);*/
		
		
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
