package modele.vue.dao;
public class DAOVueMessage {
    /**
     * 
     */
    
    private int idMessage;
    private String emailExpediteur;
    private String objet;
    private String destinataires;
    private String contenu;
    private boolean lu;
    
    public DAOVueMessage (){
    }
    public DAOVueMessage (int idMessage, String emailExpediteur, String objet, String destinataires, String contenu, boolean lu) {
        this.idMessage  = idMessage;
        this.emailExpediteur = emailExpediteur;
        this.objet          = objet;
        this.destinataires  = destinataires;
        this.contenu        = contenu;
        this.lu             = lu;
    }
    public String getExpediteur() {
        return emailExpediteur;
    }
    public void setExpediteur(String emailExpediteur) {
        this.emailExpediteur = emailExpediteur;
    }
    public int getIdMessage() {
        return idMessage;
    }
    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }
    public String getObjet() {
        return objet;
    }
    public void setObjet(String objet) {
        this.objet = objet;
    }
    public String getDestinataires() {
        return destinataires;
    }
    public void setDestinataires(String destinataires) {
        this.destinataires = destinataires;
    }
    public String getContenu() {
        return contenu;
    }
    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
    public boolean isLu() {
        return lu;
    }
    public void setLu(boolean lu) {
        this.lu = lu;
    }

}
