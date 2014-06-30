package controleur.cours;

import java.util.ArrayList;
import java.util.List;

import modele.base.actionsdao.DAOMatiere;
import modele.base.dao.Matiere;

public class GestionMatiere {
    public GestionMatiere() {
    }
    
    public List<Matiere> getAllMatieres(){
        List<Matiere> listeMatieres = new ArrayList<Matiere>();
        DAOMatiere daoMatiere = new DAOMatiere();
        listeMatieres = daoMatiere.findAll();
        
        return listeMatieres;
    }
}
