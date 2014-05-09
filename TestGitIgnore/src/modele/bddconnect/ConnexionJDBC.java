package modele.bddconnect;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;
import com.mysql.jdbc.Driver;


public class ConnexionJDBC {
	
	
	/**
	 * URL de connexion
	 */
	private static String bddAddress = "";
	/**
	 * Nom du user
	 */
	private static String bddLogin = "";
	/**
	 * Mot de passe du user
	 */
	private static String bddPassword = "";
	/**
	 * Objet Connection
	 */
	private static Connection connect = null;
	
	private ConnexionJDBC ()  {
		try {
			LoadParamBDD();
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connect = DriverManager.getConnection(bddAddress, bddLogin, bddPassword);
		} catch (IOException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new RuntimeException("context", e);
		} catch (SQLException e) {
			Logger.getLogger(Integer.toString(e.getErrorCode()));
			Logger.getLogger(e.getMessage());
			Logger.getLogger(e.getSQLState());
			e.printStackTrace();
			SQLException e2=e.getNextException();
		}	
	}
	
	private static class ConnexionJDBCHolder {
		private final static Connection instance = new ConnexionJDBC().connect;
	}
	
	/**
	 * Méthode qui va nous retourner notre instance de connexion à la bdd
	 * et la créer si elle n'existe pas...
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws IOException 
	 */
	public static Connection getInstance() {
		return (Connection) ConnexionJDBCHolder.instance;
	}
	
	
	/**
	 * Charger les paramètres de la bdd
	 * @throws IOException
	 */
	private static void LoadParamBDD () throws IOException {
		/* construire chemin absolu du fichier de conf*/
		String filePath = new File("").getAbsolutePath();
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(filePath + "/src/Fenetre/conf/bdd"));
		String sCurrentLine;
		String [] bddConf;
		
		/* parcours du fichier de config et extraction des données utiles */
		try {
			while ((sCurrentLine = br.readLine()) != null) {
				if (sCurrentLine.contains("bddAddress")){
					bddConf = sCurrentLine.split("\"");
					bddAddress = bddConf[1];
					continue;
				}
				if (sCurrentLine.contains("bddLogin")){
					bddConf = sCurrentLine.split("\"");
					bddLogin = bddConf[1];
					continue;
				}
				if (sCurrentLine.contains("bddPassword")){
					bddConf = sCurrentLine.split("\"");
					bddPassword = bddConf[1];
					continue;
				}
			}
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
