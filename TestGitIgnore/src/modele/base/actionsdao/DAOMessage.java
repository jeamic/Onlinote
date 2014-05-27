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
import modele.base.dao.Message;
import modele.utils.ConnexionJDBC;

public class DAOMessage extends DAOFactory<Message>{

    /**
     * Log4j logger
     */
    static org.apache.log4j.Logger log4j =  LogManager.getLogger(Connexion.class.getName());
    
	@Override
	public Message find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message create(Message obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message update(Message obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Message obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Message find(String chaine) {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
    public List<Message> findAll() {
        /* déclaration et init des variables nécessaires */
        List<Message> listeMsg = new ArrayList<Message>();
        Statement stmt = null;
        ResultSet res = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = (Connection) instance.getConnection();
        
        try {
            stmt = conn.createStatement();
            res = stmt.executeQuery("select * from message");

            while (res.next()){
                listeMsg.add(new Message(res.getInt("id_message"), res.getString("objet"), res.getString("destinataires"), res.getString("cotenu"), res.getBoolean("lu")));
            }
            
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }        
        return listeMsg;
    }

    @Override
    public Message map(java.sql.ResultSet resultSet) {
        // TODO Auto-generated method stub
        return null;
    }

}
