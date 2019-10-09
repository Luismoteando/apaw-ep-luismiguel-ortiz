package es.upm.miw.apaw_ep_themes.daos;

import es.upm.miw.apaw_ep_themes.TestConfig;
import es.upm.miw.apaw_ep_themes.documents.Ingredient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
class IngredientDaoIT {

    @Autowired
    private IngredientDao ingredientDao;

    @Test
    void testCreate() {
        Ingredient ingredient = new Ingredient("wheat flour", 100.0, "grams");
        this.ingredientDao.save(ingredient);
        Ingredient databaseIngredient = this.ingredientDao.findById(ingredient.getId()).orElseGet(Assertions::fail);
        assertEquals("wheat flour", databaseIngredient.getName());
    }
}
