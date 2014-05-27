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
import modele.base.dao.Controles;
import modele.utils.ConnexionJDBC;

public class DAOControles extends DAOFactory <Controles>{

    /**
     * Log4j logger
     */
    static org.apache.log4j.Logger log4j =  LogManager.getLogger(Connexion.class.getName());
    
	@Override
	public Controles find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Controles create(Controles obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Controles update(Controles obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Controles obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Controles find(String chaine) {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
    public List<Controles> findAll() {
        /* déclaration et init des variables nécessaires */
        List<Controles> listeControle = new ArrayList<Controles>();
        Statement stmt = null;
        ResultSet res = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = (Connection) instance.getConnection();
        
        try {
            stmt = conn.createStatement();
            res = stmt.executeQuery("select * from controles");

            while (res.next()){
                listeControle.add(new Controles(res.getInt("id_controle"), res.getString("enonce"), res.getString("corrige"), res.getDouble("note_max"), res.getDouble("coefficient"), res.getInt("trimestre")));
            }
            
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }        
        return listeControle;
    }

    @Override
    public Controles map(java.sql.ResultSet resultSet) {
        // TODO Auto-generated method stub
        return null;
    }
	
}
