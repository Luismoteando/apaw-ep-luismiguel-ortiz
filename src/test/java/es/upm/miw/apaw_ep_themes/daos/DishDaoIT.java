package es.upm.miw.apaw_ep_themes.daos;

import es.upm.miw.apaw_ep_themes.TestConfig;
import es.upm.miw.apaw_ep_themes.documents.Dish;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class DishDaoIT {

    @Autowired
    private DishDao dishDao;

    private Dish dish;

    @Test
    void testRead() {
        dish = this.dishDao.findAll().get(0);
        assertTrue(dish.getRecipe().getIngredients().isEmpty());
    }
}

