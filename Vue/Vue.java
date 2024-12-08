package Vue;
import DAO.*;
import Model.Employee;

import javax.print.DocFlavor;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Vue extends JFrame {

    private JPanel p1;
    private JPanel p2;
    private JPanel p3;
    public JPanel getP3(){
        return p3 ;
    }

    private JPanel p4;
    private JComboBox<String> postesComboBox ;
    private JComboBox<String> roleComboBox ;
    private JButton ajouter ;
    private JButton modifier;
    private JButton supprimer ;
    private JButton afficher ;


    private JTextField tel;
    private JTextField sal  ;
    private JTextField nom ;
    private JTextField prenom ;
    private JTextField email  ;
    private  JList<String> employeeList ;
    public  JList<String> getEmployeeList(){
        return employeeList ;
    };
    public  void setEmployeeList(JList<String> employeeList){
        this.employeeList =employeeList   ;
    } ;
    public Vue() {
        setTitle("App");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        EmployeeDAOImpl eImp = new EmployeeDAOImpl();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p1.setLayout(new BorderLayout());
        p2.setLayout(new GridLayout(7,2,10,10));

        p3.setLayout(new GridLayout());
        p4.setLayout(new GridLayout());
        add(p1);
        p1.add(p2 , BorderLayout.NORTH);
        p1.add(p3 , BorderLayout.CENTER);
        p1.add(p4 , BorderLayout.SOUTH);


        p2.add(new JLabel("Nom:"));
        nom =  new JTextField();p2.add(nom);
        p2.add(new JLabel("Prenom:"));
        prenom =  new JTextField();p2.add(prenom);
        p2.add(new JLabel("Email:"));
        email =  new JTextField();p2.add(email);
        p2.add(new JLabel("Telephone:"));
        tel = new JTextField();p2.add(tel);
        p2.add(new JLabel("Salaire:"));
        sal =  new JTextField();p2.add(sal);

        p2.add(new JLabel("Role:"));
        List<Employee.Role> roles = eImp.findAllRoles() ;
        String[] roleStrings = roles.stream()
                .map(Enum::name)
                .toArray(String[]::new);
        roleComboBox = new JComboBox<String>(roleStrings);
        p2.add(roleComboBox);

        p2.add(new JLabel("Poste:"));
        List<Employee.Poste> postes = eImp.findAllPostes() ;
        String[] postesStrings = postes.stream()
                .map(Enum::name)
                .toArray(String[]::new);
        postesComboBox = new JComboBox<String>(postesStrings);
        p2.add(postesComboBox);



        //P3 Container
        List<Employee> all_e = eImp.findAll();
        List<String> allString = new ArrayList<String>();
        allString.add(String.format(
                "| %-5s | %-15s | %-15s | %-15s | %-25s | %-10s | %-20s | %-10s |",
                "ID", "Nom", "Prenom", "Tel", "Email", "Salaire", "Poste", "Role"
        ));
        for (Employee e : all_e){
            allString.add(e.toString());
        }
        String[] allStringArray = allString.toArray(new String[0]);

        employeeList = new JList<String>(allStringArray);
        p3.add(employeeList);


        //p4 Container

        p4.setLayout(new FlowLayout());
        this.ajouter = new JButton("Ajouter");
        this.modifier = new JButton("Modifier");
        this.supprimer = new JButton("Supprimer");
        this.afficher = new JButton("Afficher");
        p4.add(this.ajouter);p4.add(this.modifier);p4.add(this.supprimer);p4.add(this.afficher);
        setVisible(true);
    }

    public JComboBox<String> getPostesComboBox() {
        return postesComboBox;
    }

    public JComboBox<String> getRoleComboBox() {
        return roleComboBox;
    }

    public JButton getAjouter() {
        return ajouter;
    }

    public JButton getModifier() {
        return modifier;
    }

    public JButton getSupprimer() {
        return supprimer;
    }

    public JButton getAfficher() {
        return afficher;
    }

    public JTextField getTel() {
        return tel;
    }

    public JTextField getSal() {
        return sal;
    }

    public JTextField getNom() {
        return nom;
    }

    public JTextField getPrenom() {
        return prenom;
    }

    public JTextField getEmail() {
        return email;
    }

    public JPanel getP1() {
        return p1;
    }

}
