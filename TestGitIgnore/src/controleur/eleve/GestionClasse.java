package controleur.eleve;

import java.util.List;

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
        return null;
        
    }


}
