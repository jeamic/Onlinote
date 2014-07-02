package vue.fenetre;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modele.base.dao.Personne;
import modele.vue.dao.DAOVueMessage;
import vue.tools.ModelTableEnvoye;
import vue.tools.ModelTableRecu;
import controleur.messages.GestionMessages;

public class Messagerie {
    private JPanel panelMessagerie = null;
    private Personne user = null;
    private List<DAOVueMessage> messageRecu = null;
    private List<DAOVueMessage> messageEnvoye = null;
    private JPanel panel_1 = null;
    private JPanel panel = null;
    public Messagerie (Personne personne)
    {
       user = personne;
       panelMessagerie = new JPanel(new BorderLayout());
       
       panel = new JPanel();
       panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
       panelMessagerie.add(panel, BorderLayout.WEST);
       GridBagLayout gbl_panel = new GridBagLayout();
       gbl_panel.columnWidths = new int[]{46, 0};
       gbl_panel.rowHeights = new int[]{14, 0, 0, 0, 0, 0, 0, 0, 0};
       gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
       gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
       panel.setLayout(gbl_panel);
       final JLabel lblNewLabel = new JLabel("Messages envoyés");
       final JLabel lblNewLabel_1 = new JLabel("<html><u>Messages reçus</u></html>");
       lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       lblNewLabel_1.addMouseListener(new MouseAdapter() {  
           public void mouseClicked(MouseEvent e) {
               
               lblNewLabel_1.setText("<html><u>Messages reçus</u></html>");
               lblNewLabel.setText("Messages envoyés");
               panel_1.removeAll();
               ModelTableRecu model = new ModelTableRecu();
               JTable table = new JTable(model);
               table.getSelectionModel().addListSelectionListener(new MsgTableSelectionListenerRecu());
               JScrollPane panelScrollTable = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
               
               GestionMessages gestionnaireMessage = new GestionMessages();
               messageRecu = gestionnaireMessage.getMessagesRecus(user.getIdPersonne());
               
               model.updateTableData(messageRecu);
               
               
               panel_1.add(panelScrollTable);
               
               panel_1.repaint();
               panel_1.validate();
               panel.repaint();
               panel.validate();
               
          }  
       });
       GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
       gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
       gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTHWEST;
       gbc_lblNewLabel_1.gridx = 0;
       gbc_lblNewLabel_1.gridy = 0;
       panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
       
       
       lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       lblNewLabel.addMouseListener(new MouseAdapter() {  
           public void mouseClicked(MouseEvent e) {
               lblNewLabel.setText("<html><u>Messages envoyés</u></html>");
               lblNewLabel_1.setText("Messages reçus");
               panel_1.removeAll();
               ModelTableEnvoye model = new ModelTableEnvoye();
               JTable table = new JTable(model);
               table.getSelectionModel().addListSelectionListener(new MsgTableSelectionListenerEnvoye());
               JScrollPane panelScrollTable = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
               
               GestionMessages gestionnaireMessage = new GestionMessages();
               messageEnvoye = gestionnaireMessage.getMessagesEnvoyes(user.getIdPersonne());
               
               model.updateTableData(messageEnvoye);
               
               
               panel_1.add(panelScrollTable);
               
               panel_1.repaint();
               panel_1.validate();
               panel.repaint();
               panel.validate();
               
          }  
       });
       GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
       gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
       gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
       gbc_lblNewLabel.gridx = 0;
       gbc_lblNewLabel.gridy = 2;
       panel.add(lblNewLabel, gbc_lblNewLabel);
       
       panel_1 = new JPanel(new BorderLayout());
       panel_1.setBackground(Color.WHITE);
       //panel_1.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
       
       
       
       /* ADD TABLEAU       */
       
       ModelTableRecu model = new ModelTableRecu();
       JTable table = new JTable(model);
       table.getSelectionModel().addListSelectionListener(new MsgTableSelectionListenerRecu());
       JScrollPane panelScrollTable = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
       
       GestionMessages gestionnaireMessage = new GestionMessages();
       messageRecu = gestionnaireMessage.getMessagesRecus(personne.getIdPersonne());
       
       model.updateTableData(messageRecu);
       
       
       panel_1.add(panelScrollTable);
       
       
       /*Fin add tableau */
       panelMessagerie.add(panel_1, BorderLayout.CENTER);
       
       JPanel panel_2 = new JPanel();
       panelMessagerie.add(panel_2, BorderLayout.NORTH);
       
       JButton btnNouveau = new JButton("Nouveau");

       btnNouveau.setHorizontalAlignment(SwingConstants.LEFT);
       panel_2.add(btnNouveau);
       
       JButton btnSupprimer = new JButton("Supprimer");
       btnSupprimer.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent arg0) {
               
           }
       });
       btnSupprimer.setVisible(false);
       panel_2.add(btnSupprimer);
       
       btnNouveau.addMouseListener(new MouseAdapter() {  
           public void mouseClicked(MouseEvent e) {  
               NouveauMessage.creerNouveauMessage(user, false, "", "", "");
          }  
       });
    }
    
    public JPanel getMess() {
        return panelMessagerie;
    }
    
    public class MsgTableSelectionListenerRecu  implements ListSelectionListener
    {
        @Override
            public void valueChanged(ListSelectionEvent selectionEvent)
        {
            if (selectionEvent.getValueIsAdjusting())
            {
                return;
            }
           
            ListSelectionModel selectEvent
                                            = (ListSelectionModel) selectionEvent.getSource();
           
            if (!selectEvent.isSelectionEmpty())
            {
                   
                    int indexMsgSelected = selectEvent.getMaxSelectionIndex();
                   
                  

                            DAOVueMessage msgSelected = messageRecu.get(indexMsgSelected);
                            
                            NouveauMessage.creerNouveauMessage(user, true, msgSelected.getExpediteur(), msgSelected.getObjet(), msgSelected.getContenu());
                           
                    
                   
                   
            }
        }
    }
    
    public class MsgTableSelectionListenerEnvoye  implements ListSelectionListener
    {
        @Override
            public void valueChanged(ListSelectionEvent selectionEvent)
        {
            if (selectionEvent.getValueIsAdjusting())
            {
                return;
            }
           
            ListSelectionModel selectEvent
                                            = (ListSelectionModel) selectionEvent.getSource();
           
            if (!selectEvent.isSelectionEmpty())
            {
                   
                    int indexMsgSelected = selectEvent.getMaxSelectionIndex();
                   
                  

                            DAOVueMessage msgSelected = messageEnvoye.get(indexMsgSelected);
                            
                            NouveauMessage.creerNouveauMessage(user, true, msgSelected.getDestinataires(), msgSelected.getObjet(), msgSelected.getContenu());
                           
                    
                   
                   
            }
        }
    }
}
