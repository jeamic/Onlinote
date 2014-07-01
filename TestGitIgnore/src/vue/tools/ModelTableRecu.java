package vue.tools;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modele.vue.dao.DAOVueMessage;


public class ModelTableRecu extends AbstractTableModel {

    /*********************************************************************/
    /**                 Données membres de la classe                    **/
    /*********************************************************************/
    
    private static final    long serialVersionUID = 1L;
    
    private final           String                  mKStrMsgFrom    = "De",
                                                    mKStrMsgSubject = "Objet",
                                                    mKStrMsgContenu    = "Contenu";
    
    private final           String[]                mKColumnHeader  = 
                                                        new String[]{
                                                            mKStrMsgSubject,
                                                            mKStrMsgContenu,
                                                            mKStrMsgFrom
                                                        };
    
    private                 List<DAOVueMessage>           mMessagesList   = null;
    
    private                 Object                  mCellCur        = null;
    
    /*********************************************************************/
    /**             Constructeur de la classe                           **/
    /*********************************************************************/
    public ModelTableRecu()
    {
        super();
        
        // Récupération de la liste des messages
        mMessagesList = new ArrayList<DAOVueMessage>();
        
    }

    /*********************************************************************/
    /**         Méthodes membres de la classe ModelTableMessages        **/
    /*********************************************************************/
    
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
        return mMessagesList.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) 
    {
        
        if(getColumnName(columnIndex).equals(mKStrMsgFrom)){
            mCellCur = mMessagesList.get(rowIndex).getExpediteur();
        }
        else if(getColumnName(columnIndex).equals(mKStrMsgSubject)){
            mCellCur = mMessagesList.get(rowIndex).getObjet();
        }
        else if(getColumnName(columnIndex).equals(mKStrMsgContenu)){
            mCellCur = mMessagesList.get(rowIndex).getContenu();
        }
        else{
            mCellCur = "ERROR";
        }
        
        return (mCellCur);
    }   

    public void updateTableData (List<DAOVueMessage> listMsg)
    {
    
        mMessagesList = listMsg;

        fireTableDataChanged();
        
    }
    
}
