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
import modele.base.dao.SubitExamen;
import modele.utils.ConnexionJDBC;
import modele.vue.dao.DAOVueNote;

public class DAOSubitExamen extends DAOFactory <SubitExamen> {

    /**
     * Log4j logger
     */
    static org.apache.log4j.Logger log4j =  LogManager.getLogger(Connexion.class.getName());
    
	@Override
	public SubitExamen find(int id /* id d'un élève */) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubitExamen create(SubitExamen obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubitExamen update(SubitExamen obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(SubitExamen obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SubitExamen find(String chaine) {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
    public List<SubitExamen> findAll() {
        /* déclaration et init des variables nécessaires */
        List<SubitExamen> listeExam = new ArrayList<SubitExamen>();
        Statement stmt = null;
        ResultSet res = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = (Connection) instance.getConnection();
        
        try {
            stmt = conn.createStatement();
            res = stmt.executeQuery("select * from subit_examen");

            while (res.next()){
                listeExam.add(new SubitExamen(res.getInt("id_controle"), res.getInt("id_eleve"), res.getInt("id_cours"), res.getDouble("note")));
            }
            
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }        
        return listeExam;
    }

    @Override
    public SubitExamen map(java.sql.ResultSet resultSet) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<DAOVueNote> getNotes(int idEleve, int trimestre, String matiere) {
        
        /* déclaration et init des variables nécessaires */
        List<DAOVueNote> listeNotes = new ArrayList<DAOVueNote>();
        Statement stmt = null;
        ResultSet res = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = (Connection) instance.getConnection();
        
        try {
            stmt = conn.createStatement();
            String req =   "select cont.id_controle, m.matiere, note, trimestre, cont.coefficient, cont.note_max"
                        + " from subit_examen s, eleve e, matiere m, cours c, controles cont"
                        + " where s.id_eleve = " + idEleve
                        + " and s.id_cours = c.id_cours"
                        + " and c.matiere = m.matiere"
                        + " and m.matiere = '" + matiere + "'"
                        + " and s.id_controle = cont.id_controle"
                        + " and s.id_eleve = e.id_eleve"
                        + " and trimestre = " + trimestre + ";";
            res = stmt.executeQuery(req);

            while (res.next()){
                listeNotes.add(new DAOVueNote(idEleve, res.getDouble("note"), res.getDouble("note_max"), res.getDouble("coefficient"), trimestre, matiere));
            }
            
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }        
        return listeNotes;
    }
	
}