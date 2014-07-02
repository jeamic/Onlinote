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
            
        GridBagLayout gblpanelCadre = new GridBagLayout();
        gblpanelCadre.rowWeights = new double[]{1.0};
        gblpanelCadre.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
        panelCadre = new JPanel(gblpanelCadre);
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
        GridBagConstraints gbcpanel = new GridBagConstraints();
        gbcpanel.insets = new Insets(0, 0, 0, 5);
        gbcpanel.fill = GridBagConstraints.BOTH;
        gbcpanel.gridx = 0;
        gbcpanel.gridy = 0;
        gbcpanel.gridwidth=2;
        panelCadre.add(panel, gbcpanel);
        
        JPanel panel1 = new JPanel();
        GridBagConstraints gbcpanel1 = new GridBagConstraints();
        gbcpanel1.insets = new Insets(0, 0, 0, 5);
        gbcpanel1.fill = GridBagConstraints.BOTH;
        gbcpanel1.gridx = 1;
        gbcpanel1.gridy = 0;
        panelCadre.add(panel1, gbcpanel1);
        
        JPanel panel2 = new JPanel(new BorderLayout());
        Border border5ieme = BorderFactory.createTitledBorder("5ieme");
        panel2.setBorder(border5ieme);
        GridBagConstraints gbcpanel2 = new GridBagConstraints();
        gbcpanel2.insets = new Insets(0, 0, 0, 5);
        gbcpanel2.fill = GridBagConstraints.BOTH;
        gbcpanel2.gridx = 2;
        gbcpanel2.gridy = 0;
        gbcpanel2.gridwidth=2;
        panelCadre.add(panel2, gbcpanel2);
        
        JPanel panel3 = new JPanel();
        GridBagConstraints gbcpanel3 = new GridBagConstraints();
        gbcpanel3.insets = new Insets(0, 0, 0, 5);
        gbcpanel3.fill = GridBagConstraints.BOTH;
        gbcpanel3.gridx = 3;
        gbcpanel3.gridy = 0;
        panelCadre.add(panel3, gbcpanel3);
        
        JPanel panel4 = new JPanel(new BorderLayout());
        Border border4ieme = BorderFactory.createTitledBorder("4ieme");
        panel4.setBorder(border4ieme);
        GridBagConstraints gbcpanel4 = new GridBagConstraints();
        gbcpanel4.insets = new Insets(0, 0, 0, 5);
        gbcpanel4.fill = GridBagConstraints.BOTH;
        gbcpanel4.gridx = 4;
        gbcpanel4.gridy = 0;
        gbcpanel4.gridwidth=2;
        panelCadre.add(panel4, gbcpanel4);
        
        JPanel panel5 = new JPanel();
        GridBagConstraints gbcpanel5 = new GridBagConstraints();
        gbcpanel5.insets = new Insets(0, 0, 0, 5);
        gbcpanel5.fill = GridBagConstraints.BOTH;
        gbcpanel5.gridx = 5;
        gbcpanel5.gridy = 0;
        panelCadre.add(panel5, gbcpanel5);
        
        JPanel panel6 = new JPanel(new BorderLayout());
        Border border3ieme = BorderFactory.createTitledBorder("3ieme");
        panel6.setBorder(border3ieme);
        GridBagConstraints gbcpanel6 = new GridBagConstraints();
        gbcpanel6.insets = new Insets(0, 0, 0, 5);
        gbcpanel6.fill = GridBagConstraints.BOTH;
        gbcpanel6.gridx = 6;
        gbcpanel6.gridy = 0;
        gbcpanel6.gridwidth=2;
        panelCadre.add(panel6, gbcpanel6);
        
        JPanel panel7 = new JPanel();
        GridBagConstraints gbcpanel7 = new GridBagConstraints();
        gbcpanel7.fill = GridBagConstraints.BOTH;
        gbcpanel7.gridx = 7;
        gbcpanel7.gridy = 0;
        panelCadre.add(panel7, gbcpanel7);

        
        // Ajout des +/- sur chaques cadres (panel, panel2, panel4 et panel6)
        
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
        
        panel2.add(plusMoins5, BorderLayout.SOUTH);
        
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
        
        panel4.add(plusMoins4, BorderLayout.SOUTH);
        
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
        
        panel6.add(plusMoins3, BorderLayout.SOUTH);
        
        
        
    }
    
    
    
    
    
    public JPanel getCadreGestionEleve() {
        return panelCadre;
    }
    
    
    

}
