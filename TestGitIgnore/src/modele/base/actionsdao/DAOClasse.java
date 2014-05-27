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
import modele.base.dao.Classe;
import modele.utils.ConnexionJDBC;

public class DAOClasse extends DAOFactory <Classe>{

    /**
     * Log4j logger
     */
    static org.apache.log4j.Logger log4j =  LogManager.getLogger(Connexion.class.getName());
    
	@Override
	public Classe find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Classe create(Classe obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Classe update(Classe obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Classe obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Classe find(String chaine) {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
    public List<Classe> findAll() {
        /* déclaration et init des variables nécessaires */
        List<Classe> listeClasse = new ArrayList<Classe>();
        Statement stmt = null;
        ResultSet res = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = (Connection) instance.getConnection();
        
        try {
            stmt = conn.createStatement();
            res = stmt.executeQuery("select * from classe");

            while (res.next()){
                listeClasse.add(new Classe(res.getInt("id_classe"), res.getString("nom_classe"), res.getInt("id_prof_principal")));
            }
            
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }        
        return listeClasse;
    }

    @Override
    public Classe map(java.sql.ResultSet resultSet) {
        // TODO Auto-generated method stub
        return null;
    }

}
