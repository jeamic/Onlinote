package controleur.cours;

import java.util.ArrayList;
import java.util.List;

import modele.base.actionsdao.DAOControles;
import modele.base.dao.Controles;
import modele.vue.dao.DAOVueControle;

public class GestionControles {
    public GestionControles() {
    }
    
    /**
     * Ajoute un contrôle dans la base
     * 
     * @param daoVueControle
     */
    public void ajouterControle(DAOVueControle daoVueControle){
        Controles controle = new Controles();
        controle.setEnonce(daoVueControle.getEnonce());
        controle.setCorrige(daoVueControle.getCorrige());
        controle.setNoteMax(daoVueControle.getNoteMax());
        controle.setCoefficient(daoVueControle.getCoefficient());
        controle.setTrimestre(daoVueControle.getTrimestre());
        DAOControles daoControles = new DAOControles();
        daoControles.create(controle);
    }
    /**
     * Obtient la liste des contrôles d'une classe pour un prof
     * 
     * @param idClasse
     * @param idProf
     * @return
     */
    public List<DAOVueControle> getControles (int idClasse, int idProf){
        DAOControles daoControles = new DAOControles();
        return daoControles.getControles(idClasse, idProf);
    }
}
