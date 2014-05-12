package modele.actionsdao;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import modele.basedao.Personne;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;


public class DAOPersonne extends DAOFactory<Personne>{

	/**
	 * Log4j logger
	 */
	static org.apache.log4j.Logger log4j =  LogManager.getLogger(DAOPersonne.class.getName());
	
	@Override
	public Personne find(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Personne find (String email) {
		//déclaration et init des variables nécessaires
		Personne pers = null;
		PreparedStatement stmt = null;
		ResultSet res = null;
		
		//requête pour rechercher la personne
		try {
			stmt = (PreparedStatement) instance.getConnection().prepareStatement("Select * from personne where email = ?");
		} catch (SQLException e) {
			log4j.info(e.getMessage(), e);
		}
		try {
			stmt.setString(1, email);
		} catch (SQLException e) {
			log4j.info(e.getMessage(), e);
		}
		try {
			res = (ResultSet) stmt.executeQuery();
		} catch (SQLException e1) {
			log4j.info(e1.getMessage(), e1);
		}
		//création de l'objet correspondant à la personne recherchée
		try {
			if (res.first()){
				pers = new Personne( res.getInt("id_personne"),
									 res.getString("nom"),
									 res.getString("prenom"),
									 res.getString("adresse"),
									 res.getString("mot_de_passe"),
									 res.getString("email"),
									 res.getString("type_p"));}
		} catch (SQLException e) {
			log4j.info(e.getMessage(), e);
		}
		return pers;
	}

	@Override
	public Personne create(Personne obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Personne update(Personne obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Personne obj) {
		// TODO Auto-generated method stub
		
	}

}
