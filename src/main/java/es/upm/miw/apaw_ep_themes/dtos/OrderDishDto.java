package es.upm.miw.apaw_ep_themes.dtos;

import es.upm.miw.apaw_ep_themes.documents.OrderDish;
import es.upm.miw.apaw_ep_themes.exceptions.BadRequestException;

public class OrderDishDto {

    private int quantity;

    private double price;

    public OrderDishDto() {
        //Empty for framework
    }

    public OrderDishDto(OrderDish orderDish) {
        this.quantity = orderDish.getQuantity();
        this.price = orderDish.getPrice();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void validate() {
        if (this.quantity <= 0 || this.price <= 0) {
            throw new BadRequestException("Incomplete OrderDishDto");
        }
    }

    @Override
    public String toString() {
        return "OrderDishDto{" +
                "quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
