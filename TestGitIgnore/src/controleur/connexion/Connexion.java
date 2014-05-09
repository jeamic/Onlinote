package controleur.connexion;

import java.io.IOException;
import java.util.logging.Logger;
import java.util.zip.DeflaterOutputStream;

import modele.actionsdao.DAOPersonne;
import modele.basedao.*;

import org.apache.log4j.*;


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
		
		if (pers != null) { //si la personne existe
			//test de comparaison du mot de passe
			if (isPasswordOk(password, pers)) {
				definirTypeConnexion(pers.getTypeP());
			} else {
				log4j.error("Le mot de passe n'est pas bon");
			}
		} else {
			log4j.error("Nom d'utilisateur incorrect");
		}
	}
	
	private static void definirTypeConnexion (String type) {
		switch (type) {
			case "élève": 
				
				new TypeConnexion("élève");
				break;
			case "professeur": 
				new TypeConnexion("professeur");
				break;
			case "parent": 
				new TypeConnexion("parent");
				break;
			case "admin": 
				new TypeConnexion("admin");
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
