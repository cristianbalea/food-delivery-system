package Business;

import Users.Client;
import Users.User;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.Observable;

public class Order extends Observable implements Serializable {

    private int orderID;
    private User client;
    private Date orderDate;
    private int value;

    /**
     * Constructor pentru un obiect de tip Order. Se atribuie ID-ul, data și clientul,
     * valoarea va fi setata prin computePrice() din MenuItem.
     *
     * @param client
     */
    public Order(User client) {
        orderID = DeliveryService.numberOfOrders + 1;
        this.orderDate = new Date();
        this.client = client;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public User getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

}
