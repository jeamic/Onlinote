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
import modele.vue.dao.DAOVueTypeClasse;

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
    
    public List<DAOVueTypeClasse> countTypeClass () {
        List<DAOVueTypeClasse> listeTypeClasse = new ArrayList<DAOVueTypeClasse>();
        /* déclaration et init des variables nécessaires */
        Statement stmt = null;
        ResultSet res = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = (Connection) instance.getConnection();
        
        try {
            stmt = conn.createStatement();
            res = stmt.executeQuery("SELECT"
  +"CASE"
  +"  WHEN nom_classe LIKE '3%' THEN '3'"
  +"  WHEN nom_classe LIKE '4%' THEN '4'"
  +" END AS      type_classe"
+" , COUNT(*) AS nombre"
+" FROM classe"
+" GROUP BY "
+"  CASE"
  +"  WHEN nom_classe LIKE '3%' THEN '3'"
  +"  WHEN nom_classe LIKE '4%' THEN '4'"
  +"END);");

            while (res.next()){
                listeTypeClasse.add(new DAOVueTypeClasse(res.getString("type_classe"), res.getInt("nombre")));
            }
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }
        return listeTypeClasse;
    }

}
