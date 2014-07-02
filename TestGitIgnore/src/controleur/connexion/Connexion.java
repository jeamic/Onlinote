package controleur.connexion;


import java.io.IOException;
import java.sql.SQLException;

import modele.base.actionsdao.DAOPersonne;
import modele.base.dao.Personne;
import modele.utils.ConnexionJDBC;
import modele.vue.dao.DAOVuePersonne;

import org.apache.log4j.LogManager;

import controleur.eleve.GestionEleve;
import vue.fenetre.ConnexionGUI;
import vue.fenetre.FenetreAdmin;
import vue.fenetre.FenetreEleve;
import vue.fenetre.FenetreParent;
import vue.fenetre.FenetreProf;


public class Connexion {
	/**
	 * Log4j logger
	 */
	static org.apache.log4j.Logger log4j =  LogManager.getLogger(Connexion.class.getName());
	
	private Connexion () {
	}
	
	/**
	 * Démarre l'application avec un des quatre types de droit
	 * 
	 * @param email
	 * @param password
	 * @throws InterruptedException 
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @wbp.parser.entryPoint
	 */
	public static void startApp(String email, char [] password)/* throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, NullPointerException, Exception */{
		
		DAOPersonne daoPers = new DAOPersonne();

	    Personne pers = daoPers.find(email);
	    
		/* si la personne existe et que son nom n'est pas "vide"*/
		if (pers != null && pers.getNom().length() != 0) { 
			/*test de comparaison du mot de passe*/
			if (isPasswordOk(password, pers)) {
			    ConnexionGUI.fermerFenetre();
				definirTypeConnexion(pers);
			} else {
			    ConnexionGUI.incorrectMDP();
				log4j.error("Le mot de passe n'est pas bon");
			}
		} else {
		    ConnexionGUI.incorrectUser();
			log4j.error("Nom d'utilisateur incorrect");
		}
	}
	
	/**
	 * Ouvre la connexion à la base
	 * 
	 * @throws SQLException
	 */
	public static void openConnexion () throws SQLException {
	    ConnexionJDBC.getInstance().openConnexion();
	}
	
	/**
	 * Détermine quel type d'utilisateur se connecte
	 * 
	 * @param personne
	 */
	private static void definirTypeConnexion (Personne personne) {
		
	    //new DAOVueEleveImpl().getEleveById(personne.getIdPersonne())
		switch (personne.getTypeP()) {
			case "élève":
				FenetreEleve.creerFenetreEleve(personne);
				break;
			case "professeur": 
			    FenetreProf.creerFenetreProf(personne);
				break;
			case "parent": 
			    FenetreParent.creerFenetreParent(personne);
				break;
			case "admin": 
			    FenetreAdmin.creerFenetreAdmin(personne);
				break;
			default:
				break;
		}
	}
	
	/**
	 * Vérifie le mot de passe
	 * 
	 * @param passwordTyped
	 * @param pers
	 * @return
	 */
	private static boolean isPasswordOk (char [] passwordTyped, Personne pers) {
		char [] tmpPassword = pers.getMotDePasse().toCharArray();
		boolean mdpOK = false;
		if ((tmpPassword.length != 0) && (tmpPassword.length == passwordTyped.length)) {
			for (int i = 0; i < passwordTyped.length; ++i) {
				mdpOK = (passwordTyped[i] != tmpPassword[i]) ? false : true;
				if (mdpOK == false)	{
					break;
				}
			}
			if (mdpOK){
				return true;
			}
		}
		return mdpOK;
	}
}
