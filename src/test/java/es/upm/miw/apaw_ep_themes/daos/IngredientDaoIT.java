package es.upm.miw.apaw_ep_themes.daos;

import es.upm.miw.apaw_ep_themes.TestConfig;
import es.upm.miw.apaw_ep_themes.documents.Ingredient;
import es.upm.miw.apaw_ep_themes.dtos.IngredientCreationDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class IngredientDaoIT {

    @Autowired
    private IngredientDao ingredientDao;

    private Ingredient ingredient;

    @Test
    void testCreate() {
        IngredientCreationDto ingredientCreationDto = new IngredientCreationDto(
                "wheat flour",
                100.0,
                "grams");
        ingredient = new Ingredient(
                ingredientCreationDto.getName(),
                ingredientCreationDto.getPortion(),
                ingredientCreationDto.getUnit());
        this.ingredientDao.save(ingredient);
        ingredient = this.ingredientDao.findById(ingredient.getId()).orElseGet(Assertions::fail);
        assertEquals("wheat flour", ingredient.getName());
    }

    @Test
    void testRead() {
        ingredient = this.ingredientDao.findAll().get(0);
        assertTrue(ingredient.getPortion() == 2.0 && ingredient.getUnit().equals("pieces"));
    }
}
