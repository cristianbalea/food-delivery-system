package Business;

import DataAccess.FileWriter;
import DataAccess.Serialization;
import Users.User;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class DeliveryService extends Observable implements IDeliveryServiceProcessing {
    public static int numberOfOrders;
    private HashMap<Order, ArrayList<MenuItem>> orders;
    private ArrayList<MenuItem> menu;
    private ArrayList<User> users;
    public Serialization serialization = new Serialization();

    /**
     * Constructor pentru un obiect de tipul DeliveryService.
     * La crearea obiectului, se instantiaza un obiect de tip Serialization,
     * si se iau datele din fisierele in care sunt serializate.
     */
    public DeliveryService() {
        serialization.readProducts();
        serialization.readUsers();
        serialization.readOrders();
        orders = serialization.getOrders();
        menu = serialization.getProducts();
        users = serialization.getUsers();
        numberOfOrders = orders.size();
    }

    public ArrayList<MenuItem> getMenu() {
        return menu;
    }

    public void setMenu(ArrayList<MenuItem> menu) {
        this.menu = menu;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public HashMap<Order, ArrayList<MenuItem>> getOrders() {
        return orders;
    }

    /**
     * Metoda pentru adaugarea unui produs in meniu.
     *
     * @param m
     */
    @Override
    public void addMenuItem(MenuItem m) {
        assert (m != null);
        menu.add(m);
        assert invariant();
    }

    /**
     * Metoda pentru eliminarea unui produs din meniu.
     *
     * @param m
     */
    @Override
    public void removeMenuItem(MenuItem m) {
        assert (m != null);
        for (MenuItem menuItem : menu) {
            if (menuItem.getTitle().equals(m.getTitle())) {
                menu.remove(menuItem);
                break;
            }
        }
    }

    @Override
    public ArrayList<MenuItem> editMenuItem(MenuItem m) {
        return null;
    }

    /**
     * Metoda pentru generarea raportului privind comenzile plasate intre 2 ore date, indiferent de zi.
     *
     * @param startHour
     * @param endHour
     */
    @Override
    public void report1(Date startHour, Date endHour) {
        assert (startHour != null && endHour != null);

        ArrayList<Order> allOrders = new ArrayList<>();
        for (Map.Entry<Order, ArrayList<MenuItem>> pair : this.orders.entrySet()) {
            allOrders.add(pair.getKey());
        }
        ArrayList<Order> requestedOrders = allOrders.stream()
                .filter(p -> p.getOrderDate().getHours() >= startHour.getHours() && p.getOrderDate().getHours() <= endHour.getHours())
                .sorted(Comparator.comparing(Order::getOrderDate))
                .collect(Collectors.toCollection(ArrayList::new));
        String s = "The orders performed between " + startHour.getHours() + " and " + endHour.getHours() + ":\n";
        for (Order o : requestedOrders) {
            s += "OrderID: " + o.getOrderID() + " Client: " + o.getClient().getName() + " Hour: " + o.getOrderDate() + "\n";
        }
        FileWriter.write("report1.txt", s);
    }

    /**
     * Metoda pentru generarea raportului privind produsele comandate de mai mult de un numar dat de ori.
     *
     * @param numberOfTimes
     */
    @Override
    public void report2(int numberOfTimes) {
        assert numberOfTimes > 0;

        HashMap<MenuItem, Integer> count = new HashMap<>();

        for (Map.Entry<Order, ArrayList<MenuItem>> o : orders.entrySet()) {
            for (MenuItem m : o.getValue()) {
                if (count.containsKey(m)) {
                    count.put(m, count.get(m) + 1);
                } else {
                    count.put(m, 1);
                }
            }
        }

        String s = "The products ordered more than " + numberOfTimes + ":\n";
        for (Map.Entry<MenuItem, Integer> m : count.entrySet()) {
            if (m.getValue() >= numberOfTimes) {
                s += m.getKey().getTitle() + " -> " + m.getValue() + " times\n";
            }
        }
        FileWriter.write("report2.txt", s);
    }

    /**
     * Metoda pentru generarea raportului privind clientii care au comandat de mai mult de un numar dat de ori
     * și de o valoare mai mare de o valoare data.
     *
     * @param numberOfTimes
     * @param price
     */
    @Override
    public void report3(int numberOfTimes, int price) {
        assert numberOfTimes > 0 && price > 0;
        HashMap<User, Integer> count = new HashMap<>();
        ArrayList<User> usersWhoOrdered = new ArrayList<>();

        for (Map.Entry<Order, ArrayList<MenuItem>> o : orders.entrySet()) {
            if (count.containsKey(o.getKey().getClient())) {
                count.put(o.getKey().getClient(), count.get(o.getKey().getClient()) + 1);
                ;
            } else {
                count.put(o.getKey().getClient(), 0);
            }
        }

        List<Order> higherThanPrice = orders.entrySet().stream()
                .filter(p -> p.getKey().getValue() >= price)
                .map(Map.Entry::getKey).toList();

        List<User> higherThanNumberOfTimes = count.entrySet().stream()
                .filter(p -> p.getValue() >= numberOfTimes)
                .map(Map.Entry::getKey).toList();

        String s = "Clients who ordered more than " + numberOfTimes + " times and the value of the order is higher" +
                " than " + price + ": \n";
        for (Map.Entry<Order, ArrayList<MenuItem>> o : orders.entrySet()) {
            if (higherThanPrice.contains(o.getKey())) {
                if (higherThanNumberOfTimes.contains(o.getKey().getClient())) {
                    if (!usersWhoOrdered.contains(o.getKey().getClient())) {
                        usersWhoOrdered.add(o.getKey().getClient());
                    }
                }
            }
        }
        for (User u : usersWhoOrdered) {
            s += u.getName() + ",  " + u.getAddress() + "\n";
        }
        FileWriter.write("report3.txt", s);
    }

    /**
     * Metoda pentru generarea raportului privind produsele comandate intr-o anumita zi, și de cate ori au fost comandate.
     *
     * @param date
     */
    @Override
    public void report4(Date date) {
        assert date != null;
        ArrayList<ArrayList<MenuItem>> orderedWithinSpecifiedDay = orders.entrySet().stream()
                .filter(p -> p.getKey().getOrderDate().getDate() == date.getDate() &&
                        p.getKey().getOrderDate().getMonth() == date.getMonth() &&
                        p.getKey().getOrderDate().getYear() + 1900 == date.getYear())
                .map(Map.Entry::getValue)
                .collect(Collectors.toCollection(ArrayList::new));

        HashMap<MenuItem, Integer> count = new HashMap<>();

        for (ArrayList al : orderedWithinSpecifiedDay) {
            for (MenuItem m : (ArrayList<MenuItem>) al) {
                if (count.containsKey(m)) {
                    count.put(m, count.get(m) + 1);
                } else {
                    count.put(m, 1);
                }
            }
        }
        int month = date.getMonth() + 1;
        String s = "Products ordered in " + date.getDate() + "-" + month + "-" + date.getYear() + "\n";
        for (Map.Entry<MenuItem, Integer> pair : count.entrySet()) {
            s += pair.getKey().getTitle() + "  ordered " + pair.getValue() + " times\n";
        }
        FileWriter.write("report4.txt", s);
    }

    /**
     * Metoda pentru filtrarea produselor in functie de titlu.
     *
     * @param clientMenu
     * @param title
     * @return
     */
    @Override
    public ArrayList<MenuItem> searchItemByTitle(ArrayList<MenuItem> clientMenu, String title) {
        assert title != null;
        ArrayList<MenuItem> allProducts = new ArrayList<>();
        allProducts.addAll(clientMenu);
        ArrayList<MenuItem> requestedProducts = allProducts.stream()
                .filter(p -> p.getTitle().toLowerCase(Locale.ROOT).contains(title.toLowerCase(Locale.ROOT)))
                .collect(Collectors.toCollection(ArrayList::new));
        return requestedProducts;
    }

    /**
     * Metoda pentru filtrarea produselor in functie de rating.
     *
     * @param clientMenu
     * @param ratingMin
     * @param ratingMax
     * @return
     */
    @Override
    public ArrayList<MenuItem> searchItemByRating(ArrayList<MenuItem> clientMenu, Float ratingMin, Float ratingMax) {
        assert ratingMin < ratingMax;
        ArrayList<MenuItem> allProducts = new ArrayList<>();
        allProducts.addAll(clientMenu);
        ArrayList<MenuItem> requestedProducts = allProducts.stream()
                .filter(p -> p.getRating() >= ratingMin && p.getRating() <= ratingMax)
                .collect(Collectors.toCollection(ArrayList::new));
        assert invariant();
        return requestedProducts;
    }

    /**
     * Metoda pentru filtrarea produselor in functie de calorii.
     *
     * @param clientMenu
     * @param caloriesMin
     * @param caloriesMax
     * @return
     */
    @Override
    public ArrayList<MenuItem> searchItemByCalories(ArrayList<MenuItem> clientMenu, int caloriesMin, int caloriesMax) {
        assert caloriesMin <= caloriesMax;
        ArrayList<MenuItem> allProducts = new ArrayList<>();
        allProducts.addAll(clientMenu);
        ArrayList<MenuItem> requestedProducts = allProducts.stream()
                .filter(p -> p.getCalories() >= caloriesMin && p.getCalories() <= caloriesMax)
                .collect(Collectors.toCollection(ArrayList::new));
        assert invariant();
        return requestedProducts;
    }

    /**
     * Metoda pentru filtrarea produselor in functie de proteine.
     *
     * @param clientMenu
     * @param proteinsMin
     * @param proteinsMax
     * @return
     */
    @Override
    public ArrayList<MenuItem> searchItemByProteins(ArrayList<MenuItem> clientMenu, int proteinsMin, int proteinsMax) {
        assert proteinsMin <= proteinsMax;
        ArrayList<MenuItem> allProducts = new ArrayList<>();
        allProducts.addAll(clientMenu);
        ArrayList<MenuItem> requestedProducts = allProducts.stream()
                .filter(p -> p.getProteins() >= proteinsMin && p.getProteins() <= proteinsMax)
                .collect(Collectors.toCollection(ArrayList::new));
        assert invariant();
        return requestedProducts;
    }

    /**
     * Metoda pentru filtrarea produselor in functie de lipide.
     *
     * @param clientMenu
     * @param fatsMin
     * @param fatsMax
     * @return
     */
    @Override
    public ArrayList<MenuItem> searchItemByFats(ArrayList<MenuItem> clientMenu, int fatsMin, int fatsMax) {
        assert fatsMin <= fatsMax;
        ArrayList<MenuItem> allProducts = new ArrayList<>();
        allProducts.addAll(clientMenu);
        ArrayList<MenuItem> requestedProducts = allProducts.stream()
                .filter(p -> p.getFats() >= fatsMin && p.getFats() <= fatsMax)
                .collect(Collectors.toCollection(ArrayList::new));
        return requestedProducts;
    }

    /**
     * Metode pentru filtrarea produselor in functie de sodiu.
     *
     * @param clientMenu
     * @param sodiumMin
     * @param sodiumMax
     * @return
     */
    @Override
    public ArrayList<MenuItem> searchItemBySodium(ArrayList<MenuItem> clientMenu, int sodiumMin, int sodiumMax) {
        assert sodiumMin <= sodiumMax;
        ArrayList<MenuItem> allProducts = new ArrayList<>();
        allProducts.addAll(clientMenu);
        ArrayList<MenuItem> requestedProducts = allProducts.stream()
                .filter(p -> p.getSodium() >= sodiumMin && p.getSodium() <= sodiumMax)
                .collect(Collectors.toCollection(ArrayList::new));
        assert invariant();
        return requestedProducts;
    }

    /**
     * Metoda pentru filtrarea produselor in functie de pret.
     *
     * @param clientMenu
     * @param priceMin
     * @param priceMax
     * @return
     */
    @Override
    public ArrayList<MenuItem> searchItemByPrice(ArrayList<MenuItem> clientMenu, int priceMin, int priceMax) {
        assert priceMin > 0 && priceMax >= priceMin;
        ArrayList<MenuItem> allProducts = new ArrayList<>();
        allProducts.addAll(clientMenu);
        ArrayList<MenuItem> requestedProducts = allProducts.stream()
                .filter(p -> p.computePrice() >= priceMin && p.computePrice() <= priceMax)
                .collect(Collectors.toCollection(ArrayList::new));
        assert invariant();
        return requestedProducts;
    }

    @Override
    public void importProducts() {
        serialization.readFromCsv();
    }

    /**
     * Metoda pentru adaugarea unei noi comenzi de catre un client.
     *
     * @param products
     * @param client
     */
    @Override
    public void newOrder(ArrayList<MenuItem> products, User client) {
        assert !products.isEmpty() && client != null;
        int totalPrice = 0;
        for (MenuItem m : products) {
            totalPrice += m.computePrice();
        }
        String s = "New order placed by " + client.getName() + ",  address: " + client.getAddress();
        setChanged();
        notifyObservers(s);
        Order order = new Order(client);
        order.setValue(totalPrice);
        orders.put(order, products);
        numberOfOrders++;
        String filename = "orders\\order" + order.getOrderID() + ".txt";
        String text = "Order: " + order.getOrderID() + "\nDate: " + order.getOrderDate() + "\nClient: " +
                client.getName() + "\nAddress: " + client.getAddress() + "\n\n";
        for (MenuItem m : products) {
            text += m.getTitle() + "  |   price: " + m.computePrice() + "\n\n";
        }
        text += "\nTotal price: " + totalPrice;
        FileWriter.write(filename, text);
    }

    protected boolean invariant() {
        return menu != null;
    }
}
