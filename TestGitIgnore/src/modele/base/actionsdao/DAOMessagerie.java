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
import modele.base.dao.Messagerie;
import modele.utils.ConnexionJDBC;

public class DAOMessagerie extends DAOFactory <Messagerie>{
    /**
     * Log4j logger
     */
    static org.apache.log4j.Logger log4j =  LogManager.getLogger(Connexion.class.getName());
    
	@Override
	public Messagerie find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Messagerie create(Messagerie msgEnvoye) {
        /* déclaration et init des variables nécessaires */
        Statement stmt = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = (Connection) instance.getConnection();
        int envoiOuRecu;
        
        try {
            if(msgEnvoye.isEnvoiOuRecu() == true){
                envoiOuRecu = 0;
            } else {
                envoiOuRecu = 1;
            }
            
            stmt = conn.createStatement();
            String req = "INSERT INTO `messagerie` (`ID_PERSONNE` ,`ID_MESSAGE` ,`ENVOI_RECU`)"
                    + " VALUES ("
                    + Integer.toString(msgEnvoye.getIdPersonne()) + ","
                    + Integer.toString(msgEnvoye.getIdMessage()) + ","
                    + Integer.toString(envoiOuRecu) + ");";
            stmt.executeUpdate(req);
            
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }
		return null;
	}

	@Override
	public Messagerie update(Messagerie obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Messagerie obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Messagerie find(String chaine) {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
    public List<Messagerie> findAll() {
        /* déclaration et init des variables nécessaires */
        List<Messagerie> listeCompose = new ArrayList<Messagerie>();
        Statement stmt = null;
        ResultSet res = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = (Connection) instance.getConnection();
        
        try {
            stmt = conn.createStatement();
            res = stmt.executeQuery("select * from compose");

            while (res.next()){
                listeCompose.add(new Messagerie(res.getInt("id_personne"), res.getInt("id_message")));
            }
            
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }        
        return listeCompose;
    }

    @Override
    public Messagerie map(java.sql.ResultSet resultSet) {
        // TODO Auto-generated method stub
        return null;
    }
}
