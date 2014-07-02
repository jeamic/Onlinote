package controleur.personne;

import java.util.List;

import modele.base.actionsdao.DAOPersonne;
import modele.vue.dao.DAOVuePersonne;

public class GestionPersonne {
    /**
     * Constructeur par défaut
     */
    public GestionPersonne () {
    }
    
    /**
     * Trouve les personnes par nom, prénom ou contenant "name"
     * 
     * @param name nom ou prénom
     * @return liste des personnes avec ce nom
     */
    public List<DAOVuePersonne> findPersonneByName (String name){
        DAOPersonne daoPersonne = new DAOPersonne();
        return daoPersonne.findPersonneByName(name);
    }
}
