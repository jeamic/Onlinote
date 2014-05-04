package Fenetre;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class Connexion {
	
	/* Connexion à la BDD */
	public static Connection connexion() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		Connection conn = null;
		try
		{
			/* objet de connexion à la base */
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			/* construire chemin absolu du fichier de conf*/
			String filePath = new File("").getAbsolutePath();
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader(filePath + "/src/Fenetre/conf/bdd"));
			String sCurrentLine;
			/* Macros de connexion */
			String BDD_ADDRESS ="";
			String BDD_LOGIN ="";
			String BDD_PASSWORD ="";
			String [] BDD_CONF;
 
			/* parcours du fichier de config et extraction des données utiles */
			while ((sCurrentLine = br.readLine()) != null) {
				
				if (sCurrentLine.contains("BDD_ADDRESS"))
				{
					BDD_CONF = sCurrentLine.split("\"");
					BDD_ADDRESS = BDD_CONF[1];
					continue;
				}
				if (sCurrentLine.contains("BDD_LOGIN"))
				{
					BDD_CONF = sCurrentLine.split("\"");
					BDD_LOGIN = BDD_CONF[1];
					continue;
				}
				if (sCurrentLine.contains("BDD_PASSWORD"))
				{
					BDD_CONF = sCurrentLine.split("\"");
					BDD_PASSWORD = BDD_CONF[1];
					continue;
				}
			}
			/* connexion */
			conn = DriverManager.getConnection(BDD_ADDRESS, BDD_LOGIN, BDD_PASSWORD);
		}
		catch(SQLException e)
		{
			System.out.println("sql exception");
			while (e!=null)
			{
				System.out.println(e.getErrorCode());
				System.out.println(e.getMessage());
				System.out.println(e.getSQLState());
				e.printStackTrace();
				e=e.getNextException();
			}
		}
		return conn;
	}
	
	/* Démarre l'application avec un des quatre types de droit*/
	public static String startApp(String Email, char [] Password) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		conn = connexion();
		String type_connexion = "";
		char [] tmp_password = null;

		if(conn != null)
		{
			try 
			{
				stmt = (PreparedStatement) conn.prepareStatement("Select mot_de_passe from personne where email = ?");
				stmt.setString(1, Email);
				ResultSet res = (ResultSet) stmt.executeQuery();
				
				if (res.first())
				{
					boolean mdp_ok = false;
					tmp_password = res.getString("mot_de_passe").toCharArray();
					if (tmp_password.length != 0)
					{
						for (int i = 0; i < Password.length; ++i)
						{
							if (Password[i] != tmp_password[i])
							{
								mdp_ok = false;
								break;
							}
							else
							{
								mdp_ok = true;
							}
						}
					}
					if (mdp_ok)
					{
						System.out.println("Connecté");
						stmt = null;
						res = null;
						stmt = (PreparedStatement) conn.prepareStatement("Select type_p from personne where email = ?");
						stmt.setString(1, Email);
						res = (ResultSet) stmt.executeQuery();
						
						if (res.first())
						{
							System.out.println(res.getString("type_p"));
							type_connexion = res.getString("type_p");
						}
						else
						{
							System.out.println("Type de connexion inconnu");
						}
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
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Connexion échouée");
			}
		}
		else
		{
			System.out.println("null !");
		}
		return type_connexion;
	}
	
}
