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
import modele.base.dao.Matiere;
import modele.utils.ConnexionJDBC;

public class DAOCategorie extends DAOFactory<Categorie>{
    /**
     * Log4j logger
     */
    static org.apache.log4j.Logger log4j =  LogManager.getLogger(Connexion.class.getName());
    
	@Override
	public Categorie find(int id) {
		
		return null;
	}

	@Override
	public Categorie find(String chaine) {
		
		return null;
	}

	@Override
	public Categorie create(Categorie obj) {
		
		return null;
	}

	@Override
	public Categorie update(Categorie obj) {
		
		return null;
	}

	@Override
	public void delete(Categorie obj) {
		return;
	}

    @Override
    public List<Categorie> findAll() {
        /* déclaration et init des variables nécessaires */
        List<Categorie> listeCateg = new ArrayList<Categorie>();
        Statement stmt = null;
        ResultSet res = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = (Connection) instance.getConnection();
        
        try {
            stmt = conn.createStatement();
            res = stmt.executeQuery("select * from categorie");

            while (res.next()){
                listeCateg.add(new Categorie(res.getString("categorie")));
            }
            
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }        
        return listeCateg;
    }

    @Override
    public Categorie map(java.sql.ResultSet resultSet) {
        
        return null;
    }
}
