package Users;

public class Administrator extends User {

    public Administrator(String username, String password, String name, String address) {
        super(username, password, name, address);
        this.setRole(Role.ADMINISTRATOR);
    }
}
