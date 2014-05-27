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
import modele.base.dao.Compose;
import modele.utils.ConnexionJDBC;

public class DAOCompose extends DAOFactory <Compose>{
    /**
     * Log4j logger
     */
    static org.apache.log4j.Logger log4j =  LogManager.getLogger(Connexion.class.getName());
    
	@Override
	public Compose find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Compose create(Compose obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Compose update(Compose obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Compose obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Compose find(String chaine) {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
    public List<Compose> findAll() {
        /* déclaration et init des variables nécessaires */
        List<Compose> listeCompose = new ArrayList<Compose>();
        Statement stmt = null;
        ResultSet res = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = (Connection) instance.getConnection();
        
        try {
            stmt = conn.createStatement();
            res = stmt.executeQuery("select * from categorie");

            while (res.next()){
                listeCompose.add(new Compose(res.getInt("id_personne"), res.getInt("id_message")));
            }
            
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }        
        return listeCompose;
    }

    @Override
    public Compose map(java.sql.ResultSet resultSet) {
        // TODO Auto-generated method stub
        return null;
    }	
}
