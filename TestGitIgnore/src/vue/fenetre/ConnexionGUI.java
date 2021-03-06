package vue.fenetre;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import modele.utils.ConnexionJDBC;

import org.apache.log4j.LogManager;

import controleur.connexion.Connexion;

public class ConnexionGUI {
	
	/**
	 * Log4j logger
	 */
	static org.apache.log4j.Logger log4j =  LogManager.getLogger(ConnexionGUI.class.getName());
	
	private static JFrame frmConnexion;
	private static JTextField textField;
	private static JPasswordField passwordField;
	private static JLabel lblIncorrectMDP = new JLabel("Le mot de passe saisi est incorrect");
    private static JLabel lblIncorrectUser = new JLabel("Le nom d'utilisateur saisi est incorrect");
    private static JLabel lblErreurConnexion = new JLabel("La connexion à la base de donnée à échoué");
	
	public ConnexionGUI() {
	    
		
		frmConnexion = new JFrame();
		frmConnexion.getContentPane().setForeground(new Color(0, 0, 0));
		frmConnexion.setResizable(false);
		
	
		

		
		frmConnexion.setTitle("Connexion");
		frmConnexion.setBounds(100, 100, 500, 200);
		frmConnexion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConnexion.getContentPane().setLayout(null);
		
	    //Centrer la fenêtre
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frmConnexion.setLocation(dim.width/2-frmConnexion.getSize().width/2, dim.height/2-frmConnexion.getSize().height/2);
		
        // fin centrer
        
		textField = new JTextField();
		textField.setBounds(158, 42, 223, 20);
		textField.setBorder(BorderFactory.createLineBorder(Color.black));
		frmConnexion.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNomDutilisateur = new JLabel("Email :");
		lblNomDutilisateur.setBounds(35, 45, 129, 14);
		frmConnexion.getContentPane().add(lblNomDutilisateur);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setBounds(35, 78, 129, 14);
		frmConnexion.getContentPane().add(lblMotDePasse);
		
		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.setBounds(209, 112, 129, 23);
		frmConnexion.getContentPane().add(btnConnexion);

		/* écouteur d'évènements sur le bouton connexion */
		btnConnexion.addActionListener(new ActionListener (){
			@Override
			public void actionPerformed(ActionEvent e) {
			    ecouteurConnexion();
			}

            private void ecouteurConnexion() {
                try {                 
                    Connexion.openConnexion();
                    Connexion.startApp(textField.getText(), passwordField.getPassword());
                } catch (NullPointerException | SQLException e1) {
                    JFrame errorFenetre = new JFrame();
                    JOptionPane.showMessageDialog(errorFenetre, "Connexion échouée à la base de données", "Erreur",  0 );
                    ConnexionJDBC instance = ConnexionJDBC.getInstance();
                    instance.closeConnection();
                    log4j.info(e1.getMessage(), e1);
                }
            }
		});
		
		/* activer la connexion quand on presse entrée */
		frmConnexion.getRootPane().setDefaultButton(btnConnexion);
		passwordField = new JPasswordField();
		passwordField.setForeground(Color.BLACK);
		passwordField.setBounds(158, 75, 223, 20);
		
		passwordField.setBorder(BorderFactory.createLineBorder(Color.black));
		frmConnexion.getContentPane().add(passwordField);
		
		
		lblIncorrectMDP.setForeground(Color.RED);
		lblIncorrectMDP.setBounds(35, 147, 263, 14);
	    lblIncorrectMDP.setVisible(false);
	    frmConnexion.getContentPane().add(lblIncorrectMDP);

		lblIncorrectUser.setForeground(Color.RED);
		lblIncorrectUser.setBounds(35, 147, 263, 14);
		lblIncorrectUser.setVisible(false);
		frmConnexion.getContentPane().add(lblIncorrectUser);
		
		lblErreurConnexion.setForeground(Color.RED);
		lblErreurConnexion.setBounds(35, 147, 263, 14);
		lblErreurConnexion.setVisible(false);
        frmConnexion.getContentPane().add(lblIncorrectMDP);
		

		frmConnexion.setVisible(true);
	}
	
	public static void fermerFenetre() {
	    frmConnexion.dispose();
	}
	
	public static void incorrectMDP() {
	    
	    passwordField.setText("");
	    lblErreurConnexion.setVisible(false);
	    
	    lblIncorrectUser.setVisible(false);
	    textField.setBorder(BorderFactory.createLineBorder(Color.black));
	    passwordField.setBorder(BorderFactory.createLineBorder(Color.red));
	    lblIncorrectMDP.setVisible(true);
	}
	
	public static void incorrectUser() {
	    
	    passwordField.setText("");
        lblErreurConnexion.setVisible(false);
	    lblIncorrectMDP.setVisible(false);
	    textField.setBorder(BorderFactory.createLineBorder(Color.red));
	    lblIncorrectUser.setVisible(true);
	}
	
	public static void incorrectBD() {
	     passwordField.setText("");
         lblIncorrectMDP.setVisible(false);
         lblIncorrectUser.setVisible(false);
         lblErreurConnexion.setVisible(true);
	        

	     textField.setBorder(BorderFactory.createLineBorder(Color.black));
	     passwordField.setBorder(BorderFactory.createLineBorder(Color.black));

	    
	}
}
