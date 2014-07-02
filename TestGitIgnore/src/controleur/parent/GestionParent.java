package controleur.parent;

import java.util.ArrayList;
import java.util.List;

import modele.base.actionsdao.DAOEleve;
import modele.base.actionsdao.DAOPersonne;
import modele.base.dao.Eleve;
import modele.base.dao.Personne;
import modele.vue.dao.DAOVuePersonne;
import modele.vue.dao.DAOVueParent;

public class GestionParent {
    
    /**
     * Constructeur par défaut
     */
    public GestionParent () {
    }
    
    /**
     * Obtient les enfants d'un parent
     * 
     * @param personne
     * @return
     */
    public DAOVueParent getEnfants (Personne personne){
        List<DAOVuePersonne> listeEnfants = new ArrayList<DAOVuePersonne>();
        DAOPersonne daoPersonne = new DAOPersonne ();
        int idPersonne = personne.getIdPersonne();
        listeEnfants = daoPersonne.getEnfants(idPersonne);
        DAOVueParent daoVueParent = new DAOVueParent(personne, listeEnfants);
        return daoVueParent;
    }

}
