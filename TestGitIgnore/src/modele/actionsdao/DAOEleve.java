package modele.actionsdao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modele.basedao.Eleve;
import modele.basedao.Personne;
import modele.controleur.NoteModele;
import modele.utils.ConnexionJDBC;

import org.apache.log4j.LogManager;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class DAOEleve extends DAOFactory<Eleve>{
    /**
     * Log4j logger
     */
    static org.apache.log4j.Logger log4j =  LogManager.getLogger(ConnexionJDBC.class.getName());
    
    /* variables pour requêtes */
    PreparedStatement stmt = null;
    ResultSet res = null;

	@Override
	public Eleve find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Eleve create(Eleve obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Eleve update(Eleve obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Eleve obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Eleve find(String chaine) {
	    /* déclaration et init des variables nécessaires */
        Eleve eleve = null;
        
        /* requête pour rechercher la personne */
        try {           
            stmt = (PreparedStatement) instance.getConnection().prepareStatement("Select * from eleve e, personne p where e.id_eleve = p.id_personne and p.email = ?;");
            stmt.setString(1, chaine);
            res = (ResultSet) stmt.executeQuery();
            while (res.next()){
                /* création de l'objet correspondant à l'élève recherchée */
                eleve = new Eleve( res.getInt("id_parent"),
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
        
        /* requête pour rechercher la personne */
        try {
            listeEleve = new ArrayList<Eleve>();
            
            stmt = (PreparedStatement) instance.getConnection().prepareStatement("Select * from eleve;");
            res = (ResultSet) stmt.executeQuery();
            while (res.next()){
                /* création de l'objet correspondant à l'élève recherchée */
                eleve = new Eleve( res.getInt("id_parent"),
                                   res.getInt("id_classe"),
                                   res.getInt("id_eleve"));
                listeEleve.add(eleve);
            }
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }

        return listeEleve;
    }
    
    public List<NoteModele> getNotes (int idEleve, String nomMatiere){
        return getNotes(idEleve, nomMatiere, 0);
    }
    
    public List<NoteModele> getNotes (int idEleve, String nomMatiere, int trimestre){
        
        /* déclaration et init des variables nécessaires */
        List<NoteModele> listeNotes = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = (Connection) instance.getConnection();
        
        /* requête pour rechercher la personne, param 1 = date, param 2 = idEleve*/
        try {
            String query = "select note, note_max, coefficient, m.matiere, trimestre"
                          +" from subit s, eleve e, matiere m, cours c, controles cont"
                          +" where s.id_eleve = ?"
                            + " and s.id_cours = c.id_cours"
                            + " and c.matiere = m.matiere"
                            + " and m.matiere = ?"
                            + " and s.id_controle = cont.id_controle;";
            if (trimestre != 0){
                query =   "select note, note_max, coefficient, m.matiere, trimestre"
                        +" from subit s, eleve e, matiere m, cours c, controles cont"
                        +" where s.id_eleve = ?"
                            + " and s.id_cours = c.id_cours"
                            + " and c.matiere = m.matiere"
                            + " and m.matiere = ?"
                            + " and s.id_controle = cont.id_controle"
                            + " and cont.trimestre = ?;";
            }
            stmt =   (PreparedStatement) conn.prepareStatement(query);
            stmt.setInt(1, idEleve);
            stmt.setString(2, nomMatiere);
            if (trimestre != 0){
                stmt.setInt(3, trimestre);
            }
            
            res = (ResultSet) stmt.executeQuery();
            listeNotes = new ArrayList<NoteModele>();
            
            while (res.next()){
                listeNotes.add(new NoteModele(idEleve, res.getDouble("note"), res.getDouble("note_max"), res.getDouble("coefficient"), res.getInt("trimestre"), res.getString("matiere")));
            }
            
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }        
        return listeNotes;
    }

    @Override
    public Eleve map(java.sql.ResultSet resultSet) {
        // TODO Auto-generated method stub
        return null;
    }

}
