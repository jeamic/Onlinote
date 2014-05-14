package controleur.cours;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;

import modele.bddconnect.ConnexionJDBC;

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
    
    
    /**
     * Renvoie un cours, la matière et la salle
     *  pour un élève donnée à une heure donnée
     * @param idEleve
     * @param date
     * @return 
     */
    public List <String> getCours (int idEleve, String date) {
        /* déclaration et init des variables nécessaires */
        List <String> cours = new ArrayList <String>();
        PreparedStatement stmt = null;
        ResultSet res = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = (Connection) instance.getConnection();
        
        /* requête pour rechercher la personne, param 1 = date, param 2 = idEleve*/
        try {
            stmt =   (PreparedStatement) conn.prepareStatement(
                      "select  cours.matiere, prof.nom, salle.nom_salle"
                     +" from    cours, enseigne ens, personne prof, eleve, salle"
                     +" where   eleve.id_classe = ens.id_classe"
                     +  " and ens.id_personne = prof.id_personne"
                     +  " and ens.id_cours = cours.id_cours"
                     +  " and ? BETWEEN HEURE_DEBUT and addtime(heure_debut, duree)"
                     +  " and cours.id_salle = salle.id_salle"
                     +  " and eleve.id_eleve = ?;");
            stmt.setString(1, date);
            stmt.setInt(2, idEleve);
            
            res = (ResultSet) stmt.executeQuery();
            if (res.first()){
                /* création de la liste correspondante au cours recherché */
                cours.add(res.getString("matiere"));
                cours.add(res.getString("nom"));
                cours.add(res.getString("nom_salle"));
                
                System.out.println("cours " + cours);
            } else {
                System.out.println("null");
                return null;
            }
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }        
        return cours;
    }
}
