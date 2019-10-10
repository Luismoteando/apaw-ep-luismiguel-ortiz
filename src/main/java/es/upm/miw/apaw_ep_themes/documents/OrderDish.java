package es.upm.miw.apaw_ep_themes.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class OrderDish {

    @Id
    private String id;

    private int quantity;

    private double price;

    @DBRef
    private Dish dish;

    public OrderDish(int quantity, double price, Dish dish) {
        this.quantity = quantity;
        this.price = price;
        this.dish = dish;
    }

    public String getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public Dish getDish() {
        return dish;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    @Override
    public String toString() {
        return "OrderDish{" +
                "id='" + id + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", dish=" + dish +
                '}';
    }
}
