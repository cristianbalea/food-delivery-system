package Users;

public class Client extends User {

    public Client(String username, String password, String name, String address) {
        super(username, password, name, address);
        this.setRole(Role.CLIENT);
    }
}
