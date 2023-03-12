package Presentation;

import Business.BaseProduct;
import Business.CompositeProduct;
import Business.DeliveryService;
import Business.MenuItem;
import Users.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class Controller {
    private WelcomeView welcomeView = new WelcomeView();
    private LoginView loginView;
    private RegisterView registerView;
    private AdminView adminView;
    private ClientView clientView;
    private EmployeeView employeeView;
    private ArrayList<User> users;
    public DeliveryService deliveryService = new DeliveryService();
    private MenuItem found;

    /**
     * Constructor pentru Controller. Programul incepe cu fereastra de WelcomeView.
     */
    public Controller() {
        // Administrator administrator = new Administrator("admin", "admin", "Administrator", "-");
        Employee employee = new Employee("empl", "empl", "Employee", "-");
        users = deliveryService.getUsers();
        // users.add(administrator);
        // users.add(employee);
        welcomeView.addWindowListener(new WelcomeWindowListener());
        welcomeView.addLoginListener(new LoginListener());
        welcomeView.addRegisterListener(new RegisterListener());
    }

    private class WelcomeWindowListener implements java.awt.event.WindowListener {

        @Override
        public void windowOpened(WindowEvent e) {

        }

        @Override
        public void windowClosing(WindowEvent e) {
            deliveryService.serialization.setProducts(deliveryService.getMenu());
            deliveryService.serialization.setUsers(users);
            deliveryService.serialization.setOrders(deliveryService.getOrders());
            deliveryService.serialization.serializeOrders();
            deliveryService.serialization.serializeProducts();
            deliveryService.serialization.serializeUsers();
        }

        @Override
        public void windowClosed(WindowEvent e) {

        }

        @Override
        public void windowIconified(WindowEvent e) {

        }

        @Override
        public void windowDeiconified(WindowEvent e) {

        }

        @Override
        public void windowActivated(WindowEvent e) {

        }

        @Override
        public void windowDeactivated(WindowEvent e) {

        }
    }

    private class BackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (loginView != null) {
                loginView.dispose();
                //welcomeView.setVisible(true);
            }
            if (registerView != null) {
                registerView.dispose();
                //welcomeView.setVisible(true);
            }
            if (adminView != null) {
                adminView.dispose();
                //welcomeView.setVisible(true);
            }
            if (clientView != null) {
                clientView.dispose();
                //welcomeView.setVisible(true);
            }
            if (employeeView != null) {
                employeeView.dispose();
                //welcomeView.setVisible(true);
            }
        }
    }

    private class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //welcomeView.setVisible(false);
            loginView = new LoginView();
            loginView.addLoginListener(new LoginPageListener());
            loginView.addBackListener(new BackListener());
        }
    }

    private class RegisterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //welcomeView.setVisible(false);
            registerView = new RegisterView();
            registerView.addRegisterListener(new RegisterPageListener());
            registerView.addBackListener(new BackListener());
        }
    }

    private class LoginPageListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = loginView.getUsername();
            String password = loginView.getPassword();

            boolean exists = false;
            for (User u : users) {
                if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                    exists = true;
                    if (u.getRole() == Role.ADMINISTRATOR) {
                        adminView = new AdminView();
                        adminView.showMenu(deliveryService.getMenu());
                        adminView.addImportListener(new ImportListener());
                        adminView.addLogoutListener(new BackListener());
                        adminView.addAddListener(new AddProductListener());
                        adminView.addRemoveListener(new RemoveProductListener());
                        adminView.addSearchListener(new SearchListener());
                        adminView.addEditListener(new EditProductListener());
                        adminView.addReport1Listener(new Report1Listener());
                        adminView.addReport2Listener(new Report2Listener());
                        adminView.addReport3Listener(new Report3Listener());
                        adminView.addReport4Listener(new Report4Listener());
                        adminView.addComposeListener(new ComposeListener());
                    } else if (u.getRole() == Role.EMPLOYEE) {
                        employeeView = new EmployeeView();
                        employeeView.addBackListener(new BackListener());
                    } else if (u.getRole() == Role.CLIENT) {
                        clientView = new ClientView(u);
                        clientView.showMenu(deliveryService.getMenu());
                        clientView.addBackListener(new BackListener());
                        clientView.addOrderListener(new OrderListener());
                        clientView.addResetListener(new ResetListener());
                        clientView.addSearchTitleListener(new SearchTitleListener());
                        clientView.addSearchRatingListener(new SearchRatingListener());
                        clientView.addSearchCaloriesListener(new SearchCaloriesListener());
                        clientView.addSearchProteinsListener(new SearchProteinsListener());
                        clientView.addSearchFatsListener(new SearchFatsListener());
                        clientView.addSearchSodiumListener(new SearchSodiumListener());
                        clientView.addSearchPriceListener(new SearchPriceListener());
                    }
                    loginView.dispose();
                    break;
                }
            }
            if (!exists) {
                JOptionPane.showMessageDialog(null, "User does not exist!");
            }
        }
    }

    private class RegisterPageListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = registerView.getUsername();
            String password = registerView.getPassword();
            String name = registerView.getName();
            String address = registerView.getAddress();

            boolean exists = false;

            for (User u : users) {
                if (u.getUsername().equals(username) && u.getPassword().equals(password) && u.getName().equals(name) && u.getAddress().equals(address)) {
                    exists = true;
                    break;
                }
            }

            if (exists) {
                JOptionPane.showMessageDialog(null, "User already registered!");
            } else {
                Client client = new Client(username, password, name, address);
                users.add(client);
                JOptionPane.showMessageDialog(null, "New account successfully created!");
            }
        }
    }

    private class AddProductListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            BaseProduct bp = new BaseProduct(adminView.getTitle(), adminView.getRating(), adminView.getCalories(),
                    adminView.getProteins(), adminView.getFats(), adminView.getSodium(), adminView.getPrice());
            deliveryService.addMenuItem(bp);
            adminView.showMenu(deliveryService.getMenu());
        }
    }

    private class RemoveProductListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            BaseProduct bp = new BaseProduct(adminView.getTitle(), adminView.getRating(), adminView.getCalories(),
                    adminView.getProteins(), adminView.getFats(), adminView.getSodium(), adminView.getPrice());
            deliveryService.removeMenuItem(bp);
            adminView.showMenu(deliveryService.getMenu());
        }
    }

    private class SearchListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String title = adminView.getSearch();

            for (MenuItem m : deliveryService.getMenu()) {
                if (m.getTitle().toLowerCase(Locale.ROOT).contains(title.toLowerCase(Locale.ROOT))) {
                    adminView.setTitle(m.getTitle());
                    adminView.setRating(String.valueOf(m.getRating()));
                    adminView.setCalories(String.valueOf(m.getCalories()));
                    adminView.setProteins(String.valueOf(m.getProteins()));
                    adminView.setFats(String.valueOf(m.getFats()));
                    adminView.setSodium(String.valueOf(m.getSodium()));
                    adminView.setPrice(String.valueOf(m.computePrice()));
                    found = m;
                    break;
                }
            }
        }
    }

    private class EditProductListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (MenuItem m : deliveryService.getMenu()) {
                if (m.equals(found)) {
                    m.setTitle(adminView.getTitle());
                    m.setRating(adminView.getRating());
                    m.setCalories(adminView.getCalories());
                    m.setProteins(adminView.getProteins());
                    m.setFats(adminView.getFats());
                    m.setPrice(adminView.getPrice());
                    break;
                }
            }
            adminView.showMenu(deliveryService.getMenu());
        }
    }

    private class ImportListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            deliveryService.importProducts();
            adminView.showMenu(deliveryService.getMenu());
        }
    }

    private class Report1Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            deliveryService.report1(adminView.getTextStartHour(), adminView.getTextEndHour());
            JOptionPane.showMessageDialog(null, "Report 1 generated successfully!");
        }
    }

    private class Report2Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            deliveryService.report2(adminView.getNumber2());
            JOptionPane.showMessageDialog(null, "Report 2 generated successfully!");
        }
    }

    private class Report3Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            deliveryService.report3(adminView.getNumber3(), adminView.getValue());
            JOptionPane.showMessageDialog(null, "Report 3 generated successfully!");
        }
    }

    private class Report4Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            deliveryService.report4(adminView.getDay());
            JOptionPane.showMessageDialog(null, "Report 4 generated successfully!");
        }
    }

    private class ComposeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            CompositeProduct compositeProduct = new CompositeProduct(adminView.getProductName());

            JList<String> list = adminView.getList();
            List<String> products = list.getSelectedValuesList();

            for (String s : products) {
                String[] title = s.split(" rating");
                for (MenuItem m : deliveryService.getMenu()) {
                    if (m.getTitle().toLowerCase(Locale.ROOT).contains(title[0].toLowerCase(Locale.ROOT))) {
                        compositeProduct.addProduct(m);
                        break;
                    }
                }
            }

            deliveryService.addMenuItem(compositeProduct);
            adminView.showMenu(deliveryService.getMenu());
        }
    }

    private class OrderListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            deliveryService.addObserver(employeeView);
            deliveryService.newOrder(clientView.getProducts(), clientView.getClient());
            JOptionPane.showMessageDialog(null, "Order successfully created!");
        }
    }

    private class SearchTitleListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<MenuItem> newMenu = deliveryService.searchItemByTitle(clientView.getMenu(), clientView.getTitle());
            clientView.showMenu(newMenu);
        }
    }

    private class SearchCaloriesListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<MenuItem> newMenu = deliveryService.searchItemByCalories(clientView.getMenu(), clientView.getCaloriesMin(), clientView.getCaloriesMax());
            clientView.showMenu(newMenu);
        }
    }

    private class SearchProteinsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<MenuItem> newMenu = deliveryService.searchItemByProteins(clientView.getMenu(), clientView.getProteinsMin(), clientView.getProteinsMax());
            clientView.showMenu(newMenu);
        }
    }

    private class SearchFatsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<MenuItem> newMenu = deliveryService.searchItemByFats(clientView.getMenu(), clientView.getFatsMin(), clientView.getFatsMax());
            clientView.showMenu(newMenu);
        }
    }

    private class SearchSodiumListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<MenuItem> newMenu = deliveryService.searchItemBySodium(clientView.getMenu(), clientView.getSodiumMin(), clientView.getSodiumMax());
            clientView.showMenu(newMenu);
        }
    }

    private class SearchPriceListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<MenuItem> newMenu = deliveryService.searchItemByPrice(clientView.getMenu(), clientView.getPriceMin(), clientView.getPriceMax());
            clientView.showMenu(newMenu);
        }
    }

    private class SearchRatingListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<MenuItem> newMenu = deliveryService.searchItemByRating(clientView.getMenu(), clientView.getRatingMin(), clientView.getRatingMax());
            clientView.showMenu(newMenu);
        }
    }

    private class ResetListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            clientView.showMenu(deliveryService.getMenu());
        }
    }

    public static void main(String[] args) {
        Controller controller = new Controller();
    }
}

