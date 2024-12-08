package DAO;

import Model.Employee;
import Model.User;

import java.util.List;

public interface UserDAOI {
    User findByUserId(int id) ;
    List<User> findAll();
    void add(User u) ;
    void update(User e , int id);
    void delete(int id) ;
}
