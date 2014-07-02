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
import modele.base.dao.Devoirs;
import modele.utils.ConnexionJDBC;

public class DAODevoirs extends DAOFactory <Devoirs>{
    
    /**
     * Log4j logger
     */
    static org.apache.log4j.Logger log4j =  LogManager.getLogger(Connexion.class.getName());
    
	@Override
	public Devoirs find(int id) {
		
		return null;
	}

	@Override
	public Devoirs create(Devoirs obj) {
		
		return null;
	}

	@Override
	public Devoirs update(Devoirs obj) {
		
		return null;
	}

	@Override
	public void delete(Devoirs obj) {
	    return;
	}

	@Override
	public Devoirs find(String chaine) {
		
		return null;
	}

    @Override
    public List<Devoirs> findAll() {
        /* déclaration et init des variables nécessaires */
        List<Devoirs> listeDevoir = new ArrayList<Devoirs>();
        Statement stmt = null;
        ResultSet res = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = (Connection) instance.getConnection();
        
        try {
            stmt = conn.createStatement();
            res = stmt.executeQuery("select * from devoirs");

            while (res.next()){
                listeDevoir.add(new Devoirs(res.getInt("id_devoir"), res.getString("categorie"), res.getString("description")));
            }
            
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }        
        return listeDevoir;
    }

    @Override
    public Devoirs map(java.sql.ResultSet resultSet) {
        
        return null;
    }

	
}
