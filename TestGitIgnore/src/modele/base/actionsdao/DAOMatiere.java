package modele.base.actionsdao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modele.base.dao.Categorie;
import modele.base.dao.Matiere;
import modele.utils.ConnexionJDBC;

import org.apache.log4j.LogManager;

import controleur.connexion.Connexion;

public class DAOMatiere extends DAOFactory<Matiere>{
    
    /**
     * Log4j logger
     */
    static org.apache.log4j.Logger log4j =  LogManager.getLogger(Connexion.class.getName());

	@Override
	public Matiere find(int id) {
		
		return null;
	}

	@Override
	public Matiere find(String chaine) {
		
		return null;
	}

	@Override
	public Matiere create(Matiere obj) {
		
		return null;
	}

	@Override
	public Matiere update(Matiere obj) {
		
		return null;
	}

	@Override
	public void delete(Matiere obj) {
		
		
	}

    @Override
    public List<Matiere> findAll() {
        /* déclaration et init des variables nécessaires */
        List<Matiere> listeMatiere = new ArrayList<Matiere>();
        Statement stmt = null;
        ResultSet res = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = (Connection) instance.getConnection();
        
        try {
            stmt = conn.createStatement();
            res = stmt.executeQuery("select * from matiere");

            while (res.next()){
                listeMatiere.add(new Matiere(res.getString("matiere")));
            }
            
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }
        return listeMatiere;
    }
    
    /**
     * Obtient toutes les matières d'un élève
     * 
     * @param idEleve
     * @return
     */
    public List<Matiere> getMatieres(int idEleve) {
        /* déclaration et init des variables nécessaires */
        List<Matiere> listeMat = new ArrayList<Matiere>();
        Statement stmt = null;
        ResultSet res = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = (Connection) instance.getConnection();
        
        try {
            stmt = conn.createStatement();
            
            res = stmt.executeQuery("select cou.matiere"
                    +" from eleve e, suit s, cours cou, enseigne ens, matiere mat, classe cl"
                    +" where e.id_eleve = " + idEleve
                       +" and e.id_classe = cl.id_classe"
                       +" and cl.id_classe = ens.id_classe"
                       +" and ens.id_cours = cou.id_cours"
                       +" and cou.matiere = mat.matiere;");

            while (res.next()){
                listeMat.add(new Matiere(res.getString("matiere")));
            }
            
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }        
        return listeMat;
    }

    @Override
    public Matiere map(ResultSet resultSet) {
        
        return null;
    }

}
