package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.business_controllers.IngredientBusinessController;
import es.upm.miw.apaw_ep_themes.dtos.IngredientBasicDto;
import es.upm.miw.apaw_ep_themes.dtos.IngredientCreationDto;
import es.upm.miw.apaw_ep_themes.dtos.IngredientPatchDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(IngredientResource.INGREDIENTS)
public class IngredientResource {

    public static final String INGREDIENTS = "/ingredients";
    private static final String ID_ID = "/{id}";

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

    @PatchMapping(value = ID_ID)
    public void patch(@PathVariable String id, @RequestBody IngredientPatchDto ingredientPatchDto) {
        ingredientPatchDto.validate();
        this.ingredientBusinessController.patch(id, ingredientPatchDto);
    }
}
