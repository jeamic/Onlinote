package vue.fenetre;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.apache.log4j.LogManager;

import controleur.connexion.Connexion;

public class ConnexionGUI {
	
	/**
	 * Log4j logger
	 */
	static org.apache.log4j.Logger log4j =  LogManager.getLogger(ConnexionGUI.class.getName());
	
	private JFrame frmConnexion;
	private JTextField textField;
	private JPasswordField passwordField;
	
	public ConnexionGUI() {
	    
		
		frmConnexion = new JFrame();
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
				// TODO Auto-generated method stub
				try {
					Connexion.startApp(textField.getText(), passwordField.getPassword());
					frmConnexion.dispose();
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IOException e1) {
					log4j.info(e1.getMessage(), e1);
				}
			}
			
		});
		/* activer la connexion quand on presse entrée */
		frmConnexion.getRootPane().setDefaultButton(btnConnexion);
		passwordField = new JPasswordField();
		passwordField.setBounds(158, 75, 223, 20);
		frmConnexion.getContentPane().add(passwordField);
		frmConnexion.setVisible(true);
	}

}
