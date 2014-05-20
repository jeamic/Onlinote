package controleur.cours;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;

import modele.utils.ConnexionJDBC;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import controleur.connexion.Connexion;

public class GestionCours {
    
    /**
     * Log4j logger
     */
    static org.apache.log4j.Logger log4j =  LogManager.getLogger(Connexion.class.getName());
    
    public GestionCours() {
        // TODO Auto-generated constructor stub
    }
    
}
