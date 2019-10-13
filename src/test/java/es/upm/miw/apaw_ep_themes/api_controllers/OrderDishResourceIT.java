package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.ApiTestConfig;
import es.upm.miw.apaw_ep_themes.daos.OrderDishDao;
import es.upm.miw.apaw_ep_themes.documents.OrderDish;
import es.upm.miw.apaw_ep_themes.dtos.OrderDishDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@ApiTestConfig
public class OrderDishResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private OrderDishDao orderDishDao;

    private OrderDish orderDish;

    @Test
    void testUpdate() {
        orderDish = this.orderDishDao.findAll().get(0);
        orderDish.setQuantity(1);
        orderDish.setPrice(5.95);
        String id = orderDish.getId();
        this.webTestClient
                .put().uri(OrderDishResource.ORDERDISHES + OrderDishResource.ID_ID, id)
                .body(BodyInserters.fromObject(new OrderDishDto(orderDish)))
                .exchange()
                .expectStatus().isOk();
    }
}
