package controleur.notes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import modele.actionsdao.DAOCours;
import modele.actionsdao.DAOMatiere;
import modele.actionsdao.DAOSubit;
import modele.basedao.Cours;
import modele.basedao.Matiere;
import modele.basedao.Subit;
import modele.utils.ConnexionJDBC;

public class GestionNotes {
    /**
     * Log4j logger
     */
    static org.apache.log4j.Logger log4j =  LogManager.getLogger(ConnexionJDBC.class.getName());
    
    public GestionNotes () {
    }


    
    public List<String> getAllNotes (int idEleve){
        return null;
    }
}

