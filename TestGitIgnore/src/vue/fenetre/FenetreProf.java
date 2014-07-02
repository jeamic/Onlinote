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
import java.net.MalformedURLException;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import modele.base.dao.Personne;
import modele.vue.dao.DAOVueClasse;

import org.apache.log4j.LogManager;

import controleur.prof.GestionProf;

public class FenetreProf {
	
	protected static JFrame maFenetreParent = null;
	protected static JPanel panelTop = null;
	protected static JPanel panelCenter = null;
	static JPanel grosMenu = null;
	private static List<DAOVueClasse> classe = null;
	private Personne prof = null;

    private FenetreProf(Personne personne){
        
        /**
         * Log4j logger
         */
        org.apache.log4j.Logger log4j =  LogManager.getLogger(ConnexionGUI.class.getName());
        
        prof = personne;
			
        maFenetreParent = new JFrame();
        
        maFenetreParent.getContentPane().setLayout(new BorderLayout());
        
        
        
        maFenetreParent.setSize(new Dimension(880, 540));
        
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        maFenetreParent.setLocation(dim.width/2-maFenetreParent.getSize().width/2, dim.height/2-maFenetreParent.getSize().height/2);

        
        maFenetreParent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
        GestionProf gestionnaireProf = new GestionProf();
        classe = gestionnaireProf.getClasses(personne.getIdPersonne());
        
        
        panelCenter = new JPanel();
        ButtonGroup group = new ButtonGroup();
        JLabel lblVosEnfants = new JLabel("Classe(s) : ");
        lblVosEnfants.setVerticalAlignment(SwingConstants.CENTER);
        lblVosEnfants.setFont(new Font("Times new roman", Font.PLAIN, 12));
        lblVosEnfants.setHorizontalAlignment(SwingConstants.CENTER);
        panelCenter.add(lblVosEnfants);
        JRadioButton aRadioButton = null;

        
        grosMenu = new JPanel(new GridBagLayout());
        JPanel monMenu = new MenuProf("Accueil", personne , classe.get(0)).getMenu();
        monMenu.setPreferredSize(new Dimension(150, 300));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;
        //monMenu.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
        
        
        JLabel testEspace = new JLabel(" ");
        

        final JPanel monMenu2 = new JPanel(new BorderLayout());
        
        monMenu2.add(testEspace, BorderLayout.NORTH);
        monMenu2.add(monMenu, BorderLayout.NORTH);
        
                
        grosMenu.add(monMenu2, gbc);
        
        
        for (int i = 0; i < classe.size(); ++i)
        {
            
            if (i == 0)
            {
                aRadioButton = new JRadioButton(classe.get(i).getNomClasse(), true);
            }
            else
            {
                aRadioButton = new JRadioButton(classe.get(i).getNomClasse());
            }
            aRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
            aRadioButton.setVerticalAlignment(SwingConstants.CENTER);
            aRadioButton.setActionCommand(Integer.toString(i));
            
            
            
            ActionListener actionListener = new ActionListener() {
                
                public void actionPerformed(ActionEvent e) {
                              
                    
                        changeEleveMenuProf(prof, Integer.parseInt(e.getActionCommand()));

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
        
        JLabel lblApplicationOnlinote = new JLabel("<html><p style='text-align:center'>Bienvenue sur l'application Onlinote</p><p style='text-align:center'>"+ personne.getPrenom() + " " + personne.getNom() + "</p></html>");
        lblApplicationOnlinote.setVerticalAlignment(SwingConstants.TOP);
        lblApplicationOnlinote.setFont(new Font("Times new roman", Font.PLAIN, 32));
        lblApplicationOnlinote.setHorizontalAlignment(SwingConstants.CENTER);
        
        
        JLabel lblDetails1 = new JLabel("");
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
    
    public static void creerFenetreProf (Personne personne) {
        new FenetreProf (personne);
    }
    
    public static void changeMenuProf()
    {
        if (panelTop != null) {
            
        }
        FenetreProf.maFenetreParent.remove(panelTop);
        
        if (panelCenter != null) {
            FenetreProf.maFenetreParent.remove(panelCenter);         
        }
        
        FenetreProf.maFenetreParent.repaint();
        FenetreProf.maFenetreParent.validate();
        
    }
    
    public static void changeEleveMenuProf(Personne p, int e)
    {
        grosMenu.removeAll();
        
        JPanel monMenu = new MenuProf("Accueil", p, classe.get(e)).getMenu();
        monMenu.setPreferredSize(new Dimension(150, 300));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;
        //monMenu.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
        
        
        JLabel testEspace = new JLabel(" ");
        

        final JPanel monMenu2 = new JPanel(new BorderLayout());
        
        monMenu2.add(testEspace, BorderLayout.NORTH);
        monMenu2.add(monMenu, BorderLayout.NORTH);
        
                
        grosMenu.add(monMenu2, gbc);
        grosMenu.revalidate();
        grosMenu.repaint();

    }
}
