package controleur.connexion;

import java.io.IOException;
import modele.actionsDAO.DAOPersonne;
import modele.baseDAO.*;

public class Connexion {
	
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
		
		if (pers != null) //si la personne existe
		{
			//test de comparaison du mot de passe
			char [] tmp_password = pers.getMot_de_passe().toCharArray();
			boolean mdp_ok = false;
			if ((tmp_password.length != 0) && (tmp_password.length == password.length))
			{
				for (int i = 0; i < password.length; ++i)
				{
					mdp_ok = (password[i] != tmp_password[i]) ? false : true;
					if (mdp_ok == false) break;
				}
				if (mdp_ok){
					
					switch (pers.getType_p()) {
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
			else
			{
				System.out.println("Le mot de passe n'est pas bon");
			}
		}
		else {
			System.out.println("Nom d'utilisateur incorrect");
		}
	}
}
