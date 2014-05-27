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
import modele.base.dao.Suit;
import modele.utils.ConnexionJDBC;

public class DAOSuit extends DAOFactory <Suit>{
    /**
     * Log4j logger
     */
    static org.apache.log4j.Logger log4j =  LogManager.getLogger(Connexion.class.getName());
    
	@Override
	public Suit find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Suit create(Suit obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Suit update(Suit obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Suit obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Suit find(String chaine) {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
    public List<Suit> findAll() {
        /* déclaration et init des variables nécessaires */
        List<Suit> listeSuit = new ArrayList<Suit>();
        Statement stmt = null;
        ResultSet res = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = (Connection) instance.getConnection();
        
        try {
            stmt = conn.createStatement();
            res = stmt.executeQuery("select * from suit");

            while (res.next()){
                listeSuit.add(new Suit(res.getInt("id_eleve"), res.getString("libelle")));
            }
            
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }        
        return listeSuit;
    }

    @Override
    public Suit map(java.sql.ResultSet resultSet) {
        // TODO Auto-generated method stub
        return null;
    }

	
}
