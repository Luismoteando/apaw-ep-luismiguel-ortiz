package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.business_controllers.OrderDishBusinessController;
import es.upm.miw.apaw_ep_themes.dtos.OrderDishDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(OrderDishResource.ORDERDISHES)
public class OrderDishResource {

    public static final String ORDERDISHES = "/orderdishes";
    public static final String ID_ID = "/{id}";

    private OrderDishBusinessController orderDishBusinessController;

    @Autowired
    public OrderDishResource(OrderDishBusinessController orderDishBusinessController) {
        this.orderDishBusinessController = orderDishBusinessController;
    }

    @PutMapping(value = ID_ID)
    public void update(@PathVariable String id, @RequestBody OrderDishDto orderDishDto) {
        orderDishDto.validate();
        this.orderDishBusinessController.update(id, orderDishDto);
    }
}
