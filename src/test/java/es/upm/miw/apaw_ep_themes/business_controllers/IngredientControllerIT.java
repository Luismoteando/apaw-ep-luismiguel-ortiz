package es.upm.miw.apaw_ep_themes.business_controllers;

import es.upm.miw.apaw_ep_themes.TestConfig;
import es.upm.miw.apaw_ep_themes.daos.IngredientDao;
import es.upm.miw.apaw_ep_themes.documents.Ingredient;
import es.upm.miw.apaw_ep_themes.dtos.IngredientBasicDto;
import es.upm.miw.apaw_ep_themes.dtos.IngredientCreationDto;
import es.upm.miw.apaw_ep_themes.dtos.IngredientPatchDto;
import es.upm.miw.apaw_ep_themes.exceptions.BadRequestException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class IngredientControllerIT {

    @Autowired
    private IngredientBusinessController ingredientBusinessController;

    @Autowired
    private IngredientDao ingredientDao;

    private Ingredient ingredient;

    @Test
    void testCreate() {
        IngredientCreationDto ingredientCreationDto = new IngredientCreationDto("tomato", 2, "pieces");
        ingredientCreationDto.validate();
        IngredientBasicDto ingredientBasicDto = ingredientBusinessController.create(ingredientCreationDto);
        assertEquals("tomato", ingredientBasicDto.getName());
    }

    @Test
    void testCreateException() {
        IngredientCreationDto ingredientCreationDto = new IngredientCreationDto(null, 2, "pieces");
        assertThrows(BadRequestException.class, () -> ingredientCreationDto.validate());
    }

    void testPatch(String path, String newValue) {
        String id = this.ingredientDao.findAll().get(0).getId();
        IngredientPatchDto ingredientPatchDto = new IngredientPatchDto(path, newValue);
        ingredientPatchDto.validate();
        assertDoesNotThrow(() -> this.ingredientBusinessController.patch(id, ingredientPatchDto));
    }

    @Test
    void testPatchName() {
        this.testPatch("name", "spinach");
    }

    @Test
    void testPatchPortion() {
        this.testPatch("portion", "50");
    }

    @Test
    void testPatchUnit() {
        this.testPatch("unit", "grams");
    }
}

