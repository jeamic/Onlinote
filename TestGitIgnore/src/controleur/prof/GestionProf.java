package controleur.prof;

import java.util.ArrayList;
import java.util.List;

import modele.base.actionsdao.DAOEnseigne;
import modele.base.actionsdao.DAOPersonne;
import modele.vue.dao.DAOVueClasse;
import modele.vue.dao.DAOVuePersonne;

public class GestionProf {
    /**
     * Constructeur par défaut
     */
    public GestionProf() {     
    }
    
    /**
     * Obtient toutes les classes pour un prof
     * 
     * @param idProf
     * @return
     */
    public List<DAOVueClasse> getClasses (int idProf){
        List<DAOVueClasse> listeClasses = new ArrayList<DAOVueClasse>();
        DAOEnseigne daoEnseigne = new DAOEnseigne();
        listeClasses = daoEnseigne.getClasses(idProf);
                
        return listeClasses;
    }
}
