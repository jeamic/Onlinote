package vue.fenetre;


import java.awt.BorderLayout;
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

import modele.base.dao.Personne;
import controleur.connexion.Onlinote;

public class FenetreAdmin {
	
	protected static JFrame maFenetreAdmin = null;

    private FenetreAdmin(Personne personne){
			
        maFenetreAdmin = new JFrame();
        
        
        
        maFenetreAdmin.setSize(new Dimension(880, 540));
        
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        maFenetreAdmin.setLocation(dim.width/2-maFenetreAdmin.getSize().width/2, dim.height/2-maFenetreAdmin.getSize().height/2);
        
        JPanel menuDroite = new JPanel();

        
        maFenetreAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        maFenetreAdmin.getContentPane().setLayout(new BorderLayout(0, 0));
        
            
        JLabel lblApplicationOnlinote = new JLabel("Bienvenue sur l'application Onlinote Administrateur");
        lblApplicationOnlinote.setBounds(150, 0, 714, 502);
        lblApplicationOnlinote.setVerticalAlignment(SwingConstants.TOP);
        lblApplicationOnlinote.setFont(new Font("Times new roman", Font.PLAIN, 32));
        lblApplicationOnlinote.setHorizontalAlignment(SwingConstants.CENTER);
        maFenetreAdmin.getContentPane().add(lblApplicationOnlinote, BorderLayout.NORTH);
        
        
        
        
        
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
        menuDroite.add(lblIconDeconnexion);
        menuDroite.add(lblDeconnexion);
        
        maFenetreAdmin.add(menuDroite, BorderLayout.EAST);
        
        maFenetreAdmin.setVisible(true);
	}
    
    public static void creerFenetreAdmin (Personne personne) {
        new FenetreAdmin (personne);
    }
	

}
