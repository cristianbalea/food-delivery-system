package Business;

import java.io.Serializable;
import java.util.ArrayList;

public class CompositeProduct implements MenuItem, Serializable {
    private String title;
    private ArrayList<MenuItem> products = new ArrayList<>();

    /**
     * Constructor pentru obiect de tip CompositeProduct
     *
     * @param title
     */
    public CompositeProduct(String title) {
        this.title = title;
    }

    /**
     * Metoda de adaugare a unui BaseProduct intr-un CompositeProduct
     *
     * @param m
     */
    public void addProduct(MenuItem m) {
        products.add(m);
    }

    @Override
    public int computePrice() {
        int p = 0;
        for (MenuItem m : products) {
            p += m.computePrice();
        }
        return p;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public float getRating() {
        float r = 0.0f;
        for (MenuItem m : products) {
            r += m.getRating();
        }
        r /= products.size();
        return r;
    }

    @Override
    public int getCalories() {
        int c = 0;
        for (MenuItem m : products) {
            c += m.getCalories();
        }
        return c;
    }

    @Override
    public int getProteins() {
        int p = 0;
        for (MenuItem m : products) {
            p += m.getProteins();
        }
        return p;
    }

    @Override
    public int getFats() {
        int f = 0;
        for (MenuItem m : products) {
            f += m.getFats();
        }
        return f;
    }

    @Override
    public int getSodium() {
        int s = 0;
        for (MenuItem m : products) {
            s += m.getSodium();
        }
        return s;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void setRating(float rating) {
    }

    @Override
    public void setCalories(int calories) {

    }

    @Override
    public void setProteins(int proteins) {

    }

    @Override
    public void setFats(int fats) {

    }

    @Override
    public void setSodium(int sodium) {

    }

    @Override
    public void setPrice(int price) {

    }
}
