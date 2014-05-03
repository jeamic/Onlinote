package Fenetre;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class ConnexionClick {
	
	/* Classe de connexion à la BDD */
	public static Connection connexion() {
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		Connection conn = null;
		try
		{
			@SuppressWarnings("resource")
			String filePath = new File("").getAbsolutePath();
			BufferedReader br = new BufferedReader(new FileReader(filePath + "/src/Fenetre/conf/bdd"));
			String sCurrentLine;
			String BDD_ADDRESS ="";
			String BDD_LOGIN ="";
			String BDD_PASSWORD ="";
			String [] BDD_CONF;
 
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
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void clicked(String Email, String Password) {
		
		Connection conn = connexion();
		PreparedStatement stmt = null;
		
		if(conn != null)
		{
			try {
				stmt = (PreparedStatement) conn.prepareStatement("Select mot_de_passe from personne where email = ?");
				stmt.setString(1, Email);
				ResultSet res = (ResultSet) stmt.executeQuery();
				
				if (res.first())
				{
					
					if (res.getString("mot_de_passe").equals(Password))
					{
						System.out.println("Connecté");
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
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Connexion échouée");
			}
		}
		else
		{
			System.out.println("null !");
		}
		
	}
	
}
