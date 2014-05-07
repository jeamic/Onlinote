package controleur.connexion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import modele.actionsDAO.DAOPersonne;
import modele.baseDAO.*;
import modele.bddConnect.*;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class Connexion {
	
	/* Démarre l'application avec un des quatre types de droit*/
	public static void startApp(String email, char [] password) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		
		DAOPersonne DAOPers = new DAOPersonne();
		//DAOPersonne.find(email);
		
		Connection conn = null;
		PreparedStatement stmt = null;
		conn = ConnexionJDBC.getInstance();
		String type_connexion = "";
		char [] tmp_password = null;
		if(conn != null)
		{
			try 
			{
				stmt = (PreparedStatement) conn.prepareStatement("Select mot_de_passe from personne where email = ?");
				stmt.setString(1, email);
				ResultSet res = (ResultSet) stmt.executeQuery();
				
				
				
				if (res.first())
				{
					boolean mdp_ok = false;
					tmp_password = res.getString("mot_de_passe").toCharArray();
					if ((tmp_password.length != 0) && (tmp_password.length == password.length))
					{
						for (int i = 0; i < password.length; ++i)
						{
							mdp_ok = (password[i] != tmp_password[i]) ? false : true;
							if (mdp_ok == false) break;
						}
					}
					if (mdp_ok)
					{
						System.out.println("Connecté");
						stmt = null;
						res = null;
						stmt = (PreparedStatement) conn.prepareStatement("Select type_p from personne where email = ?");
						stmt.setString(1, email);
						res = (ResultSet) stmt.executeQuery();
						type_connexion = (res.first()) ?  res.getString("type_p") : "Type de connexion inconnu";
					}
					else
					{
						System.out.println("Le mot de passe n'est pas bon");
					}
				}
				else
				{
					System.out.println("Nom d'utilisateur incorrect");
				}
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Connexion échouée");
			}
		}
		
		switch (type_connexion) {
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
