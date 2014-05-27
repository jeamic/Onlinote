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
import modele.base.dao.Enseigne;
import modele.utils.ConnexionJDBC;

public class DAOEnseigne extends DAOFactory <Enseigne>{

    /**
     * Log4j logger
     */
    static org.apache.log4j.Logger log4j =  LogManager.getLogger(Connexion.class.getName());
    
	@Override
	public Enseigne find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enseigne create(Enseigne obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enseigne update(Enseigne obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Enseigne obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Enseigne find(String chaine) {
		// TODO Auto-generated method stub
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
        // TODO Auto-generated method stub
        return null;
    }

		
}
