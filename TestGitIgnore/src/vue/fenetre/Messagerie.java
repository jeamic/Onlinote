package vue.fenetre;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Messagerie {
    private JPanel panelMessagerie = null;
    public Messagerie ()
    {
       panelMessagerie = new JPanel(new BorderLayout());
       
       JPanel panel = new JPanel();
       panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
       panelMessagerie.add(panel, BorderLayout.WEST);
       GridBagLayout gbl_panel = new GridBagLayout();
       gbl_panel.columnWidths = new int[]{46, 0};
       gbl_panel.rowHeights = new int[]{14, 0, 0, 0, 0, 0, 0, 0, 0};
       gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
       gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
       panel.setLayout(gbl_panel);
       
       JLabel lblNewLabel_1 = new JLabel("<html><u>Message reçu</u></html>");
       lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
       gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
       gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTHWEST;
       gbc_lblNewLabel_1.gridx = 0;
       gbc_lblNewLabel_1.gridy = 0;
       panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
       
       JLabel lblNewLabel = new JLabel("<html><u>Message envoyé</u></html>");
       lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
       gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
       gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
       gbc_lblNewLabel.gridx = 0;
       gbc_lblNewLabel.gridy = 2;
       panel.add(lblNewLabel, gbc_lblNewLabel);
       
       JLabel lblNewLabel_2 = new JLabel("<html><u>Brouillons</u></html>");
       lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
       gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
       gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
       gbc_lblNewLabel_2.gridx = 0;
       gbc_lblNewLabel_2.gridy = 4;
       panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
       
       JLabel lblNewLabel_3 = new JLabel("<html><u>Message supprimé</u></html>");
       lblNewLabel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
       gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
       gbc_lblNewLabel_3.gridx = 0;
       gbc_lblNewLabel_3.gridy = 6;
       panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
       
       JPanel panel_1 = new JPanel();
       panel_1.setBackground(Color.WHITE);
       panel_1.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
       panelMessagerie.add(panel_1, BorderLayout.CENTER);
       
    }
    
    public JPanel getMess() {
        return panelMessagerie;
    }
}
