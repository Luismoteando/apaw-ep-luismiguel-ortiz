package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.business_controllers.RecipeBusinessController;
import es.upm.miw.apaw_ep_themes.dtos.RecipeBasicDto;
import es.upm.miw.apaw_ep_themes.dtos.RecipeCreationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RecipeResource.RECIPES)
public class RecipeResource {

    static final String RECIPES = "/recipes";

    private RecipeBusinessController recipeBusinessController;

    @Autowired
    public RecipeResource(RecipeBusinessController recipeBusinessController) {
        this.recipeBusinessController = recipeBusinessController;
    }

    @PostMapping
    public RecipeBasicDto create(@RequestBody RecipeCreationDto recipeCreationDto) {
        recipeCreationDto.validate();
        return this.recipeBusinessController.create(recipeCreationDto);
    }
}
