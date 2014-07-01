package vue.tools;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

import modele.vue.dao.DAOVueMessage;


public class ModelTable extends AbstractTableModel {

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
    
    private                 Color                   mKColorBgMsgNew = new Color(204, 255, 204),
                                                    mKColorBgMsgRead    = Color.WHITE,
                                                    mKColorBgMsgSelected = Color.LIGHT_GRAY,
                                                    mKColorFgMsgSelected = Color.WHITE;
    
    /*********************************************************************/
    /**             Constructeur de la classe                           **/
    /*********************************************************************/
    public ModelTable()
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
    
    public class DefaultCellRenderer extends DefaultTableCellRenderer
    {

        private static final long serialVersionUID = 1L;

        @Override
        public Component getTableCellRendererComponent(JTable table, 
                                                       Object value, 
                                                       boolean isSelected, 
                                                       boolean hasFocus, 
                                                       int row, 
                                                       int column)
        {
            super.getTableCellRendererComponent(table, 
                                                value, 
                                                isSelected, 
                                                hasFocus, 
                                                row, 
                                                column);
            this.setOpaque(true);

            setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
            
            if(isSelected){
                setForeground(mKColorFgMsgSelected);
                setBackground(mKColorBgMsgSelected);
            }
            else{
                setBackground(mKColorBgMsgRead);
                setFont(new Font(null, Font.ITALIC, 14));
                setForeground(Color.BLACK);
            }
            
            
            return this;
        }
    }   
}
