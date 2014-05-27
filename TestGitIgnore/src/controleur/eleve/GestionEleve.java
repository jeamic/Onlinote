package controleur.eleve;

import java.util.ArrayList;
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
        DAOEleve daoEleve = new DAOEleve();
        DAOPersonne daoPersonne = new DAOPersonne();
        
        Personne eleve_personne = new Personne();
        Eleve eleve = new Eleve();
        
        eleve_personne = daoPersonne.find(idEleve);
        eleve = daoEleve.find(idEleve);
        DAOVueEleve daoVueEleve = new DAOVueEleve(eleve_personne, eleve.getidClasse(), eleve.getIdParent1(), eleve.getIdParent2());
        return daoVueEleve;
    }
    
    public List<DAOVueEleve> getEleveByName (String name) {
        List<DAOVueEleve> listeDaoVueEleve = new ArrayList<DAOVueEleve>();
        DAOEleve daoEleve = new DAOEleve();
        listeDaoVueEleve = daoEleve.findEleveByName(name);
        
        for (int i = 0; i < listeDaoVueEleve.size(); ++i){
            listeDaoVueEleve.add(listeDaoVueEleve.get(i));
        }
        return listeDaoVueEleve;
    }

}
