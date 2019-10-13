package es.upm.miw.apaw_ep_themes.daos;

import es.upm.miw.apaw_ep_themes.TestConfig;
import es.upm.miw.apaw_ep_themes.documents.Recipe;
import es.upm.miw.apaw_ep_themes.dtos.RecipeCreationDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;

@TestConfig
public class RecipeDaoIT {

    @Autowired
    private RecipeDao recipeDao;

    private Recipe recipe;

    @Test
    void testCreate() {
        RecipeCreationDto recipeCreationDto = new RecipeCreationDto(Arrays.asList(
                "Cut tomato into slices.",
                "Cut fresh cheese into slices.",
                "Dress with olive oil extra virgin.",
                "Garnish with basil leaves."));
        recipe = new Recipe(recipeCreationDto.getSteps());
        this.recipeDao.save(recipe);
        Recipe databaseRecipe = this.recipeDao.findById(recipe.getId()).orElseGet(Assertions::fail);
        assertNotNull(databaseRecipe.getId());
    }

    @Test
    void testRead() {
        recipe = this.recipeDao.findAll().get(0);
        assertFalse(recipe.getSteps().isEmpty());
    }
}
