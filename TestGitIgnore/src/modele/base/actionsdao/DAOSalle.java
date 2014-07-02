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
import modele.base.dao.Salle;
import modele.utils.ConnexionJDBC;

public class DAOSalle extends DAOFactory<Salle>{
    
    /**
     * Log4j logger
     */
    static org.apache.log4j.Logger log4j =  LogManager.getLogger(Connexion.class.getName());
    
	@Override
	public Salle find(int id) {
		
		return null;
	}

	@Override
	public Salle create(Salle obj) {
		
		return null;
	}

	@Override
	public Salle update(Salle obj) {
		
		return null;
	}

	@Override
	public void delete(Salle obj) {
	    return;
	}

	@Override
	public Salle find(String chaine) {
		
		return null;
	}

    @Override
    public List<Salle> findAll() {
        /* déclaration et init des variables nécessaires */
        List<Salle> listeSalle = new ArrayList<Salle>();
        Statement stmt = null;
        ResultSet res = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = (Connection) instance.getConnection();
        
        try {
            stmt = conn.createStatement();
            res = stmt.executeQuery("select * from salle");

            while (res.next()){
                listeSalle.add(new Salle(res.getInt("id_salle")));
            }
            
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }        
        return listeSalle;
    }

    @Override
    public Salle map(java.sql.ResultSet resultSet) {
        
        return null;
    }

	
}
