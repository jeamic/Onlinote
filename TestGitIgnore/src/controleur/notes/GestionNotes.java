package controleur.notes;

import java.util.List;

import modele.utils.ConnexionJDBC;

import org.apache.log4j.LogManager;

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

