package vue.fenetre;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import modele.base.dao.Personne;
import modele.vue.dao.DAOVuePersonne;
import modele.vue.dao.DAOVueParent;

import org.apache.log4j.LogManager;

import controleur.connexion.Onlinote;
import controleur.parent.GestionParent;


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
    private DAOVueParent parent = null;
    private List<DAOVuePersonne> enfant = null;
	private DAOVuePersonne eleveG = null;
	private Personne personneG = null;
	
	public Menu (String ongletEC, Personne personne, DAOVuePersonne eleve) {
	    
	    eleveG = eleve;
	    personneG = personne;
	    
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
		
		
        
        JPanel panel_1 = new JPanel();
        panel.add(panel_1);
        panel_1.setLayout(new BorderLayout(0, 0));
        panel_1.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        
        
        JLabel lblNomEleve = new JLabel(eleve.getNom() + " " + eleve.getPrenom());
        lblNomEleve.setHorizontalAlignment(SwingConstants.CENTER);
        panel_1.add(lblNomEleve);
        
        
        JLabel lblEleve = new JLabel();
        lblEleve.setHorizontalAlignment(SwingConstants.CENTER);
        panel_1.add(lblEleve, BorderLayout.NORTH);
        
        lblEleve.setFont(new Font("Times new roman", Font.PLAIN, 14));
        lblEleve.setText("Elève :");

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
                 switchOnglet("Accueil", personneG , eleveG);
            }  
        });
        lblIconAccueil.addMouseListener(new MouseAdapter() {  
            public void mouseClicked(MouseEvent e) {  
                switchOnglet("Accueil", personneG , eleveG);
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
                 switchOnglet("Notes", personneG , eleveG);
            }  
        });
        lblIconNotes.addMouseListener(new MouseAdapter()  {  
            public void mouseClicked(MouseEvent e) {  
                switchOnglet("Notes", personneG , eleveG);
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
                 switchOnglet("Emploi du temps", personneG , eleveG);
            }  
        });
        lblIconEmploiDuTemps.addMouseListener(new MouseAdapter() {  
            public void mouseClicked(MouseEvent e) {  
                switchOnglet("Emploi du temps", personneG , eleveG);
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
                 switchOnglet("Messagerie", personneG , eleveG);
            }  
        });
        menu.add(lblIconMessagerie);
        menu.add(lblMessagerie);
	}
	
   private void switchOnglet(String onglet, Personne personne, DAOVuePersonne eleve) {
       viderGras();
       FenetreParent.changeMenu();
        
        switch(onglet) {
            case "Accueil" :
                
                remplirFenetre("Bienvenue sur l'application Onlinote Mr ","");
                FenetreParent.panelCenter = new JPanel(new BorderLayout());
                
                
                lblAccueil.setFont(new Font("Times new roman", Font.BOLD, 14));
                FenetreParent.maFenetreParent.getContentPane().validate();
                
                GestionParent gestionnaireParent = new GestionParent();
                parent = gestionnaireParent.getEnfants(personne);
                
                enfant = parent.getListeEnfants();
                
                FenetreParent.panelCenter = new JPanel();
                ButtonGroup group = new ButtonGroup();
                JLabel lblVosEnfants = new JLabel("Enfant(s) : ");
                lblVosEnfants.setVerticalAlignment(SwingConstants.TOP);
                lblVosEnfants.setFont(new Font("Times new roman", Font.PLAIN, 12));
                lblVosEnfants.setHorizontalAlignment(SwingConstants.CENTER);
                FenetreParent.panelCenter.add(lblVosEnfants);
                JRadioButton aRadioButton = null;
                
                FenetreParent.grosMenu.removeAll();
                JPanel monMenu = new Menu("Accueil", personne, enfant.get(0)).getMenu();
                monMenu.setPreferredSize(new Dimension(150, 300));
                
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.anchor = GridBagConstraints.NORTHWEST;
                //monMenu.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
                
                
                JLabel testEspace = new JLabel(" ");
                

                final JPanel monMenu2 = new JPanel(new BorderLayout());
                
                monMenu2.add(testEspace, BorderLayout.NORTH);
                monMenu2.add(monMenu, BorderLayout.NORTH);
                
                        
                FenetreParent.grosMenu.add(monMenu2, gbc);
                
                
                for (int i = 0; i < enfant.size(); ++i)
                {
                    if (enfant.get(i).getIdEleve() == eleve.getIdEleve())
                    {
                        aRadioButton = new JRadioButton(enfant.get(i).getNom() + " " + enfant.get(i).getPrenom(), true);
                    }
                    else
                    {
                        aRadioButton = new JRadioButton(enfant.get(i).getNom() + " " + enfant.get(i).getPrenom());
                    }
                    aRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
                    aRadioButton.setActionCommand(Integer.toString(i));
                    
                    
                    
                    ActionListener actionListener = new ActionListener() {
                        
                        public void actionPerformed(ActionEvent e) {
                            
                            
                            FenetreParent.changeEleveMenu(personneG, Integer.parseInt(e.getActionCommand()));
                                

                            }
                    };
                    
                    aRadioButton.addActionListener(actionListener);
                    group.add(aRadioButton);
                    FenetreParent.panelCenter.add(aRadioButton);

                    
                }
                
                
                
                FenetreParent.maFenetreParent.getContentPane().add(FenetreParent.panelCenter, BorderLayout.CENTER);
                
                
               break;
            case "Notes" :
                remplirFenetre("Onlinote - Notes","");
                FenetreParent.panelCenter = new JPanel(new BorderLayout());
                
                JPanel mesNotes = new Notes(eleve.getIdEleve()).getNotes();
                mesNotes.setBorder(BorderFactory.createEmptyBorder(0,30,30,30));
                FenetreParent.panelCenter.add(mesNotes, BorderLayout.CENTER);
                FenetreParent.maFenetreParent.getContentPane().add(FenetreParent.panelCenter, BorderLayout.CENTER);
                lblNotes.setFont(new Font("Times new roman", Font.BOLD, 14));
                FenetreParent.maFenetreParent.validate();
                
                
                break;
            case "Emploi du temps" :
                
                remplirFenetre("Onlinote - Emploi du temps","");
                FenetreParent.panelCenter = new JPanel(new BorderLayout());
                
                JPanel monEDT = new EmploiDuTemps().getEDT();
                monEDT.setBorder(BorderFactory.createEmptyBorder(0,30,30,30));
                FenetreParent.panelCenter.add(monEDT);
  
                FenetreParent.maFenetreParent.getContentPane().add(FenetreParent.panelCenter, BorderLayout.CENTER);
                lblEmploiDuTemps.setFont(new Font("Times new roman", Font.BOLD, 14));
                FenetreParent.maFenetreParent.validate();
                break;
                
            case "Messagerie" :
                remplirFenetre("Onlinote - Messagerie", "");
                FenetreParent.panelCenter = new JPanel(new BorderLayout());
                
                
                JPanel maMessagerie = new Messagerie(personneG).getMess();
                maMessagerie.setBorder(BorderFactory.createEmptyBorder(0,30,30,30));
                FenetreParent.panelCenter.add(maMessagerie);
                
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
   
   private void remplirFenetre(String titre, String desc)
   {
       FenetreParent.panelTop = new JPanel(new BorderLayout());
       JPanel panelTopGauche = new JPanel(new BorderLayout());
       JPanel panelTopCentre = new JPanel(new BorderLayout());
       
       JLabel lblApplicationOnlinote = new JLabel(titre);
       lblApplicationOnlinote.setVerticalAlignment(SwingConstants.TOP);
       lblApplicationOnlinote.setFont(new Font("Times new roman", Font.PLAIN, 32));
       lblApplicationOnlinote.setHorizontalAlignment(SwingConstants.CENTER);
       
       
       JLabel lblDetails1 = new JLabel(desc);
       lblDetails1.setHorizontalAlignment(SwingConstants.CENTER);
       lblDetails1.setFont(new Font("Times new roman", Font.PLAIN, 12));
       JLabel lblVide = new JLabel(" ");
       lblVide.setHorizontalAlignment(SwingConstants.CENTER);
       
       
       java.net.URL imgURLAccueil = null;
       try {
           imgURLAccueil = new java.net.URL("file:img/gard.png");
       } catch (MalformedURLException e) {
           // TODO Auto-generated catch block
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
       
       FenetreParent.panelTop.add(panelTopGauche);
       FenetreParent.panelTop.add(panelTopCentre);
       
       
       FenetreParent.maFenetreParent.getContentPane().add(FenetreParent.panelTop, BorderLayout.NORTH);
   }

}
