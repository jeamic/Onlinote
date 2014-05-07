package controleur.connexion;

import java.awt.PopupMenu;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;

import javax.swing.JToolBar;

public class TypeConnexion {
	
	private JFrame fen;
	
	private JTextField textField;

	public TypeConnexion () {}
	
	/**
	 * @wbp.parser.constructor
	 * @wbp.parser.entryPoint
	 */
	public TypeConnexion (String sType) {
		
		fen = new JFrame();
		
		JToolBar toolBar = new JToolBar();
		fen.getContentPane().add(toolBar, BorderLayout.CENTER);
		System.out.println("Type switch connexion " + sType);
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fen.getContentPane().setLayout(null);
		
		fen.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(164, 40, 223, 20);
		fen.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNomDutilisateur = new JLabel("Email :");
		lblNomDutilisateur.setBounds(41, 43, 129, 14);
		fen.getContentPane().add(lblNomDutilisateur);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setBounds(41, 76, 129, 14);
		fen.getContentPane().add(lblMotDePasse);
		
		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.setBounds(215, 110, 129, 23);
		fen.getContentPane().add(btnConnexion);
		fen.setExtendedState(JFrame.MAXIMIZED_BOTH);
		fen.setVisible(true);

	}

}
