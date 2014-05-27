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
import modele.base.dao.DonneLieu;
import modele.utils.ConnexionJDBC;

public class DAODonneLieu extends DAOFactory <DonneLieu>{

    /**
     * Log4j logger
     */
    static org.apache.log4j.Logger log4j =  LogManager.getLogger(Connexion.class.getName());
    
	@Override
	public DonneLieu find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DonneLieu create(DonneLieu obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DonneLieu update(DonneLieu obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(DonneLieu obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DonneLieu find(String chaine) {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
    public List<DonneLieu> findAll() {
        /* déclaration et init des variables nécessaires */
        List<DonneLieu> liste = new ArrayList<DonneLieu>();
        Statement stmt = null;
        ResultSet res = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = (Connection) instance.getConnection();
        
        try {
            stmt = conn.createStatement();
            res = stmt.executeQuery("select * from donne_lieu");

            while (res.next()){
                liste.add(new DonneLieu(res.getInt("id_cours"), res.getInt("id_devoir")));
            }
            
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }        
        return liste;
    }

    @Override
    public DonneLieu map(java.sql.ResultSet resultSet) {
        // TODO Auto-generated method stub
        return null;
    }

}
