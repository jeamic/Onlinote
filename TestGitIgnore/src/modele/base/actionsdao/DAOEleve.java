package modele.base.actionsdao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modele.base.dao.Eleve;
import modele.base.dao.Personne;
import modele.utils.ConnexionJDBC;
import modele.vue.dao.DAOVuePersonne;
import modele.vue.dao.DAOVueNote;

import org.apache.log4j.LogManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAOEleve extends DAOFactory<Eleve>{
    /**
     * Log4j logger
     */
    static org.apache.log4j.Logger log4j =  LogManager.getLogger(ConnexionJDBC.class.getName());

	@Override
	public Eleve find(int id) {
        /* déclaration et init des variables nécessaires */
        Eleve eleve = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        
        /* requête pour rechercher la personne */
        try {
            stmt = (PreparedStatement) instance.getConnection().prepareStatement("Select * from eleve where id_eleve = ?");
            stmt.setInt(1, id);
            res = (ResultSet) stmt.executeQuery();
            if (res.first()){
                /* création de l'objet correspondant à la personne recherchée */
                eleve = new Eleve( res.getInt("id_parent1"), res.getInt("id_parent2"),res.getInt("id_classe"),res.getInt("id_eleve"));
            }
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);

        }
        return eleve;
	}

	@Override
	public Eleve create(Eleve obj) {
		
		return null;
	}

	@Override
	public Eleve update(Eleve obj) {
		
		return null;
	}

	@Override
	public void delete(Eleve obj) {
		
		
	}

	@Override
	public Eleve find(String chaine) {
	    /* déclaration et init des variables nécessaires */
        Eleve eleve = null;
        
        Statement stmt = null;
        ResultSet res = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = instance.getConnection();
        
        try {
            
            stmt = conn.createStatement();
            res = stmt.executeQuery("select * from eleve e, personne p where e.id_eleve = p.id_personne and p.email = " + chaine + ";");
            while (res.next()){
                /* création de l'objet correspondant à l'élève recherchée */
                eleve = new Eleve( res.getInt("id_parent1"),
                                   res.getInt("id_parent1"),
                                   res.getInt("id_classe"),
                                   res.getInt("id_eleve"));
            }
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }

        return eleve;
	}

    @Override
    public List<Eleve> findAll() {        
        /* déclaration et init des variables nécessaires */
        Eleve eleve = null;
        List<Eleve> listeEleve = null;
        
        Statement stmt = null;
        ResultSet res = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = instance.getConnection();
        
        try {
            
            stmt = conn.createStatement();
            res = stmt.executeQuery("select * from eleve;");
            listeEleve = new ArrayList<Eleve>();
            
            while (res.next()){
                /* création de l'objet correspondant à l'élève recherchée */
                eleve = new Eleve( res.getInt("id_parent1"),
                        res.getInt("id_parent1"),
                        res.getInt("id_classe"),
                        res.getInt("id_eleve"));
                listeEleve.add(eleve);
            }
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }

        return listeEleve;
    }
    
    /**
     * Trouve une liste d'élèves qui contient la chaîne de caractères
     * 
     * @param name
     * @return
     */
    public List<DAOVuePersonne> findEleveByName (String name) {
        /* déclaration et init des variables nécessaires */
        DAOVuePersonne daoVueEleve = null;
        Personne eleve = null;
        List<DAOVuePersonne> listeEleve = null;
        
        Statement stmt = null;
        ResultSet res = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = instance.getConnection();
        
        try {
            
            stmt = conn.createStatement();
            res = stmt.executeQuery("select * "
                                + " from personne, eleve "
                                + " where nom LIKE '" + name + "%' "
                                 + "or prenom LIKE '" + name + "%' "
                                + "and id_personne in "
                                        + " (select id_eleve from eleve;");
            listeEleve = new ArrayList<DAOVuePersonne>();
            
            while (res.next()){
                eleve = new Personne();
                eleve.setIdPersonne(res.getInt("id_eleve"));
                eleve.setNom(res.getString("nom"));
                eleve.setPrenom(res.getString("prenom"));
                eleve.setAdresse(res.getString("adresse"));
                eleve.setEmail(res.getString("email"));
                
                /* création de l'objet correspondant à l'élève recherchée */
                daoVueEleve = new DAOVuePersonne(eleve, res.getInt("id_classe"), res.getInt("id_parent1"), res.getInt("id_parent2"));
                listeEleve.add(daoVueEleve);
            }
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }

        return listeEleve;
    }
    
    /**
     * Obtient les notes d'un élève
     * 
     * @param idEleve
     * @param nomMatiere
     * @return
     */
    public List<DAOVueNote> getNotes (int idEleve, String nomMatiere){
        return getNotes(idEleve, nomMatiere, 0);
    }
    
    /**
     * Obtient les notes d'un élève
     * 
     * @param idEleve
     * @param nomMatiere
     * @param trimestre
     * @return
     */
    public List<DAOVueNote> getNotes (int idEleve, String nomMatiere, int trimestre){
        
        /* déclaration et init des variables nécessaires */
        List<DAOVueNote> listeNotes = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = (Connection) instance.getConnection();
        
        /* requête pour rechercher la personne, param 1 = date, param 2 = idEleve*/
        try {
            String query = "select cont.id_controle, m.matiere, note, trimestre, cont.coefficient, cont.note_max"
                    + " from subit_examen s, eleve e, matiere m, cours c, controles cont"
                    + " where s.id_eleve = ? "
                    + " and s.id_cours = c.id_cours"
                    + " and c.matiere = m.matiere"
                    + " and m.matiere = ?"
                    + " and s.id_controle = cont.id_controle"
                    + " and s.id_eleve = e.id_eleve" + ";";
            if (trimestre != 0){
                query =   "select cont.id_controle, m.matiere, note, trimestre, cont.coefficient, cont.note_max"
                        + " from subit_examen s, eleve e, matiere m, cours c, controles cont"
                        + " where s.id_eleve = ?"
                        + " and s.id_cours = c.id_cours"
                        + " and c.matiere = m.matiere"
                        + " and m.matiere = ?"
                        + " and s.id_controle = cont.id_controle"
                        + " and s.id_eleve = e.id_eleve"
                        + " and trimestre = ?;";
            }
            stmt =   (PreparedStatement) conn.prepareStatement(query);
            stmt.setInt(1, idEleve);
            stmt.setString(2, nomMatiere);
            if (trimestre != 0){
                stmt.setInt(3, trimestre);
            }
            
            res = (ResultSet) stmt.executeQuery();
            listeNotes = new ArrayList<DAOVueNote>();
            
            while (res.next()){
                listeNotes.add(new DAOVueNote(idEleve, res.getDouble("note"), res.getDouble("note_max"), res.getDouble("coefficient"), res.getInt("trimestre"), res.getString("matiere")));
            }
            
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }        
        return listeNotes;
    }

    @Override
    public Eleve map(java.sql.ResultSet resultSet) {
        
        return null;
    }

}
