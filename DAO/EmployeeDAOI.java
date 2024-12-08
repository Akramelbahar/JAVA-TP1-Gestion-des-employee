package DAO;
import Model.Employee ;

import javax.management.relation.Role;
import java.util.List;

public interface EmployeeDAOI {
    Employee findByEmployee(int id) ;
    List<Employee> findAll();
    void add(Employee e) ;
    void update(Employee e , int id);
    void delete(int id) ;
    List<Employee.Role> findAllRoles();
    List<Employee.Poste>  findAllPostes();
}
