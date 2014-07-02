package vue.tools;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modele.vue.dao.DAOVueMessage;
import modele.vue.dao.DAOVueNote;


public class ModelTableNote extends AbstractTableModel {
    
    private static final    long serialVersionUID = 1L;
    
    private final           String                  mKStrArt   = "Arts plastiques",
                                                    mKStrEPS   ="E.P.S",
                                                    mKStrBio = "Bio",
                                                    mKStrFrancais    = "Français",
                                                    mKStrHistoire    = "Histoire Géographie",
                                                    mKStrLV1    = "LV1",
                                                    mKStrLV2    = "LV2",
                                                    mKStrMaths    = "Mathématiques",
                                                    mKStrMusique    = "Musique",
                                                    mKStrPhysique    = "Physique Chimie",
                                                    mKStrTechnologie    = "Technologie";
    
    private final           String[]                mKColumnHeader  = 
                                                        new String[]{
                                                    mKStrArt,
                                                    mKStrEPS,
                                                    mKStrBio,
                                                    mKStrFrancais,
                                                    mKStrHistoire,
                                                    mKStrLV1,
                                                    mKStrLV2,
                                                    mKStrMaths,
                                                    mKStrMusique,
                                                    mKStrPhysique,
                                                    mKStrTechnologie
            
                                                        };
    
    private                 List<DAOVueNote>           mNotesListArt   = null;
    private                 List<DAOVueNote>           mNotesListEPS   = null;
    private                 List<DAOVueNote>           mNotesListBio   = null;
    private                 List<DAOVueNote>           mNotesListFrancais   = null;
    private                 List<DAOVueNote>           mNotesListHistoire   = null;
    private                 List<DAOVueNote>           mNotesListLV1   = null;
    private                 List<DAOVueNote>           mNotesListLV2   = null;
    private                 List<DAOVueNote>           mNotesListMaths   = null;
    private                 List<DAOVueNote>           mNotesListMusique   = null;
    private                 List<DAOVueNote>           mNotesListPhysique   = null;
    private                 List<DAOVueNote>           mNotesListTechnologie   = null;
    
    
    private                 Object                  mCellCur        = null;
    
    
    public ModelTableNote() {
        super();
        
        // Récupération de la liste des messages
        mNotesListArt = new ArrayList<DAOVueNote>();
        mNotesListEPS   = new ArrayList<DAOVueNote>();
        mNotesListBio   = new ArrayList<DAOVueNote>();
        mNotesListFrancais   = new ArrayList<DAOVueNote>();
        mNotesListHistoire   = new ArrayList<DAOVueNote>();
        mNotesListLV1   = new ArrayList<DAOVueNote>();
        mNotesListLV2   = new ArrayList<DAOVueNote>();
        mNotesListMaths   = new ArrayList<DAOVueNote>();
        mNotesListMusique   = new ArrayList<DAOVueNote>();
        mNotesListPhysique   = new ArrayList<DAOVueNote>();
        mNotesListTechnologie   = new ArrayList<DAOVueNote>();
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
        return mNotesListMaths.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        if(getColumnName(columnIndex).equals(mKStrArt)){
            if (mNotesListArt.size() > rowIndex) {
                mCellCur = mNotesListArt.get(rowIndex).getNote() +"/" + mNotesListArt.get(rowIndex).getNoteMax() + " (" + mNotesListArt.get(rowIndex).getCoefficient() + ")" ;
            } else {
                mCellCur = "/";
            }
        } else if(getColumnName(columnIndex).equals(mKStrEPS)){
            if (mNotesListEPS.size() > rowIndex) {
                mCellCur = mNotesListEPS.get(rowIndex).getNote() +"/" + mNotesListEPS.get(rowIndex).getNoteMax() + " (" + mNotesListEPS.get(rowIndex).getCoefficient() + ")" ;
            } else {
                mCellCur = "/";
            }
        } else if(getColumnName(columnIndex).equals(mKStrBio)){
            if (mNotesListBio.size() > rowIndex) {
                mCellCur = mNotesListBio.get(rowIndex).getNote() +"/" + mNotesListBio.get(rowIndex).getNoteMax() + " (" + mNotesListBio.get(rowIndex).getCoefficient() + ")" ;
            } else {
                mCellCur = "/";
            }
        } else if(getColumnName(columnIndex).equals(mKStrFrancais)){
            if (mNotesListFrancais.size() > rowIndex) {
                mCellCur = mNotesListFrancais.get(rowIndex).getNote() +"/" + mNotesListFrancais.get(rowIndex).getNoteMax() + " (" + mNotesListFrancais.get(rowIndex).getCoefficient() + ")" ;
            } else {
                mCellCur = "/";
            }
        } else if(getColumnName(columnIndex).equals(mKStrHistoire)){
            if (mNotesListHistoire.size() > rowIndex) {
                mCellCur = mNotesListHistoire.get(rowIndex).getNote() +"/" + mNotesListHistoire.get(rowIndex).getNoteMax() + " (" + mNotesListHistoire.get(rowIndex).getCoefficient() + ")" ;
            } else {
                mCellCur = "/";
            }
        } else if(getColumnName(columnIndex).equals(mKStrLV1)){
            if (mNotesListLV1.size() > rowIndex) {
                mCellCur = mNotesListLV1.get(rowIndex).getNote() +"/" + mNotesListLV1.get(rowIndex).getNoteMax()+ " (" + mNotesListLV1.get(rowIndex).getCoefficient() + ")" ;
            } else {
                mCellCur = "/";
            }
        } else if(getColumnName(columnIndex).equals(mKStrLV2)){
            if (mNotesListLV2.size() > rowIndex) {
                mCellCur = mNotesListLV2.get(rowIndex).getNote() +"/" + mNotesListLV2.get(rowIndex).getNoteMax() + " (" + mNotesListLV2.get(rowIndex).getCoefficient() + ")" ;
            }
        } else if(getColumnName(columnIndex).equals(mKStrMaths)){
            if (mNotesListMaths.size() > rowIndex) {
                mCellCur = mNotesListMaths.get(rowIndex).getNote() +"/" + mNotesListMaths.get(rowIndex).getNoteMax() + " (" + mNotesListMaths.get(rowIndex).getCoefficient() + ")" ;
            } else {
                mCellCur = "/";
            }   
        } else if(getColumnName(columnIndex).equals(mKStrMusique)){
            if (mNotesListMusique.size() > rowIndex) {
                mCellCur = mNotesListMusique.get(rowIndex).getNote() +"/" + mNotesListMusique.get(rowIndex).getNoteMax() + " (" + mNotesListMusique.get(rowIndex).getCoefficient() + ")" ;
            } else {
                mCellCur = "/";
            }
        } else if(getColumnName(columnIndex).equals(mKStrPhysique)){
            if (mNotesListPhysique.size() > rowIndex) {
                mCellCur = mNotesListPhysique.get(rowIndex).getNote() +"/" + mNotesListPhysique.get(rowIndex).getNoteMax() + " (" + mNotesListPhysique.get(rowIndex).getCoefficient() + ")" ;
            } else {
                mCellCur = "/";
            }
        } else if(getColumnName(columnIndex).equals(mKStrTechnologie)){
            if (mNotesListTechnologie.size() > rowIndex) {
                mCellCur = mNotesListTechnologie.get(rowIndex).getNote() +"/" + mNotesListTechnologie.get(rowIndex).getNoteMax() + " (" + mNotesListTechnologie.get(rowIndex).getCoefficient() + ")" ;
            } else {
                mCellCur = "/";
            }
        } else{
            mCellCur = "ERROR";
        }
        
        return (mCellCur);
    }   

    public void updateTableData (List<DAOVueNote> listNoteArt, List<DAOVueNote> listNoteEPS, List<DAOVueNote> listNoteBio, List<DAOVueNote> listNoteFrancais, List<DAOVueNote> listNoteHistoire, List<DAOVueNote> listNoteLV1, List<DAOVueNote> listNoteLV2, List<DAOVueNote> listNoteMaths, List<DAOVueNote> listNoteMusique, List<DAOVueNote> listNotePhysique, List<DAOVueNote> listNoteTechno) {
    
        mNotesListArt = listNoteArt;
        mNotesListEPS = listNoteEPS;
        mNotesListBio = listNoteBio;
        mNotesListFrancais = listNoteFrancais;
        mNotesListHistoire = listNoteHistoire;
        mNotesListLV1 = listNoteLV1;
        mNotesListLV2 = listNoteLV2;
        mNotesListMaths = listNoteMaths;
        mNotesListMusique = listNoteMusique;
        mNotesListPhysique = listNotePhysique;
        mNotesListTechnologie = listNoteTechno;
        
        fireTableDataChanged();
        
    }
    
}
