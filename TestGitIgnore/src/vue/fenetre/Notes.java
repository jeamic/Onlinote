package vue.fenetre;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import modele.base.dao.Matiere;
import modele.base.dao.Personne;
import modele.vue.dao.DAOVueNote;
import vue.fenetre.Messagerie.MsgTableSelectionListenerRecu;
import vue.tools.ModelTableNote;
import controleur.cours.GestionMatiere;
import controleur.cours.GestionNotes;

public class Notes {
    private JPanel notes = null;
    private List<DAOVueNote> NotesArt = null;
    private List<DAOVueNote> NotesEPS = null;
    private List<DAOVueNote> NotesBio = null;
    private List<DAOVueNote> NotesFrancais = null;
    private List<DAOVueNote> NotesHistoire = null;
    private List<DAOVueNote> NotesLV1 = null;
    private List<DAOVueNote> NotesLV2 = null;
    private List<DAOVueNote> NoteMaths = null;
    private List<DAOVueNote> NotePhysique = null;
    private List<DAOVueNote> NoteMusique = null;
    private List<DAOVueNote> NoteTechno = null;
    
    
    public Notes (int idEleve) {
    
    
        notes = new JPanel(new BorderLayout());
        
        ModelTableNote model = new ModelTableNote();
        JTable table = new JTable(model);
        //table.getSelectionModel().addListSelectionListener(new MsgTableSelectionListenerRecu());
        JScrollPane panelScrollTable = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        GestionMatiere gestionnaireMatiere = new GestionMatiere();
        List<Matiere> Matiere = gestionnaireMatiere.getAllMatieres();
        GestionNotes gestionnaireNotes = new GestionNotes();
        NotesArt = gestionnaireNotes.getNotes(idEleve, 1, Matiere.get(0).getMatiere());
        NotesEPS = gestionnaireNotes.getNotes(idEleve, 1, Matiere.get(1).getMatiere());
        NotesBio = gestionnaireNotes.getNotes(idEleve, 1, Matiere.get(2).getMatiere());
        NotesFrancais = gestionnaireNotes.getNotes(idEleve, 1, Matiere.get(3).getMatiere());
        NotesHistoire = gestionnaireNotes.getNotes(idEleve, 1, Matiere.get(4).getMatiere());
        NotesLV1 = gestionnaireNotes.getNotes(idEleve, 1, Matiere.get(5).getMatiere());
        NotesLV2 = gestionnaireNotes.getNotes(idEleve, 1, Matiere.get(6).getMatiere());
        NoteMaths = gestionnaireNotes.getNotes(idEleve, 1, Matiere.get(7).getMatiere());
        NotePhysique = gestionnaireNotes.getNotes(idEleve, 1, Matiere.get(8).getMatiere());
        NoteMusique = gestionnaireNotes.getNotes(idEleve, 1, Matiere.get(9).getMatiere());
        NoteTechno = gestionnaireNotes.getNotes(idEleve, 1, Matiere.get(10).getMatiere());
        
        model.updateTableData(NotesArt, NotesEPS, NotesBio, NotesFrancais, NotesHistoire, NotesLV1, NotesLV2, NoteMaths, NotePhysique, NoteMusique, NoteTechno);
        
        
        notes.add(panelScrollTable);
        
    }
    
    public JPanel getNotes() {
        return notes;
    }

}
