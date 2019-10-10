package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.ApiTestConfig;
import es.upm.miw.apaw_ep_themes.daos.DishDao;
import es.upm.miw.apaw_ep_themes.daos.RecipeDao;
import es.upm.miw.apaw_ep_themes.documents.Dish;
import es.upm.miw.apaw_ep_themes.documents.Recipe;
import es.upm.miw.apaw_ep_themes.dtos.DishBasicDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@ApiTestConfig
public class DishResourceIT {

    @Autowired
    private DishDao dishDao;

    @Autowired
    private RecipeDao recipeDao;

    @Autowired
    private WebTestClient webTestClient;

    private Recipe recipe;

    private Dish dish;

    @BeforeEach
    void before() {
        List<String> steps = new ArrayList<>();
        steps.add("Cut tomato into slices.");
        steps.add("Dress with olive oil.");
        this.recipe = new Recipe(steps);
        this.recipeDao.save(recipe);
        this.dish = new Dish("tomato salad", true,
                this.recipeDao.findById(recipe.getId()).get());
        this.dishDao.save(dish);
    }

    @Test
    void testRead() {
        String id = this.dishDao.findById(dish.getId()).get().getId();
        DishBasicDto dishBasicDto = this.webTestClient
                .get().uri(DishResource.DISHES + DishResource.ID_ID, id)
                .exchange()
                .expectStatus().isOk()
                .expectBody(DishBasicDto.class)
                .returnResult().getResponseBody();
        assertEquals(id, dishBasicDto.getId());
        assertEquals("tomato salad", dishBasicDto.getName());
    }

    @Test
    void testSearch() {
        List<DishBasicDto> dishes = this.webTestClient
                .get().uri(uriBuilder ->
                        uriBuilder.path(DishResource.DISHES + DishResource.SEARCH)
                                .queryParam("q", "glutenFree:true")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(DishBasicDto.class)
                .returnResult().getResponseBody();
        assertFalse(dishes.isEmpty());
    }
}
