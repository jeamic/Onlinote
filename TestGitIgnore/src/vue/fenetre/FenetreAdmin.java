package vue.fenetre;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

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
        
        maFenetreAdmin.add(menuDroite, BorderLayout.EAST);
        
        
        JPanel panelCentre = new JPanel();
        
        panelCentre.setBorder((new LineBorder(new Color(0, 0, 0))));
        
        maFenetreAdmin.add(panelCentre, BorderLayout.CENTER);
        
        maFenetreAdmin.setVisible(true);
        
        
	}
    
    public static void creerFenetreAdmin (Personne personne) {
        new FenetreAdmin (personne);
    }
	

}
