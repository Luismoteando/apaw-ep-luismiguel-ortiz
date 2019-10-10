package es.upm.miw.apaw_ep_themes.business_controllers;

import es.upm.miw.apaw_ep_themes.daos.RecipeDao;
import es.upm.miw.apaw_ep_themes.documents.Recipe;
import es.upm.miw.apaw_ep_themes.dtos.RecipeBasicDto;
import es.upm.miw.apaw_ep_themes.dtos.RecipeCreationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RecipeBusinessController {

    private RecipeDao recipeDao;

    @Autowired
    public RecipeBusinessController(RecipeDao recipeDao) {
        this.recipeDao = recipeDao;
    }

    public RecipeBasicDto create(RecipeCreationDto recipeCreationDto) {
        Recipe recipe = new Recipe(recipeCreationDto.getSteps());
        this.recipeDao.save(recipe);
        return new RecipeBasicDto(recipe);
    }
}
