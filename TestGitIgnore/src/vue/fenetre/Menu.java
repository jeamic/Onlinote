package vue.fenetre;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import org.apache.log4j.LogManager;

import controleur.connexion.Onlinote;


public class Menu {
    
    /**
     * Log4j logger
     */
    static org.apache.log4j.Logger log4j =  LogManager.getLogger(ConnexionGUI.class.getName());
	
	private JPanel menu = null;
	
	public Menu (String ongletEC) {
	    
	    ImageIcon tabImg[] = getImg();
	    

		
		menu = new JPanel();
		menu.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		menu.setSize(new Dimension(153, 267));
		menu.setLayout(null);
		
	    addAccueil(tabImg[0], ongletEC);
        addNotes(tabImg[1], ongletEC);
        addMsg(tabImg[2], ongletEC);
        addEmploiDuTemps(tabImg[3], ongletEC);
        addDeconnexion(tabImg[4], ongletEC);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(15, 58, 125, 63);
		
		
		JLabel lblEleve = new JLabel();
		
		lblEleve.setFont(new Font("Times new roman", Font.PLAIN, 14));
		lblEleve.setText("Elève :");
		lblEleve.setBounds(51,59,96,26);
		
		
		JLabel lblNomEleve = new JLabel("");
		
		menu.add(lblEleve);
		panel.add(lblNomEleve);
		menu.add(panel);

	}
	
	public JPanel getMenu() {
		return menu;
	}
	

	
	private ImageIcon[] getImg() {
	    
	       java.net.URL imgURLAccueil, imgURLNotes, imgURLSchedule, imgURLOff, imgURLMsg;
	        ImageIcon imgAccueil = null;
	        ImageIcon imgNotes = null;
	        ImageIcon imgSchedule = null;
	        ImageIcon imgOff = null;
	        ImageIcon imgMsg = null;
	        try {
	            imgURLAccueil = new java.net.URL("file:img/homeBlack.png");
	            imgAccueil = new ImageIcon(new ImageIcon(imgURLAccueil).getImage().getScaledInstance(24, 24, Image.SCALE_DEFAULT));
	            imgURLNotes = new java.net.URL("file:img/notesBlack.png");
	            imgNotes = new ImageIcon(new ImageIcon(imgURLNotes).getImage().getScaledInstance(24, 24, Image.SCALE_DEFAULT));
	            imgURLSchedule = new java.net.URL("file:img/clockBlack.png");
	            imgSchedule = new ImageIcon(new ImageIcon(imgURLSchedule).getImage().getScaledInstance(24, 24, Image.SCALE_DEFAULT));
	            imgURLOff = new java.net.URL("file:img/offBlack.png");
	            imgOff = new ImageIcon(new ImageIcon(imgURLOff).getImage().getScaledInstance(24, 24, Image.SCALE_DEFAULT));
	            imgURLMsg = new java.net.URL("file:img/msgBlack.png");
	            imgMsg = new ImageIcon(new ImageIcon(imgURLMsg).getImage().getScaledInstance(24, 24, Image.SCALE_DEFAULT));
	        } catch (MalformedURLException e) {
	            
	            log4j.info(e.getMessage(), e);
	        }
	        
	        ImageIcon tabImg[] ={imgAccueil, imgNotes, imgMsg, imgSchedule, imgOff};
            return tabImg;

	}
	
	private void addDeconnexion (ImageIcon tabImg, String ongletEC) {
    	JLabel lblDeconnexion = new JLabel();
        JLabel lblIconDeconnexion = new JLabel(tabImg);
        lblDeconnexion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblIconDeconnexion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblIconDeconnexion.setBounds(5, 214, 29, 53);
        lblDeconnexion.setBounds(45, 230, 96, 17);
        lblDeconnexion.setFont(new Font("Times new roman", Font.PLAIN, 14));
        lblDeconnexion.setText("Deconnexion");
        if (lblDeconnexion.getText() == ongletEC) {
            lblDeconnexion.setFont(new Font("Times new roman", Font.BOLD, 14));
        }
        lblDeconnexion.addMouseListener(new MouseAdapter() {  
            
            public void mouseClicked(MouseEvent e) {  
                
                 Fenetre.maFenetre.dispose();
                 Onlinote.relancer();
    
            }  
        });
        lblIconDeconnexion.addMouseListener(new MouseAdapter() {  
            
            public void mouseClicked(MouseEvent e) {  
                
                 Fenetre.maFenetre.dispose();
                 Onlinote.relancer();
    
            }  
        });
        menu.add(lblIconDeconnexion);
        menu.add(lblDeconnexion);
	}
	private void addAccueil (ImageIcon tabImg, String ongletEC) {
        JLabel lblIconAccueil = new JLabel(tabImg);
        JLabel lblAccueil = new JLabel();
        lblIconAccueil.setBounds(5, 4, 29, 53);
        lblAccueil.setBounds(44, 4, 50, 53);
        lblAccueil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblIconAccueil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblAccueil.setFont(new Font("Times new roman", Font.PLAIN, 14));
        lblAccueil.setText("Accueil");
        if ( lblAccueil.getText() == ongletEC) {
            lblAccueil.setFont(new Font("Times new roman", Font.BOLD, 14));
        }
        lblAccueil.addMouseListener(new MouseAdapter() {  
            public void mouseClicked(MouseEvent e) {  
                 switchOnglet("Accueil");
            }  
        });
        lblIconAccueil.addMouseListener(new MouseAdapter() {  
            public void mouseClicked(MouseEvent e) {  
                switchOnglet("Accueil");
           }  
        });

        menu.add(lblIconAccueil);
        menu.add(lblAccueil);
	}
	
	
	private void addNotes(ImageIcon tabImg, String ongletEC) {
	    JLabel lblNotes = new JLabel();
        JLabel lblIconNotes = new JLabel(tabImg);
        lblIconNotes.setBounds(5, 119, 29, 53);
        lblNotes.setBounds(45, 136, 50, 17);
        lblNotes.setFont(new Font("Times new roman", Font.PLAIN, 14));
        lblNotes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblIconNotes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblNotes.setText("Notes");
        if (lblNotes.getText() == ongletEC) {
            lblNotes.setFont(new Font("Times new roman", Font.BOLD, 14));
        }
        
        lblNotes.addMouseListener(new MouseAdapter()  {  
            public void mouseClicked(MouseEvent e) {  
                 switchOnglet("Notes");
            }  
        });
        lblIconNotes.addMouseListener(new MouseAdapter()  {  
            public void mouseClicked(MouseEvent e) {  
                switchOnglet("Notes");
           }  
        });
        menu.add(lblIconNotes);
        menu.add(lblNotes);
	}
	
	private void addEmploiDuTemps(ImageIcon tabImg, String ongletEC) { 
        JLabel lblEmploiDuTemps = new JLabel();
        JLabel lblIconEmploiDuTemps = new JLabel(tabImg);
        lblEmploiDuTemps.addMouseListener(new MouseAdapter() {  
            public void mouseClicked(MouseEvent e) {  
                 switchOnglet("Emploi du temps");
            }  
        });
        lblIconEmploiDuTemps.addMouseListener(new MouseAdapter() {  
            public void mouseClicked(MouseEvent e) {  
                switchOnglet("Emploi du temps");
           }  
        });
        lblIconEmploiDuTemps.setBounds(5, 179, 29, 53);
        lblEmploiDuTemps.setBounds(44, 198, 110, 17);
        lblEmploiDuTemps.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblIconEmploiDuTemps.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblEmploiDuTemps.setText("Emploi du temps");
        lblEmploiDuTemps.setFont(new Font("Times new roman", Font.PLAIN, 14));
        if ( lblEmploiDuTemps.getText() == ongletEC) {
            lblEmploiDuTemps.setFont(new Font("Times new roman", Font.BOLD, 14));
        }
        menu.add(lblIconEmploiDuTemps);
        menu.add(lblEmploiDuTemps);
	}
	
	private void addMsg(ImageIcon tabImg, String ongletEC) { 
    	JLabel lblMessagerie = new JLabel();
        JLabel lblIconMessagerie = new JLabel(tabImg);
        lblIconMessagerie.setBounds(5, 150, 29, 53);
        lblMessagerie.setBounds(44, 165, 96, 17);
        lblMessagerie.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblIconMessagerie.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblMessagerie.setText("Messagerie");
        lblMessagerie.setFont(new Font("Times new roman", Font.PLAIN, 14));
        if (lblMessagerie.getText() == ongletEC) {
            lblMessagerie.setFont(new Font("Times new roman", Font.BOLD, 14));
        }
        lblMessagerie.addMouseListener(new MouseAdapter() {  
            public void mouseClicked(MouseEvent e) {  
                 switchOnglet("Messagerie");
            }  
        });
        menu.add(lblIconMessagerie);
        menu.add(lblMessagerie);
	}
	
   private void switchOnglet(String onglet) {
        Fenetre.maFenetre.getContentPane().removeAll();
        JPanel monMenu = new Menu(onglet).getMenu();
        monMenu.setBounds(0,0,150,300);
        
        
        Fenetre.maFenetre.getContentPane().add( monMenu, BorderLayout.CENTER);
        Fenetre.maFenetre.getContentPane().setLayout(null);
        
        Fenetre.maFenetre.getContentPane().repaint();
        
        switch(onglet) {
            case "Accueil" :
                JLabel lblApplicationOnlinote = new JLabel("Bienvenue sur l'application Onlinote Mr X");
                lblApplicationOnlinote.setBounds(150, 0, 714, 502);
                lblApplicationOnlinote.setVerticalAlignment(SwingConstants.TOP);
                lblApplicationOnlinote.setFont(new Font("Times new roman", Font.PLAIN, 32));
                lblApplicationOnlinote.setHorizontalAlignment(SwingConstants.CENTER);
                Fenetre.maFenetre.getContentPane().add(lblApplicationOnlinote);
                
                
                JLabel lblDetails1 = new JLabel("L'application qui vous permet de suivre vos enfants et garder un contact avec l'administration");
                lblDetails1.setHorizontalAlignment(SwingConstants.CENTER);
                lblDetails1.setFont(new Font("Times new roman", Font.PLAIN, 12));
                lblDetails1.setBounds(150, 44, 714, 35);
                Fenetre.maFenetre.getContentPane().add(lblDetails1);
               break;
            default : 
                break;
        }
    }

}
