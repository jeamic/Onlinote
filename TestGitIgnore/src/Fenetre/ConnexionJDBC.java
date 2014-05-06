package Fenetre;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnexionJDBC {
	
	private static volatile ConnexionJDBC instance = null;
	/**
	 * URL de connexion
	 */
	private static String BDD_ADDRESS = "";
	/**
	 * Nom du user
	 */
	private static String BDD_LOGIN = "";
	/**
	 * Mot de passe du user
	 */
	private static String BDD_PASSWORD = "";
	/**
	 * Objet Connection
	 */
	private static Connection connect;
	
	private ConnexionJDBC () throws IOException, SQLException {
		try {
			LoadParamBDD();
			connect = DriverManager.getConnection(BDD_ADDRESS, BDD_LOGIN, BDD_PASSWORD);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			System.out.println(e.getErrorCode());
			System.out.println(e.getMessage());
			System.out.println(e.getSQLState());
			e.printStackTrace();
			e=e.getNextException();
		}
	}
	

	private static void LoadParamBDD () throws IOException {
		/* construire chemin absolu du fichier de conf*/
		String filePath = new File("").getAbsolutePath();
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(filePath + "/src/Fenetre/conf/bdd"));
		String sCurrentLine;
		String [] BDD_CONF;
		
		/* parcours du fichier de config et extraction des données utiles */
		try {
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
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Méthode qui va nous retourner notre instance
	 * et la créer si elle n'existe pas...
	 * @return
	 * @throws IOException 
	 */
	public static Connection getInstance() {
		if(ConnexionJDBC.instance == null){
			try {
				synchronized (ConnexionJDBC.class) {
					if (ConnexionJDBC.instance == null) {
						new ConnexionJDBC();
					}
				}
				
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}
		}		
		return connect;	
	}	
}
