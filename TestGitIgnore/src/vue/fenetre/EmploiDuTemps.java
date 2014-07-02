package vue.fenetre;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import modele.base.dao.Matiere;
import modele.vue.dao.DAOVueCours;
import vue.tools.ModelTableEdt;
import controleur.cours.GestionCours;
import controleur.cours.GestionMatiere;
import controleur.cours.GestionNotes;

public class EmploiDuTemps {
    private List<DAOVueCours> CoursLundi = new ArrayList<DAOVueCours>();
    private List<DAOVueCours> CoursMardi = new ArrayList<DAOVueCours>();
    private List<DAOVueCours> CoursMercredi = new ArrayList<DAOVueCours>();
    private List<DAOVueCours> CoursJeudi = new ArrayList<DAOVueCours>();
    private List<DAOVueCours> CoursVendredi = new ArrayList<DAOVueCours>();
 
    private JPanel eDT = null;

    public EmploiDuTemps (int idEleve) {
    
    
        eDT = new JPanel(new BorderLayout());
        
        List<String> heures = new ArrayList<String>();
        heures.add("8h00 - 9h00");
        heures.add("9h00 - 10h00");
        heures.add("10h00 - 11h00");
        heures.add("11h00 - 12h00");
        heures.add("12h00 - 13h00");
        heures.add("13h00 - 14h00");
        heures.add("14h00 - 15h00");
        heures.add("15h00 - 16h00");
        heures.add("16h00 - 17h00");
        heures.add("17h00 - 18h00");
        
        
        ModelTableEdt model = new ModelTableEdt();
        JTable table = new JTable(model);
        table.setRowHeight(100);
        //table.getSelectionModel().addListSelectionListener(new MsgTableSelectionListenerRecu());
        JScrollPane panelScrollTable = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        GestionCours gestionnaireCours = new GestionCours();
        
        int h = 8;
        
        System.out.println(gestionnaireCours.getCours(idEleve, "2014-06-30 10:00:02").getMatiere());
        for (int i=0; i < 10 ;++i) {
            
            if (h== 8 || h == 9) {
                CoursLundi.add(gestionnaireCours.getCours(idEleve, "2014-06-30 0" + h + ":00:02"));
                CoursMardi.add(gestionnaireCours.getCours(idEleve, "2014-07-01 0" + h + ":00:02"));
                CoursMercredi.add(gestionnaireCours.getCours(idEleve, "2014-07-02 0" + h + ":00:02"));
                CoursJeudi.add(gestionnaireCours.getCours(idEleve, "2014-07-03 0" + h + ":00:02"));
                CoursVendredi.add(gestionnaireCours.getCours(idEleve, "2014-07-04 0" + h + ":00:02"));
            } else {
                CoursLundi.add(gestionnaireCours.getCours(idEleve, "2014-06-30 " + h + ":00:02"));
                CoursMardi.add(gestionnaireCours.getCours(idEleve, "2014-07-01 " + h + ":00:02"));
                CoursMercredi.add(gestionnaireCours.getCours(idEleve, "2014-07-02 " + h + ":00:02"));
                CoursJeudi.add(gestionnaireCours.getCours(idEleve, "2014-07-03 " + h + ":00:02"));
                CoursVendredi.add(gestionnaireCours.getCours(idEleve, "2014-07-04 " + h + ":00:02"));
            }

            h = h+1;
        }
        
        model.updateTableData(heures, CoursLundi, CoursMardi, CoursMercredi, CoursJeudi, CoursVendredi);
        
        eDT.add(panelScrollTable);

    }
    
    public JPanel getEDT() {
        return eDT;
    }
}
