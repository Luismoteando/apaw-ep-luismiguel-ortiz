package es.upm.miw.apaw_ep_themes.daos;

import es.upm.miw.apaw_ep_themes.TestConfig;
import es.upm.miw.apaw_ep_themes.documents.Dish;
import es.upm.miw.apaw_ep_themes.documents.Recipe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class DishDaoIT {

    @Autowired
    private DishDao dishDao;

    @Autowired
    private RecipeDao recipeDao;

    private Dish dish;

    @BeforeEach
    void before() {
        List<String> steps = new ArrayList<>();
        steps.add("Cut tomato into slices.");
        steps.add("Dress with olive oil.");
        Recipe recipe = new Recipe(steps);
        this.recipeDao.save(recipe);
        this.dish = new Dish("tomato salad", true,
                this.recipeDao.findById(recipe.getId()).get());
        this.dishDao.save(dish);
    }

    @Test
    void testRead() {
        Dish databaseDish = this.dishDao.findById(dish.getId()).orElseGet(Assertions::fail);
        assertTrue(databaseDish.getRecipe().getIngredients().isEmpty());
    }
}

