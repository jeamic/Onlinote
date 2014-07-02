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
import modele.base.dao.Support;
import modele.utils.ConnexionJDBC;

public class DAOSupport extends DAOFactory <Support>{
    /**
     * Log4j logger
     */
    static org.apache.log4j.Logger log4j =  LogManager.getLogger(Connexion.class.getName());
    
	@Override
	public Support find(int id) {
		
		return null;
	}

	@Override
	public Support create(Support obj) {
		
		return null;
	}

	@Override
	public Support update(Support obj) {
		
		return null;
	}

	@Override
	public void delete(Support obj) {
	    return;
	}

	@Override
	public Support find(String chaine) {
		
		return null;
	}

    @Override
    public List<Support> findAll() {
        /* déclaration et init des variables nécessaires */
        List<Support> listeSupport = new ArrayList<Support>();
        Statement stmt = null;
        ResultSet res = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = (Connection) instance.getConnection();
        
        try {
            stmt = conn.createStatement();
            res = stmt.executeQuery("select * from support");

            while (res.next()){
                listeSupport.add(new Support(res.getString("nom_support")));
            }
            
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }        
        return listeSupport;
    }

    @Override
    public Support map(java.sql.ResultSet resultSet) {
        
        return null;
    }
}
