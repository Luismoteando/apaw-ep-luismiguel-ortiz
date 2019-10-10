package es.upm.miw.apaw_ep_themes.daos;

import es.upm.miw.apaw_ep_themes.TestConfig;
import es.upm.miw.apaw_ep_themes.documents.Recipe;
import es.upm.miw.apaw_ep_themes.dtos.RecipeCreationDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;

@TestConfig
public class RecipeDaoIT {

    @Autowired
    private RecipeDao recipeDao;

    @Test
    void testCreate() {
        ArrayList<String> steps = new ArrayList<>();
        steps.add("Cut tomato into slices.");
        steps.add("Dress with olive oil extra virgin.");
        RecipeCreationDto recipeCreationDto = new RecipeCreationDto(steps);
        Recipe recipe = new Recipe(recipeCreationDto.getSteps());
        this.recipeDao.save(recipe);
        Recipe databaseRecipe = this.recipeDao.findById(recipe.getId()).orElseGet(Assertions::fail);
        assertNotNull(databaseRecipe.getId());
    }
}
