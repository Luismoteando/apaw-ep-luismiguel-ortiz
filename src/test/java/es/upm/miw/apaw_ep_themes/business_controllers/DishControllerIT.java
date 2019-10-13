package es.upm.miw.apaw_ep_themes.business_controllers;

import es.upm.miw.apaw_ep_themes.TestConfig;
import es.upm.miw.apaw_ep_themes.daos.DishDao;
import es.upm.miw.apaw_ep_themes.documents.Dish;
import es.upm.miw.apaw_ep_themes.dtos.DishDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class DishControllerIT {

    @Autowired
    private DishBusinessController dishBusinessController;

    @Autowired
    private DishDao dishDao;

    private Dish dish;

    @Test
    void testRead() {
        dish = this.dishDao.findAll().get(0);
        DishDto dishDto = dishBusinessController.read(this.dish.getId());
        assertEquals("Tomato and fresh cheese salad", dishDto.getName());
    }

    @Test
    void testReadByGlutenFree() {
        dish = this.dishDao.findAll().get(0);
        List<DishDto> glutenFreeDishes = dishBusinessController.findByGlutenFree(true);
        assertFalse(glutenFreeDishes.isEmpty());
    }
}
