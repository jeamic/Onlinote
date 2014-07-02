package controleur.eleve;

import java.util.ArrayList;
import java.util.List;

import modele.base.actionsdao.DAOEleve;
import modele.base.actionsdao.DAOPersonne;
import modele.base.dao.Eleve;
import modele.base.dao.Personne;
import modele.vue.dao.DAOVuePersonne;

public class GestionEleve {
    
    /**
     * Constructeur par défaut
     */
    public GestionEleve() {
    }
    
    /**
     * Obtient un élève par l'id
     * 
     * @param idEleve
     * @return
     */
    public DAOVuePersonne getEleveById (int idEleve){
        DAOEleve daoEleve = new DAOEleve();
        DAOPersonne daoPersonne = new DAOPersonne();
        
        Personne eleve_personne = new Personne();
        Eleve eleve = new Eleve();
        
        eleve_personne = daoPersonne.find(idEleve);
        eleve = daoEleve.find(idEleve);
        DAOVuePersonne daoVueEleve = new DAOVuePersonne(eleve_personne, eleve.getidClasse(), eleve.getIdParent1(), eleve.getIdParent2());
        return daoVueEleve;
    }
    
    /**
     * Obtient une liste d'élèves par le nom
     * 
     * @param name
     * @return
     */
    public List<DAOVuePersonne> getEleveByName (String name) {
        List<DAOVuePersonne> listeDaoVueEleve = new ArrayList<DAOVuePersonne>();
        DAOEleve daoEleve = new DAOEleve();
        listeDaoVueEleve = daoEleve.findEleveByName(name);
        
        for (int i = 0; i < listeDaoVueEleve.size(); ++i){
            listeDaoVueEleve.add(listeDaoVueEleve.get(i));
        }
        return listeDaoVueEleve;
    }
   

}
