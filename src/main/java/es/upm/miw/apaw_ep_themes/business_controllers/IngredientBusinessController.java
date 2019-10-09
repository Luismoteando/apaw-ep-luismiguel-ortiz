package es.upm.miw.apaw_ep_themes.business_controllers;

import es.upm.miw.apaw_ep_themes.daos.IngredientDao;
import es.upm.miw.apaw_ep_themes.documents.Ingredient;
import es.upm.miw.apaw_ep_themes.dtos.IngredientBasicDto;
import es.upm.miw.apaw_ep_themes.dtos.IngredientCreationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class IngredientBusinessController {

    private IngredientDao ingredientDao;

    @Autowired
    public IngredientBusinessController(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }

    public IngredientBasicDto create(IngredientCreationDto ingredientCreationDto) {
        Ingredient ingredient = new Ingredient(ingredientCreationDto.getName(),
                ingredientCreationDto.getPortion(), ingredientCreationDto.getUnit());
        this.ingredientDao.save(ingredient);
        return new IngredientBasicDto(ingredient);
    }

}
