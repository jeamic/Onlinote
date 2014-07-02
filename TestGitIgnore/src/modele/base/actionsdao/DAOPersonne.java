package modele.base.actionsdao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modele.base.dao.Categorie;
import modele.base.dao.Eleve;
import modele.base.dao.Personne;
import modele.utils.ConnexionJDBC;
import modele.vue.dao.DAOVuePersonne;

import org.apache.log4j.LogManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DAOPersonne extends DAOFactory<Personne>{

	/**
	 * Log4j logger
	 */
	static org.apache.log4j.Logger log4j =  LogManager.getLogger(DAOPersonne.class.getName());
	
	@Override
	public Personne find(int id) {
        /* déclaration et init des variables nécessaires */
        Personne pers = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        
        /* requête pour rechercher la personne */
        try {
            stmt = (PreparedStatement) instance.getConnection().prepareStatement("Select * from personne where id_personne = ?");
            stmt.setInt(1, id);
            res = (ResultSet) stmt.executeQuery();
            if (res.first()){
                /* création de l'objet correspondant à la personne recherchée */
                pers = new Personne( res.getInt("id_personne"),
                                     res.getString("nom"),
                                     res.getString("prenom"),
                                     res.getString("adresse"),
                                     res.getString("mot_de_passe"),
                                     res.getString("email"),
                                     res.getString("type_p"),
                                     res.getString("Date_naiss"));
            }
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);

        }
        return pers;
	}
	
	@Override
	public Personne find (String email) {
		/* déclaration et init des variables nécessaires */
		Personne pers = null;
		PreparedStatement stmt = null;
		ResultSet res = null;
		
		/* requête pour rechercher la personne */
		try {
			stmt = (PreparedStatement) instance.getConnection().prepareStatement("Select * from personne where email = ?");
			stmt.setString(1, email);
			res = (ResultSet) stmt.executeQuery();
            if (res.first()){
                /* création de l'objet correspondant à la personne recherchée */
                pers = new Personne( res.getInt("id_personne"),
                                     res.getString("nom"),
                                     res.getString("prenom"),
                                     res.getString("adresse"),
                                     res.getString("mot_de_passe"),
                                     res.getString("email"),
                                     res.getString("type_p"),
                                     res.getString("Date_naiss"));
            }
		} catch (SQLException e) {
			log4j.info(e.getMessage(), e);

		}
		return pers;
	}

	@Override
	public Personne create(Personne obj) {
		
		return null;
	}

	@Override
	public Personne update(Personne obj) {
		
		return null;
	}

	@Override
	public void delete(Personne obj) {
		
		
	}

    @Override
    public List<Personne> findAll() {
        /* déclaration et init des variables nécessaires */
        List<Personne> listePersonne = new ArrayList<Personne>();
        Statement stmt = null;
        ResultSet res = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = (Connection) instance.getConnection();
        
        try {
            stmt = conn.createStatement();
            res = stmt.executeQuery("select * from personne");

            while (res.next()){
                listePersonne.add(new Personne(res.getInt("id_personne"), res.getString("nom"), res.getString("prenom"), res.getString("adresse"), res.getString("mot_de_passe"), res.getString("email"), res.getString("type_p"), res.getString("Date_naiss")));
            }
            
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }        
        return listePersonne;
    }

    @Override
    public Personne map(java.sql.ResultSet resultSet) {
        
        return null;
    }
    
    /**
     * Obtient les enfants d'un parent
     * 
     * @param idParent
     * @return
     */
    public List<DAOVuePersonne> getEnfants (int idParent) {
        /* déclaration et init des variables nécessaires */
        List<DAOVuePersonne> listeEnfants = new ArrayList<DAOVuePersonne>();
        Statement stmt = null;
        ResultSet res = null;
        /*ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = instance.getConnection();*/
        
        try {
            stmt = instance.getConnection().createStatement();
            String req = "select * from eleve where id_parent1="
                        +Integer.toString(idParent)
                        +" OR id_parent2 ="
                        +Integer.toString(idParent);
            res = stmt.executeQuery(req);
            DAOPersonne daoPersonne = new DAOPersonne();
            DAOEleve daoEleve = new DAOEleve();
            
            while (res.next()){
                Personne eleve_personne = daoPersonne.find(res.getInt("id_eleve"));
                Eleve eleve = daoEleve.find(eleve_personne.getIdPersonne());
                listeEnfants.add(new DAOVuePersonne(eleve_personne, eleve.getidClasse(), eleve.getIdParent1(), eleve.getIdParent2()));
            }
            
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }
        return listeEnfants;
    }
    
    /**
     * Trouve une personne par nom ou prénom
     * ou seulement contenant le texte de recherche
     * @param name
     * @return
     */
    public List<DAOVuePersonne> findPersonneByName (String name){
        /* déclaration et init des variables nécessaires */
        DAOVuePersonne daoVuePersonne = null;
        Personne personne = null;
        List<DAOVuePersonne> listePersonne = null;
        
        Statement stmt = null;
        ResultSet res = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = instance.getConnection();
        
        try {
            
            stmt = conn.createStatement();
            res = stmt.executeQuery("select * "
                                + " from personne "
                                + " where nom LIKE '" + name + "%' "
                                 + "or prenom LIKE '" + name + "%' ");
            listePersonne = new ArrayList<DAOVuePersonne>();
            
            while (res.next()){
                personne = new Personne();
                personne.setIdPersonne(res.getInt("id_personne"));
                personne.setNom(res.getString("nom"));
                personne.setPrenom(res.getString("prenom"));
                personne.setAdresse(res.getString("adresse"));
                personne.setEmail(res.getString("email"));
                
                /* création de l'objet correspondant à l'élève recherchée */
                daoVuePersonne = new DAOVuePersonne(personne, 0, 0, 0);
                listePersonne.add(daoVuePersonne);
            }
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }

        return listePersonne;
    }
}
