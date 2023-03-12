package Users;

public class Employee extends User {

    public Employee(String username, String password, String name, String address) {
        super(username, password, name, address);
        this.setRole(Role.EMPLOYEE);
    }
}
