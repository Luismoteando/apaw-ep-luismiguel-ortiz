package es.upm.miw.apaw_ep_themes.business_controllers;

import es.upm.miw.apaw_ep_themes.daos.RecipeDao;
import es.upm.miw.apaw_ep_themes.documents.Recipe;
import es.upm.miw.apaw_ep_themes.dtos.RecipeBasicDto;
import es.upm.miw.apaw_ep_themes.dtos.RecipeCreationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.EmitterProcessor;

@Controller
public class RecipeBusinessController {

    private RecipeDao recipeDao;

    private EmitterProcessor<String> emitter;

    @Autowired
    public RecipeBusinessController(RecipeDao recipeDao) {
        this.recipeDao = recipeDao;
        this.emitter = EmitterProcessor.create();
    }

    public RecipeBasicDto create(RecipeCreationDto recipeCreationDto) {
        Recipe recipe = new Recipe(recipeCreationDto.getSteps());
        this.recipeDao.save(recipe);
        this.emitter.onNext("New recipe available");
        return new RecipeBasicDto(recipe);
    }

    public EmitterProcessor<String> publisher() {
        return this.emitter;
    }
}
