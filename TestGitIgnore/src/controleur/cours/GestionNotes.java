package controleur.cours;

import java.util.ArrayList;
import java.util.List;

import modele.base.actionsdao.DAOEleve;
import modele.base.actionsdao.DAOSubitExamen;
import modele.utils.ConnexionJDBC;
import modele.vue.dao.DAOVueNote;

import org.apache.log4j.LogManager;

public class GestionNotes {
    /**
     * Log4j logger
     */
    static org.apache.log4j.Logger log4j =  LogManager.getLogger(ConnexionJDBC.class.getName());
    
    /**
     * Constructeur par défaut
     */
    public GestionNotes () {
    }

    /**
     * Obtient les notes pour un élève, un trimestre et une matière
     * 
     * @param idEleve
     * @param trimestre
     * @param matiere
     * @return
     */
    public List<DAOVueNote> getNotes (int idEleve, int trimestre, String matiere){
        List<DAOVueNote> listeNotes = new ArrayList<DAOVueNote>();
        DAOEleve daoSubitExamen = new DAOEleve();
        listeNotes = daoSubitExamen.getNotes(idEleve, matiere, trimestre);

        return listeNotes;
    }
    
    /**
     * Ajouter une note
     * 
     * @param idEleve
     * @param nomControle
     * @param note
     */
    public void ajouterNote (int idEleve, String nomControle, int note) {
        DAOSubitExamen daoNotes = new DAOSubitExamen();
        daoNotes.ajouterNote(idEleve, nomControle, note);
    }
    
    public void modifierNote () {
        
    }
    
    public void supprimerNote () {
        
    }
}

