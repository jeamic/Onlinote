package Fenetre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class ConnexionClick {
	
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
			conn = DriverManager.getConnection("jdbc:mysql://localhost/onlinote", "root", "");
			
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
			
			//return null;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			
			//return null;
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
				
//				java.sql.Statement stat = conn.createStatement();
//				java.sql.ResultSet res = stat.executeQuery("Select mot_de_passe from personne where email = " + Email);

				while (res.next())
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
