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
import modele.vue.dao.DAOVueEleve;
import modele.vue.dao.DAOVueMessage;
import modele.vue.dao.DAOVueNote;
import modele.vue.dao.DAOVueParent;

import org.apache.log4j.LogManager;

import controleur.administration.GestionClasse;
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
		/*
		DAOMatiere daoMatiere = new DAOMatiere();
		List<Matiere> listeMat = daoMatiere.getMatieres(3);
		for (int i = 0; i < listeMat.size(); ++i) {
		    System.out.println(listeMat.get(i).getMatiere());
		}
		
		DAOEleve daoEleve = new DAOEleve();
		List<DAOVueNote> test = daoEleve.getNotes(3, "Maths", 1);
		
		for (int i = 0; i < test.size(); i++){
		    System.out.println(test.get(i).getNoteMax());
		}
		
		*/
		
		/* test message 
        try {
            ConnexionJDBC.getInstance().openConnexion();
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
		
		GestionMessages messagerie = new GestionMessages();
		DAOVueMessage daoMess = new DAOVueMessage();
		daoMess.setExpediteur("malo.cou@email.com");
		daoMess.setObjet("Bienvenue dans la messagerie Onlinote");
		daoMess.setContenu("Quelques conseils pour utiliser la boite de réception");
		daoMess.setDestinataires("malo.cou@email.com;max.affine@email.com");
		messagerie.envoyerMessage(daoMess);
		*/
		
		
		/* test getEnfants 
		try {
            Connexion.openConnexion();
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
		
		GestionParent gestPar = new GestionParent();
		DAOPersonne daoPersonne = new DAOPersonne();
		Personne personne = daoPersonne.find("malo.cou@email.com");
		DAOVueParent daoVueParent = gestPar.getEnfants(personne);
		
        for (int i = 0; i < daoVueParent.getListeEnfants().size(); ++i) {
            System.out.println(daoVueParent.getListeEnfants().get(i).getNom());
        }
	    / * fin test getEnfants() */
		
		
		/* test getMsg recus et envoyes */
	     /* try {
	            Connexion.openConnexion();
	        } catch (SQLException e1) {
	            // TODO Auto-generated catch block
	            e1.printStackTrace();
	        }
	      
	      GestionMessages messagerie = new GestionMessages();
	      List<DAOVueMessage> daoVueMessage = messagerie.getMessagesEnvoyes(2);
	      
	        for (int i = 0; i < daoVueMessage.size(); ++i) {
	            System.out.println(daoVueMessage.get(i));
	        }
	        
	          List<DAOVueMessage> daoVueMessager = messagerie.getMessagesRecus(2);
	          
	            for (int i = 0; i < daoVueMessager.size(); ++i) {
	                System.out.println(daoVueMessager.get(i));
	            }*/
		
		/* test getNotes() */
		/*
		try {
            Connexion.openConnexion();
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
		GestionNotes gestNotes = new GestionNotes();
		List <DAOVueNote> notes = gestNotes.getNotes(3, 1, "Maths");
		
		for (int i = 0; i < notes.size(); ++i) {
            System.out.println(notes.get(i));
        }
		*/
		/* test getMatiere */
		/*try {
            Connexion.openConnexion();
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
		
		GestionMatiere gestMat = new GestionMatiere();
		List<Matiere> listeMat = gestMat.getAllMatieres();
		
		for (int i = 0; i < listeMat.size(); ++i) {
            System.out.println(listeMat.get(i).getMatiere());
        }*/
		
		/* test getEleves et getClasses */
		/*try {
            Connexion.openConnexion();
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
		
		GestionProf gestProf = new GestionProf();
		List<DAOVueClasse> listeClasses = gestProf.getClasses(1);
		
		GestionClasse gestClasse = new GestionClasse();
		for(int i = 0; i < listeClasses.size(); ++i) {
		    System.out.println(gestClasse.getEleves("3B").get(i).getPrenom());
		}*/
		
		/* test suppression messages */
		/*try {
            Connexion.openConnexion();
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
		GestionMessages gestMess = new GestionMessages();
		gestMess.supprimerMessage(3, 3, 0);*/
		
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
