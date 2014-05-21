package vue.fenetre;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import modele.basedao.Personne;

public class FenetreAdmin {
	
	protected static JFrame maFenetreAdmin = null;

    private FenetreAdmin(Personne personne){
			
        maFenetreAdmin = new JFrame();
        
        maFenetreAdmin.setSize(new Dimension(880, 540));
        
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        maFenetreAdmin.setLocation(dim.width/2-maFenetreAdmin.getSize().width/2, dim.height/2-maFenetreAdmin.getSize().height/2);

        
        maFenetreAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
            
        JLabel lblApplicationOnlinote = new JLabel("Bienvenue sur l'application Onlinote Administrateur");
        lblApplicationOnlinote.setBounds(150, 0, 714, 502);
        lblApplicationOnlinote.setVerticalAlignment(SwingConstants.TOP);
        lblApplicationOnlinote.setFont(new Font("Times new roman", Font.PLAIN, 32));
        lblApplicationOnlinote.setHorizontalAlignment(SwingConstants.CENTER);
        maFenetreAdmin.getContentPane().add(lblApplicationOnlinote);
        
            
        maFenetreAdmin.setVisible(true);
	}
    
    public static void creerFenetreAdmin (Personne personne) {
        new FenetreAdmin (personne);
    }
	

}
