package modele.actionsDAO;
import modele.bddConnect.ConnexionJDBC;

import com.mysql.jdbc.Connection;

public abstract class DAOFactory <T> {
	
	public Connection connect = (Connection) ConnexionJDBC.getInstance();

	
	/**
	 * Permet de récupérer un objet via son ID
	 * @param id
	 * @return
	 */
	public abstract T find(int id);
	
	/**
	 * Permet de récupérer un objet via une string
	 * @param String
	 * @return
	 */
	public abstract T find(String chaine);
	
	/**
	 * Permet de créer une entrée dans la base de données
	 * par rapport à un objet
	 * @param obj
	 */
	public abstract T create(T obj);
	
	/**
	 * Permet de mettre à jour les données d'une entrée dans la base 
	 * @param obj
	 */
	public abstract T update(T obj);
	
	/**
	 * Permet la suppression d'une entrée de la base
	 * @param obj
	 */
	public abstract void delete(T obj);
}
