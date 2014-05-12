package vue.fenetre;


import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.SwingConstants;

public class Fenetre {
	
	public Fenetre(){
		JFrame maFenetre = new JFrame();
		
		maFenetre.setSize(new Dimension(880, 540));
		

		
		maFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel Monmenu = new Menu("Accueil").getMenu();
		Monmenu.setBounds(0,0,150,300);
		
		maFenetre.getContentPane().add( Monmenu, BorderLayout.CENTER);
		maFenetre.getContentPane().setLayout(null);
		
		JLabel lblApplicationOnlinote = new JLabel("Bienvenue sur l'application Onlinote Mr X");
		lblApplicationOnlinote.setBounds(150, 0, 714, 502);
		lblApplicationOnlinote.setVerticalAlignment(SwingConstants.TOP);
		lblApplicationOnlinote.setFont(new Font("Times new roman", Font.PLAIN, 32));
		lblApplicationOnlinote.setHorizontalAlignment(SwingConstants.CENTER);
		maFenetre.getContentPane().add(lblApplicationOnlinote);
		
		
		JLabel lblDetails1 = new JLabel("L'application qui vous permet de suivre vos enfants et garder un contact avec l'administration");
		lblDetails1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDetails1.setFont(new Font("Times new roman", Font.PLAIN, 12));
		lblDetails1.setBounds(150, 44, 714, 35);
		maFenetre.getContentPane().add(lblDetails1);
			
		maFenetre.setVisible(true);
	}

}
