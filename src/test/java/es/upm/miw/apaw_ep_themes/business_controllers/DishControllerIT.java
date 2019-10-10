package es.upm.miw.apaw_ep_themes.business_controllers;

import es.upm.miw.apaw_ep_themes.TestConfig;
import es.upm.miw.apaw_ep_themes.daos.DishDao;
import es.upm.miw.apaw_ep_themes.daos.RecipeDao;
import es.upm.miw.apaw_ep_themes.documents.Dish;
import es.upm.miw.apaw_ep_themes.documents.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class DishControllerIT {

    @Autowired
    private DishDao dishDao;

    @Autowired
    private RecipeDao recipeDao;

    @Autowired
    private DishBusinessController dishBusinessController;

    private Dish dish;

    private Recipe recipe;

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
        dishBusinessController.read(this.dish.getId());
        assertEquals("tomato salad", this.dishDao.findById(dish.getId()).get().getName());
    }
}
