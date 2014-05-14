package modele.actionsdao;
import org.apache.log4j.LogManager;

import modele.basedao.*;
import modele.bddconnect.ConnexionJDBC;

public class DAOEleve extends DAOFactory<Eleve>{
    /**
     * Log4j logger
     */
    static org.apache.log4j.Logger log4j =  LogManager.getLogger(ConnexionJDBC.class.getName());

	@Override
	public Eleve find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Eleve create(Eleve obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Eleve update(Eleve obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Eleve obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Eleve find(String chaine) {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
    public Eleve findAll() {        
        return null;
    }

}
