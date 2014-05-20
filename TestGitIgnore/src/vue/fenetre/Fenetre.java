package vue.fenetre;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import modele.basedao.Personne;

public class Fenetre {
	
	protected static JFrame maFenetre = null;

    private Fenetre(Personne personne){
			
        maFenetre = new JFrame();
        
        maFenetre.setSize(new Dimension(880, 540));
        
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        maFenetre.setLocation(dim.width/2-maFenetre.getSize().width/2, dim.height/2-maFenetre.getSize().height/2);

        
        maFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel monMenu = new Menu("Accueil").getMenu();
        monMenu.setBounds(0,0,150,300);
        
        maFenetre.getContentPane().add( monMenu, BorderLayout.CENTER);
        maFenetre.getContentPane().setLayout(null);
        
        
        JLabel lblApplicationOnlinote = new JLabel("Bienvenue sur l'application Onlinote Mr X");
        lblApplicationOnlinote.setBounds(150, 0, 714, 502);
        lblApplicationOnlinote.setVerticalAlignment(SwingConstants.TOP);
        lblApplicationOnlinote.setFont(new Font("Times new roman", Font.PLAIN, 32));
        lblApplicationOnlinote.setHorizontalAlignment(SwingConstants.CENTER);
        maFenetre.getContentPane().add(lblApplicationOnlinote);
        
        
        JLabel lblDetails1 = new JLabel("L'application qui vous permet de suivre vos enfants et garder un contact avec l'administration");
        lblDetails1.setHorizontalAlignment(SwingConstants.CENTER);
        lblDetails1.setFont(new Font("Times new roman", Font.PLAIN, 12));
        lblDetails1.setBounds(150, 44, 714, 35);
        maFenetre.getContentPane().add(lblDetails1);
            
        maFenetre.setVisible(true);
	}
    
    public static void creerFenetre (Personne personne) {
        new Fenetre (personne);
    }
	

}
