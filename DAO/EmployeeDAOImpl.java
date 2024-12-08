package DAO;

import Model.Employee;

import java.awt.image.AreaAveragingScaleFilter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAOI{
    private Connection connection = DBConnection.getConnection() ;
    private String sql ;
    public EmployeeDAOImpl(){

    }

    @Override
    public Employee findByEmployee(int id) {
        String sql = "SELECT * FROM employee WHERE id = ?";
        Employee employee = null;
        for (Employee e : findAll()){
            if(e.getId() == id){
                return e;
            }
        }
        return null;
    }
    @Override
    public List<Employee> findAll() {
        String sql = "SELECT * FROM employee";
        Employee employee = null;
        ArrayList<Employee> employeesList = new ArrayList<Employee>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            try (ResultSet rs = stmt.executeQuery()) {
                while(rs.next()){
                    Employee e = new Employee(
                            rs.getInt("id"),
                            rs.getString("nom"),
                            rs.getString("prenom"),
                            rs.getString("tel"),
                            rs.getString("email"),
                            rs.getDouble("salaire"),
                            Employee.Role.valueOf(rs.getString("role")),
                            Employee.Poste.valueOf(rs.getString("poste"))
                    );
                    employeesList.add(e);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeesList ;
    }

    @Override
    public void add(Employee e) {
        sql = "insert into employee(nom , prenom , tel , email , salaire , role , poste) values (?,?,?,?,?,?,?);";
        try (PreparedStatement st = connection.prepareStatement(sql);){
            st.setString(1 , e.getNom());
            st.setString(2 , e.getPrenom());
            st.setString(3, e.getTel());
            st.setString(4 , e.getEmail());
            st.setDouble(5 , e.getSalaire());
            st.setString(6, e.getRole().name());
            st.setString(7, e.getPoste().name());
            st.executeUpdate();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Employee e, int id) {
        String sql = "UPDATE employee SET nom = ?, prenom = ?, tel = ?, email = ?, salaire = ?, role = ?, poste = ? WHERE id = ?";
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, e.getNom());
            st.setString(2, e.getPrenom());
            st.setString(3, e.getTel());
            st.setString(4, e.getEmail());
            st.setDouble(5, e.getSalaire());
            st.setString(6, e.getRole().name());
            st.setString(7, e.getPoste().name());
            st.setInt(8, id);

            int rowsUpdated = st.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Employee updated successfully.");
            } else {
                System.out.println("No employee found with ID: " + id);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM employee WHERE id = ?";
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, id);

            int rowsDeleted = st.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Employee deleted successfully.");
            } else {
                System.out.println("No employee found with ID: " + id);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public   List<Employee.Role> findAllRoles() {
        return List.of(Employee.Role.values());
    }


    @Override
    public   List<Employee.Poste> findAllPostes() {
        return List.of(Employee.Poste.values());
    }

}
