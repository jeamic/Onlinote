package vue.tools;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modele.vue.dao.DAOVueCours;


public class ModelTableEdt extends AbstractTableModel {

    
    private static final    long serialVersionUID = 1L;
    
    private final           String                  mKStrHeures = "\\",
                                                    mKStrLundi    = "Lundi",
                                                    mKStrMardi = "Mardi",
                                                    mKStrMercredi    = "Mercredi",
                                                    mKStrJeudi    = "Jeudi",
                                                    mKStrVendredi    = "Vendredi";
    
    private final           String[]                mKColumnHeader  = 
                                                        new String[]{
                                                        mKStrHeures,
                                                        mKStrLundi,
                                                        mKStrMardi,
                                                        mKStrMercredi,
                                                        mKStrJeudi,
                                                        mKStrVendredi
                                                        };
    
    private                 List<String>                mHeures = null;
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
        mHeures = new ArrayList<String>();
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
        
        if(getColumnName(columnIndex).equals(mKStrHeures)){
                mCellCur = new String ("<html><p style='text-align:center'>" + mHeures.get(rowIndex).toString() + "</p></html>");
        }
        else if(getColumnName(columnIndex).equals(mKStrLundi)){
            if (mCoursListLundi.get(rowIndex).getMatiere() != null) {
                mCellCur = new String ("<html><p style='text-align:center'>" + mCoursListLundi.get(rowIndex).getMatiere() + " </p><p style='text-align:center'>Classe : " + mCoursListLundi.get(rowIndex).getSalle() + " </p><p style='text-align:center'>M." + mCoursListLundi.get(rowIndex).getNomProf() + "</p></html>");
            } else {
                mCellCur = "";
            }
        }
        else if(getColumnName(columnIndex).equals(mKStrMardi)){
            if (mCoursListMardi.get(rowIndex).getMatiere() != null) {
                mCellCur = new String ("<html><p style='text-align:center'>" + mCoursListMardi.get(rowIndex).getMatiere() + " </p><p style='text-align:center'>Classe : " + mCoursListMardi.get(rowIndex).getSalle() + " </p><p style='text-align:center'>M." + mCoursListMardi.get(rowIndex).getNomProf() + "</p></html>");
            } else {
                mCellCur = "";
            }
        }
        else if(getColumnName(columnIndex).equals(mKStrMercredi)){
            if (mCoursListMercredi.get(rowIndex).getMatiere() != null) {
                mCellCur = new String ("<html><p style='text-align:center'>" + mCoursListMercredi.get(rowIndex).getMatiere() + " </p><p style='text-align:center'>Classe : " + mCoursListMercredi.get(rowIndex).getSalle() + " </p><p style='text-align:center'>M." + mCoursListMercredi.get(rowIndex).getNomProf() + "</p></html>");
            } else {
                mCellCur = "";
            }
        }
        else if(getColumnName(columnIndex).equals(mKStrJeudi)){
            if (mCoursListJeudi.get(rowIndex).getMatiere() != null) {
                mCellCur = new String ("<html><p style='text-align:center'>" + mCoursListJeudi.get(rowIndex).getMatiere() + " </p><p style='text-align:center'>Classe : " + mCoursListJeudi.get(rowIndex).getSalle() + " </p><p style='text-align:center'>M." + mCoursListJeudi.get(rowIndex).getNomProf() + "</p></html>");
            } else {
                mCellCur = "";
            }
        }
        else if(getColumnName(columnIndex).equals(mKStrVendredi)){
            if (mCoursListVendredi.get(rowIndex).getMatiere() != null) {
                mCellCur = new String ("<html><p style='text-align:center'>" + mCoursListVendredi.get(rowIndex).getMatiere() + " </p><p style='text-align:center'>Classe : " + mCoursListVendredi.get(rowIndex).getSalle() + " </p><p style='text-align:center'>M." + mCoursListVendredi.get(rowIndex).getNomProf() + "</p></html>");
            } else {
                mCellCur = "";
            }
        }
        else{
            mCellCur = "ERROR";
        }
        
        return (mCellCur);
    }   

    public void updateTableData (List<String> heures, List<DAOVueCours> listLundi, List<DAOVueCours> listMardi, List<DAOVueCours> listMercredi, List<DAOVueCours> listJeudi, List<DAOVueCours> listVendredi)
    {
        mHeures = heures;
        mCoursListLundi = listLundi;
        mCoursListMardi = listMardi;
        mCoursListMercredi = listMercredi;
        mCoursListJeudi = listJeudi;
        mCoursListVendredi = listVendredi;

        fireTableDataChanged();
        
    }
    
}
