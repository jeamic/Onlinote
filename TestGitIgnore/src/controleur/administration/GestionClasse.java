package controleur.administration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modele.base.actionsdao.DAOClasse;
import modele.base.dao.Personne;
import modele.utils.ConnexionJDBC;
import modele.vue.dao.DAOVueClasse;
import modele.vue.dao.DAOVuePersonne;
import modele.vue.dao.DAOVueTypeClasse;

public class GestionClasse {    
    
    public GestionClasse () {
    }
    
    /**
     * Compte le nombre de classes de chaque type
     * 
     * @return
     */
    public List<DAOVueTypeClasse> getCountTypeClasse () {
        DAOClasse daoClasse = new DAOClasse();
        List<DAOVueTypeClasse> liste = daoClasse.countTypeClasse();
        
        return liste;
    }
    
    /**
     * Obtenir tous les élèves d'une classe
     * 
     * @param nomClasse
     * @return listeEleves
     */
    public List<DAOVuePersonne> getEleves (String nomClasse){
        DAOClasse daoClasse = new DAOClasse();
        List <DAOVuePersonne> listeEleves = daoClasse.getEleves(nomClasse);
        
        return listeEleves;
    }
    
    /**
     * Obtenir toutes les classes d'un type
     * 
     * @param typeClasse 3 pour 3ème, 4 pour 4ème
     * @return
     */
    public List<DAOVueClasse> getClasses (int typeClasse){
        DAOClasse daoClasse = new DAOClasse();
        daoClasse.getClasses(typeClasse);
        
        return daoClasse.getClasses(typeClasse);
    }
}
