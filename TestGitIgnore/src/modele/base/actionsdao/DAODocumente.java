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
import modele.base.dao.Documente;
import modele.utils.ConnexionJDBC;

public class DAODocumente extends DAOFactory<Documente>{

    /**
     * Log4j logger
     */
    static org.apache.log4j.Logger log4j =  LogManager.getLogger(Connexion.class.getName());
    
	@Override
	public Documente find(int id) {
		
		return null;
	}

	@Override
	public Documente create(Documente obj) {
		
		return null;
	}

	@Override
	public Documente update(Documente obj) {
		
		return null;
	}

	@Override
	public void delete(Documente obj) {
		
		
	}

	@Override
	public Documente find(String chaine) {
		
		return null;
	}

    @Override
    public List<Documente> findAll() {
        /* déclaration et init des variables nécessaires */
        List<Documente> listeDocument = new ArrayList<Documente>();
        Statement stmt = null;
        ResultSet res = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = (Connection) instance.getConnection();
        
        try {
            stmt = conn.createStatement();
            res = stmt.executeQuery("select * from documente");

            while (res.next()){
                listeDocument.add(new Documente(res.getInt("id_support"), res.getString("nom_support")));
            }
            
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }        
        return listeDocument;
    }

    @Override
    public Documente map(java.sql.ResultSet resultSet) {
        
        return null;
    }

}
