package vue.fenetre;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import modele.base.dao.Personne;
import modele.vue.dao.DAOVueMessage;
import controleur.messages.GestionMessages;



public class NouveauMessage {
    
    private static JFrame frmMessage;
    private JPanel panel;
    private JPanel panel_1;
    private JTextField txtDestinataire;
    private JPanel panel_2;
    private JButton btnEnvoyer;
    private JPanel panel_3;
    private JTextField txtSujet;
    private JTextArea txtrMssage;
    private Personne user = null;
    private NouveauMessage(Personne personne) {
        
        user = personne;
        
        frmMessage = new JFrame();
        frmMessage.setVisible(true);
        frmMessage.getContentPane().setForeground(new Color(0, 0, 0));
        frmMessage.getContentPane().setLayout(new BorderLayout(0, 0));
        
        panel = new JPanel();
        frmMessage.getContentPane().add(panel, BorderLayout.NORTH);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[]{0, 0};
        gbl_panel.rowHeights = new int[]{0, 0};
        gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        panel.setLayout(gbl_panel);
        panel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        
        txtDestinataire = new JTextField();
        txtDestinataire.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                txtDestinataire.setText("");
            }
        });
        txtDestinataire.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        txtDestinataire.setText("Destinataire");
        txtDestinataire.setBorder((BorderFactory.createLineBorder(Color.black)));
        txtDestinataire.setToolTipText("Destinataire");
        GridBagConstraints gbc_txtDestinataire = new GridBagConstraints();
        gbc_txtDestinataire.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtDestinataire.gridx = 0;
        gbc_txtDestinataire.gridy = 0;
        panel.add(txtDestinataire, gbc_txtDestinataire);
        txtDestinataire.setColumns(10);
        
        panel_1 = new JPanel();
        frmMessage.getContentPane().add(panel_1, BorderLayout.CENTER);
        panel_1.setLayout(new BorderLayout(0, 0));
        panel_1.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        
        panel_2 = new JPanel();
        panel_1.add(panel_2, BorderLayout.SOUTH);
        
        btnEnvoyer = new JButton("Envoyer");
        btnEnvoyer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                DAOVueMessage message = new DAOVueMessage();
                GestionMessages messagerie = new GestionMessages();
                
                
                String dest = txtDestinataire.getText();
                String subjet = txtSujet.getText();
                String object = txtrMssage.getText();
                message.setExpediteur(user.getEmail());
                message.setDestinataires(txtDestinataire.getText());
                message.setObjet(txtSujet.getText());
                message.setContenu(txtrMssage.getText());
                messagerie.envoyerMessage(message);
                NouveauMessage.reussiNouveauMessage();
            }
        });
        panel_2.add(btnEnvoyer);
        
        panel_3 = new JPanel();
        panel_1.add(panel_3, BorderLayout.NORTH);
        panel_3.setLayout(new BorderLayout(0, 0));
        
        txtSujet = new JTextField();
        txtSujet.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                txtSujet.setText("");
            }
        });
        txtSujet.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        txtSujet.setText("Sujet");
        panel_3.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
        panel_3.add(txtSujet, BorderLayout.NORTH);
        txtSujet.setBorder((BorderFactory.createLineBorder(Color.black)));
        txtSujet.setColumns(10);
        
        txtrMssage = new JTextArea();
        txtrMssage.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                txtrMssage.setText("");
            }
        });
        txtrMssage.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        txtrMssage.setText("Message");
        txtrMssage.setBorder((BorderFactory.createLineBorder(Color.black)));
        txtrMssage.setLineWrap(true);
        panel_1.add(txtrMssage, BorderLayout.CENTER);
        frmMessage.setResizable(false);
        

        frmMessage.setTitle("Message");
        frmMessage.setBounds(100, 100, 500, 200);
        
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frmMessage.setLocation(dim.width/2-frmMessage.getSize().width/2, dim.height/2-frmMessage.getSize().height/2);
        
    }
    
    public static void creerNouveauMessage(Personne personne) {
        new NouveauMessage(personne);
    }
    
    public static void reussiNouveauMessage(){
        frmMessage.getContentPane().removeAll();
        JLabel lblReussi = new JLabel("Envoi réussi");
        frmMessage.getContentPane().add(lblReussi);
        
        frmMessage.repaint();
        frmMessage.validate();
        
        
    }
    
}
