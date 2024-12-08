package Model;

import DAO.EmployeeDAOImpl;
import java.util.List;

public class EmployeeModel {
    private final EmployeeDAOImpl dao;

    public EmployeeModel(EmployeeDAOImpl dao) {
        this.dao = dao;
    }

    public void addEmployee(Employee emp) {
        dao.add(emp);
    }

    public List<Employee> getAllEmployees() {
        return dao.findAll();
    }

    public void deleteEmployee(int id) {
        dao.delete(id);
    }

    public void updateEmployee(Employee emp, int id) {
        dao.update(emp, id);
    }

    public static int parseEmployeeId(String selectedEmployeeString) {
        try {
            return Integer.parseInt(selectedEmployeeString.split("\\|")[1].trim());
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid employee format.");
        }
    }
}
