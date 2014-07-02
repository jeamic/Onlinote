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
import javax.swing.JComboBox;

public class NotesProf {
    private JPanel notes = null;

    
    
    public NotesProf (int idClass) {
    
    
        notes = new JPanel(new BorderLayout());
        
        JPanel panel = new JPanel();
        notes.add(panel, BorderLayout.CENTER);
        
        JComboBox comboBox = new JComboBox();
        panel.add(comboBox);
        
        
        
        
        
    }
    
    public JPanel getNotesProf() {
        return notes;
    }

}
