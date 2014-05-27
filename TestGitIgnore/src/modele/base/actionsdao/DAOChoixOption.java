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
import modele.base.dao.ChoixOption;
import modele.utils.ConnexionJDBC;

public class DAOChoixOption extends DAOFactory <ChoixOption>{

    /**
     * Log4j logger
     */
    static org.apache.log4j.Logger log4j =  LogManager.getLogger(Connexion.class.getName());
    
	@Override
	public ChoixOption find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChoixOption create(ChoixOption obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChoixOption update(ChoixOption obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(ChoixOption obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ChoixOption find(String chaine) {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
    public List<ChoixOption> findAll() {
        /* déclaration et init des variables nécessaires */
        List<ChoixOption> listeChoixOption = new ArrayList<ChoixOption>();
        Statement stmt = null;
        ResultSet res = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = (Connection) instance.getConnection();
        
        try {
            stmt = conn.createStatement();
            res = stmt.executeQuery("select * from choix_option");

            while (res.next()){
                listeChoixOption.add(new ChoixOption(res.getString("libelle")));
            }
            
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }        
        return listeChoixOption;
    }

    @Override
    public ChoixOption map(java.sql.ResultSet resultSet) {
        // TODO Auto-generated method stub
        return null;
    }
}
