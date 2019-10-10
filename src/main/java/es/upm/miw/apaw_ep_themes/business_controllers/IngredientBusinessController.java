package es.upm.miw.apaw_ep_themes.business_controllers;

import es.upm.miw.apaw_ep_themes.daos.IngredientDao;
import es.upm.miw.apaw_ep_themes.documents.Ingredient;
import es.upm.miw.apaw_ep_themes.dtos.IngredientBasicDto;
import es.upm.miw.apaw_ep_themes.dtos.IngredientCreationDto;
import es.upm.miw.apaw_ep_themes.dtos.IngredientPatchDto;
import es.upm.miw.apaw_ep_themes.exceptions.BadRequestException;
import es.upm.miw.apaw_ep_themes.exceptions.NotFoundException;
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

    public void patch(String id, IngredientPatchDto ingredientPatchDto) {
        Ingredient ingredient = this.findIngredientByIdAssured(id);
        switch (ingredientPatchDto.getPath()) {
            case "name":
                ingredient.setName(ingredientPatchDto.getNewValue());
                break;
            case "portion":
                ingredient.setPortion(Double.parseDouble(ingredientPatchDto.getNewValue()));
                break;
            case "unit":
                ingredient.setUnit(ingredientPatchDto.getNewValue());
                break;
            default:
                throw new BadRequestException("IngredientPatchDto is invalid");
        }
        this.ingredientDao.save(ingredient);
    }

    private Ingredient findIngredientByIdAssured(String id) {
        return this.ingredientDao.findById(id).orElseThrow(() -> new NotFoundException("Ingredient id: " + id));
    }
}
