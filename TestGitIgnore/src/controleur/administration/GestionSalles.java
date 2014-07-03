package controleur.administration;

import java.util.ArrayList;
import java.util.List;

import modele.base.actionsdao.DAOSalle;
import modele.base.dao.Salle;
import modele.vue.dao.DAOVueSalle;

public class GestionSalles {
    public GestionSalles() {
    }
    
    public List<DAOVueSalle> getAllNomSalles(){
        DAOSalle daoSalle = new DAOSalle();
        List<Salle> salle = daoSalle.findAll();
        List<DAOVueSalle> daoVueSalle = new ArrayList<DAOVueSalle>();
        for (int i =0; i < salle.size(); ++i ){
            daoVueSalle.add(new DAOVueSalle(salle.get(i).getIdSalle(), salle.get(i).getNomSalle())); 
        }
        return daoVueSalle;
    }
}
