package Fenetre;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class ConnexionGUI {
	
	private JFrame frmConnexion;
	private JTextField textField;
	private JPasswordField passwordField;
	
	public ConnexionGUI() {
	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void Affiche (){
		frmConnexion = new JFrame();
		frmConnexion.setTitle("Connexion");
		frmConnexion.setBounds(100, 100, 448, 212);
		frmConnexion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConnexion.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(199, 40, 129, 20);
		frmConnexion.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNomDutilisateur = new JLabel("Email :");
		lblNomDutilisateur.setBounds(76, 43, 129, 14);
		frmConnexion.getContentPane().add(lblNomDutilisateur);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setBounds(76, 76, 129, 14);
		frmConnexion.getContentPane().add(lblMotDePasse);
		
		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.setBounds(199, 117, 129, 23);
		frmConnexion.getContentPane().add(btnConnexion);
		
		/* écouteur d'évènements sur le bouton connexion */
		btnConnexion.addActionListener(new ActionListener (){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Connexion.startApp(textField.getText(), passwordField.getPassword());
				} 
				catch (InstantiationException | IllegalAccessException
						| ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		/* activer la connexion quand on presse entrée */
		frmConnexion.getRootPane().setDefaultButton(btnConnexion);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(199, 73, 129, 20);
		frmConnexion.getContentPane().add(passwordField);
		
		frmConnexion.setVisible(true);
	}
}
