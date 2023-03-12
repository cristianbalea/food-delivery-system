package Business;

import Users.User;

import java.util.ArrayList;
import java.util.Date;

public interface IDeliveryServiceProcessing {
    void importProducts();

    /**
     * @param m
     * @pre m != null
     * @post invariant()
     */
    void addMenuItem(MenuItem m);

    /**
     * @param m
     * @pre m != null
     */
    void removeMenuItem(MenuItem m);

    ArrayList<MenuItem> editMenuItem(MenuItem m);

    /**
     * @param startHour
     * @param endHour
     * @pre startHour != null, endHour != null
     */
    void report1(Date startHour, Date endHour);

    /**
     * @param numberOfTimes
     * @pre numberOfTimes > 0
     */
    void report2(int numberOfTimes);

    /**
     * @param numberOfTimes
     * @param price
     * @pre numberOfTimes > 0 && price > 0
     */
    void report3(int numberOfTimes, int price);

    /**
     * @param date
     * @pre date != null
     */
    void report4(Date date);

    /**
     * @param products
     * @param client
     * @pre !products.isEmpty() && client != null;
     */
    void newOrder(ArrayList<MenuItem> products, User client);

    /**
     * @param clientMenu
     * @param title
     * @return
     * @pre title != null
     */
    ArrayList<MenuItem> searchItemByTitle(ArrayList<MenuItem> clientMenu, String title);

    /**
     * @param clientMenu
     * @param ratingMin
     * @param ratingMax
     * @return
     * @pre ratingMin <= ratingMax
     */
    ArrayList<MenuItem> searchItemByRating(ArrayList<MenuItem> clientMenu, Float ratingMin, Float ratingMax);

    /**
     * @param clientMenu
     * @param caloriesMin
     * @param caloriesMax
     * @return
     * @pre caloriesMin <= caloriesMax
     */
    ArrayList<MenuItem> searchItemByCalories(ArrayList<MenuItem> clientMenu, int caloriesMin, int caloriesMax);

    /**
     * @param clientMenu
     * @param proteinsMin
     * @param proteinsMax
     * @return
     * @pre proteinsMin <= proteinsMax
     */
    ArrayList<MenuItem> searchItemByProteins(ArrayList<MenuItem> clientMenu, int proteinsMin, int proteinsMax);

    /**
     * @param clientMenu
     * @param fatsMin
     * @param fatsMax
     * @return
     * @pre fatsMin <= fatsMax
     */
    ArrayList<MenuItem> searchItemByFats(ArrayList<MenuItem> clientMenu, int fatsMin, int fatsMax);

    /**
     * @param clientMenu
     * @param sodiumMin
     * @param sodiumMax
     * @return
     * @pre sodiumMin < sodiumMax
     */
    ArrayList<MenuItem> searchItemBySodium(ArrayList<MenuItem> clientMenu, int sodiumMin, int sodiumMax);

    /**
     * @param clientMenu
     * @param priceMin
     * @param priceMax
     * @return
     * @pre priceMin > 0 && priceMax >= priceMin
     */
    ArrayList<MenuItem> searchItemByPrice(ArrayList<MenuItem> clientMenu, int priceMin, int priceMax);
}
