package vue.fenetre;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.MalformedURLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import modele.base.dao.Personne;

import org.apache.log4j.LogManager;

public class FenetreEleve {
	
	protected static JFrame maFenetreEleve = null;
	protected static JPanel panelTop = null;
	protected static JPanel panelCenter = null;

    private FenetreEleve(Personne personne){
        
        /**
         * Log4j logger
         */
        
        
        
        org.apache.log4j.Logger log4j =  LogManager.getLogger(ConnexionGUI.class.getName());
			
        maFenetreEleve = new JFrame();
        
        maFenetreEleve.getContentPane().setLayout(new BorderLayout());
        
        
        
        maFenetreEleve.setSize(new Dimension(880, 540));
        
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        maFenetreEleve.setLocation(dim.width/2-maFenetreEleve.getSize().width/2, dim.height/2-maFenetreEleve.getSize().height/2);

        
        maFenetreEleve.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel grosMenu = new JPanel(new GridBagLayout());
        
        JPanel monMenu = new MenuEleve("Accueil", personne).getMenu();
        monMenu.setPreferredSize(new Dimension(150, 300));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;
        //monMenu.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
        
        
        JLabel testEspace = new JLabel(" ");
        

        JPanel monMenu2 = new JPanel(new BorderLayout());
        
        monMenu2.add(testEspace, BorderLayout.NORTH);
        monMenu2.add(monMenu, BorderLayout.NORTH);
        
                
        grosMenu.add(monMenu2, gbc);
        
        
       
        maFenetreEleve.getContentPane().add(grosMenu, BorderLayout.WEST);
        

        
        panelTop = new JPanel(new BorderLayout());
        JPanel panelTopGauche = new JPanel(new BorderLayout());
        JPanel panelTopCentre = new JPanel(new BorderLayout());
        
        JLabel lblApplicationOnlinote = new JLabel("Bienvenue sur l'application Onlinote");
        lblApplicationOnlinote.setVerticalAlignment(SwingConstants.TOP);
        lblApplicationOnlinote.setFont(new Font("Times new roman", Font.PLAIN, 32));
        lblApplicationOnlinote.setHorizontalAlignment(SwingConstants.CENTER);
        
        
        JLabel lblDetails1 = new JLabel("L'application qui vous permet de suivre vos enfants et garder un contact avec l'administration");
        lblDetails1.setHorizontalAlignment(SwingConstants.CENTER);
        lblDetails1.setFont(new Font("Times new roman", Font.PLAIN, 12));
        JLabel lblVide = new JLabel(" ");
        lblVide.setHorizontalAlignment(SwingConstants.CENTER);
        
        
        java.net.URL imgURLAccueil = null;
        try {
            imgURLAccueil = new java.net.URL("file:img/gard.png");
        } catch (MalformedURLException e) {
            log4j.error("image existe pas");

        }
        ImageIcon imgAccueil = new ImageIcon(new ImageIcon(imgURLAccueil).getImage().getScaledInstance(100, 50, Image.SCALE_DEFAULT));
        
        JLabel lblImgAccueil= new JLabel(imgAccueil);
        lblImgAccueil.setBounds(0,0,100,100);
        panelTopGauche.add(lblImgAccueil, BorderLayout.CENTER);
        
        panelTopGauche.setBounds(0,0,100,100);
        
        panelTopCentre.add(lblApplicationOnlinote, BorderLayout.NORTH);
        panelTopCentre.add(lblVide, BorderLayout.CENTER);
        panelTopCentre.add(lblDetails1, BorderLayout.SOUTH);
        
        panelTop.add(panelTopGauche);
        panelTop.add(panelTopCentre);
        
        
        maFenetreEleve.getContentPane().add(panelTop, BorderLayout.NORTH);
            
        maFenetreEleve.setVisible(true);
        
        
        
        
	}
    
    public static void creerFenetreEleve (Personne personne) {
        new FenetreEleve (personne);
    }
    
    public static void changeMenu()
    {
        if (panelTop != null) {
            FenetreEleve.maFenetreEleve.remove(panelTop);
        }

        
        if (panelCenter != null) {
            FenetreEleve.maFenetreEleve.remove(panelCenter);         
        }
        
        FenetreEleve.maFenetreEleve.repaint();
        FenetreEleve.maFenetreEleve.validate();
        
    }
}
