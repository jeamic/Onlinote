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
			conn = DriverManager.getConnection("jdbc:mysql://localhost/Onlinote", "root", "");
			
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
	
	public static void clicked(String Id, String Password) {
		Connection conn = connexion();
		
		if(conn != null)
			try {
				
				java.sql.Statement stat = conn.createStatement();
				java.sql.ResultSet res = stat.executeQuery("Select Password from utilisateur where id = " + Id);
				
				while (res.next())
				{
					if (res.getString(1).equals(Password))
						{
							System.out.println("Connecté");
							MainFenetre window = new MainFenetre();							
							//test.click();
						}
					else
					System.out.println("Le mot de passe n'est pas bon");
				}
				
				System.out.println("Connexion échouée");
				
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else
			System.out.println("null !");
		
	}
	
}
