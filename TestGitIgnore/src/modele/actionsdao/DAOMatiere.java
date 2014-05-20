package modele.actionsdao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import controleur.connexion.Connexion;
import modele.basedao.Matiere;
import modele.utils.ConnexionJDBC;

public class DAOMatiere extends DAOFactory<Matiere>{
    
    /**
     * Log4j logger
     */
    static org.apache.log4j.Logger log4j =  LogManager.getLogger(Connexion.class.getName());

	@Override
	public Matiere find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Matiere find(String chaine) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Matiere create(Matiere obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Matiere update(Matiere obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Matiere obj) {
		// TODO Auto-generated method stub
		
	}

    @Override
    public List<Matiere> findAll() {
        // TODO Auto-generated method stub
        return null;
    }
    
    public List<Matiere> getMatieres(int idEleve) {
        /* déclaration et init des variables nécessaires */
        List<Matiere> listeMat = new ArrayList<Matiere>();
        PreparedStatement stmt = null;
        ResultSet res = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = (Connection) instance.getConnection();
        
        /* requête pour rechercher la personne, param 1 = date, param 2 = idEleve*/
        try {
            stmt =   (PreparedStatement) conn.prepareStatement(
                 "select cou.matiere"
                +" from eleve e, suit s, cours cou, enseigne ens, matiere mat, classe cl"
                +" where e.id_eleve = ?"
                   +" and e.id_classe = cl.id_classe"
                   +" and cl.id_classe = ens.id_classe"
                   +" and ens.id_cours = cou.id_cours"
                   +" and cou.matiere = mat.matiere;");
            
            stmt.setInt(1, idEleve);
            res = (ResultSet) stmt.executeQuery();

            while (res.next()){
                listeMat.add(new Matiere(res.getString("matiere")));
            }
            
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }        
        return listeMat;
    }

}
