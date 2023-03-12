package Presentation;

import Business.MenuItem;
import Users.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.util.*;
import java.util.List;

/**
 * Interfata grafica pentru pagina de Welcome. Se poate alege mai departe Register sau Login.
 */
class WelcomeView {
    private JFrame frame = new JFrame("Welcome!");
    private JPanel panel = new JPanel();
    private JLabel labelTitle = new JLabel("Welcome!");
    private JButton btnLogin = new JButton("Login");
    private JButton btnRegister = new JButton("Register");
    private Font font = new Font("Georgia", Font.BOLD, 30);
    private Color backgroundColor = new Color(208, 204, 177);

    public WelcomeView() {
        labelTitle.setBounds(105, 40, 200, 30);
        btnLogin.setBounds(90, 110, 200, 30);
        btnRegister.setBounds(90, 145, 200, 30);

        labelTitle.setFont(font);

        btnLogin.setFocusPainted(false);
        btnLogin.setContentAreaFilled(false);
        btnRegister.setFocusPainted(false);
        btnRegister.setContentAreaFilled(false);

        panel.add(labelTitle);
        panel.add(btnLogin);
        panel.add(btnRegister);


        panel.setBackground(backgroundColor);
        panel.setLayout(null);
        frame.setSize(400, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel);
    }

    public void addLoginListener(ActionListener al) {
        btnLogin.addActionListener(al);
    }

    public void addRegisterListener(ActionListener al) {
        btnRegister.addActionListener(al);
    }

    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }

    public void addWindowListener(WindowListener wl) {
        frame.addWindowListener(wl);
    }
}

/**
 * Interfata pentru pagina de Login. Daca userul e valid se va deschide pagina corespunzatoare rolului acestuia.
 */
class LoginView {
    private JFrame frame = new JFrame("Login");
    private JPanel panel = new JPanel();
    private JLabel labelLogin = new JLabel("LOGIN");
    private JLabel labelUsername = new JLabel("Username");
    private JLabel labelPassword = new JLabel("Password");
    private JTextField textUsername = new JTextField();
    private JPasswordField textPassword = new JPasswordField();
    private JButton btnLogin = new JButton("Login");
    private JButton btnBack = new JButton("Back");
    private Font font = new Font("Georgia", Font.BOLD, 20);
    private Color backgroundColor = new Color(208, 204, 177);

    public LoginView() {
        labelLogin.setBounds(230, 10, 300, 30);
        labelUsername.setBounds(20, 50, 120, 30);
        textUsername.setBounds(140, 50, 300, 30);
        labelPassword.setBounds(20, 80, 120, 30);
        textPassword.setBounds(140, 80, 300, 30);
        btnLogin.setBounds(140, 120, 150, 30);
        btnBack.setBounds(290, 120, 150, 30);

        labelLogin.setFont(font);
        labelPassword.setFont(font);
        labelUsername.setFont(font);

        btnLogin.setFocusPainted(false);
        btnLogin.setContentAreaFilled(false);
        btnBack.setFocusPainted(false);
        btnBack.setContentAreaFilled(false);

        panel.add(labelUsername);
        panel.add(labelLogin);
        panel.add(labelPassword);
        panel.add(textUsername);
        panel.add(textPassword);
        panel.add(btnLogin);
        panel.add(btnBack);

        panel.setBackground(backgroundColor);
        panel.setLayout(null);
        frame.setVisible(true);
        frame.setSize(550, 300);
        frame.setContentPane(panel);
    }

    public String getUsername() {
        return textUsername.getText();
    }

    public String getPassword() {
        return textPassword.getText();
    }

    public void addLoginListener(ActionListener al) {
        btnLogin.addActionListener(al);
    }

    public void addBackListener(ActionListener al) {
        btnBack.addActionListener(al);
    }

    public void dispose() {
        frame.dispose();
    }
}

/**
 * Interfata pentru inregistrarea unui client.
 */
class RegisterView {
    private Font font = new Font("Georgia", Font.BOLD, 20);
    private Color backgroundColor = new Color(208, 204, 177);

    private JLabel labelRegister = new JLabel("Register");
    private JLabel labelUsername = new JLabel("Username:");
    private JLabel labelPassword = new JLabel("Password:");
    private JLabel labelName = new JLabel("Name:");
    private JLabel labelAddress = new JLabel("Address:");

    private JTextField textUsername = new JTextField();
    private JPasswordField textPassword = new JPasswordField();
    private JTextField textName = new JTextField();
    private JTextField textAddress = new JTextField();

    private JButton btnRegister = new JButton("Register");
    private JButton btnBack = new JButton("Back");

    private JPanel panel = new JPanel();
    private JFrame frame = new JFrame("Register");

    public RegisterView() {
        labelRegister.setBounds(150, 10, 200, 30);
        labelUsername.setBounds(10, 60, 150, 30);
        textUsername.setBounds(160, 60, 300, 30);
        labelPassword.setBounds(10, 90, 150, 30);
        textPassword.setBounds(160, 90, 300, 30);
        labelName.setBounds(10, 120, 150, 30);
        textName.setBounds(160, 120, 300, 30);
        labelAddress.setBounds(10, 150, 150, 30);
        textAddress.setBounds(160, 150, 300, 30);
        btnRegister.setBounds(160, 185, 150, 30);
        btnBack.setBounds(310, 185, 150, 30);

        labelUsername.setFont(font);
        labelPassword.setFont(font);
        labelRegister.setFont(font);
        labelName.setFont(font);
        labelAddress.setFont(font);

        btnRegister.setContentAreaFilled(false);
        btnRegister.setFocusPainted(false);
        btnBack.setContentAreaFilled(false);
        btnBack.setContentAreaFilled(false);

        panel.add(btnBack);
        panel.add(btnRegister);
        panel.add(labelName);
        panel.add(labelAddress);
        panel.add(labelUsername);
        panel.add(labelPassword);
        panel.add(labelRegister);
        panel.add(textName);
        panel.add(textAddress);
        panel.add(textUsername);
        panel.add(textPassword);

        panel.setBackground(backgroundColor);
        panel.setLayout(null);
        frame.setVisible(true);
        frame.setSize(500, 300);
        frame.setContentPane(panel);
    }

    public String getUsername() {
        return textUsername.getText();
    }

    public String getPassword() {
        return textPassword.getText();
    }

    public String getName() {
        return textName.getText();
    }

    public String getAddress() {
        return textAddress.getText();
    }

    public void addRegisterListener(ActionListener al) {
        btnRegister.addActionListener(al);
    }

    public void addBackListener(ActionListener al) {
        btnBack.addActionListener(al);
    }

    public void dispose() {
        frame.dispose();
    }
}

/**
 * Interfata pentru administratorul aplicatiei.
 */
class AdminView {
    private Color backgroundColor = new Color(208, 204, 177);
    private Font font = new Font("Georgia", Font.BOLD, 17);

    private JLabel labelTitle = new JLabel("Title:");
    private JLabel labelRating = new JLabel("Rating:");
    private JLabel labelCalories = new JLabel("Calories:");
    private JLabel labelProteins = new JLabel("Proteins");
    private JLabel labelFats = new JLabel("Fats:");
    private JLabel labelSodium = new JLabel("Sodium:");
    private JLabel labelPrice = new JLabel("Price:");
    private JLabel labelSearch = new JLabel("Add a product or search for the product to edit/remove");
    private JLabel labelReports = new JLabel("Generate reports");
    private JLabel labelCompose = new JLabel("Compose new product");

    private JTextField textTitle = new JTextField();
    private JTextField textRating = new JTextField();
    private JTextField textCalories = new JTextField();
    private JTextField textProteins = new JTextField();
    private JTextField textFats = new JTextField();
    private JTextField textSodium = new JTextField();
    private JTextField textPrice = new JTextField();
    private JTextField textSearch = new JTextField();
    private JTextField textStartHour = new JTextField("start hour: HH");
    private JTextField textEndHour = new JTextField("end hour: HH");
    private JTextField textNumber2 = new JTextField("number of times");
    private JTextField textNumber3 = new JTextField("number of times");
    private JTextField textValue = new JTextField("value");
    private JTextField textDay = new JTextField("day: YYYY-MM-DD");
    private JTextField textProductName = new JTextField("Insert the name of the product");

    private JPanel panel = new JPanel();
    private JFrame frame = new JFrame("Add product");

    private JButton btnAdd = new JButton("Add product");
    private JButton btnEdit = new JButton("Edit product");
    private JButton btnRemove = new JButton("Remove product");
    private JButton btnSearch = new JButton("Search");
    private JButton btnImport = new JButton("Import products");
    private JButton btnReport1 = new JButton("Report 1");
    private JButton btnReport2 = new JButton("Report 2");
    private JButton btnReport3 = new JButton("Report 3");
    private JButton btnReport4 = new JButton("Report 4");
    private JButton btnCompose = new JButton("Compose");
    private JButton btnLogout = new JButton("Log out");

    private DefaultListModel<String> productList = new DefaultListModel<>();
    private JList<String> list = new JList<>(productList);
    private JScrollPane jScrollPane = new JScrollPane(list);

    public AdminView() {
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        labelSearch.setBounds(10, 10, 550, 30);
        textSearch.setBounds(50, 40, 300, 30);
        btnSearch.setBounds(360, 40, 150, 30);
        labelTitle.setBounds(10, 80, 150, 30);
        textTitle.setBounds(160, 80, 350, 30);
        labelRating.setBounds(10, 110, 150, 30);
        textRating.setBounds(160, 110, 350, 30);
        labelCalories.setBounds(10, 140, 150, 30);
        textCalories.setBounds(160, 140, 350, 30);
        labelProteins.setBounds(10, 170, 150, 30);
        textProteins.setBounds(160, 170, 350, 30);
        labelFats.setBounds(10, 200, 150, 30);
        textFats.setBounds(160, 200, 350, 30);
        labelSodium.setBounds(10, 230, 150, 30);
        textSodium.setBounds(160, 230, 350, 30);
        labelPrice.setBounds(10, 260, 150, 30);
        textPrice.setBounds(160, 260, 350, 30);
        btnAdd.setBounds(160, 290, 350, 30);
        btnEdit.setBounds(160, 320, 350, 30);
        btnRemove.setBounds(160, 350, 350, 30);
        labelReports.setBounds(600, 10, 200, 30);
        btnReport1.setBounds(600, 50, 200, 30);
        textStartHour.setBounds(600, 80, 300, 30);
        textEndHour.setBounds(600, 110, 300, 30);
        btnReport2.setBounds(600, 150, 200, 30);
        textNumber2.setBounds(600, 180, 300, 30);
        btnReport3.setBounds(600, 220, 200, 30);
        textNumber3.setBounds(600, 250, 300, 30);
        textValue.setBounds(600, 280, 300, 30);
        btnReport4.setBounds(600, 320, 200, 30);
        textDay.setBounds(600, 350, 300, 30);
        labelCompose.setBounds(1000, 10, 300, 30);
        textProductName.setBounds(1000, 550, 300, 30);
        btnCompose.setBounds(1000, 590, 300, 30);
        btnImport.setBounds(300, 590, 250, 30);
        btnLogout.setBounds(550, 590, 250, 30);
        jScrollPane.setBounds(1000, 40, 550, 500);

        btnAdd.setFocusPainted(false);
        btnAdd.setContentAreaFilled(false);
        btnSearch.setFocusPainted(false);
        btnSearch.setContentAreaFilled(false);
        btnEdit.setContentAreaFilled(false);
        btnEdit.setFocusPainted(false);
        btnRemove.setFocusPainted(false);
        btnRemove.setContentAreaFilled(false);
        btnImport.setFocusPainted(false);
        btnImport.setContentAreaFilled(false);
        btnReport1.setFocusPainted(false);
        btnReport1.setContentAreaFilled(false);
        btnReport2.setFocusPainted(false);
        btnReport2.setContentAreaFilled(false);
        btnReport3.setFocusPainted(false);
        btnReport3.setContentAreaFilled(false);
        btnReport4.setFocusPainted(false);
        btnReport4.setContentAreaFilled(false);
        btnCompose.setContentAreaFilled(false);
        btnCompose.setFocusPainted(false);
        btnLogout.setContentAreaFilled(false);
        btnLogout.setFocusPainted(false);

        labelTitle.setFont(font);
        labelRating.setFont(font);
        labelCalories.setFont(font);
        labelProteins.setFont(font);
        labelFats.setFont(font);
        labelSodium.setFont(font);
        labelPrice.setFont(font);
        labelSearch.setFont(font);
        labelReports.setFont(font);
        labelCompose.setFont(font);

        panel.add(labelSearch);
        panel.add(textSearch);
        panel.add(btnSearch);
        panel.add(btnAdd);
        panel.add(labelTitle);
        panel.add(textTitle);
        panel.add(labelRating);
        panel.add(textRating);
        panel.add(labelCalories);
        panel.add(textCalories);
        panel.add(labelProteins);
        panel.add(textProteins);
        panel.add(labelFats);
        panel.add(textFats);
        panel.add(labelSodium);
        panel.add(textSodium);
        panel.add(labelPrice);
        panel.add(textPrice);
        panel.add(btnEdit);
        panel.add(btnRemove);
        panel.add(btnImport);
        panel.add(labelReports);
        panel.add(btnReport1);
        panel.add(btnReport2);
        panel.add(btnReport3);
        panel.add(btnReport4);
        panel.add(textStartHour);
        panel.add(textEndHour);
        panel.add(textNumber2);
        panel.add(textNumber3);
        panel.add(textDay);
        panel.add(textValue);
        panel.add(labelCompose);
        panel.add(textProductName);
        panel.add(btnCompose);
        panel.add(btnLogout);
        panel.add(jScrollPane);

        panel.setBackground(backgroundColor);
        panel.setLayout(null);

        frame.setContentPane(panel);
        frame.setVisible(true);
        frame.setSize(1600, 750);
    }

    public void addAddListener(ActionListener al) {
        btnAdd.addActionListener(al);
    }

    public void addEditListener(ActionListener al) {
        btnEdit.addActionListener(al);
    }

    public void addRemoveListener(ActionListener al) {
        btnRemove.addActionListener(al);
    }

    public void addSearchListener(ActionListener al) {
        btnSearch.addActionListener(al);
    }

    public void addImportListener(ActionListener al) {
        btnImport.addActionListener(al);
    }

    public void addReport1Listener(ActionListener al) {
        btnReport1.addActionListener(al);
    }

    public void addReport2Listener(ActionListener al) {
        btnReport2.addActionListener(al);
    }

    public void addReport3Listener(ActionListener al) {
        btnReport3.addActionListener(al);
    }

    public void addReport4Listener(ActionListener al) {
        btnReport4.addActionListener(al);
    }

    public void addComposeListener(ActionListener al) {
        btnCompose.addActionListener(al);
    }

    public void addLogoutListener(ActionListener al) {
        btnLogout.addActionListener(al);
    }

    public String getTitle() {
        return textTitle.getText();
    }

    public void setTitle(String title) {
        this.textTitle.setText(title);
    }

    public Float getRating() {
        return Float.parseFloat(textRating.getText());
    }

    public void setRating(String rating) {
        this.textRating.setText(rating);
    }

    public int getCalories() {
        return Integer.parseInt(textCalories.getText());
    }

    public void setCalories(String calories) {
        this.textCalories.setText(calories);
    }

    public int getProteins() {
        return Integer.parseInt(textProteins.getText());
    }

    public void setProteins(String proteins) {
        this.textProteins.setText(proteins);
    }

    public int getFats() {
        return Integer.parseInt(textFats.getText());
    }

    public void setFats(String fats) {
        this.textFats.setText(fats);
    }

    public int getSodium() {
        return Integer.parseInt(textSodium.getText());
    }

    public void setSodium(String sodium) {
        this.textSodium.setText(sodium);
    }

    public int getPrice() {
        return Integer.parseInt(textPrice.getText());
    }

    public void setPrice(String price) {
        this.textPrice.setText(price);
    }

    public String getSearch() {
        return textSearch.getText();
    }

    public Date getTextStartHour() {
        Date start = new Date(2022, 1, 1, Integer.parseInt(textStartHour.getText()), 0);
        return start;
    }

    public Date getTextEndHour() {
        Date start = new Date(2030, 1, 1, Integer.parseInt(textEndHour.getText()), 0);
        return start;
    }

    public Integer getNumber2() {
        return Integer.parseInt(textNumber2.getText());
    }

    public Integer getNumber3() {
        return Integer.parseInt(textNumber3.getText());
    }

    public Integer getValue() {
        return Integer.parseInt(textValue.getText());
    }

    public Date getDay() {
        Date date = null;
        try {
            date = new Date(Integer.parseInt(textDay.getText(0, 4)), Integer.parseInt(textDay.getText(5, 2)) - 1,
                    Integer.parseInt(textDay.getText(8, 2)), 0, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    public String getProductName() {
        return textProductName.getText();
    }

    public void showMenu(ArrayList<MenuItem> menu) {
        productList.removeAllElements();
        for (MenuItem m : menu) {
            String s = m.getTitle() + " rating: " + m.getRating() + " kcals: " + m.getCalories() + " proteins: " + m.getProteins() + " fats: " + m.getFats() +
                    " sodium: " + m.getSodium() + " price: " + m.computePrice();
            this.productList.addElement(s);
        }
    }

    public JList<String> getList() {
        return list;
    }

    public void dispose() {
        frame.dispose();
    }
}

/**
 * Interfata pentru clienti.
 */
class ClientView {
    private Color backgroundColor = new Color(208, 204, 177);
    private Font font = new Font("Georgia", Font.BOLD, 17);

    private DefaultListModel<String> productList = new DefaultListModel<>();
    private JList<String> list = new JList<>(productList);
    private JScrollPane jScrollPane = new JScrollPane(list);

    private JPanel panel = new JPanel();
    private JFrame frame = new JFrame("Client Page");

    private JTextField textTitle = new JTextField();
    private JTextField textRatingMin = new JTextField("minimum rating");
    private JTextField textRatingMax = new JTextField("maximum rating");
    private JTextField textCaloriesMin = new JTextField("minimum calories");
    private JTextField textCaloriesMax = new JTextField("maximum calories");
    private JTextField textProteinsMin = new JTextField("minimum proteins");
    private JTextField textProteinsMax = new JTextField("maximum proteins");
    private JTextField textFatsMin = new JTextField("minimum fats");
    private JTextField textFatsMax = new JTextField("maximum fats");
    private JTextField textSodiumMin = new JTextField("minimum sodium");
    private JTextField textSodiumMax = new JTextField("maximum sodium");
    private JTextField textPriceMin = new JTextField("minimum price");
    private JTextField textPriceMax = new JTextField("maximum price");

    private JButton btnSearchTitle = new JButton("Search by title");
    private JButton btnSearchRating = new JButton("Search by rating");
    private JButton btnSearchCalories = new JButton("Search by calories");
    private JButton btnSearchProteins = new JButton("Search by proteins");
    private JButton btnSearchFats = new JButton("Search by fats");
    private JButton btnSearchSodium = new JButton("Search by sodium");
    private JButton btnSearchPrice = new JButton("Search by price");

    private JButton btnOrder = new JButton("Order");
    private JButton btnBack = new JButton("Logout");
    private JButton btnReset = new JButton("Reset search");

    private JLabel labelMenu = new JLabel("Menu");

    private ArrayList<MenuItem> menu = new ArrayList<>();


    private User client;

    public ClientView(User client) {
        this.client = client;
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        labelMenu.setBounds(10, 10, 300, 30);
        jScrollPane.setBounds(10, 40, 620, 700);
        btnOrder.setBounds(670, 300, 200, 30);
        btnBack.setBounds(670, 330, 200, 30);
        btnSearchTitle.setBounds(900, 20, 200, 30);
        textTitle.setBounds(900, 50, 300, 30);
        btnSearchRating.setBounds(900, 90, 200, 30);
        textRatingMin.setBounds(900, 120, 300, 30);
        textRatingMax.setBounds(900, 150, 300, 30);
        btnSearchCalories.setBounds(900, 190, 200, 30);
        textCaloriesMin.setBounds(900, 220, 300, 30);
        textCaloriesMax.setBounds(900, 250, 300, 30);
        btnSearchProteins.setBounds(900, 290, 200, 30);
        textProteinsMin.setBounds(900, 320, 300, 30);
        textProteinsMax.setBounds(900, 350, 300, 30);
        btnSearchFats.setBounds(900, 390, 200, 30);
        textFatsMin.setBounds(900, 420, 300, 30);
        textFatsMax.setBounds(900, 450, 300, 30);
        btnSearchSodium.setBounds(900, 490, 200, 30);
        textSodiumMin.setBounds(900, 520, 300, 30);
        textSodiumMax.setBounds(900, 550, 300, 30);
        btnSearchPrice.setBounds(900, 590, 200, 30);
        textPriceMin.setBounds(900, 620, 300, 30);
        textPriceMax.setBounds(900, 650, 300, 30);
        btnReset.setBounds(900, 690, 200, 30);

        panel.add(labelMenu);
        panel.add(jScrollPane);
        panel.add(btnBack);
        panel.add(btnOrder);
        panel.add(btnSearchTitle);
        panel.add(btnSearchRating);
        panel.add(btnSearchCalories);
        panel.add(btnSearchProteins);
        panel.add(btnSearchSodium);
        panel.add(btnSearchFats);
        panel.add(btnSearchPrice);
        panel.add(textTitle);
        panel.add(textRatingMin);
        panel.add(textCaloriesMin);
        panel.add(textProteinsMin);
        panel.add(textFatsMin);
        panel.add(textSodiumMin);
        panel.add(textPriceMin);
        panel.add(textRatingMax);
        panel.add(textCaloriesMax);
        panel.add(textProteinsMax);
        panel.add(textFatsMax);
        panel.add(textSodiumMax);
        panel.add(textPriceMax);
        panel.add(btnReset);

        btnBack.setContentAreaFilled(false);
        btnBack.setFocusPainted(false);
        btnOrder.setContentAreaFilled(false);
        btnBack.setFocusPainted(false);
        btnReset.setFocusPainted(false);
        btnReset.setContentAreaFilled(false);
        btnSearchTitle.setContentAreaFilled(false);
        btnSearchTitle.setFocusPainted(false);
        btnSearchRating.setContentAreaFilled(false);
        btnSearchRating.setFocusPainted(false);
        btnSearchCalories.setContentAreaFilled(false);
        btnSearchCalories.setFocusPainted(false);
        btnSearchProteins.setContentAreaFilled(false);
        btnSearchProteins.setFocusPainted(false);
        btnSearchSodium.setContentAreaFilled(false);
        btnSearchSodium.setFocusPainted(false);
        btnSearchFats.setContentAreaFilled(false);
        btnSearchFats.setFocusPainted(false);
        btnSearchPrice.setContentAreaFilled(false);
        btnSearchPrice.setFocusPainted(false);

        labelMenu.setFont(font);

        panel.setBackground(backgroundColor);
        panel.setLayout(null);
        frame.setVisible(true);
        frame.setSize(1300, 800);
        frame.setContentPane(panel);
    }

    public void showMenu(ArrayList<MenuItem> products) {
        productList.removeAllElements();
        menu.clear();

        menu.addAll(products);

        for (MenuItem m : menu) {
            String s = m.getTitle() + " rating: " + m.getRating() + " kcals: " + m.getCalories() + " proteins: " + m.getProteins() + " fats: " + m.getFats() +
                    " sodium: " + m.getSodium() + " price: " + m.computePrice();
            this.productList.addElement(s);
        }
    }

    public ArrayList<MenuItem> getMenu() {
        return menu;
    }

    public void addBackListener(ActionListener al) {
        btnBack.addActionListener(al);
    }

    public void addOrderListener(ActionListener al) {
        btnOrder.addActionListener(al);
    }

    public void addResetListener(ActionListener al) {
        btnReset.addActionListener(al);
    }

    public void addSearchTitleListener(ActionListener al) {
        btnSearchTitle.addActionListener(al);
    }

    public void addSearchRatingListener(ActionListener al) {
        btnSearchRating.addActionListener(al);
    }

    public void addSearchCaloriesListener(ActionListener al) {
        btnSearchCalories.addActionListener(al);
    }

    public void addSearchProteinsListener(ActionListener al) {
        btnSearchProteins.addActionListener(al);
    }

    public void addSearchSodiumListener(ActionListener al) {
        btnSearchSodium.addActionListener(al);
    }

    public void addSearchFatsListener(ActionListener al) {
        btnSearchFats.addActionListener(al);
    }

    public void addSearchPriceListener(ActionListener al) {
        btnSearchPrice.addActionListener(al);
    }

    public void dispose() {
        frame.dispose();
    }

    public String getTitle() {
        return textTitle.getText();
    }

    public int getCaloriesMin() {
        return Integer.parseInt(textCaloriesMin.getText());
    }

    public int getCaloriesMax() {
        return Integer.parseInt(textCaloriesMax.getText());
    }

    public int getProteinsMin() {
        return Integer.parseInt(textProteinsMin.getText());
    }

    public int getProteinsMax() {
        return Integer.parseInt(textProteinsMax.getText());
    }

    public int getFatsMin() {
        return Integer.parseInt(textFatsMin.getText());
    }

    public int getFatsMax() {
        return Integer.parseInt(textFatsMax.getText());
    }

    public int getSodiumMin() {
        return Integer.parseInt(textSodiumMin.getText());
    }

    public int getSodiumMax() {
        return Integer.parseInt(textSodiumMax.getText());
    }

    public int getPriceMin() {
        return Integer.parseInt(textPriceMin.getText());
    }

    public int getPriceMax() {
        return Integer.parseInt(textPriceMax.getText());
    }

    public Float getRatingMin() {
        return Float.parseFloat(textRatingMin.getText());
    }

    public Float getRatingMax() {
        return Float.parseFloat(textRatingMax.getText());
    }

    public User getClient() {
        return client;
    }

    public ArrayList<MenuItem> getProducts() {
        ArrayList<MenuItem> orderProducts = new ArrayList<>();
        List<String> products = list.getSelectedValuesList();

        for (String s : products) {
            String[] title = s.split(" rating");
            for (MenuItem m : menu) {
                if (m.getTitle().toLowerCase(Locale.ROOT).contains(title[0].toLowerCase(Locale.ROOT))) {
                    orderProducts.add(m);
                }
            }
        }
        return orderProducts;
    }
}

/**
 * Interfata pentru angajati.
 */
class EmployeeView implements java.util.Observer {
    private JFrame frame = new JFrame("Employee Page");
    private JPanel panel = new JPanel();

    private JLabel labelOrders = new JLabel("no pending orders");
    private JButton btnBack = new JButton("Logout");

    private Color backgroundColor = new Color(208, 204, 177);
    private Font font = new Font("Georgia", Font.BOLD, 17);

    public EmployeeView() {
        labelOrders.setBounds(20, 10, 700, 60);
        labelOrders.setFont(font);
        btnBack.setBounds(20, 100, 200, 30);

        btnBack.setFocusPainted(false);
        btnBack.setContentAreaFilled(false);

        panel.add(labelOrders);
        panel.add(btnBack);

        panel.setLayout(null);
        panel.setBackground(backgroundColor);
        frame.setVisible(true);
        frame.setSize(700, 350);
        frame.setContentPane(panel);
    }

    public void addBackListener(ActionListener al) {
        btnBack.addActionListener(al);
    }

    public void setText(String s) {
        labelOrders.setText(s);
    }

    public void dispose() {
        frame.dispose();
    }

    @Override
    public void update(Observable o, Object arg) {
        setText((String) arg);
    }
}
