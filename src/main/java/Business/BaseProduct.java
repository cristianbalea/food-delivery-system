package Business;

import java.io.Serializable;

public class BaseProduct implements MenuItem, Serializable {
    private String title;
    private float rating;
    private int calories;
    private int proteins;
    private int fats;
    private int sodium;
    private int price;

    /**
     * Constructor pentru obiecte de tip BaseProduct
     *
     * @param title
     * @param rating
     * @param calories
     * @param proteins
     * @param fats
     * @param sodium
     * @param price
     */
    public BaseProduct(String title, float rating, int calories, int proteins, int fats, int sodium, int price) {
        this.title = title;
        this.rating = rating;
        this.calories = calories;
        this.proteins = proteins;
        this.fats = fats;
        this.sodium = sodium;
        this.price = price;
    }

    @Override
    public int computePrice() {
        return price;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public float getRating() {
        return rating;
    }

    @Override
    public int getCalories() {
        return calories;
    }

    @Override
    public int getProteins() {
        return proteins;
    }

    @Override
    public int getFats() {
        return fats;
    }

    @Override
    public int getSodium() {
        return sodium;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public void setProteins(int proteins) {
        this.proteins = proteins;
    }

    @Override
    public void setFats(int fats) {
        this.fats = fats;
    }

    @Override
    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
