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
import modele.base.dao.Subit_examen;
import modele.utils.ConnexionJDBC;

public class DAOSubiteExamen extends DAOFactory <Subit_examen> {

    /**
     * Log4j logger
     */
    static org.apache.log4j.Logger log4j =  LogManager.getLogger(Connexion.class.getName());
    
	@Override
	public Subit_examen find(int id /* id d'un élève */) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Subit_examen create(Subit_examen obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Subit_examen update(Subit_examen obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Subit_examen obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Subit_examen find(String chaine) {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
    public List<Subit_examen> findAll() {
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
    public Subit_examen map(java.sql.ResultSet resultSet) {
        // TODO Auto-generated method stub
        return null;
    }


	
}
