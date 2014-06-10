package vue.fenetre;


import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import modele.base.dao.Personne;

import org.apache.log4j.LogManager;

import controleur.connexion.Onlinote;

public class FenetreAdmin {
	
	protected static JFrame maFenetreAdmin = null;

    private FenetreAdmin(Personne personne){
        
        
        /**
         * Log4j logger
         */
        org.apache.log4j.Logger log4j =  LogManager.getLogger(ConnexionGUI.class.getName());
        
			
        maFenetreAdmin = new JFrame();
        
        
        
        maFenetreAdmin.setSize(new Dimension(880, 540));
        
        maFenetreAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        maFenetreAdmin.setLocation(dim.width/2-maFenetreAdmin.getSize().width/2, dim.height/2-maFenetreAdmin.getSize().height/2);
        
        JPanel menuDroite = new JPanel();

        
        JLabel lblApplicationOnlinote = new JLabel("Bienvenue sur l'application Onlinote Administrateur");
        lblApplicationOnlinote.setVerticalAlignment(SwingConstants.TOP);
        lblApplicationOnlinote.setFont(new Font("Times new roman", Font.PLAIN, 32));
        lblApplicationOnlinote.setHorizontalAlignment(SwingConstants.CENTER);
        
        
        JLabel lblDetails1 = new JLabel(" ");
        lblDetails1.setHorizontalAlignment(SwingConstants.CENTER);
        lblDetails1.setFont(new Font("Times new roman", Font.PLAIN, 12));
        JLabel lblVide = new JLabel(" ");
        lblVide.setHorizontalAlignment(SwingConstants.CENTER);
        
        
        java.net.URL imgURLAccueil = null;
        try {
            imgURLAccueil = new java.net.URL("file:img/mines_ales.png");
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            log4j.error("image existe pas");

        }
        ImageIcon imgAccueil = new ImageIcon(new ImageIcon(imgURLAccueil).getImage());
        
        JLabel lblImgAccueil= new JLabel(imgAccueil);
        lblImgAccueil.setBounds(0,0,100,100);
        JPanel panelTop = new JPanel(new BorderLayout());
        JPanel panelTopCentre = new JPanel(new BorderLayout());
        JPanel panelTopGauche = new JPanel(new BorderLayout());
        panelTopGauche .add(lblImgAccueil, BorderLayout.CENTER);
        
        panelTopGauche.setBounds(0,0,100,100);
        
        panelTopCentre.add(lblApplicationOnlinote, BorderLayout.NORTH);
        panelTopCentre.add(lblVide, BorderLayout.CENTER);
        panelTopCentre.add(lblDetails1, BorderLayout.SOUTH);
        
        panelTop.add(panelTopGauche);
        panelTop.add(panelTopCentre);
        
        
        maFenetreAdmin.getContentPane().add(panelTop, BorderLayout.NORTH);
            
        maFenetreAdmin.setVisible(true);
        
        URL imgURLOff = null;
        try {
            imgURLOff = new java.net.URL("file:img/offBlack.png");
        } catch (MalformedURLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        ImageIcon imgOff = new ImageIcon(new ImageIcon(imgURLOff).getImage().getScaledInstance(24, 24, Image.SCALE_DEFAULT));
        
        JLabel lblDeconnexion = new JLabel();
        lblDeconnexion.setHorizontalAlignment(SwingConstants.RIGHT);
        lblDeconnexion.setVerticalAlignment(SwingConstants.TOP);
        JLabel lblIconDeconnexion = new JLabel(imgOff);
        lblIconDeconnexion.setHorizontalAlignment(SwingConstants.RIGHT);
        lblDeconnexion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblIconDeconnexion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblIconDeconnexion.setBounds(5, 214, 29, 53);
        lblDeconnexion.setBounds(45, 230, 96, 17);
        lblDeconnexion.setFont(new Font("Times new roman", Font.PLAIN, 14));
        lblDeconnexion.setText("Deconnexion");
        lblDeconnexion.addMouseListener(new MouseAdapter() {  
            
            public void mouseClicked(MouseEvent e) {  
                
                 FenetreAdmin.maFenetreAdmin.dispose();
                 Onlinote.relancer();
    
            }  
        });
        lblIconDeconnexion.addMouseListener(new MouseAdapter() {  
            
            public void mouseClicked(MouseEvent e) {  
                
                 FenetreAdmin.maFenetreAdmin.dispose();
                 Onlinote.relancer();
    
            }  
        });
        menuDroite.add(lblIconDeconnexion);
        menuDroite.add(lblDeconnexion);
        
        
        maFenetreAdmin.getContentPane().add(menuDroite, BorderLayout.EAST);
                
        
        JPanel panelCentre = new JPanel(new BorderLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.weighty = 1;
        gbc.weightx = 1;
        gbc.gridy = 0;
        gbc.gridx = 1;
        JPanel multiRadio = new JPanel(new BorderLayout());
        ButtonGroup group = new ButtonGroup();
        JRadioButton aRadioButton = new JRadioButton("Gestion des élèves", true);
        aRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
        multiRadio.add(aRadioButton, BorderLayout.NORTH);
        group.add(aRadioButton);
        JRadioButton aRadioButton2 = new JRadioButton("Gestion des professeurs");
        multiRadio.add(aRadioButton2, BorderLayout.CENTER);
        aRadioButton2.setHorizontalAlignment(SwingConstants.CENTER);
        group.add(aRadioButton2);
        JRadioButton aRadioButton3 = new JRadioButton("Gestion de l'emploi du temps");
        multiRadio.add(aRadioButton3, BorderLayout.SOUTH);
        aRadioButton3.setHorizontalAlignment(SwingConstants.CENTER);
        group.add(aRadioButton3);
        
        panelCentre.add(multiRadio, BorderLayout.NORTH);
        
        final JTextField textField = new JTextField("Rechercher");
        
        gbc.gridy=1;
        gbc.gridx=0;
        textField.addMouseListener(new MouseAdapter() {  
            
            public void mouseClicked(MouseEvent e) {  
                
                textField.setText("");
    
            }  
        });
        
        textField.setPreferredSize(new Dimension(10,20));
        JPanel panelGestion = new JPanel(new BorderLayout());
        
        panelGestion.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
        
        panelGestion.add(textField, BorderLayout.NORTH);
       
        
        JPanel monCadreGestionEleve = new CadreGestionEleve().getCadreGestionEleve();
        panelGestion.add(monCadreGestionEleve,BorderLayout.CENTER);
        
        panelCentre.add(panelGestion, BorderLayout.CENTER);
        
        maFenetreAdmin.getContentPane().add(panelCentre, BorderLayout.CENTER);
        
        

       /* JComboBox comboBox = new JComboBox();
        comboBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        comboBox.setOpaque(false);
        comboBox.setLightWeightPopupEnabled(false);
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Gestion des élèves", "Gestion des professeurs", "Gestion de l'emploi du temps"}));
        comboBox.setPreferredSize(new Dimension(10,40));
        comboBox.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
        panelCentre.add(comboBox, BorderLayout.NORTH);
        
        JPanel panelCarreCentre = new JPanel();
        
        panelCarreCentre.setBorder(new LineBorder( new Color(0,0,0)));
        
        panelCentre.add(panelCarreCentre, BorderLayout.CENTER);
        */
        
        maFenetreAdmin.setVisible(true);
        
        
	}
    
    public static void creerFenetreAdmin (Personne personne) {
        new FenetreAdmin (personne);
    }
	

}
