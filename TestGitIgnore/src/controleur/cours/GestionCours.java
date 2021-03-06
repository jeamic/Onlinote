package controleur.cours;

import java.sql.Date;
import java.sql.Time;
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
    
    /**
     * Constructeur par défaut
     */
    public GestionCours() {
    }
    
    /**
     * Donne un cours pour une date et un élève donnés
     * 
     * @param idEleve
     * @param date
     * @return
     */
    public DAOVueCours getCours (int idEleve, String date) {
        DAOVueCours cours = new DAOVueCours();
        DAOCours daoCours = new DAOCours();
        cours = daoCours.getCours(idEleve, date);
        
        return cours;
    }
    
    /**
     * Donne un cours pour une date et une classe données
     * 
     * @param idEleve
     * @param date
     * @return
     */
    public DAOVueCours getCours (String nomClasse, String date) {
        DAOVueCours cours = new DAOVueCours();
        DAOCours daoCours = new DAOCours();
        cours = daoCours.getCours(nomClasse, date);
        
        return cours;
    }
    
    /**
     * Permet l'ajout d'un cours
     * 
     * @param daoVueCours
     * @param heureDebut
     * @param duree
     * @param idProf
     */
    public void ajouterCours(DAOVueCours daoVueCours, String heureDebut, String duree, int idProf) {
        DAOCours daoCours = new DAOCours();
        daoCours.ajouterCours(daoVueCours, heureDebut, duree, idProf);
    }
    
    public void modifierCours () {
        return;
    }
    
    public void supprimerCours () {
        return;
    }
    
}
