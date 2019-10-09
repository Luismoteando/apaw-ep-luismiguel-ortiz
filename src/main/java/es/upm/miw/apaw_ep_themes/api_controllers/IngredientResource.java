package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.business_controllers.IngredientBusinessController;
import es.upm.miw.apaw_ep_themes.dtos.IngredientBasicDto;
import es.upm.miw.apaw_ep_themes.dtos.IngredientCreationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(IngredientResource.INGREDIENTS)
public class IngredientResource {

    public static final String INGREDIENTS = "/ingredients";

    private IngredientBusinessController ingredientBusinessController;

    @Autowired
    public IngredientResource(IngredientBusinessController ingredientBusinessController) {
        this.ingredientBusinessController = ingredientBusinessController;
    }

    @PostMapping
    public IngredientBasicDto create(@RequestBody IngredientCreationDto ingredientCreationDto) {
        ingredientCreationDto.validate();
        return this.ingredientBusinessController.create(ingredientCreationDto);
    }
}
