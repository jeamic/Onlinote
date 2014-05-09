package modele.actionsdao;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import modele.basedao.*;
import modele.bddconnect.*;

public class DAOPersonne extends DAOFactory<Personne>{

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
		//connexion à la base
		Connection conn = (Connection) ConnexionJDBC.getInstance();
		
		//requête pour rechercher la personne
		try {
			stmt = (PreparedStatement) conn.prepareStatement("Select * from personne where email = ?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.setString(1, email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			res = (ResultSet) stmt.executeQuery();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
			// TODO Auto-generated catch block
			e.printStackTrace();
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
