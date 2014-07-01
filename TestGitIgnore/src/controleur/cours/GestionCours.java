package controleur.cours;

import java.util.List;

import modele.base.actionsdao.DAOCours;
import modele.vue.dao.DAOVueCours;

import org.apache.log4j.LogManager;

import controleur.connexion.Connexion;

public class GestionCours {
    
    /**
     * Log4j logger
     */
    static org.apache.log4j.Logger log4j =  LogManager.getLogger(Connexion.class.getName());
    
    public GestionCours() {
        // TODO Auto-generated constructor stub
    }
    
    public DAOVueCours getCours (int idEleve, String date) {
        DAOVueCours cours = new DAOVueCours();
        DAOCours daoCours = new DAOCours();
        cours = daoCours.getCours(idEleve, date);
        
        return cours;
    }
    
    public void ajouterCours() {
        
    }
    
    public void modifierCours () {
        
    }
    
    public void supprimerCours () {
        
    }
    
}
