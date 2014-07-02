package modele.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.LogManager;


public class ConnexionJDBC {
	
	/**
	 * Log4j logger
	 */
	static org.apache.log4j.Logger log4j =  LogManager.getLogger(ConnexionJDBC.class.getName());
	
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
	private Connection connect = null;
	
	/**
	 * Charge les paramètres de la bdd et le driver JDBC
	 */
	private ConnexionJDBC ()  {
		try {
			loadParamBDD();
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (IOException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			log4j.info(e.getMessage(), e);
		}	
	}
	
	/**
	 * Classe pour la gestion du Singleton de connexion à la bdd
	 * 
	 * @author Gir
	 */
	private static class ConnexionJDBCHolder {
		private ConnexionJDBCHolder () {
		}
		private final static ConnexionJDBC INSTANCE = new ConnexionJDBC();
	}
	
	/**
	 * Méthode qui va nous retourner notre instance de connexion à la bdd
	 * et la créer si elle n'existe pas
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws IOException 
	 */
	public static ConnexionJDBC getInstance() {
		return ConnexionJDBCHolder.INSTANCE;
	}
	
	/**
	 * Renvoie la connexion
	 * 
	 * @return
	 */
	public Connection getConnection () {
		return connect;
	}
	
	/**
	 * Ouvre la connexion
	 * 
	 * @throws SQLException
	 */
	public void openConnexion () throws SQLException {
        connect = DriverManager.getConnection(bddAddress, bddLogin, bddPassword);
	}
	
	/**
	 * Ferme la connexion
	 */
	public void closeConnection () {
	    try {
            connect.close();
        } catch (Exception e){
            log4j.info(e.getMessage(), e);
        }
	}
	
	/**
	 * Charger les paramètres de la bdd
	 * @throws IOException
	 */
	private static void loadParamBDD () throws IOException {
		/* construire chemin absolu du fichier de conf*/
		String filePath = new File("").getAbsolutePath();
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(filePath + "/src/Fenetre/conf/bdd"));
		String sCurrentLine;
		String [] bddConf;
		
		/* parcours du fichier de config et extraction des données utiles */
		try {
			while ((sCurrentLine = br.readLine()) != null) {
				if (sCurrentLine.contains("BDD_ADDRESS")){
					bddConf = sCurrentLine.split("\"");
					bddAddress = bddConf[1];
				}
				if (sCurrentLine.contains("BDD_LOGIN")){
					bddConf = sCurrentLine.split("\"");
					bddLogin = bddConf[1];
				}
				if (sCurrentLine.contains("BDD_PASSWORD")){
					bddConf = sCurrentLine.split("\"");
					bddPassword = bddConf[1];
				}
			}
		} catch (Exception e){
		    log4j.info(e.getMessage(), e);
		}
	}
}
