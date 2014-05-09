package controleur.connexion;

import java.io.IOException;

import java.util.logging.Logger;

import modele.actionsdao.DAOPersonne;
import modele.basedao.*;
import org.apache.log4j.*;


public class Connexion {
	/**
	 * Log4j logger
	 */
	static org.apache.log4j.Logger log4j =  LogManager.getLogger(Connexion.class.getName());
	
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
		
		DAOPersonne DAOPers = new DAOPersonne();
		Personne pers = DAOPers.find(email);
		
		if (pers != null) { //si la personne existe
			//test de comparaison du mot de passe
			char [] tmp_password = pers.getMotDePasse().toCharArray();
			boolean mdpOK = false;
			if ((tmp_password.length != 0) && (tmp_password.length == password.length)) {
				for (int i = 0; i < password.length; ++i) {
					mdpOK = (password[i] != tmp_password[i]) ? false : true;
					if (mdpOK == false)	{
						break;
					}
				}
				if (mdpOK){
					switch (pers.getTypeP()) {
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
			}
			else {
				log4j.error("Le mot de passe n'est pas bon");
			}
		}
		else {
			log4j.error("Nom d'utilisateur incorrect");
		}
	}
}
