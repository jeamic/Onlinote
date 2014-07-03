package modele.base.actionsdao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modele.base.dao.Categorie;
import modele.base.dao.Cours;
import modele.base.dao.Matiere;
import modele.base.dao.Salle;
import modele.utils.ConnexionJDBC;
import modele.vue.dao.DAOVueCours;

import org.apache.log4j.LogManager;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;

import controleur.connexion.Connexion;

public class DAOCours extends DAOFactory<Cours>{
    
    /**
     * Log4j logger
     */
    static org.apache.log4j.Logger log4j =  LogManager.getLogger(Connexion.class.getName());

	@Override
	public Cours find(int id) {
		
		return null;
	}

	@Override
	public Cours create(Cours cours) {
        Statement stmt = null;
        ResultSet res = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = (Connection) instance.getConnection();
        try {
            stmt = conn.createStatement();
            String req = "INSERT INTO Cours (id_cours, matiere, id_salle, commentaire, heure_debut, duree)"
                    + " values (" + cours.getidCours()
                    + "," + cours.getMatiere()
                    + "," + cours.getidSalle() 
                    + "," + cours.getCommentaire()
                    + "," + cours.getheureDebut()
                    + "," + cours.getDuree() + ");";
            stmt.executeUpdate(req);
        
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }
		return null;
	}

	@Override
	public Cours update(Cours obj) {
		
		return null;
	}

	@Override
	public void delete(Cours obj) {
	    return;
	}

	@Override
	public Cours find(String chaine /*format: 2014-05-15 10:00:01 trouve tous les cours à partir de cette date */) {
		
		return null;
	}

    @Override
    public List<Cours> findAll() {
        /* déclaration et init des variables nécessaires */
        List<Cours> listeCours = new ArrayList<Cours>();
        Statement stmt = null;
        ResultSet res = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = (Connection) instance.getConnection();
        
        try {
            stmt = conn.createStatement();
            res = stmt.executeQuery("select * from cours");

            while (res.next()){
                listeCours.add(new Cours(res.getInt("id_cours"), res.getString("matiere"), res.getInt("id_salle"), res.getString("commentaire"), res.getDate("heure_debut"), res.getTime("duree")));
            }
            
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }        
        return listeCours;
    }
    
    /**
     * Obtient les cours d'un élève à une date donnée
     *  
     * @param idPersonne
     * @param date format: 2014-05-15 10:00:01
     * @return 
     */
    public DAOVueCours getCours (int idPersonne, String date) {
        DAOClasse daoClasse = new DAOClasse();
        int idClasse = daoClasse.getEleveIdClasse(idPersonne);
        
        /* déclaration et init des variables nécessaires */
        DAOVueCours cours = new DAOVueCours();
        Statement stmt = null;
        ResultSet res = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = (Connection) instance.getConnection();
        
        /* requête pour rechercher la personne, param 1 = date, param 2 = idEleve*/
        try {
            stmt = conn.createStatement();
            res =   stmt.executeQuery(
                      "select  cours.id_cours, salle.nom_salle, prof.nom, cours.matiere, nom_classe"
                     +" from    cours, enseigne ens, personne prof, eleve, salle, classe cl, personne p"
                     +" where   eleve.id_classe = ens.id_classe"
                     +  " and ens.id_personne = prof.id_personne"
                     +  " and ens.id_cours = cours.id_cours"
                     +  " and '" + date + "' between heure_debut and addtime(heure_debut, duree)"
                     +  " and cours.id_salle = salle.id_salle"
                     +  " and ens.id_classe = cl.id_classe"
                     +  " and cl.id_classe = " + idClasse + ";");            

            while (res.next()){
                cours = new DAOVueCours(res.getInt("id_cours"), res.getString("nom"), res.getString("nom_classe"), res.getString("nom_salle"), res.getString("matiere"));
            }
            
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }        
        return cours;
    }
    
    /**
     * Obtient les cours d'une classe à une date donnée
     *  
     * @param nomClasse
     * @param date format: 2014-05-15 10:00:01
     * @return 
     */
    public DAOVueCours getCours (String nomClasse, String date) {       
        /* déclaration et init des variables nécessaires */
        DAOVueCours cours = new DAOVueCours();
        Statement stmt = null;
        ResultSet res = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = (Connection) instance.getConnection();
        
        /* requête pour rechercher la personne, param 1 = date, param 2 = idEleve*/
        try {
            stmt = conn.createStatement();
            res =   stmt.executeQuery(
                      "select  cours.id_cours, salle.nom_salle, prof.nom, cours.matiere, nom_classe"
                     +" from    cours, enseigne ens, personne prof, eleve, salle, classe cl, personne p"
                     +" where   eleve.id_classe = ens.id_classe"
                     +  " and ens.id_personne = prof.id_personne"
                     +  " and ens.id_cours = cours.id_cours"
                     +  " and '" + date + "' between heure_debut and addtime(heure_debut, duree)"
                     +  " and cours.id_salle = salle.id_salle"
                     +  " and ens.id_classe = cl.id_classe"
                     +  " and cl.nom_classe = '" + nomClasse + "';");            

            while (res.next()){
                cours = new DAOVueCours(res.getInt("id_cours"), res.getString("nom"), res.getString("nom_classe"), res.getString("nom_salle"), res.getString("matiere"));
            }
            
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }        
        return cours;
    }
    
    public void ajouterCours(DAOVueCours daoVueCours, Date heureDebut, Time duree){
        DAOSalle daoSalle = new DAOSalle();
        Salle salle = daoSalle.find(daoVueCours.getSalle());
        int idSalle = salle.getIdSalle();
        
        DAOCours daoCours = new DAOCours();
        Cours cours = new Cours(daoVueCours.getIdCours(), daoVueCours.getMatiere(), idSalle, "", heureDebut, duree);
        daoCours.create(cours);
    }
    
    @Override
    public Cours map(java.sql.ResultSet resultSet) {
        
        return null;
    }

}
