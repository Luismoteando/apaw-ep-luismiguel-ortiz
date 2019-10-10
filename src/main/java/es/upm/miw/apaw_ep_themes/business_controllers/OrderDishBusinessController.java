package es.upm.miw.apaw_ep_themes.business_controllers;

import es.upm.miw.apaw_ep_themes.daos.OrderDishDao;
import es.upm.miw.apaw_ep_themes.documents.OrderDish;
import es.upm.miw.apaw_ep_themes.dtos.OrderDishDto;
import es.upm.miw.apaw_ep_themes.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class OrderDishBusinessController {

    private OrderDishDao orderDishDao;

    @Autowired
    public OrderDishBusinessController(OrderDishDao orderDishDao) {
        this.orderDishDao = orderDishDao;
    }

    public void update(String id, OrderDishDto orderDishDto) {
        OrderDish orderDish = this.findOrderDishByIdAssured(id);
        orderDish.setQuantity(orderDishDto.getQuantity());
        orderDish.setPrice(orderDishDto.getPrice());
        this.orderDishDao.save(orderDish);
    }

    private OrderDish findOrderDishByIdAssured(String id) {
        return this.orderDishDao.findById(id).orElseThrow(() -> new NotFoundException("OrderDish id: " + id));
    }
}
