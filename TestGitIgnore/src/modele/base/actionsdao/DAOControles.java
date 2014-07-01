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
import modele.vue.dao.DAOVueControle;

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
	public Controles create(Controles controle) {
        DAOVueControle daoControles = new DAOVueControle();
        Statement stmt = null;
        ResultSet res = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = (Connection) instance.getConnection();
        
        try {
            stmt = conn.createStatement();
            String req = "INSERT INTO Controles (id_controle, enonce, corrige, noteMax, coefficient, trimestre, titre)"
                    + " values (" + controle.getIdControle()
                    + "," + controle.getEnonce()
                    + "," + controle.getCorrige()
                    + "," + controle.getNoteMax()
                    + "," + controle.getCoefficient()
                    + "," + controle.getTrimestre()
                    + "," + controle.getTitre() + ")";
            stmt.executeUpdate(req);
        
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }
        return controle;
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
	public Controles find(String nomControle) {
        /* déclaration et init des variables nécessaires */
        Controles controle = new Controles();
        Statement stmt = null;
        ResultSet res = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = (Connection) instance.getConnection();
        
        try {
            stmt = conn.createStatement();
            res = stmt.executeQuery("select * from controles where titre = '" + nomControle  + "')");

            while (res.next()){
                controle = new Controles(res.getInt("id_controle"), res.getString("enonce"), res.getString("corrige"), res.getDouble("note_max"), res.getDouble("coefficient"), res.getInt("trimestre"), res.getString("titre"));
            }
            
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }        
        return controle;
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
                listeControle.add(new Controles(res.getInt("id_controle"), res.getString("enonce"), res.getString("corrige"), res.getDouble("note_max"), res.getDouble("coefficient"), res.getInt("trimestre"), res.getString("titre")));
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
