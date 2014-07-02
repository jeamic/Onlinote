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
import modele.base.dao.Classe;
import modele.base.dao.Enseigne;
import modele.utils.ConnexionJDBC;
import modele.vue.dao.DAOVueClasse;

public class DAOEnseigne extends DAOFactory <Enseigne>{

    /**
     * Log4j logger
     */
    static org.apache.log4j.Logger log4j =  LogManager.getLogger(Connexion.class.getName());
    
	@Override
	public Enseigne find(int id) {
		
		return null;
	}

	@Override
	public Enseigne create(Enseigne obj) {
		
		return null;
	}

	@Override
	public Enseigne update(Enseigne obj) {
		
		return null;
	}

	@Override
	public void delete(Enseigne obj) {
		
		
	}

	@Override
	public Enseigne find(String chaine) {
		
		return null;
	}

    @Override
    public List<Enseigne> findAll() {
        /* déclaration et init des variables nécessaires */
        List<Enseigne> listeEnseigne = new ArrayList<Enseigne>();
        Statement stmt = null;
        ResultSet res = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = (Connection) instance.getConnection();
        
        try {
            stmt = conn.createStatement();
            res = stmt.executeQuery("select * from enseigne");

            while (res.next()){
                listeEnseigne.add(new Enseigne(res.getInt("id_cours"), res.getInt("id_classe"), res.getInt("id_personne")));
            }
            
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }        
        return listeEnseigne;
    }

    @Override
    public Enseigne map(java.sql.ResultSet resultSet) {
        
        return null;
    }
    
    /**
     * Obtient toutes les classes d'un prof
     * 
     * @param idProf
     * @return
     */
    public List<DAOVueClasse> getClasses (int idProf){
        List<DAOVueClasse> listeClasses = new ArrayList<DAOVueClasse>();
        
        /* déclaration et init des variables nécessaires */
        Statement stmt = null;
        ResultSet res = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = (Connection) instance.getConnection();
        
        try {
            stmt = conn.createStatement();
            res = stmt.executeQuery("select * "
                                + " from enseigne e, classe c, personne p"
                                + " where e.id_classe = c.id_classe"
                                + " and p.id_personne = e.id_personne"
                                + " and e.id_personne = " + idProf + ";");
            while (res.next()){
                listeClasses.add(new DAOVueClasse(res.getInt("id_classe"), res.getString("nom_classe"), res.getInt("id_prof_principal")));
            }
            
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }    
        return listeClasses;
    }
		
}
