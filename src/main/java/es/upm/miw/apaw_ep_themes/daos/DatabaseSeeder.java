package es.upm.miw.apaw_ep_themes.daos;

import es.upm.miw.apaw_ep_themes.documents.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DatabaseSeeder {

    private IngredientDao ingredientDao;

    private RecipeDao recipeDao;

    private DishDao dishDao;

    private OrderDishDao orderDishDao;

    private ClaimDao claimDao;

    private Recipe recipe;

    private Dish dish;

    @Autowired
    public DatabaseSeeder(IngredientDao ingredientDao, RecipeDao recipeDao, DishDao dishDao, OrderDishDao orderDishDao,
                          ClaimDao claimDao) {
        this.ingredientDao = ingredientDao;
        this.recipeDao = recipeDao;
        this.dishDao = dishDao;
        this.orderDishDao = orderDishDao;
        this.claimDao = claimDao;
        this.seedIngredients();
        this.seedRecipes();
        this.seedDishes();
        this.seedOrderDishes();
        this.seedClaims();
    }

    private void seedIngredients() {
        this.ingredientDao.saveAll(Arrays.asList(
                new Ingredient("tomato", 2, "pieces"),
                new Ingredient("olive oil extra virgin", 1, "tablespoonful"),
                new Ingredient("fresh cheese", 50, "grams"),
                new Ingredient("basil", 3, "leaves")
        ));
    }

    private void seedRecipes() {
        recipe = new Recipe(Arrays.asList(
                "Cut tomato into slices.",
                "Cut fresh cheese into slices.",
                "Dress with olive oil extra virgin.",
                "Garnish with basil leaves."
        ));
        this.recipeDao.save(recipe);
    }

    private void seedDishes() {
        dish = new Dish("Tomato and fresh cheese salad", true, recipe);
        this.dishDao.save(dish);
    }

    private void seedOrderDishes() {
        this.orderDishDao.save(new OrderDish(2, 21.8, dish));
    }

    private void seedClaims() {
        this.claimDao.saveAll(Arrays.asList(
                new Claim("The food was terribly cold. I will not return to the restaurant."),
                new Claim("The food has taken an hour. I will not recommend the restaurant.")
        ));
    }
}