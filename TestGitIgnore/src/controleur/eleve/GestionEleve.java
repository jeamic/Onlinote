package controleur.eleve;

import java.util.ArrayList;
import java.util.List;

import modele.actionsdao.DAOEleve;
import modele.basedao.Eleve;

public class GestionEleve {
    public GestionEleve () {
    }
    
    public Eleve GetAllEleve(){
        DAOEleve dao = new DAOEleve();
        List<Eleve> listEleve = new ArrayList<Eleve>();
        
        listEleve = dao.findAll();
        
        for (int i = 0; i < listEleve.size(); ++i) {
            System.out.println(listEleve.get(i));
        }
        
        System.out.println(listEleve);
        return null;
    }
}
