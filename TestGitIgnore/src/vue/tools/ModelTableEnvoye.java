package vue.tools;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modele.vue.dao.DAOVueMessage;


public class ModelTableEnvoye extends AbstractTableModel {
    
    private static final    long serialVersionUID = 1L;
    
    private final           String                  mKStrMsgA    = "A",
                                                    mKStrMsgSubject = "Objet",
                                                    mKStrMsgContenu    = "Contenu";
    
    private final           String[]                mKColumnHeader  = 
                                                        new String[]{
                                                            mKStrMsgSubject,
                                                            mKStrMsgContenu,
                                                            mKStrMsgA
                                                        };
    
    private                 List<DAOVueMessage>           mMessagesList   = null;
    
    private                 Object                  mCellCur        = null;
    
    public ModelTableEnvoye() {
        super();
        
        // Récupération de la liste des messages
        mMessagesList = new ArrayList<DAOVueMessage>();
        
    }
    
    @Override
    public int getColumnCount() {
        return mKColumnHeader.length;
    }

    @Override
    public String getColumnName(int columnIndex) {

        return mKColumnHeader[columnIndex];

    }
    
    @Override
    public int getRowCount() {   
        return mMessagesList.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        if(getColumnName(columnIndex).equals(mKStrMsgA)){
            mCellCur = mMessagesList.get(rowIndex).getDestinataires();
        } else if(getColumnName(columnIndex).equals(mKStrMsgSubject)){
            mCellCur = mMessagesList.get(rowIndex).getObjet();
        } else if(getColumnName(columnIndex).equals(mKStrMsgContenu)){
            mCellCur = mMessagesList.get(rowIndex).getContenu();
        } else{
            mCellCur = "ERROR";
        }
        
        return (mCellCur);
    }   

    public void updateTableData (List<DAOVueMessage> listMsg) {
    
        mMessagesList = listMsg;

        fireTableDataChanged();
        
    }
    
}
