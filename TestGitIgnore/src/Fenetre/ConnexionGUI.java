package Fenetre;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ConnexionGUI {
	
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	
	public ConnexionGUI() {
	}
	
	public void Affiche (){
		frame = new JFrame();
		frame.setBounds(100, 100, 448, 212);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(242, 40, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNomDutilisateur = new JLabel("Email :");
		lblNomDutilisateur.setBounds(76, 43, 129, 14);
		frame.getContentPane().add(lblNomDutilisateur);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(242, 73, 86, 20);
		frame.getContentPane().add(textField_1);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setBounds(76, 76, 129, 14);
		frame.getContentPane().add(lblMotDePasse);
		
		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.setBounds(169, 117, 89, 23);
		frame.getContentPane().add(btnConnexion);
		
		/* écouteur d'évènements sur le bouton connexion */
		btnConnexion.addActionListener(new ActionListener (){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Connexion.startApp(textField.getText(), textField_1.getText());
				} 
				catch (InstantiationException | IllegalAccessException
						| ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		/* activer la connexion quand on presse entrée */
		frame.getRootPane().setDefaultButton(btnConnexion);
		
		frame.setVisible(true);
	}
}
