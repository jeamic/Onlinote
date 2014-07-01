package controleur.administration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modele.base.actionsdao.DAOClasse;
import modele.base.dao.Personne;
import modele.utils.ConnexionJDBC;
import modele.vue.dao.DAOVueEleve;
import modele.vue.dao.DAOVueTypeClasse;

public class GestionClasse {

    
/*    select distributor_id,
    count(*) total,
    sum(case when level = 'exec' then 1 else 0 end) ExecCount,
    sum(case when level = 'personal' then 1 else 0 end) PersonalCount
from yourtable
group by distributor_id*/
    
    
    public GestionClasse () {
    }
    
    public List<DAOVueTypeClasse> getCountTypeClasse () {
        DAOClasse daoClasse = new DAOClasse();
        List<DAOVueTypeClasse> liste = daoClasse.countTypeClass();
        
        return liste;
    }
    
    public List<DAOVueEleve> getEleves (String nomClasse){
        DAOClasse daoClasse = new DAOClasse();
        List <DAOVueEleve> listeEleves = daoClasse.getEleves(nomClasse);
        
        return listeEleves;
    }


}
