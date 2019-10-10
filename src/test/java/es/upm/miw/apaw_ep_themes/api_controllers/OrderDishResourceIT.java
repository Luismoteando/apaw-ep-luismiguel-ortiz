package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.ApiTestConfig;
import es.upm.miw.apaw_ep_themes.daos.DishDao;
import es.upm.miw.apaw_ep_themes.daos.OrderDishDao;
import es.upm.miw.apaw_ep_themes.daos.RecipeDao;
import es.upm.miw.apaw_ep_themes.documents.Dish;
import es.upm.miw.apaw_ep_themes.documents.OrderDish;
import es.upm.miw.apaw_ep_themes.documents.Recipe;
import es.upm.miw.apaw_ep_themes.dtos.OrderDishDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.support.SimpleReactiveMongoRepository;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.ArrayList;
import java.util.List;

@ApiTestConfig
public class OrderDishResourceIT {

    @Autowired
    private RecipeDao recipeDao;

    @Autowired
    private DishDao dishDao;

    @Autowired
    private OrderDishDao orderDishDao;

    @Autowired
    private WebTestClient webTestClient;

    private OrderDish orderDish;

    @BeforeEach
    void before() {
        List<String> steps = new ArrayList<>();
        steps.add("Cut tomato into slices.");
        steps.add("Dress with olive oil.");
        Recipe recipe = new Recipe(steps);
        this.recipeDao.save(recipe);
        Dish dish = new Dish("tomato salad", true,
                this.recipeDao.findById(recipe.getId()).get());
        this.dishDao.save(dish);
        this.orderDish = new OrderDish(2, 11.9, this.dishDao.findById(dish.getId()).get());
        this.orderDishDao.save(orderDish);
    }

    @Test
    void testUpdate() {
        OrderDish newOrderDish = this.orderDishDao.findById(orderDish.getId()).get();
        String id = newOrderDish.getId();
        newOrderDish.setQuantity(1);
        newOrderDish.setPrice(5.95);
        this.webTestClient
                .put().uri(OrderDishResource.ORDERDISHES + OrderDishResource.ID_ID, id)
                .body(BodyInserters.fromObject(new OrderDishDto(newOrderDish)))
                .exchange()
                .expectStatus().isOk();
    }
}
