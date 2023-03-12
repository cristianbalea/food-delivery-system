package Business;

/**
 * Interfata implementata de BaseProducts si CompositeProducts ce contine metodele specifice.
 */
public interface MenuItem {
    int computePrice();

    String getTitle();

    float getRating();

    int getCalories();

    int getProteins();

    int getFats();

    int getSodium();

    void setTitle(String title);

    void setRating(float rating);

    void setCalories(int calories);

    void setProteins(int proteins);

    void setFats(int fats);

    void setSodium(int sodium);

    void setPrice(int price);
}
