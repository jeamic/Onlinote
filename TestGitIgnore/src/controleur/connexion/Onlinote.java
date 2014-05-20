package controleur.connexion;

import java.awt.EventQueue;
import java.util.List;

import modele.actionsdao.DAOEleve;
import modele.actionsdao.DAOMatiere;
import modele.basedao.Eleve;
import modele.basedao.Matiere;
import modele.controleur.NoteModele;
import modele.utils.ConnexionJDBC;

import org.apache.log4j.LogManager;

import controleur.cours.GestionCours;
import controleur.eleve.GestionEleve;
import controleur.notes.GestionNotes;
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
		
		/*
		 * @test getCours
		 * 
		 */
		/*GestionCours gestCours = new GestionCours();
		List<List<String>> bla = gestCours.getCours(3, "2014-05-15 10:00:01");
		
		System.out.println(bla);*/
		
		/*
		 * @ test getNotes
		 * 
		 */
		/*DAOEleve daoEleve = new DAOEleve();
		List<List<String>> bli = daoEleve.getNotes(3, "Maths");
		System.out.println(bli);*/
		
		
		/*
		 * 
		 * @test getMatieres
		 */
		DAOMatiere daoMatiere = new DAOMatiere();
		List<Matiere> listeMat = daoMatiere.getMatieres(3);
		for (int i = 0; i < listeMat.size(); ++i) {
		    System.out.println(listeMat.get(i).getMatiere());
		}
		
		DAOEleve daoEleve = new DAOEleve();
		List<NoteModele> test = daoEleve.getNotes(3, "Maths", 1);
		
		for (int i = 0; i < test.size(); i++){
		    System.out.println(test.get(i).getNoteMax());
		}
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
