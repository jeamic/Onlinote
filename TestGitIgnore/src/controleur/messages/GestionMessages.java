package controleur.messages;

import modele.base.actionsdao.DAOCompose;
import modele.base.actionsdao.DAOMessage;
import modele.base.actionsdao.DAOPersonne;
import modele.base.dao.*;
import modele.vue.dao.DAOVueMessage;

public class GestionMessages {
    public GestionMessages () {
    }
    
    /**
     * @param message
     * @param expediteur mandatory field: email
     */
    public void envoyerMessage (DAOVueMessage message, Personne expediteur) {
        Message envoiMessage = new Message();
        envoiMessage.setObjet(message.getObjet());
        envoiMessage.setDestinataires(message.getDestinataires());
        envoiMessage.setContenu(message.getContenu());
        DAOMessage daoMessage = new DAOMessage();
        envoiMessage = daoMessage.create(envoiMessage);
        
        Personne pers = new Personne();
        DAOPersonne daoPers = new DAOPersonne();
        pers = daoPers.find(expediteur.getEmail());
        
        Compose compose = new Compose();
        compose.setIdMessage(envoiMessage.getIdMessage());
        compose.setIdPersonne(pers.getIdPersonne());
        DAOCompose daoCompose = new DAOCompose();
        daoCompose.create(compose);
    }
}
