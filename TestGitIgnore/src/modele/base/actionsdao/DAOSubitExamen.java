package modele.base.actionsdao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;

import controleur.connexion.Connexion;
import modele.base.dao.Categorie;
import modele.base.dao.SubitExamen;
import modele.utils.ConnexionJDBC;
import modele.vue.dao.DAOVueNote;

public class DAOSubitExamen extends DAOFactory <SubitExamen> {

    /**
     * Log4j logger
     */
    static org.apache.log4j.Logger log4j =  LogManager.getLogger(Connexion.class.getName());
    
	@Override
	public SubitExamen find(int id /* id d'un élève */) {
		
		return null;
	}

	@Override
	public SubitExamen create(SubitExamen obj) {
		
		return null;
	}

	@Override
	public SubitExamen update(SubitExamen obj) {
		
		return null;
	}

	@Override
	public void delete(SubitExamen obj) {
		
		
	}

	@Override
	public SubitExamen find(String chaine) {
		
		return null;
	}

    @Override
    public List<SubitExamen> findAll() {
        /* déclaration et init des variables nécessaires */
        List<SubitExamen> listeExam = new ArrayList<SubitExamen>();
        Statement stmt = null;
        ResultSet res = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = (Connection) instance.getConnection();
        
        try {
            stmt = conn.createStatement();
            res = stmt.executeQuery("select * from subit_examen");

            while (res.next()){
                listeExam.add(new SubitExamen(res.getInt("id_controle"), res.getInt("id_eleve"), res.getInt("id_cours"), res.getDouble("note")));
            }
            
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }        
        return listeExam;
    }

    @Override
    public SubitExamen map(java.sql.ResultSet resultSet) {
        
        return null;
    }
    
    /**
     * Ajouter une note
     * 
     * @param idEleve
     * @param nomControle
     * @param note
     */
    public void ajouterNote (int idEleve, String nomControle, int note) {
        DAOControles daoControles = new DAOControles();
        int idControle = daoControles.find(nomControle).getIdControle();
        int idCours = (Integer) null;
        Statement stmt = null;
        ResultSet res = null;
        Statement stmt2 = null;
        ResultSet res2 = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = (Connection) instance.getConnection();
        
        try {
            stmt = conn.createStatement();
            String req = "select distinct id_cours from subit_examen where id_controle = " + idControle;
            res = stmt.executeQuery(req);
            
            while (res.next()){
                idCours = res.getInt("id_cours");
            }
            stmt2 = conn.createStatement();
            String req2 = "INSERT INTO Subit_examen (id_controle, id_eleve, id_cours, note)"
                    + " values (" + idControle
                    + "," + idEleve
                    + "," + idCours 
                    + "," + note + ")";
            stmt2.executeUpdate(req2);
        
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }
    }
	
}
