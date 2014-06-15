package controleur.messages;

import modele.base.actionsdao.DAOMessagerie;
import modele.base.actionsdao.DAOMessage;
import modele.base.actionsdao.DAOPersonne;
import modele.base.dao.*;
import modele.vue.dao.DAOVueMessage;

public class GestionMessages {
    public GestionMessages () {
    }
    
    /**
     * @param message mandatory field: email
     */
    public void envoyerMessage (DAOVueMessage message) {
        Personne pers = new Personne();
        DAOPersonne daoPers = new DAOPersonne();
        pers = daoPers.find(message.getExpediteur());
        
        if (pers != null){
            Message envoiMessage = new Message();
            envoiMessage.setObjet(message.getObjet());
            envoiMessage.setDestinataires(message.getDestinataires());
            envoiMessage.setContenu(message.getContenu());
            DAOMessage daoMessage = new DAOMessage();
            envoiMessage = daoMessage.create(envoiMessage);
            
            /* ajout à la table des correspondances de l'éxpéditeur */
            Messagerie compose = new Messagerie();
            compose.setIdMessage(envoiMessage.getIdMessage());
            compose.setIdPersonne(pers.getIdPersonne());
            compose.setEnvoiOuRecu(true);
            DAOMessagerie daoCompose = new DAOMessagerie();
            daoCompose.create(compose);        
            
            /*ajout à la table des correspondances pour chaque destinataire*/
            message.setDestinataires(message.getDestinataires().trim());
            String tabAdresses [] = message.getDestinataires().split(";");
            
            for (int i = 0; i < tabAdresses.length; ++i) {
                Personne pers2 = new Personne();
                pers2 = daoPers.find(tabAdresses[i]);
                
                /* si le destinataire existe*/
                if (pers2 != null){
                    Messagerie compose2 = new Messagerie();
                    compose2.setIdMessage(envoiMessage.getIdMessage());
                    compose2.setIdPersonne(pers2.getIdPersonne());
                    compose2.setEnvoiOuRecu(false);
                    daoCompose.create(compose2); 
                }
            }
        }
    }
}
