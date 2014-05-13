package vue.fenetre;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class EmploiDuTemps {
    private JTable tableEDT;
    private JPanel eDT = null;
    
    public EmploiDuTemps () {
    
    
        eDT = new JPanel();
        
        String[] columnNames = {"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi"};
        
        Object[][] data = {
                {"Kathy", "Smith",
                 "Snowboarding", new Integer(5), new Boolean(false)},
                {"John", "Doe",
                 "Rowing", new Integer(3), new Boolean(true)},
                {"Sue", "Black",
                 "Knitting", new Integer(2), new Boolean(false)},
                {"Jane", "White",
                 "Speed reading", new Integer(20), new Boolean(true)},
                {"Joe", "Brown",
                 "Pool", new Integer(10), new Boolean(false)}
            };
        
        tableEDT = new JTable(data, columnNames);
        eDT.add(tableEDT);
        eDT.add(new JScrollPane(tableEDT));
        
        tableEDT.setVisible(true);
        
    }
    
    public JPanel getEDT() {
        return eDT;
    }
}
