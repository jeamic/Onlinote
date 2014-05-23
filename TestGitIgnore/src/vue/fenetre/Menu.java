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

import javax.swing.BorderFactory;
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
	private JLabel lblAccueil = null;
	private JLabel lblNotes = null;
	private JLabel lblEmploiDuTemps = null;
	private JLabel lblMessagerie = null;
	
	public Menu (String ongletEC) {
	    
	    ImageIcon tabImg[] = getImg();
	    

		
		menu = new JPanel();
		menu.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		menu.setSize(new Dimension(153, 267));
		menu.setLayout(null);
		
	    addAccueil(tabImg[0]);
        addNotes(tabImg[1]);
        addMsg(tabImg[2]);
        addEmploiDuTemps(tabImg[3]);
        addDeconnexion(tabImg[4]);
		
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
	
	private void addDeconnexion (ImageIcon tabImg) {
    	JLabel lblDeconnexion = new JLabel();
        JLabel lblIconDeconnexion = new JLabel(tabImg);
        lblDeconnexion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblIconDeconnexion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblIconDeconnexion.setBounds(5, 214, 29, 53);
        lblDeconnexion.setBounds(45, 230, 96, 17);
        lblDeconnexion.setFont(new Font("Times new roman", Font.PLAIN, 14));
        lblDeconnexion.setText("Deconnexion");
        lblDeconnexion.addMouseListener(new MouseAdapter() {  
            
            public void mouseClicked(MouseEvent e) {  
                
                 FenetreParent.maFenetreParent.dispose();
                 Onlinote.relancer();
    
            }  
        });
        menu.add(lblIconDeconnexion);
        menu.add(lblDeconnexion);
	}
	private void addAccueil (ImageIcon tabImg) {
        JLabel lblIconAccueil = new JLabel(tabImg);
        lblAccueil = new JLabel();
        lblIconAccueil.setBounds(5, 4, 29, 53);
        lblAccueil.setBounds(44, 4, 50, 53);
        lblAccueil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblIconAccueil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblAccueil.setFont(new Font("Times new roman", Font.BOLD, 14));
        lblAccueil.setText("Accueil");
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
	
	
	private void addNotes(ImageIcon tabImg) {
	    lblNotes = new JLabel();
        JLabel lblIconNotes = new JLabel(tabImg);
        lblIconNotes.setBounds(5, 119, 29, 53);
        lblNotes.setBounds(45, 136, 50, 17);
        lblNotes.setFont(new Font("Times new roman", Font.PLAIN, 14));
        lblNotes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblIconNotes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblNotes.setText("Notes");
        
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
	
	private void addEmploiDuTemps(ImageIcon tabImg) { 
        lblEmploiDuTemps = new JLabel();
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
        menu.add(lblIconEmploiDuTemps);
        menu.add(lblEmploiDuTemps);
	}
	
	private void addMsg(ImageIcon tabImg) { 
    	lblMessagerie = new JLabel();
        JLabel lblIconMessagerie = new JLabel(tabImg);
        lblIconMessagerie.setBounds(5, 150, 29, 53);
        lblMessagerie.setBounds(44, 165, 96, 17);
        lblMessagerie.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblIconMessagerie.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblMessagerie.setText("Messagerie");
        lblMessagerie.setFont(new Font("Times new roman", Font.PLAIN, 14));
        lblMessagerie.addMouseListener(new MouseAdapter() {  
            public void mouseClicked(MouseEvent e) {  
                 switchOnglet("Messagerie");
            }  
        });
        menu.add(lblIconMessagerie);
        menu.add(lblMessagerie);
	}
	
   private void switchOnglet(String onglet) {
       viderGras();
       FenetreParent.changeMenu();
        
        switch(onglet) {
            case "Accueil" :
                FenetreParent.panelTop = new JPanel(new BorderLayout());
                
                JLabel lblApplicationOnlinote = new JLabel("Bienvenue sur l'application Onlinote Mr ");
                lblApplicationOnlinote.setVerticalAlignment(SwingConstants.TOP);
                lblApplicationOnlinote.setFont(new Font("Times new roman", Font.PLAIN, 32));
                lblApplicationOnlinote.setHorizontalAlignment(SwingConstants.CENTER);
                
                
                JLabel lblDetails1 = new JLabel("L'application qui vous permet de suivre vos enfants et garder un contact avec l'administration");
                lblDetails1.setHorizontalAlignment(SwingConstants.CENTER);
                lblDetails1.setFont(new Font("Times new roman", Font.PLAIN, 12));
                JLabel lblVide = new JLabel(" ");
                lblVide.setHorizontalAlignment(SwingConstants.CENTER);
                
                
                FenetreParent.panelTop.add(lblApplicationOnlinote, BorderLayout.NORTH);
                FenetreParent.panelTop.add(lblVide, BorderLayout.CENTER);
                FenetreParent.panelTop.add(lblDetails1, BorderLayout.SOUTH);
                
                FenetreParent.maFenetreParent.getContentPane().add(FenetreParent.panelTop, BorderLayout.NORTH);
                lblAccueil.setFont(new Font("Times new roman", Font.BOLD, 14));
                FenetreParent.maFenetreParent.getContentPane().validate();
                
               break;
            case "Notes" :
                FenetreParent.panelTop = new JPanel(new BorderLayout());
                FenetreParent.panelCenter = new JPanel (new BorderLayout());
                
                JLabel lblApplicationOnlinoteN = new JLabel("Onlinote - Notes");
                lblApplicationOnlinoteN.setVerticalAlignment(SwingConstants.TOP);
                lblApplicationOnlinoteN.setFont(new Font("Times new roman", Font.PLAIN, 32));
                lblApplicationOnlinoteN.setHorizontalAlignment(SwingConstants.CENTER);
                
                
                JLabel lblDetailsN = new JLabel(" ");
                lblDetailsN.setHorizontalAlignment(SwingConstants.CENTER);
                lblDetailsN.setFont(new Font("Times new roman", Font.PLAIN, 12));
                JLabel lblVide2 = new JLabel(" ");
                lblVide2.setHorizontalAlignment(SwingConstants.CENTER);
                
                
                FenetreParent.panelTop.add(lblApplicationOnlinoteN, BorderLayout.NORTH);
                FenetreParent.panelTop.add(lblVide2, BorderLayout.CENTER);
                FenetreParent.panelTop.add(lblDetailsN, BorderLayout.SOUTH);
                
                FenetreParent.maFenetreParent.getContentPane().add(FenetreParent.panelTop, BorderLayout.NORTH);
                
                
                JPanel mesNotes = new Notes().getNotes();
                mesNotes.setBorder(BorderFactory.createEmptyBorder(0,30,30,30));
                FenetreParent.panelCenter.add(mesNotes, BorderLayout.CENTER);
                FenetreParent.maFenetreParent.getContentPane().add(FenetreParent.panelCenter, BorderLayout.CENTER);
                lblNotes.setFont(new Font("Times new roman", Font.BOLD, 14));
                FenetreParent.maFenetreParent.validate();
                
                
                break;
            case "Emploi du temps" :
                
                FenetreParent.panelTop = new JPanel(new BorderLayout());
                FenetreParent.panelCenter = new JPanel (new BorderLayout());
                
                JLabel lblApplicationOnlinoteEDT = new JLabel("Onlinote - Emploi du temps");
                lblApplicationOnlinoteEDT.setVerticalAlignment(SwingConstants.TOP);
                lblApplicationOnlinoteEDT.setFont(new Font("Times new roman", Font.PLAIN, 32));
                lblApplicationOnlinoteEDT.setHorizontalAlignment(SwingConstants.CENTER);
                
                
                JLabel lblDetailsEDT = new JLabel(" ");
                lblDetailsEDT.setHorizontalAlignment(SwingConstants.CENTER);
                lblDetailsEDT.setFont(new Font("Times new roman", Font.PLAIN, 12));
                JLabel lblVideEDT = new JLabel(" ");
                lblVideEDT.setHorizontalAlignment(SwingConstants.CENTER);
                
                
                FenetreParent.panelTop.add(lblApplicationOnlinoteEDT, BorderLayout.NORTH);
                FenetreParent.panelTop.add(lblVideEDT, BorderLayout.CENTER);
                FenetreParent.panelTop.add(lblDetailsEDT, BorderLayout.SOUTH);
                
                FenetreParent.maFenetreParent.getContentPane().add(FenetreParent.panelTop, BorderLayout.NORTH);
                
                JPanel monEDT = new EmploiDuTemps().getEDT();
                monEDT.setBorder(BorderFactory.createEmptyBorder(0,30,30,30));
                FenetreParent.panelCenter.add(monEDT);
  
                FenetreParent.maFenetreParent.getContentPane().add(FenetreParent.panelCenter, BorderLayout.CENTER);
                lblEmploiDuTemps.setFont(new Font("Times new roman", Font.BOLD, 14));
                FenetreParent.maFenetreParent.validate();
                break;
                
            case "Messagerie" :
                FenetreParent.panelTop = new JPanel(new BorderLayout());
                FenetreParent.panelCenter = new JPanel (new BorderLayout());
                
                JLabel lblApplicationOnlinoteM = new JLabel("Onlinote - Emploi du temps");
                lblApplicationOnlinoteM.setVerticalAlignment(SwingConstants.TOP);
                lblApplicationOnlinoteM.setFont(new Font("Times new roman", Font.PLAIN, 32));
                lblApplicationOnlinoteM.setHorizontalAlignment(SwingConstants.CENTER);
                
                
                JLabel lblDetailsM = new JLabel(" ");
                lblDetailsM.setHorizontalAlignment(SwingConstants.CENTER);
                lblDetailsM.setFont(new Font("Times new roman", Font.PLAIN, 12));
                JLabel lblVideM = new JLabel(" ");
                lblVideM.setHorizontalAlignment(SwingConstants.CENTER);
                
                
                FenetreParent.panelTop.add(lblApplicationOnlinoteM, BorderLayout.NORTH);
                FenetreParent.panelTop.add(lblVideM, BorderLayout.CENTER);
                FenetreParent.panelTop.add(lblDetailsM, BorderLayout.SOUTH);
                
                FenetreParent.maFenetreParent.getContentPane().add(FenetreParent.panelTop, BorderLayout.NORTH);
                
                lblMessagerie.setFont(new Font("Times new roman", Font.BOLD, 14));
                FenetreParent.maFenetreParent.getContentPane().add(FenetreParent.panelCenter, BorderLayout.CENTER);
                FenetreParent.maFenetreParent.validate();
                break;
                
            default : 
                
                break;
        }
    }
   
   private void viderGras ()
   {
       lblAccueil.setFont(new Font("Times new roman", Font.PLAIN, 14));
       lblNotes.setFont(new Font("Times new roman", Font.PLAIN, 14));
       lblEmploiDuTemps.setFont(new Font("Times new roman", Font.PLAIN, 14));
       lblMessagerie.setFont(new Font("Times new roman", Font.PLAIN, 14));
       
   }

}
