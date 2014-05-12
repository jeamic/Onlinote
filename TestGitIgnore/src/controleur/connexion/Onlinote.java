package controleur.connexion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JCheckBox;

import modele.bddconnect.ConnexionJDBC;

import org.apache.log4j.LogManager;

import vue.fenetre.ConnexionGUI;

public class Onlinote {
	
	/**
	 * Log4j logger
	 */
	static org.apache.log4j.Logger log4j =  LogManager.getLogger(ConnexionJDBC.class.getName());
	
	/**
	 * Create the application.
	 */
	private Onlinote() {
		new ConnexionGUI();
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Onlinote();
				} catch (Exception e) {
					log4j.info(e.getMessage(), e);
				}
			}
		});
	}
	
	public static void relancer() {
	    try {
            new Onlinote();
        } catch (Exception e) {
            log4j.info(e.getMessage(), e);
        }
	    
	}
}
