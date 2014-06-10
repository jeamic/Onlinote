package vue.fenetre;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class CadreGestionEleve {
    
    private JPanel panelCadre = null;
    public CadreGestionEleve() {
            
        GridBagLayout gbl_panelCadre = new GridBagLayout();
        gbl_panelCadre.rowWeights = new double[]{1.0};
        gbl_panelCadre.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
        panelCadre = new JPanel(gbl_panelCadre);
        GridBagConstraints gbc = new GridBagConstraints();
        Border borderClasse = BorderFactory.createTitledBorder("Classes");

        panelCadre.setBorder(borderClasse);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 600;
        gbc.weightx = 0.5;
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridwidth = 6;
        gbc.gridheight = 6;
        //monCadreEleve.getContentPane().add(panelCadre);
        
        /*
         * 
         *    Création des cadres 
         */
        
        JPanel panel = new JPanel(new BorderLayout());
        Border border6ieme = BorderFactory.createTitledBorder("6ieme");
        panel.setBorder(border6ieme);
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.insets = new Insets(0, 0, 0, 5);
        gbc_panel.fill = GridBagConstraints.BOTH;
        gbc_panel.gridx = 0;
        gbc_panel.gridy = 0;
        gbc_panel.gridwidth=2;
        panelCadre.add(panel, gbc_panel);
        
        JPanel panel_1 = new JPanel();
        GridBagConstraints gbc_panel_1 = new GridBagConstraints();
        gbc_panel_1.insets = new Insets(0, 0, 0, 5);
        gbc_panel_1.fill = GridBagConstraints.BOTH;
        gbc_panel_1.gridx = 1;
        gbc_panel_1.gridy = 0;
        panelCadre.add(panel_1, gbc_panel_1);
        
        JPanel panel_2 = new JPanel(new BorderLayout());
        Border border5ieme = BorderFactory.createTitledBorder("5ieme");
        panel_2.setBorder(border5ieme);
        GridBagConstraints gbc_panel_2 = new GridBagConstraints();
        gbc_panel_2.insets = new Insets(0, 0, 0, 5);
        gbc_panel_2.fill = GridBagConstraints.BOTH;
        gbc_panel_2.gridx = 2;
        gbc_panel_2.gridy = 0;
        gbc_panel_2.gridwidth=2;
        panelCadre.add(panel_2, gbc_panel_2);
        
        JPanel panel_3 = new JPanel();
        GridBagConstraints gbc_panel_3 = new GridBagConstraints();
        gbc_panel_3.insets = new Insets(0, 0, 0, 5);
        gbc_panel_3.fill = GridBagConstraints.BOTH;
        gbc_panel_3.gridx = 3;
        gbc_panel_3.gridy = 0;
        panelCadre.add(panel_3, gbc_panel_3);
        
        JPanel panel_4 = new JPanel(new BorderLayout());
        Border border4ieme = BorderFactory.createTitledBorder("4ieme");
        panel_4.setBorder(border4ieme);
        GridBagConstraints gbc_panel_4 = new GridBagConstraints();
        gbc_panel_4.insets = new Insets(0, 0, 0, 5);
        gbc_panel_4.fill = GridBagConstraints.BOTH;
        gbc_panel_4.gridx = 4;
        gbc_panel_4.gridy = 0;
        gbc_panel_4.gridwidth=2;
        panelCadre.add(panel_4, gbc_panel_4);
        
        JPanel panel_5 = new JPanel();
        GridBagConstraints gbc_panel_5 = new GridBagConstraints();
        gbc_panel_5.insets = new Insets(0, 0, 0, 5);
        gbc_panel_5.fill = GridBagConstraints.BOTH;
        gbc_panel_5.gridx = 5;
        gbc_panel_5.gridy = 0;
        panelCadre.add(panel_5, gbc_panel_5);
        
        JPanel panel_6 = new JPanel(new BorderLayout());
        Border border3ieme = BorderFactory.createTitledBorder("3ieme");
        panel_6.setBorder(border3ieme);
        GridBagConstraints gbc_panel_6 = new GridBagConstraints();
        gbc_panel_6.insets = new Insets(0, 0, 0, 5);
        gbc_panel_6.fill = GridBagConstraints.BOTH;
        gbc_panel_6.gridx = 6;
        gbc_panel_6.gridy = 0;
        gbc_panel_6.gridwidth=2;
        panelCadre.add(panel_6, gbc_panel_6);
        
        JPanel panel_7 = new JPanel();
        GridBagConstraints gbc_panel_7 = new GridBagConstraints();
        gbc_panel_7.fill = GridBagConstraints.BOTH;
        gbc_panel_7.gridx = 7;
        gbc_panel_7.gridy = 0;
        panelCadre.add(panel_7, gbc_panel_7);

        
        // Ajout des +/- sur chaques cadres (panel, panel_2, panel_4 et panel_6)
        
        JLabel plus6 = new JLabel("+");
        JLabel vide6 = new JLabel("  ");
        JLabel moins6 = new JLabel("-");
        JPanel plusMoins6 = new JPanel();
        
       
        plusMoins6.add(moins6);
        plusMoins6.add(vide6);
        plusMoins6.add(plus6);
        plus6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        plus6.addMouseListener(new MouseAdapter() {  
            
            public void mouseClicked(MouseEvent e) {  
                
    
            }  
        });
        moins6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        moins6.addMouseListener(new MouseAdapter() {  
            
            public void mouseClicked(MouseEvent e) {  
                
    
            }  
        });
        
        panel.add(plusMoins6, BorderLayout.SOUTH);
        
        JLabel plus5 = new JLabel("+");
        JLabel vide5 = new JLabel("  ");
        JLabel moins5 = new JLabel("-");
        JPanel plusMoins5 = new JPanel();
        
       
        plusMoins5.add(moins5);
        plusMoins5.add(vide5);
        plusMoins5.add(plus5);
        plus5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        moins5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        plus5.addMouseListener(new MouseAdapter() {  
            
            public void mouseClicked(MouseEvent e) {  
                
    
            }  
        });
        moins5.addMouseListener(new MouseAdapter() {  
            
            public void mouseClicked(MouseEvent e) {  
                
    
            }  
        });
        
        panel_2.add(plusMoins5, BorderLayout.SOUTH);
        
        JLabel plus4 = new JLabel("+");
        JLabel vide4 = new JLabel("  ");
        JLabel moins4 = new JLabel("-");
        JPanel plusMoins4 = new JPanel();
        
       
        plusMoins4.add(moins4);
        plusMoins4.add(vide4);
        plusMoins4.add(plus4);
        plus4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        moins4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        plus4.addMouseListener(new MouseAdapter() {  
            
            public void mouseClicked(MouseEvent e) {  
                
    
            }  
        });
        moins4.addMouseListener(new MouseAdapter() {  
            
            public void mouseClicked(MouseEvent e) {  
                
    
            }  
        });
        
        panel_4.add(plusMoins4, BorderLayout.SOUTH);
        
        JLabel plus3 = new JLabel("+");
        JLabel vide3 = new JLabel("  ");
        JLabel moins3 = new JLabel("-");
        JPanel plusMoins3 = new JPanel();
        
       
        plusMoins3.add(moins3);
        plusMoins3.add(vide3);
        plusMoins3.add(plus3);
        plus3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        moins3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        plus3.addMouseListener(new MouseAdapter() {  
            
            public void mouseClicked(MouseEvent e) {  
                
    
            }  
        });
        moins3.addMouseListener(new MouseAdapter() {  
            
            public void mouseClicked(MouseEvent e) {  
                
    
            }  
        });
        
        panel_6.add(plusMoins3, BorderLayout.SOUTH);
        
        
        
    }
    
    
    
    
    
    public JPanel getCadreGestionEleve() {
        return panelCadre;
    }
    
    
    

}
