package controleur.prof;

import java.util.ArrayList;
import java.util.List;

import modele.base.actionsdao.DAOEnseigne;
import modele.base.actionsdao.DAOPersonne;
import modele.vue.dao.DAOVueClasse;
import modele.vue.dao.DAOVueEleve;

public class GestionProf {
    public GestionProf() {     
    }
    
    public List<DAOVueClasse> getClasses (int idProf){
        List<DAOVueClasse> listeClasses = new ArrayList<DAOVueClasse>();
        DAOEnseigne daoEnseigne = new DAOEnseigne();
                
        return listeClasses;
    }
}
