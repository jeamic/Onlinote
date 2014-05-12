package vue.fenetre;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.net.MalformedURLException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;


public class Menu {
	
	private JPanel menu = null;
	
	public Menu (String ongletEC) {
		

		java.net.URL imgURLAccueil, imgURLNotes, imgURLSchedule, imgURLOff, imgURLMsg;
		ImageIcon imgAccueil = null;
		ImageIcon imgNotes = null;
		ImageIcon imgSchedule = null;
		ImageIcon imgOff = null;
		ImageIcon imgMsg = null;
		try {
			imgURLAccueil = new java.net.URL("file:img/home2.png");
			imgAccueil = new ImageIcon(new ImageIcon(imgURLAccueil).getImage().getScaledInstance(24, 24, Image.SCALE_DEFAULT));
			imgURLNotes = new java.net.URL("file:img/notes1.png");
			imgNotes = new ImageIcon(new ImageIcon(imgURLNotes).getImage().getScaledInstance(24, 24, Image.SCALE_DEFAULT));
			imgURLSchedule = new java.net.URL("file:img/clock.png");
			imgSchedule = new ImageIcon(new ImageIcon(imgURLSchedule).getImage().getScaledInstance(24, 24, Image.SCALE_DEFAULT));
			imgURLOff = new java.net.URL("file:img/exit2.png");
			imgOff = new ImageIcon(new ImageIcon(imgURLOff).getImage().getScaledInstance(24, 24, Image.SCALE_DEFAULT));
			imgURLMsg = new java.net.URL("file:img/msgBlack.svg");
			imgMsg = new ImageIcon(new ImageIcon(imgURLMsg).getImage().getScaledInstance(24, 24, Image.SCALE_DEFAULT));
		} catch (MalformedURLException e) {
			
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		menu = new JPanel();
		menu.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		menu.setSize(new Dimension(153, 267));
		menu.setLayout(null);
		
		JLabel lblDeconnexion = new JLabel();
		JLabel lblIconDeconnexion = new JLabel(imgOff);
		lblDeconnexion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblIconDeconnexion.setBounds(5, 214, 29, 53);
		lblDeconnexion.setBounds(44, 214, 96, 53);
		lblDeconnexion.setFont(new Font("Times new roman", Font.PLAIN, 14));
		lblDeconnexion.setText("Deconnexion");
		if (lblDeconnexion.getText() == ongletEC) {
			lblDeconnexion.setFont(new Font("Times new roman", Font.BOLD, 14));
		}
		menu.add(lblIconDeconnexion);
		menu.add(lblDeconnexion);
		
		JLabel lblNotes = new JLabel();
		JLabel lblIconNotes = new JLabel(imgNotes);
		lblIconNotes.setBounds(5, 119, 29, 53);
		lblNotes.setBounds(44, 119, 50, 53);
		lblNotes.setFont(new Font("Times new roman", Font.PLAIN, 14));
		lblNotes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNotes.setText("Notes");
		if (lblNotes.getText() == ongletEC) {
			lblNotes.setFont(new Font("Times new roman", Font.BOLD, 14));
		}
		menu.add(lblIconNotes);
		menu.add(lblNotes);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(15, 58, 125, 63);
		menu.add(panel);
		
		JLabel lblEleve = new JLabel();
		panel.add(lblEleve);
		lblEleve.setFont(new Font("Times new roman", Font.PLAIN, 14));
		lblEleve.setText("Elève :");
		
		JLabel lblNomEleve = new JLabel("");
		panel.add(lblNomEleve);
		
		JLabel lblMessagerie = new JLabel();
		JLabel lblIconMessagerie = new JLabel(imgMsg);
		lblIconMessagerie.setBounds(5, 150, 29, 53);
		lblMessagerie.setBounds(44, 150, 96, 53);
		lblMessagerie.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblMessagerie.setText("Messagerie");
		lblMessagerie.setFont(new Font("Times new roman", Font.PLAIN, 14));
		if (lblMessagerie.getText() == ongletEC) {
			lblMessagerie.setFont(new Font("Times new roman", Font.BOLD, 14));
		}
		menu.add(lblIconMessagerie);
		menu.add(lblMessagerie);
		
		//menu.setLayout(null);
				
		JLabel lblEmploiDuTemps = new JLabel();
		JLabel lblIconEmploiDuTemps = new JLabel(imgSchedule);
		lblIconEmploiDuTemps.setBounds(5, 179, 29, 53);
		lblEmploiDuTemps.setBounds(44, 179, 110, 53);
		lblEmploiDuTemps.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblEmploiDuTemps.setText("Emploi du temps");
		lblEmploiDuTemps.setFont(new Font("Times new roman", Font.PLAIN, 14));
		if ( lblEmploiDuTemps.getText() == ongletEC) {
			lblEmploiDuTemps.setFont(new Font("Times new roman", Font.BOLD, 14));
		}
		menu.add(lblIconEmploiDuTemps);
		menu.add(lblEmploiDuTemps);
		
		
        JPanel panelAccueil = new JPanel();
        panelAccueil.setBounds(5, 11, 106, 36);
        menu.add(panelAccueil);
			
		JLabel lblIconAccueil = new JLabel(imgAccueil);
		JLabel lblAccueil = new JLabel();
		lblIconAccueil.setBounds(5, 4, 29, 53);
		lblAccueil.setBounds(44, 4, 50, 53);
		lblAccueil.setFont(new Font("Times new roman", Font.PLAIN, 14));
		lblAccueil.setText("Accueil");
		if ( lblAccueil.getText() == ongletEC) {
			lblAccueil.setFont(new Font("Times new roman", Font.BOLD, 14));
		}

		panelAccueil.add(lblIconAccueil);
	      panelAccueil.add(lblAccueil);
	     panelAccueil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		

		
	}
	
	public JPanel getMenu()
	{
		return menu;
	}
}
