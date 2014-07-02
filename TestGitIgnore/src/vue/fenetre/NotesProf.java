package vue.fenetre;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modele.vue.dao.DAOVuePersonne;
import controleur.administration.GestionClasse;

public class NotesProf {
    private JPanel notes = null;
    private List<DAOVuePersonne> listEleve = null;
    private JTextField textField;
    
    
    public NotesProf (String nomClasse) {
    
    
        notes = new JPanel(new BorderLayout());
        
        JPanel panel = new JPanel();
        notes.add(panel, BorderLayout.CENTER);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[]{0, 0, 74, 0, 0, 0, 0, 0};
        gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_panel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
        gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        panel.setLayout(gbl_panel);
        
        JComboBox<String> comboBox = new JComboBox<String>();
        GridBagConstraints gbc_comboBox = new GridBagConstraints();
        gbc_comboBox.insets = new Insets(0, 0, 0, 5);
        gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBox.gridx = 0;
        gbc_comboBox.gridy = 8;
        panel.add(comboBox, gbc_comboBox);
        
        JComboBox<String> comboBox_1 = new JComboBox<String>();
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
        
        JButton btnNewButton = new JButton("Valider");
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.gridx = 6;
        gbc_btnNewButton.gridy = 8;
        panel.add(btnNewButton, gbc_btnNewButton);
        
        GestionClasse gestionnaireClasse = new GestionClasse();
        listEleve = gestionnaireClasse.getEleves(nomClasse);
        
        //GestionControle gestionnaireControle = new GestionContro
        
        for (int i =0;i<listEleve.size();++i)
        {
            comboBox.addItem(listEleve.get(i).getNom() + " " + listEleve.get(i).getPrenom());
        }
        
        
        
        
        
        
    }
    
    public JPanel getNotesProf() {
        return notes;
    }

}
