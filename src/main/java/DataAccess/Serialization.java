package DataAccess;

import Business.BaseProduct;
import Business.MenuItem;
import Business.Order;
import Users.User;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Serialization implements Serializable {
    private ArrayList<MenuItem> products = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();
    private HashMap<Order, ArrayList<MenuItem>> orders = new HashMap<>();

    /**
     * Metoda pentru citirea din fisierul products.csv
     */
    public void readFromCsv() {
        String line = "";
        String splitBy = ",";

        try {
            FileReader file = new FileReader("products.csv");
            BufferedReader br = new BufferedReader(file);

            boolean first = true;

            while ((line = br.readLine()) != null) {
                if (first) {
                    first = false;
                } else {
                    String[] p = line.split(splitBy);
                    BaseProduct baseProduct = new BaseProduct(p[0], Float.parseFloat(p[1]), Integer.parseInt(p[2]), Integer.parseInt(p[3]),
                            Integer.parseInt(p[4]), Integer.parseInt(p[5]), Integer.parseInt(p[6]));
                    int ok = 1;
                    for (MenuItem m : products) {
                        if (p[0].equals(m.getTitle())) {
                            ok = 0;
                            break;
                        }
                    }
                    if (ok == 1) {
                        products.add(baseProduct);
                    }
                }
            }
            br.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Metoda pentru citirea produselor serializate din products.txt.
     */
    public void readProducts() {
        try {
            FileInputStream fileInputStream = new FileInputStream("serialized\\products.txt");
            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
            products = (ArrayList<MenuItem>) inputStream.readObject();
            inputStream.close();
            fileInputStream.close();
            System.out.println("Serialized products read from the file.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metoda pentru citirea utilizatorilor serializati din users.txt.
     */
    public void readUsers() {
        try {
            FileInputStream fileInputStream = new FileInputStream("serialized\\users.txt");
            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
            users = (ArrayList<User>) inputStream.readObject();
            inputStream.close();
            fileInputStream.close();
            System.out.println("Serialized users read from the file.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metoda pentru citirea comenzilor din orders.txt.
     */
    public void readOrders() {
        try {
            FileInputStream fileInputStream = new FileInputStream("serialized\\orders.txt");
            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
            HashMap<Order, ArrayList<MenuItem>> aux = (HashMap<Order, ArrayList<MenuItem>>) inputStream.readObject();
            orders.putAll(aux);
            inputStream.close();
            fileInputStream.close();
            System.out.println("Serialized orders read from the file.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metoda pentru serializarea produselor in fisierul products.txt la inchiderea programului.
     */
    public void serializeProducts() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("serialized\\products.txt");
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.flush();
            outputStream.writeObject(products);
            outputStream.close();
            fileOutputStream.close();
            System.out.println("Serialized products are saved in products.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Metoda pentru serializarea utilizatorilor in fisierul users.txt la inchiderea programului.
     */
    public void serializeUsers() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("serialized\\users.txt");
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.flush();
            outputStream.writeObject(users);
            outputStream.close();
            fileOutputStream.close();
            System.out.println("Serialized users are saved in users.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metoda pentru serializarea comenzilor in fisierul orders.txt la inchiderea programului.
     */
    public void serializeOrders() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("serialized\\orders.txt");
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.flush();
            outputStream.writeObject(orders);
            outputStream.close();
            fileOutputStream.close();
            System.out.println("Serialized orders are saved in orders.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<MenuItem> getProducts() {
        return products;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setProducts(ArrayList<MenuItem> products) {
        this.products = products;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public HashMap<Order, ArrayList<MenuItem>> getOrders() {
        return orders;
    }

    public void setOrders(HashMap<Order, ArrayList<MenuItem>> orders) {
        this.orders = orders;
    }
}

