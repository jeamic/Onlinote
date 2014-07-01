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
import java.sql.SQLException;
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

import modele.base.actionsdao.DAOFactory;
import modele.base.dao.Message;
import modele.base.dao.Personne;
import modele.vue.dao.DAOVueMessage;
import vue.tools.ModelTable;
import controleur.messages.GestionMessages;

public class Messagerie {
    private JPanel panelMessagerie = null;
    private Personne user = null;
    private List<DAOVueMessage> messageRecu = null;
    public Messagerie (Personne personne)
    {
       user = personne;
       panelMessagerie = new JPanel(new BorderLayout());
       
       JPanel panel = new JPanel();
       panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
       panelMessagerie.add(panel, BorderLayout.WEST);
       GridBagLayout gbl_panel = new GridBagLayout();
       gbl_panel.columnWidths = new int[]{46, 0};
       gbl_panel.rowHeights = new int[]{14, 0, 0, 0, 0, 0, 0, 0, 0};
       gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
       gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
       panel.setLayout(gbl_panel);
       
       JLabel lblNewLabel_1 = new JLabel("<html><u>Message reçu</u></html>");
       lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
       gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
       gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTHWEST;
       gbc_lblNewLabel_1.gridx = 0;
       gbc_lblNewLabel_1.gridy = 0;
       panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
       
       JLabel lblNewLabel = new JLabel("<html><u>Message envoyé</u></html>");
       lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
       gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
       gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
       gbc_lblNewLabel.gridx = 0;
       gbc_lblNewLabel.gridy = 2;
       panel.add(lblNewLabel, gbc_lblNewLabel);
       
       JLabel lblNewLabel_3 = new JLabel("<html><u>Message supprimé</u></html>");
       lblNewLabel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
       gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
       gbc_lblNewLabel_3.gridx = 0;
       gbc_lblNewLabel_3.gridy = 4;
       panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
       
       JPanel panel_1 = new JPanel(new BorderLayout());
       panel_1.setBackground(Color.WHITE);
       //panel_1.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
       
       
       
       /* ADD TABLEAU       */
       ModelTable model = new ModelTable();
       JTable table = new JTable(model);
       table.getSelectionModel().addListSelectionListener(new MsgTableSelectionListener());
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
    
    public class MsgTableSelectionListener  implements ListSelectionListener
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
                            
                            System.out.println(msgSelected.getContenu());
                            
                            NouveauMessage.creerNouveauMessage(user, true, msgSelected.getExpediteur(), msgSelected.getObjet(), msgSelected.getContenu());
                           
                    
                   
                   
            }
        }
    }
}
