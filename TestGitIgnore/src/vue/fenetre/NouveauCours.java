package vue.fenetre;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.base.dao.Matiere;
import modele.vue.dao.DAOVueCours;
import modele.vue.dao.DAOVuePersonne;
import modele.vue.dao.DAOVueSalle;
import controleur.administration.GestionSalles;
import controleur.cours.GestionCours;
import controleur.cours.GestionMatiere;
import controleur.prof.GestionProf;

import javax.swing.JButton;

import vue.tools.ComboItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class NouveauCours {
    
    private static JFrame frmCours;
    private JPanel panel;
    private JLabel lblMatire;
    private JLabel lblNomSalle;
    private JComboBox<String> comboBoxMatiere;
    private JButton btnAjouterCours;
    private JLabel lblNomProf;
    private JComboBox<String> comboBoxSalle;
    private JComboBox<ComboItem> comboBoxProf;
    private String dateP = null;
    private NouveauCours(String date, String nomClasse) {
        
        
        frmCours = new JFrame();
        
        dateP = date;
        
        panel = new JPanel();
        frmCours.getContentPane().add(panel);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0};
        gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        panel.setLayout(gbl_panel);
        
        lblNomSalle = new JLabel("Nom salle");
        GridBagConstraints gbc_lblNomSalle = new GridBagConstraints();
        gbc_lblNomSalle.insets = new Insets(0, 0, 5, 5);
        gbc_lblNomSalle.gridx = 1;
        gbc_lblNomSalle.gridy = 1;
        panel.add(lblNomSalle, gbc_lblNomSalle);
        
        comboBoxSalle = new JComboBox<String>();
        GestionSalles gestionnaireSalle = new GestionSalles();
        List<DAOVueSalle> listSalle = gestionnaireSalle.getAllNomSalles();
        
        for (int i =0; i<listSalle.size();++i){
            comboBoxSalle.addItem(listSalle.get(i).getNomSalle());
        }
        GridBagConstraints gbc_comboBoxSalle = new GridBagConstraints();
        gbc_comboBoxSalle.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxSalle.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxSalle.gridx = 3;
        gbc_comboBoxSalle.gridy = 1;
        panel.add(comboBoxSalle, gbc_comboBoxSalle);
        
        lblMatire = new JLabel("Matière");
        GridBagConstraints gbc_lblMatire = new GridBagConstraints();
        gbc_lblMatire.insets = new Insets(0, 0, 5, 5);
        gbc_lblMatire.gridx = 1;
        gbc_lblMatire.gridy = 3;
        panel.add(lblMatire, gbc_lblMatire);
        
        comboBoxMatiere = new JComboBox<String>();
        GestionMatiere gestionnaireMatiere = new GestionMatiere();
        List<Matiere> listMatiere = gestionnaireMatiere.getAllMatieres();
        
        for (int i=0; i<listMatiere.size(); ++i) {
            comboBoxMatiere.addItem(listMatiere.get(i).getMatiere());
        }
        
        GridBagConstraints gbc_comboBoxMatiere = new GridBagConstraints();
        gbc_comboBoxMatiere.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxMatiere.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxMatiere.gridx = 3;
        gbc_comboBoxMatiere.gridy = 3;
        panel.add(comboBoxMatiere, gbc_comboBoxMatiere);
        
        JLabel lblDure = new JLabel("Durée");
        GridBagConstraints gbc_lblDure = new GridBagConstraints();
        gbc_lblDure.insets = new Insets(0, 0, 5, 5);
        gbc_lblDure.gridx = 1;
        gbc_lblDure.gridy = 5;
        panel.add(lblDure, gbc_lblDure);
        
        final JComboBox<String> comboBoxDuree = new JComboBox<String>();
        comboBoxDuree.addItem("01:00:00");
        comboBoxDuree.addItem("02:00:00");
        comboBoxDuree.addItem("03:00:00");
        GridBagConstraints gbc_comboBoxDuree = new GridBagConstraints();
        gbc_comboBoxDuree.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxDuree.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxDuree.gridx = 3;
        gbc_comboBoxDuree.gridy = 5;
        panel.add(comboBoxDuree, gbc_comboBoxDuree);
        
        lblNomProf = new JLabel("Nom enseignant");
        GridBagConstraints gbc_lblNomProf = new GridBagConstraints();
        gbc_lblNomProf.insets = new Insets(0, 0, 5, 5);
        gbc_lblNomProf.gridx = 1;
        gbc_lblNomProf.gridy = 7;
        panel.add(lblNomProf, gbc_lblNomProf);
        
        comboBoxProf = new JComboBox<ComboItem>();
        GestionProf gestionnaireProf = new GestionProf();
        List<DAOVuePersonne> listProf = gestionnaireProf.getAllProf();
        
        for (int i = 0; i<listProf.size();++i) {
            comboBoxProf.addItem(new ComboItem(listProf.get(i).getNom() + " " + listProf.get(i).getPrenom(), listProf.get(i).getIdEleve()));
            
        }
        
        GridBagConstraints gbc_comboBoxProf = new GridBagConstraints();
        gbc_comboBoxProf.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxProf.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxProf.gridx = 3;
        gbc_comboBoxProf.gridy = 7;
        panel.add(comboBoxProf, gbc_comboBoxProf);
        
        btnAjouterCours = new JButton("Ajouter cours");
        btnAjouterCours.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                Object itemP = comboBoxProf.getSelectedItem();
                DAOVueCours cours = new DAOVueCours();
                cours.setMatiere(comboBoxMatiere.getSelectedItem().toString());
                cours.setSalle(comboBoxSalle.getSelectedItem().toString());
                GestionCours gestionnaireCours = new GestionCours();

                gestionnaireCours.ajouterCours(cours, Date.valueOf(dateP), Time.valueOf(comboBoxDuree.getSelectedItem().toString()),((ComboItem)itemP).getValue(), "");
            }
        });
        GridBagConstraints gbc_btnAjouterCours = new GridBagConstraints();
        gbc_btnAjouterCours.insets = new Insets(0, 0, 0, 5);
        gbc_btnAjouterCours.gridx = 2;
        gbc_btnAjouterCours.gridy = 9;
        panel.add(btnAjouterCours, gbc_btnAjouterCours);
        
        frmCours.setVisible(true);
        
        frmCours.setResizable(false);
        

        frmCours.setTitle("Nouveau cours");
        frmCours.setBounds(100, 100, 581, 310);
        
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frmCours.setLocation(dim.width/2-frmCours.getSize().width/2, dim.height/2-frmCours.getSize().height/2);
        
    }
    
    public static void creerNouveauCours(String date, String nomClasse) {
        new NouveauCours(date, nomClasse);
    }
    
   
    
}
