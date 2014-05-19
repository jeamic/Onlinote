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

    public List<List<String>> getNotes (int idEleve, String nomMatiere){
        
        /*DAOSubit daoSubit = new DAOSubit();
        DAOMatiere daoMatiere = new DAOMatiere();
        DAOCours daoCours = new DAOCours();
        List<Subit> listeSubit = daoSubit.findAll();
        List<Matiere> listeMatiere = daoMatiere.findAll();
        List<Cours> listeCours = daoCours.findAll();*/
        
        /* déclaration et init des variables nécessaires */
        List<List<String>> notes = new ArrayList<List<String>>();
        PreparedStatement stmt = null;
        ResultSet res = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = (Connection) instance.getConnection();
        
        /* requête pour rechercher la personne, param 1 = date, param 2 = idEleve*/
        try {
            stmt =   (PreparedStatement) conn.prepareStatement(
                 "select note, m.matiere"
                +" from subit s, eleve e, matiere m, cours c"
                +" where s.id_eleve = ?"
                    +" and s.id_cours = c.id_cours"
                    +" and c.matiere = m.matiere"
                    +" and m.matiere = ?;");
            stmt.setInt(1, idEleve);
            stmt.setString(2, nomMatiere);
            
            res = (ResultSet) stmt.executeQuery();
            
            while (res.next()){
                ArrayList<String> listeTemp = new ArrayList<String>();
                listeTemp.add(res.getString("matiere"));
                listeTemp.add(res.getString("note"));
                notes.add(listeTemp);
            }
            
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }        
        return notes;
    }
    
    public List<String> getAllNotes (int idEleve){
        return null;
    }
}

