package modele.actionsDAO;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import modele.baseDAO.*;
import modele.bddConnect.*;

public class DAOPersonne extends DAOFactory<Personne>{

	@Override
	public Personne find(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static Personne find (String email) throws SQLException {
		Personne pers = null;
		//connexion à la base
		Connection conn = (Connection) ConnexionJDBC.getInstance();
		//requête pour rechercher la personne
		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("Select * from personne where email = ?");
		stmt.setString(1, email);
		ResultSet res = (ResultSet) stmt.executeQuery();
		//création de l'objet correspondant à la personne recherchée
		if (res.first())
		{
			pers = new Personne( res.getInt("id_personne"),
								 res.getString("nom"),
								 res.getString("prenom"),
								 res.getString("adresse"),
								 res.getString("mot_de_passe"),
								 res.getString("email"),
								 res.getString("type_p"));
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
