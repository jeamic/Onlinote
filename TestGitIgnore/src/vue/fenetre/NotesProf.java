package vue.fenetre;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import vue.tools.ComboItem;
import modele.base.dao.Personne;
import modele.vue.dao.DAOVueClasse;
import modele.vue.dao.DAOVueControle;
import modele.vue.dao.DAOVueNote;
import modele.vue.dao.DAOVuePersonne;
import controleur.administration.GestionClasse;
import controleur.cours.GestionControles;
import controleur.cours.GestionNotes;

public class NotesProf {
    private JPanel notes = null;
    private List<DAOVuePersonne> listEleve = null;
    private List<DAOVueControle> listControle = null;
    private JTextField textField;
    private JComboBox<ComboItem> comboBox = null;
    private JComboBox<ComboItem> comboBox_1 = null;
    private JButton btnNewButton = null;
    
    
    public NotesProf (Personne personne, DAOVueClasse classe) {
    
    
        notes = new JPanel(new BorderLayout());
        
        JPanel panel = new JPanel();
        notes.add(panel, BorderLayout.CENTER);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[]{0, 0, 74, 0, 0, 0, 0, 0};
        gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_panel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
        gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        panel.setLayout(gbl_panel);
        
        comboBox = new JComboBox<>();
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (comboBox_1.getSelectedItem() != null) {
                    textField.setEditable(true);
                    btnNewButton.setEnabled(true);
                    textField.setText("");
                    
                    Object itemC = comboBox_1.getSelectedItem();
                    Object itemE = comboBox.getSelectedItem();
                    GestionNotes gestionnaireNotes = new GestionNotes();
                    DAOVueNote note = gestionnaireNotes.getNoteControle(((ComboItem)itemE).getValue(), ((ComboItem)itemC).getValue());
                    if (note != null) {
                        textField.setText(String.valueOf(note.getNote()));
                        textField.setEditable(false);
                        btnNewButton.setEnabled(false);
                    }
                }
            }
        });
        GridBagConstraints gbc_comboBox = new GridBagConstraints();
        gbc_comboBox.insets = new Insets(0, 0, 0, 5);
        gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBox.gridx = 0;
        gbc_comboBox.gridy = 8;
        panel.add(comboBox, gbc_comboBox);
        
        comboBox_1 = new JComboBox<>();
        GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
        gbc_comboBox_1.insets = new Insets(0, 0, 0, 5);
        gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBox_1.gridx = 2;
        gbc_comboBox_1.gridy = 8;
        panel.add(comboBox_1, gbc_comboBox_1);
        
        textField = new JTextField();
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.insets = new Insets(0, 0, 0, 5);
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 5;
        gbc_textField.gridy = 8;
        panel.add(textField, gbc_textField);
        textField.setColumns(10);
        
        btnNewButton = new JButton("Noter");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (textField.isEnabled()) {
                Object itemC = comboBox_1.getSelectedItem();
                Object itemE = comboBox.getSelectedItem();
                GestionNotes gestionnaireNotes = new GestionNotes();
                gestionnaireNotes.ajouterNote(((ComboItem)itemE).getValue(), ((ComboItem)itemC).getKey() , Integer.valueOf(textField.getText()));
                textField.setEditable(false);
                btnNewButton.setEnabled(false);
                }
            }
        });
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.gridx = 6;
        gbc_btnNewButton.gridy = 8;
        panel.add(btnNewButton, gbc_btnNewButton);
        
        GestionNotes gestionnaireNotes = new GestionNotes();
        
        
        GestionClasse gestionnaireClasse = new GestionClasse();
        listEleve = gestionnaireClasse.getEleves(classe.getNomClasse());
        
        GestionControles gestionnaireControle = new GestionControles();
        listControle = gestionnaireControle.getControles(classe.getIdClasse(), personne.getIdPersonne());
        
        if (!listEleve.isEmpty() && !listControle.isEmpty() ) {
            DAOVueNote note = gestionnaireNotes.getNoteControle(listEleve.get(0).getIdEleve(), listControle.get(0).getIdControle());
            if ( note != null ) {
                textField.setText(String.valueOf(note.getNote()));
                textField.setEditable(false);
                btnNewButton.setEnabled(false);
            } else {
                textField.setEditable(false);
                btnNewButton.setEnabled(false);
            }
            
        } else {
            textField.setEditable(false);
            btnNewButton.setEnabled(false);
        }
         
        
        
        for (int i =0;i<listEleve.size();++i) {
            comboBox.addItem(new ComboItem(listEleve.get(i).getNom() + " " + listEleve.get(i).getPrenom(), listEleve.get(i).getIdEleve()));
        }
        
        for (int i =0;i<listControle.size();++i) {
            comboBox_1.addItem(new ComboItem(listControle.get(i).getTitre(), listControle.get(i).getIdControle()));
        }
        
        
        
        
        
    }
    
    public JPanel getNotesProf() {
        return notes;
    }

}
