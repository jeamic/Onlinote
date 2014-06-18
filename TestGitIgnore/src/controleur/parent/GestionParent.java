package controleur.parent;

import java.util.ArrayList;
import java.util.List;

import modele.base.actionsdao.DAOEleve;
import modele.base.actionsdao.DAOPersonne;
import modele.base.dao.Eleve;
import modele.base.dao.Personne;
import modele.vue.dao.DAOVueEleve;
import modele.vue.dao.DAOVueParent;

public class GestionParent {
    
    public GestionParent () {
        
    }
    
    public DAOVueParent getEnfants (Personne personne){
        List<DAOVueEleve> listeEnfants = new ArrayList<DAOVueEleve>();
        DAOPersonne daoPersonne = new DAOPersonne ();
        int idPersonne = personne.getIdPersonne();
        listeEnfants = daoPersonne.getEnfants(idPersonne);
        DAOVueParent daoVueParent = new DAOVueParent(personne, listeEnfants);
        return daoVueParent;
    }

}
