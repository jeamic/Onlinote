package modele.vue.dao;
public class DAOVueMessage {
    /**
     * 
     */
    
    private int idMessage;
    private int idPersonne;
    private String emailExpediteur;
    private String objet;
    private String destinataires;
    private String contenu;
    private int lu;
    private int envoiRecu;
    
    public DAOVueMessage (){
    }
    public DAOVueMessage (int idMessage, int idPersonne, String emailExpediteur, String objet, String destinataires, String contenu, int lu, int envoiRecu) {
        this.idMessage  = idMessage;
        this.emailExpediteur = emailExpediteur;
        this.objet          = objet;
        this.destinataires  = destinataires;
        this.contenu        = contenu;
        this.lu             = lu;
        this.idPersonne     = idPersonne;
        this.envoiRecu      = envoiRecu;
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
    public int getIdPersonne() {
        return idPersonne;
    }
    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }
    public int getLu() {
        return lu;
    }
    public void setLu(int lu) {
        this.lu = lu;
    }
    public int getEnvoiRecu() {
        return envoiRecu;
    }
    public void setEnvoiRecu(int envoiRecu) {
        this.envoiRecu = envoiRecu;
    }


}
