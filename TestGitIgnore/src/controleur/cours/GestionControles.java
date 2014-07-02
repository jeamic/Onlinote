package controleur.cours;

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
        controle.setIdControle(daoVueControle.getIdControle());
        controle.setEnonce(daoVueControle.getEnonce());
        controle.setCorrige(daoVueControle.getCorrige());
        controle.setNoteMax(daoVueControle.getNoteMax());
        controle.setCoefficient(daoVueControle.getCoefficient());
        controle.setTrimestre(daoVueControle.getTrimestre());
        DAOControles daoControles = new DAOControles();
        daoControles.create(controle);
    }
}
