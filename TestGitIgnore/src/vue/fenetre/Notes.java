package vue.fenetre;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Notes {
    private JTable table;
    private JPanel notes = null;
    
    public Notes () {
    
    
        notes = new JPanel();
        
        String[] columnNames = {"Math", "Math", "Sport", "Math", "Math"};
        
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
        
        table = new JTable(data, columnNames);
        notes.add(table);
        notes.add(new JScrollPane(table));
        
        table.setVisible(true);
        
    }
    
    public JPanel getNotes() {
        return notes;
    }

}
