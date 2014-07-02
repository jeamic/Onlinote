package vue.tools;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modele.vue.dao.DAOVueCours;


public class ModelTableEdt extends AbstractTableModel {

    
    private static final    long serialVersionUID = 1L;
    
    private final           String                  mKStrLundi    = "Lundi",
                                                    mKStrMardi = "Mardi",
                                                    mKStrMercredi    = "Mercredi",
                                                    mKStrJeudi    = "Jeudi",
                                                    mKStrVendredi    = "Vendredi";
    
    private final           String[]                mKColumnHeader  = 
                                                        new String[]{
                                                        mKStrLundi,
                                                        mKStrMardi,
                                                        mKStrMercredi,
                                                        mKStrJeudi,
                                                        mKStrVendredi
                                                        };
    
    private                 List<DAOVueCours>           mCoursListLundi   = null;
    private                 List<DAOVueCours>           mCoursListMardi   = null;
    private                 List<DAOVueCours>           mCoursListMercredi   = null;
    private                 List<DAOVueCours>           mCoursListJeudi   = null;
    private                 List<DAOVueCours>           mCoursListVendredi   = null;
    
    private                 Object                  mCellCur        = null;
    
    public ModelTableEdt()
    {
        super();
        
        // Récupération de la liste des messages
        mCoursListLundi   = new ArrayList<DAOVueCours>();
        mCoursListMardi   =new ArrayList<DAOVueCours>();
        mCoursListMercredi   = new ArrayList<DAOVueCours>();
        mCoursListJeudi   = new ArrayList<DAOVueCours>();
        mCoursListVendredi   = new ArrayList<DAOVueCours>();
    }
    
    @Override
    public int getColumnCount() 
    {
        return mKColumnHeader.length;
    }

    @Override
    public String getColumnName(int columnIndex) 
    {

        return mKColumnHeader[columnIndex];

    }
    
    @Override
    public int getRowCount()
    {   
        return 10;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) 
    {
        
        if(getColumnName(columnIndex).equals(mKStrLundi)){
            mCellCur = mCoursListLundi.get(rowIndex).getMatiere();
        }
        else if(getColumnName(columnIndex).equals(mKStrMardi)){
            mCellCur = mCoursListMardi.get(rowIndex).getMatiere();
        }
        else if(getColumnName(columnIndex).equals(mKStrMercredi)){
            mCellCur = mCoursListMercredi.get(rowIndex).getMatiere();
        }
        else if(getColumnName(columnIndex).equals(mKStrJeudi)){
            mCellCur = mCoursListJeudi.get(rowIndex).getMatiere();
        }
        else if(getColumnName(columnIndex).equals(mKStrVendredi)){
            mCellCur = mCoursListVendredi.get(rowIndex).getMatiere();
        }
        else{
            mCellCur = "ERROR";
        }
        
        return (mCellCur);
    }   

    public void updateTableData (List<DAOVueCours> listLundi, List<DAOVueCours> listMardi, List<DAOVueCours> listMercredi, List<DAOVueCours> listJeudi, List<DAOVueCours> listVendredi)
    {
    
        mCoursListLundi = listLundi;
        mCoursListMardi = listMardi;
        mCoursListMercredi = listMercredi;
        mCoursListJeudi = listJeudi;
        mCoursListVendredi = listVendredi;

        fireTableDataChanged();
        
    }
    
}
