package controleur.connexion;


import java.io.IOException;

import modele.actionsdao.DAOPersonne;
import modele.basedao.Personne;

import org.apache.log4j.LogManager;

import vue.fenetre.ConnexionGUI;
import vue.fenetre.FenetreParent;


public class Connexion {
	/**
	 * Log4j logger
	 */
	static org.apache.log4j.Logger log4j =  LogManager.getLogger(Connexion.class.getName());
	
	private Connexion () {
	}
	
	/* Démarre l'application avec un des quatre types de droit*/
	/**
	 * @param email
	 * @param password
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @wbp.parser.entryPoint
	 */
	public static void startApp(String email, char [] password) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		
		DAOPersonne daoPers = new DAOPersonne();
		Personne pers = daoPers.find(email);
		/* si la personne existe */
		if (pers != null) { 
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
	
	private static void definirTypeConnexion (Personne personne) {
		
		switch (personne.getTypeP()) {
			case "élève":
				FenetreParent.creerFenetreParent(personne);
				break;
			case "professeur": 
			    FenetreParent.creerFenetreParent(personne);
				break;
			case "parent": 
			    FenetreParent.creerFenetreParent(personne);
				break;
			case "admin": 
			    FenetreParent.creerFenetreParent(personne);
				break;
			default:
				break;
		}
	}
	
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
