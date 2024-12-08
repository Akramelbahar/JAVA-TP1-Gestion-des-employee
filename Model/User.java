package Model;

public class User {


    private String username ;
    private String password ;
    private int id ;
    private Employee employee ;
    public User(int id, String user, String passw, Employee employee){
        this.username = user ;
        this.password = passw;
        this.id = id ;
        this.employee = employee ;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}
