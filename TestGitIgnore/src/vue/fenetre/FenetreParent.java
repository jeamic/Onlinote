package vue.fenetre;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.MalformedURLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import modele.base.dao.Personne;

public class FenetreParent {
	
	protected static JFrame maFenetreParent = null;
	protected static JPanel panelTop = null;
	protected static JPanel panelCenter = null;

    private FenetreParent(Personne personne){
			
        maFenetreParent = new JFrame();
        
        maFenetreParent.getContentPane().setLayout(new BorderLayout());
        
        
        
        maFenetreParent.setSize(new Dimension(880, 540));
        
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        maFenetreParent.setLocation(dim.width/2-maFenetreParent.getSize().width/2, dim.height/2-maFenetreParent.getSize().height/2);

        
        maFenetreParent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel grosMenu = new JPanel(new GridBagLayout());
        
        JPanel monMenu = new Menu("Accueil").getMenu();
        monMenu.setPreferredSize(new Dimension(150, 300));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;
        //monMenu.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));

        JPanel monMenu2 = new JPanel();
        monMenu2.setBorder(BorderFactory.createEmptyBorder(30,30,130,30));
        
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.weighty=1;
        
        
        
        grosMenu.add(monMenu, gbc);
        
        
       
        maFenetreParent.getContentPane().add(grosMenu, BorderLayout.WEST);
        

        
        panelTop = new JPanel(new BorderLayout());
        JPanel panelTopGauche = new JPanel(new BorderLayout());
        JPanel panelTopCentre = new JPanel(new BorderLayout());
        
        JLabel lblApplicationOnlinote = new JLabel("Bienvenue sur l'application Onlinote Mr ");
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
            imgURLAccueil = new java.net.URL("file:img/mines_ales.png");
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ImageIcon imgAccueil = new ImageIcon(new ImageIcon(imgURLAccueil).getImage().getScaledInstance(24, 24, Image.SCALE_DEFAULT));
        
        JLabel lblImgAccueil= new JLabel(imgAccueil);
        panelTopGauche.add(lblImgAccueil, BorderLayout.CENTER);
        
        
        panelTopCentre.add(lblApplicationOnlinote, BorderLayout.NORTH);
        panelTopCentre.add(lblVide, BorderLayout.CENTER);
        panelTopCentre.add(lblDetails1, BorderLayout.SOUTH);
        
        panelTop.add(panelTopGauche);
        panelTop.add(panelTopCentre);
        
        maFenetreParent.getContentPane().add(panelTop, BorderLayout.NORTH);
            
        maFenetreParent.setVisible(true);
        
        
	}
    
    public static void creerFenetreParent (Personne personne) {
        new FenetreParent (personne);
    }
    
    public static void changeMenu()
    {
        if (panelTop != null) {
            
        }
        FenetreParent.maFenetreParent.remove(panelTop);
        
        if (panelCenter != null) {
            FenetreParent.maFenetreParent.remove(panelCenter);         
        }
        
        FenetreParent.maFenetreParent.repaint();
        FenetreParent.maFenetreParent.validate();
        
    }
}
