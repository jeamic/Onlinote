package vue.fenetre;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import modele.vue.dao.DAOVueCours;
import vue.tools.ModelTableEdt;
import controleur.cours.GestionCours;

public class EmploiDuTemps {

    private Calendar c = null;
    private String dt = null;
    private SimpleDateFormat sdf = null;
    private int ideleve = 0;
 
    private JPanel eDT = null;

    public EmploiDuTemps (int idEleve) {
    
        ideleve = idEleve;
    
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
        
        
        

        c = Calendar.getInstance();
        dt = c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.DATE);
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            c.setTime(sdf.parse(dt));
            dt = sdf.format(c.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        
        while (dayOfWeek != 2) {
            c.add(Calendar.DATE, -1);
            dt = sdf.format(c.getTime());
            dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        }
        
        


        
        
        ModelTableEdt model = new ModelTableEdt();
        JTable table = new JTable(model);
        table.setRowHeight(100);
        JScrollPane panelScrollTable = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        GestionCours gestionnaireCours = new GestionCours();
        
        
        
        
        List<String> dateCours = new ArrayList<String>();
        
        for (int i = 0; i < 5;++i)
        {
            dateCours.add(dt);
            c.add(Calendar.DATE, 1);
            dt = sdf.format(c.getTime());
        }
        
        int h = 8;
        
        JPanel panelTop = new JPanel(new BorderLayout());
        
        JButton droite = new JButton(">");
        droite.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                
                c.add(Calendar.DATE, 2);
                dt = sdf.format(c.getTime());
                
                modifEdt();
                
                
            }
        });
        JButton gauche = new JButton("<");
        gauche.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                
                c.add(Calendar.DATE, -12);
                dt = sdf.format(c.getTime());
                
                modifEdt();
                
                
            }
        });
        
        List<DAOVueCours> CoursLundi = new ArrayList<DAOVueCours>();
        List<DAOVueCours> CoursMardi = new ArrayList<DAOVueCours>();
        List<DAOVueCours> CoursMercredi = new ArrayList<DAOVueCours>();
        List<DAOVueCours> CoursJeudi = new ArrayList<DAOVueCours>();
        List<DAOVueCours> CoursVendredi = new ArrayList<DAOVueCours>();
        
        JLabel centre = new JLabel("Semaine du : " + dateCours.get(0) + " au : " + dateCours.get(4));
        centre.setHorizontalAlignment(SwingConstants.CENTER);
        
        panelTop.add(droite, BorderLayout.EAST);
        panelTop.add(gauche, BorderLayout.WEST);
        panelTop.add(centre, BorderLayout.CENTER);
        
        for (int i=0; i < 10 ;++i) {
            
            if (h== 8 || h == 9) {
                CoursLundi.add(gestionnaireCours.getCours(idEleve, dateCours.get(0) + " 0" + h + ":00:02"));
                CoursMardi.add(gestionnaireCours.getCours(idEleve, dateCours.get(1)  + " 0" + h + ":00:02"));
                CoursMercredi.add(gestionnaireCours.getCours(idEleve, dateCours.get(2) + " 0" + h + ":00:02"));
                CoursJeudi.add(gestionnaireCours.getCours(idEleve, dateCours.get(3) + " 0" + h + ":00:02"));
                CoursVendredi.add(gestionnaireCours.getCours(idEleve, dateCours.get(4) + " 0" + h + ":00:02"));
            } else {
                CoursLundi.add(gestionnaireCours.getCours(idEleve, dateCours.get(0) +" " + h + ":00:02"));
                CoursMardi.add(gestionnaireCours.getCours(idEleve, dateCours.get(1) +" " + h + ":00:02"));
                CoursMercredi.add(gestionnaireCours.getCours(idEleve, dateCours.get(2) +" " + h + ":00:02"));
                CoursJeudi.add(gestionnaireCours.getCours(idEleve, dateCours.get(3) +" "+ h + ":00:02"));
                CoursVendredi.add(gestionnaireCours.getCours(idEleve, dateCours.get(4) +" " + h + ":00:02"));
            }

            h = h+1;
        }
        
        model.updateTableData(heures, CoursLundi, CoursMardi, CoursMercredi, CoursJeudi, CoursVendredi);
        
        eDT.add(panelScrollTable, BorderLayout.CENTER);
        eDT.add(panelTop, BorderLayout.NORTH);

    }
    
    public JPanel getEDT() {
        return eDT;
    }
    
    public void modifEdt() {
        
        eDT.removeAll();
        
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
        JScrollPane panelScrollTable = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        GestionCours gestionnaireCours = new GestionCours();
        
        
        
        
        List<String> dateCours = new ArrayList<String>();
        
        for (int i = 0; i < 5;++i)
        {
            dateCours.add(dt);
            c.add(Calendar.DATE, 1);
            dt = sdf.format(c.getTime());
        }
        
        int h = 8;
        
        JPanel panelTop = new JPanel(new BorderLayout());
        
        JButton droite = new JButton(">");
        droite.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                c.add(Calendar.DATE, 2);
                dt = sdf.format(c.getTime());
                
                modifEdt();
                
            }
        });
        JButton gauche = new JButton("<");
        gauche.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                c.add(Calendar.DATE, -12);
                dt = sdf.format(c.getTime());
                
                modifEdt();
                
            }
        });
        
        JLabel centre = new JLabel("Semaine du : " + dateCours.get(0) + " au : " + dateCours.get(4));
        centre.setHorizontalAlignment(SwingConstants.CENTER);
        
        panelTop.add(droite, BorderLayout.EAST);
        panelTop.add(gauche, BorderLayout.WEST);
        panelTop.add(centre, BorderLayout.CENTER);
        
        List<DAOVueCours> CoursLundi = new ArrayList<DAOVueCours>();
        List<DAOVueCours> CoursMardi = new ArrayList<DAOVueCours>();
        List<DAOVueCours> CoursMercredi = new ArrayList<DAOVueCours>();
        List<DAOVueCours> CoursJeudi = new ArrayList<DAOVueCours>();
        List<DAOVueCours> CoursVendredi = new ArrayList<DAOVueCours>();

        for (int i=0; i < 10 ;++i) {
            
            if (h== 8 || h == 9) {
                CoursLundi.add(gestionnaireCours.getCours(ideleve, dateCours.get(0) + " 0" + h + ":00:02"));
                CoursMardi.add(gestionnaireCours.getCours(ideleve, dateCours.get(1)  + " 0" + h + ":00:02"));
                CoursMercredi.add(gestionnaireCours.getCours(ideleve, dateCours.get(2) + " 0" + h + ":00:02"));
                CoursJeudi.add(gestionnaireCours.getCours(ideleve, dateCours.get(3) + " 0" + h + ":00:02"));
                CoursVendredi.add(gestionnaireCours.getCours(ideleve, dateCours.get(4) + " 0" + h + ":00:02"));
            } else {
                CoursLundi.add(gestionnaireCours.getCours(ideleve, dateCours.get(0) +" " + h + ":00:02"));
                CoursMardi.add(gestionnaireCours.getCours(ideleve, dateCours.get(1) +" " + h + ":00:02"));
                CoursMercredi.add(gestionnaireCours.getCours(ideleve, dateCours.get(2) +" " + h + ":00:02"));
                CoursJeudi.add(gestionnaireCours.getCours(ideleve, dateCours.get(3) +" "+ h + ":00:02"));
                CoursVendredi.add(gestionnaireCours.getCours(ideleve, dateCours.get(4) +" " + h + ":00:02"));
            }

            h = h+1;
        }
        
        model.updateTableData(heures, CoursLundi, CoursMardi, CoursMercredi, CoursJeudi, CoursVendredi);
        
        eDT.add(panelScrollTable, BorderLayout.CENTER);
        eDT.add(panelTop, BorderLayout.NORTH);
        eDT.repaint();
        eDT.revalidate();
    }
}
