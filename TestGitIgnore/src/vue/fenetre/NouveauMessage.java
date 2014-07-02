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
    private JPanel panel1;
    private JTextField txtDestinataire;
    private JPanel panel2;
    private JButton btnEnvoyer;
    private JPanel panel3;
    private JTextField txtSujet;
    private JTextArea txtrMssage;
    private Personne user = null;
    private JButton btnRepondre;
    private JButton btnSupprimer;
    private NouveauMessage(Personne personne, boolean isRepondre, final String dest, final String obj, String cont) {
        
        user = personne;
        
        frmMessage = new JFrame();
        frmMessage.setVisible(true);
        frmMessage.getContentPane().setForeground(new Color(0, 0, 0));
        frmMessage.getContentPane().setLayout(new BorderLayout(0, 0));
        
        panel = new JPanel();
        frmMessage.getContentPane().add(panel, BorderLayout.NORTH);
        GridBagLayout gblpanel = new GridBagLayout();
        gblpanel.columnWidths = new int[]{0, 0};
        gblpanel.rowHeights = new int[]{0, 0};
        gblpanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gblpanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        panel.setLayout(gblpanel);
        panel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        
        txtDestinataire = new JTextField();
        txtDestinataire.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                if (txtDestinataire.getText().equals("Destinataire")) {
                    txtDestinataire.setText("");
                }
            }
        });
        txtDestinataire.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        txtDestinataire.setText("Destinataire");
        if (!dest.equals("")) {
            txtDestinataire.setText(dest);
        }
        if (isRepondre) {
            txtDestinataire.setEditable(false);
        }
        txtDestinataire.setBorder((BorderFactory.createLineBorder(Color.black)));
        txtDestinataire.setToolTipText("Destinataire");
        GridBagConstraints gbctxtDestinataire = new GridBagConstraints();
        gbctxtDestinataire.fill = GridBagConstraints.HORIZONTAL;
        gbctxtDestinataire.gridx = 0;
        gbctxtDestinataire.gridy = 0;
        panel.add(txtDestinataire, gbctxtDestinataire);
        txtDestinataire.setColumns(10);
        
        panel1 = new JPanel();
        frmMessage.getContentPane().add(panel1, BorderLayout.CENTER);
        panel1.setLayout(new BorderLayout(0, 0));
        panel1.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        
        panel2 = new JPanel(new BorderLayout());
        panel1.add(panel2, BorderLayout.SOUTH);
        
        btnEnvoyer = new JButton("Envoyer");
        btnEnvoyer.setVisible(!isRepondre);
        btnEnvoyer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                DAOVueMessage message = new DAOVueMessage();
                GestionMessages messagerie = new GestionMessages();
                
                message.setExpediteur(user.getEmail());
                message.setDestinataires(txtDestinataire.getText());
                message.setObjet(txtSujet.getText());
                message.setContenu(txtrMssage.getText());
                messagerie.envoyerMessage(message);
                NouveauMessage.reussiNouveauMessage();
            }
        });
        panel2.add(btnEnvoyer, BorderLayout.CENTER);
        
        btnRepondre = new JButton("Repondre");
        btnRepondre.setVisible(isRepondre);
        btnRepondre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                creerNouveauMessage(user, false, dest, "RE:"+ obj, "");
            }
        });
        panel2.add(btnRepondre, BorderLayout.WEST);
        
        btnSupprimer = new JButton("Supprimer");
        btnSupprimer.setVisible(isRepondre);
        btnSupprimer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
            }
        });
        panel2.add(btnSupprimer, BorderLayout.EAST);
        
        panel3 = new JPanel();
        panel1.add(panel3, BorderLayout.NORTH);
        panel3.setLayout(new BorderLayout(0, 0));
        
        txtSujet = new JTextField();
        txtSujet.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                if (txtSujet.getText().equals("Sujet")) {
                    txtSujet.setText(""); 
                }
            }
        });
        txtSujet.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        txtSujet.setText("Sujet");
        if (!obj.equals("")) {
           txtSujet.setText(obj);
        }
        if (isRepondre) {
            txtSujet.setEditable(false);
        }
        panel3.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
        panel3.add(txtSujet, BorderLayout.NORTH);
        txtSujet.setBorder((BorderFactory.createLineBorder(Color.black)));
        txtSujet.setColumns(10);
        
        txtrMssage = new JTextArea();
        txtrMssage.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                if (txtrMssage.getText().equals("Message")) {
                    txtrMssage.setText("");
                }
            }
        });
        txtrMssage.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        txtrMssage.setText("Message");
        if (!cont.equals("")) {
            txtrMssage.setText(cont);
        }
        if (isRepondre) {
            txtrMssage.setEditable(false);
        }
        txtrMssage.setBorder((BorderFactory.createLineBorder(Color.black)));
        txtrMssage.setLineWrap(true);
        panel1.add(txtrMssage, BorderLayout.CENTER);
        frmMessage.setResizable(false);
        

        frmMessage.setTitle("Message");
        frmMessage.setBounds(100, 100, 500, 200);
        
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frmMessage.setLocation(dim.width/2-frmMessage.getSize().width/2, dim.height/2-frmMessage.getSize().height/2);
        
    }
    
    public static void creerNouveauMessage(Personne personne, boolean isRepondre, String dest, String obj, String cont) {
        new NouveauMessage(personne, isRepondre, dest, obj, cont);
    }
    
    public static void reussiNouveauMessage(){
        frmMessage.getContentPane().removeAll();
        JLabel lblReussi = new JLabel("Envoi réussi");
        frmMessage.getContentPane().add(lblReussi);
        
        frmMessage.repaint();
        frmMessage.validate();
        
        
    }
    
}
