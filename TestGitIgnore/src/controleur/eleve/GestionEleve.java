package controleur.eleve;

import java.util.List;

import modele.base.actionsdao.DAOEleve;
import modele.base.actionsdao.DAOPersonne;
import modele.base.dao.Eleve;
import modele.base.dao.Personne;
import modele.vue.dao.DAOVueEleve;

public class GestionEleve {
    
    public GestionEleve() {
        // TODO Auto-generated constructor stub
    }
    
    public DAOVueEleve getEleveById (int idEleve){
        Personne eleve = new Personne();
        
        DAOPersonne daoEleve = new DAOPersonne();
        eleve = daoEleve.find(idEleve);
        
        DAOVueEleve daoVueEleve = new DAOVueEleve(eleve, id_classe, idparent1, idparent2);
        return daoVueEleve;
    }
    
    public List<DAOVueEleve> getEleveByName (String name) {
        return null;
    }

}
