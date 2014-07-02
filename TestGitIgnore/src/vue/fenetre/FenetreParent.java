package vue.fenetre;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import modele.base.dao.Personne;
import modele.vue.dao.DAOVueEleve;
import modele.vue.dao.DAOVueParent;

import org.apache.log4j.LogManager;

import controleur.parent.GestionParent;

public class FenetreParent {
	
	protected static JFrame maFenetreParent = null;
	protected static JPanel panelTop = null;
	protected static JPanel panelCenter = null;
	static JPanel grosMenu = null;
    private DAOVueParent parent = null;
    private static List<DAOVueEleve> enfant = null;
    
    FenetreParent(final Personne personne){
        
        /**
         * Log4j logger
         */
                
        org.apache.log4j.Logger log4j =  LogManager.getLogger(ConnexionGUI.class.getName());
			
        maFenetreParent = new JFrame();
        
        maFenetreParent.getContentPane().setLayout(new BorderLayout());
        
        
        
        maFenetreParent.setSize(new Dimension(880, 540));
        
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        maFenetreParent.setLocation(dim.width/2-maFenetreParent.getSize().width/2, dim.height/2-maFenetreParent.getSize().height/2);

        
        maFenetreParent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        GestionParent gestionnaireParent = new GestionParent();
        parent = gestionnaireParent.getEnfants(personne);
        
        enfant = parent.getListeEnfants();
        
        panelCenter = new JPanel();
        ButtonGroup group = new ButtonGroup();
        JLabel lblVosEnfants = new JLabel("Enfant(s) : ");
        lblVosEnfants.setVerticalAlignment(SwingConstants.TOP);
        lblVosEnfants.setFont(new Font("Times new roman", Font.PLAIN, 12));
        lblVosEnfants.setHorizontalAlignment(SwingConstants.CENTER);
        panelCenter.add(lblVosEnfants);
        JRadioButton aRadioButton = null;
        
        grosMenu = new JPanel(new GridBagLayout());
        JPanel monMenu = new Menu("Accueil", personne , enfant.get(0)).getMenu();
        monMenu.setPreferredSize(new Dimension(150, 300));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;
        //monMenu.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
        
        
        JLabel testEspace = new JLabel(" ");
        

        final JPanel monMenu2 = new JPanel(new BorderLayout());
        
        monMenu2.add(testEspace, BorderLayout.NORTH);
        monMenu2.add(monMenu, BorderLayout.NORTH);
        
                
        grosMenu.add(monMenu2, gbc);
        
        
        for (int i = 0; i < enfant.size(); ++i)
        {
            
            if (i == 0)
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
                              
                    
                        changeEleveMenu(personne, Integer.parseInt(e.getActionCommand()));
                       /* grosMenu.removeAll();
                        
                        JPanel monMenu = new Menu("Accueil", personne, enfant.get(Integer.parseInt(e.getActionCommand()))).getMenu();
                        monMenu.setPreferredSize(new Dimension(150, 300));
                        
                        GridBagConstraints gbc = new GridBagConstraints();
                        gbc.anchor = GridBagConstraints.NORTHWEST;
                        //monMenu.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
                        
                        
                        JLabel testEspace = new JLabel(" ");
                        

                        final JPanel monMenu2 = new JPanel(new BorderLayout());
                        
                        monMenu2.add(testEspace, BorderLayout.NORTH);
                        monMenu2.add(monMenu, BorderLayout.NORTH);
                        
                                
                        grosMenu.add(monMenu2, gbc);
                        grosMenu.updateUI();
                        */

                    }
            };
            
            aRadioButton.addActionListener(actionListener);
            group.add(aRadioButton);
            panelCenter.add(aRadioButton);

            
        }
        
        
        
       maFenetreParent.getContentPane().add(panelCenter, BorderLayout.CENTER);
        

        
       
        maFenetreParent.getContentPane().add(grosMenu, BorderLayout.WEST);
        
        
        panelTop = new JPanel(new BorderLayout());
        JPanel panelTopGauche = new JPanel(new BorderLayout());
        JPanel panelTopCentre = new JPanel(new BorderLayout());
        
        JLabel lblApplicationOnlinote = new JLabel("Bienvenue sur l'application Onlinote "+ personne.getPrenom() + " " + personne.getNom());
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
            FenetreParent.maFenetreParent.remove(panelTop);
        }

        
        if (panelCenter != null) {
            FenetreParent.maFenetreParent.remove(panelCenter);         
        }
        
        FenetreParent.maFenetreParent.repaint();
        FenetreParent.maFenetreParent.validate();
        
    }
    
    public static void changeEleveMenu(Personne p, int e)
    {
        grosMenu.removeAll();
        
        JPanel monMenu = new Menu("Accueil", p, enfant.get(e)).getMenu();
        monMenu.setPreferredSize(new Dimension(150, 300));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;
        //monMenu.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
        
        
        JLabel testEspace = new JLabel(" ");
        

        final JPanel monMenu2 = new JPanel(new BorderLayout());
        
        monMenu2.add(testEspace, BorderLayout.NORTH);
        monMenu2.add(monMenu, BorderLayout.NORTH);
        
                
        grosMenu.add(monMenu2, gbc);
        //grosMenu.updateUI();
        grosMenu.revalidate();
        grosMenu.repaint();

    }
}
