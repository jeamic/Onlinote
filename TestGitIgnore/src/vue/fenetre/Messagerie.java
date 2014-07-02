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
    private JPanel panel1 = null;
    private JPanel panel = null;
    public Messagerie (Personne personne)
    {
       user = personne;
       panelMessagerie = new JPanel(new BorderLayout());
       
       panel = new JPanel();
       panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
       panelMessagerie.add(panel, BorderLayout.WEST);
       GridBagLayout gblpanel = new GridBagLayout();
       gblpanel.columnWidths = new int[]{46, 0};
       gblpanel.rowHeights = new int[]{14, 0, 0, 0, 0, 0, 0, 0, 0};
       gblpanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
       gblpanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
       panel.setLayout(gblpanel);
       final JLabel lblNewLabel = new JLabel("Messages envoyés");
       final JLabel lblNewLabel1 = new JLabel("<html><u>Messages reçus</u></html>");
       lblNewLabel1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       lblNewLabel1.addMouseListener(new MouseAdapter() {  
           public void mouseClicked(MouseEvent e) {
               
               lblNewLabel1.setText("<html><u>Messages reçus</u></html>");
               lblNewLabel.setText("Messages envoyés");
               panel1.removeAll();
               ModelTableRecu model = new ModelTableRecu();
               JTable table = new JTable(model);
               table.getSelectionModel().addListSelectionListener(new MsgTableSelectionListenerRecu());
               JScrollPane panelScrollTable = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
               
               GestionMessages gestionnaireMessage = new GestionMessages();
               messageRecu = gestionnaireMessage.getMessagesRecus(user.getIdPersonne());
               
               model.updateTableData(messageRecu);
               
               
               panel1.add(panelScrollTable);
               
               panel1.repaint();
               panel1.validate();
               panel.repaint();
               panel.validate();
               
          }  
       });
       GridBagConstraints gbclblNewLabel1 = new GridBagConstraints();
       gbclblNewLabel1.insets = new Insets(0, 0, 5, 0);
       gbclblNewLabel1.anchor = GridBagConstraints.NORTHWEST;
       gbclblNewLabel1.gridx = 0;
       gbclblNewLabel1.gridy = 0;
       panel.add(lblNewLabel1, gbclblNewLabel1);
       
       
       lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       lblNewLabel.addMouseListener(new MouseAdapter() {  
           public void mouseClicked(MouseEvent e) {
               lblNewLabel.setText("<html><u>Messages envoyés</u></html>");
               lblNewLabel1.setText("Messages reçus");
               panel1.removeAll();
               ModelTableEnvoye model = new ModelTableEnvoye();
               JTable table = new JTable(model);
               table.getSelectionModel().addListSelectionListener(new MsgTableSelectionListenerEnvoye());
               JScrollPane panelScrollTable = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
               
               GestionMessages gestionnaireMessage = new GestionMessages();
               messageEnvoye = gestionnaireMessage.getMessagesEnvoyes(user.getIdPersonne());
               
               model.updateTableData(messageEnvoye);
               
               
               panel1.add(panelScrollTable);
               
               panel1.repaint();
               panel1.validate();
               panel.repaint();
               panel.validate();
               
          }  
       });
       GridBagConstraints gbclblNewLabel = new GridBagConstraints();
       gbclblNewLabel.anchor = GridBagConstraints.WEST;
       gbclblNewLabel.insets = new Insets(0, 0, 5, 0);
       gbclblNewLabel.gridx = 0;
       gbclblNewLabel.gridy = 2;
       panel.add(lblNewLabel, gbclblNewLabel);
       
       panel1 = new JPanel(new BorderLayout());
       panel1.setBackground(Color.WHITE);      
       
       
       /* ADD TABLEAU       */
       
       ModelTableRecu model = new ModelTableRecu();
       JTable table = new JTable(model);
       table.getSelectionModel().addListSelectionListener(new MsgTableSelectionListenerRecu());
       JScrollPane panelScrollTable = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
       
       GestionMessages gestionnaireMessage = new GestionMessages();
       messageRecu = gestionnaireMessage.getMessagesRecus(personne.getIdPersonne());
       
       model.updateTableData(messageRecu);
       
       
       panel1.add(panelScrollTable);
       
       
       /*Fin add tableau */
       panelMessagerie.add(panel1, BorderLayout.CENTER);
       
       JPanel panel2 = new JPanel();
       panelMessagerie.add(panel2, BorderLayout.NORTH);
       
       JButton btnNouveau = new JButton("Nouveau");

       btnNouveau.setHorizontalAlignment(SwingConstants.LEFT);
       panel2.add(btnNouveau);
       
       JButton btnSupprimer = new JButton("Supprimer");
       btnSupprimer.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent arg0) {
               
           }
       });
       btnSupprimer.setVisible(false);
       panel2.add(btnSupprimer);
       
       btnNouveau.addMouseListener(new MouseAdapter() {  
           public void mouseClicked(MouseEvent e) {  
               NouveauMessage.creerNouveauMessage(user, false, "", "", "");
          }  
       });
    }
    
    public JPanel getMess() {
        return panelMessagerie;
    }
    
    public class MsgTableSelectionListenerRecu  implements ListSelectionListener {
        @Override
            public void valueChanged(ListSelectionEvent selectionEvent) {
            if (selectionEvent.getValueIsAdjusting()) {
                return;
            }
           
            ListSelectionModel selectEvent = (ListSelectionModel) selectionEvent.getSource();
           
            if (!selectEvent.isSelectionEmpty()) {
                   
                    int indexMsgSelected = selectEvent.getMaxSelectionIndex();

                    DAOVueMessage msgSelected = messageRecu.get(indexMsgSelected);
                    
                    NouveauMessage.creerNouveauMessage(user, true, msgSelected.getExpediteur(), msgSelected.getObjet(), msgSelected.getContenu());
                           
                    
                   
                   
            }
        }
    }
    
    public class MsgTableSelectionListenerEnvoye  implements ListSelectionListener {
        @Override
            public void valueChanged(ListSelectionEvent selectionEvent) {
            if (selectionEvent.getValueIsAdjusting()) {
                return;
            }
           
            ListSelectionModel selectEvent = (ListSelectionModel) selectionEvent.getSource();
           
            if (!selectEvent.isSelectionEmpty()) {
                   
                    int indexMsgSelected = selectEvent.getMaxSelectionIndex();

                    DAOVueMessage msgSelected = messageEnvoye.get(indexMsgSelected);
                    
                    NouveauMessage.creerNouveauMessage(user, true, msgSelected.getDestinataires(), msgSelected.getObjet(), msgSelected.getContenu());
                           
                    
                   
                   
            }
        }
    }
}
