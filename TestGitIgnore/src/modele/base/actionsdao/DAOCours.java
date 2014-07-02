package modele.base.actionsdao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modele.base.dao.Categorie;
import modele.base.dao.Cours;
import modele.base.dao.Matiere;
import modele.utils.ConnexionJDBC;
import modele.vue.dao.DAOVueCours;

import org.apache.log4j.LogManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import controleur.connexion.Connexion;

public class DAOCours extends DAOFactory<Cours>{
    
    /**
     * Log4j logger
     */
    static org.apache.log4j.Logger log4j =  LogManager.getLogger(Connexion.class.getName());

	@Override
	public Cours find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cours create(Cours obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cours update(Cours obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Cours obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cours find(String chaine /*format: 2014-05-15 10:00:01 trouve tous les cours à partir de cette date */) {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
    public List<Cours> findAll() {
        /* déclaration et init des variables nécessaires */
        List<Cours> listeCours = new ArrayList<Cours>();
        Statement stmt = null;
        ResultSet res = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = (Connection) instance.getConnection();
        
        try {
            stmt = conn.createStatement();
            res = stmt.executeQuery("select * from cours");

            while (res.next()){
                listeCours.add(new Cours(res.getInt("id_cours"), res.getString("matiere"), res.getInt("id_salle"), res.getString("commentaire"), res.getDate("heure_debut"), res.getTime("duree")));
            }
            
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }        
        return listeCours;
    }
    
    /**
     * Renvoie un cours, la matière et la salle
     *  pour un élève donnée à une heure donnée
     * @param idEleve
     * @param date format: 2014-05-15 10:00:01
     * @return 
     */
    public DAOVueCours getCours (int idEleve, String date) {
        /* déclaration et init des variables nécessaires */
        DAOVueCours cours = new DAOVueCours();
        Statement stmt = null;
        ResultSet res = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = (Connection) instance.getConnection();
        
        /* requête pour rechercher la personne, param 1 = date, param 2 = idEleve*/
        try {
            stmt = conn.createStatement();
            res =   stmt.executeQuery(
                      "select  cours.id_cours, salle.nom_salle, prof.nom, cours.matiere, nom_classe"
                     +" from    cours, enseigne ens, personne prof, eleve, salle, classe cl"
                     +" where   eleve.id_classe = ens.id_classe"
                     +  " and ens.id_personne = prof.id_personne"
                     +  " and ens.id_cours = cours.id_cours"
                     +  " and '" + date + "' between heure_debut and addtime(heure_debut, duree)"
                     +  " and cours.id_salle = salle.id_salle"
                     +  " and ens.id_classe = cl.id_classe"
                     +  " and eleve.id_eleve = " + idEleve + ";");

            while (res.next()){
                cours = new DAOVueCours(res.getInt("id_cours"), res.getString("nom"), res.getString("nom_classe"), res.getString("nom_salle"), res.getString("matiere"));
            }
            
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }        
        return cours;
    }

    @Override
    public Cours map(java.sql.ResultSet resultSet) {
        // TODO Auto-generated method stub
        return null;
    }

}
