package modele.base.actionsdao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;

import controleur.connexion.Connexion;
import modele.base.dao.Categorie;
import modele.base.dao.Classe;
import modele.base.dao.Eleve;
import modele.base.dao.Personne;
import modele.utils.ConnexionJDBC;
import modele.vue.dao.DAOVueClasse;
import modele.vue.dao.DAOVuePersonne;
import modele.vue.dao.DAOVueTypeClasse;

public class DAOClasse extends DAOFactory <Classe>{

    /**
     * Log4j logger
     */
    static org.apache.log4j.Logger log4j =  LogManager.getLogger(Connexion.class.getName());
    
	@Override
	public Classe find(int id) {
		
		return null;
	}

	@Override
	public Classe create(Classe obj) {
		
		return null;
	}

	@Override
	public Classe update(Classe obj) {
		
		return null;
	}

	@Override
	public void delete(Classe obj) {
		
		
	}

	@Override
	public Classe find(String nomClasse) {
        /* déclaration et init des variables nécessaires */
        int idClasse;
        Classe classe = null;
        Statement stmt = null;
        ResultSet res = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = (Connection) instance.getConnection();
        
        try {
            stmt = conn.createStatement();
            res = stmt.executeQuery("select id_classe, id_prof_principal from classe where nom_classe = '" + nomClasse + "'");
            while (res.next()){
                idClasse = res.getInt("id_classe");
                classe = new Classe(idClasse, nomClasse, res.getInt("id_prof_principal"));
            }
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }        
        return classe;
	}

    @Override
    public List<Classe> findAll() {
        /* déclaration et init des variables nécessaires */
        List<Classe> listeClasse = new ArrayList<Classe>();
        Statement stmt = null;
        ResultSet res = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = (Connection) instance.getConnection();
        
        try {
            stmt = conn.createStatement();
            res = stmt.executeQuery("select * from classe");

            while (res.next()){
                listeClasse.add(new Classe(res.getInt("id_classe"), res.getString("nom_classe"), res.getInt("id_prof_principal")));
            }
            
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }        
        return listeClasse;
    }

    @Override
    public Classe map(java.sql.ResultSet resultSet) {
        
        return null;
    }
    
    /**
     * Compte le nombre de classes de chaque type
     * 
     * @return
     */
    public List<DAOVueTypeClasse> countTypeClasse () {
        List<DAOVueTypeClasse> listeTypeClasse = new ArrayList<DAOVueTypeClasse>();
        /* déclaration et init des variables nécessaires */
        Statement stmt = null;
        ResultSet res = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = (Connection) instance.getConnection();
        
        try {
            stmt = conn.createStatement();
            res = stmt.executeQuery("SELECT"
  +"CASE"
  +"  WHEN nom_classe LIKE '3%' THEN '3'"
  +"  WHEN nom_classe LIKE '4%' THEN '4'"
  +"  WHEN nom_classe LIKE '5%' THEN '5'"
  +"  WHEN nom_classe LIKE '6%' THEN '6'"
  +" END AS      type_classe"
+" , COUNT(*) AS nombre"
+" FROM classe"
+" GROUP BY "
+"  CASE"
  +"  WHEN nom_classe LIKE '3%' THEN '3'"
  +"  WHEN nom_classe LIKE '4%' THEN '4'"
  +"  WHEN nom_classe LIKE '5%' THEN '5'"
  +"  WHEN nom_classe LIKE '6%' THEN '6'"
  +"END);");

            while (res.next()){
                listeTypeClasse.add(new DAOVueTypeClasse(res.getString("type_classe"), res.getInt("nombre")));
            }
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }
        return listeTypeClasse;
    }
    
    /**
     * Obtient la liste des élèves d'une classe
     * 
     * @param nomClasse
     * @return
     */
    public List<DAOVuePersonne> getEleves (String nomClasse){
        List<DAOVuePersonne> listeEleves = new ArrayList<DAOVuePersonne>();
        Statement stmt = null;
        ResultSet res = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = (Connection) instance.getConnection();
        int idClasse = this.find(nomClasse).getIdClasse();
        
        try {
            stmt = conn.createStatement();
            res = stmt.executeQuery("select * "
                                + " from  eleve"
                                + " where id_classe = " + idClasse);

            while (res.next()){
                DAOPersonne daoPersonne = new DAOPersonne();
                Personne pers = daoPersonne.find(res.getInt("id_eleve"));
                DAOEleve daoEleve = new DAOEleve();
                Eleve eleve = daoEleve.find(res.getInt("id_eleve"));
                listeEleves.add(new DAOVuePersonne(pers, res.getInt("id_classe"), eleve.getIdParent1(), eleve.getIdParent2()));
            }
            
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        } 
        
        return listeEleves;
    }
    
    /**
     * Obtient toutes les classes d'un type
     * 
     * @param typeClasse
     * @return
     */
    public List<DAOVueClasse> getClasses (int typeClasse){
        List<DAOVueClasse> listeClasses = new ArrayList<DAOVueClasse>();
        
        /* déclaration et init des variables nécessaires */
        Statement stmt = null;
        ResultSet res = null;
        ConnexionJDBC instance = ConnexionJDBC.getInstance();
        Connection conn = (Connection) instance.getConnection();
        
        try {
            stmt = conn.createStatement();
            res = stmt.executeQuery("select * "
                                + " from classe c"
                                + " where nom_classe LIKE '"
                                + typeClasse + "%'"  + ";");
            while (res.next()){
                listeClasses.add(new DAOVueClasse(res.getInt("id_classe"), res.getString("nom_classe"), res.getInt("id_prof_principal")));
            }
            
        } catch (SQLException e) {
            log4j.info(e.getMessage(), e);
        }    
        return listeClasses;
    }

}
