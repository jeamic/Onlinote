package controleur.cours;

import modele.base.actionsdao.DAOControles;
import modele.base.dao.Controles;
import modele.vue.dao.DAOVueControle;

public class GestionControles {
    public GestionControles() {
    }
    
    public void ajouterNotes(DAOVueControle daoVueControle){
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
