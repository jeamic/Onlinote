package vue.fenetre;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import modele.base.dao.Matiere;
import vue.tools.ModelTableEdt;
import controleur.cours.GestionMatiere;
import controleur.cours.GestionNotes;

public class EmploiDuTemps {/*
    private List<DAOVueCours> CoursLundi = null;
    private List<DAOVueCours> CoursMardi = null;
    private List<DAOVueCours> CoursMercredi = null;
    private List<DAOVueCours> CoursJeudi = null;
    private List<DAOVueCours> CoursVendredi = null;
    */
    private JPanel eDT = null;

    public EmploiDuTemps () {
    
    
        eDT = new JPanel(new BorderLayout());
      /*  
        ModelTableEdt model = new ModelTableEdt();
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
        */
    }
    
    public JPanel getEDT() {
        return eDT;
    }
}
