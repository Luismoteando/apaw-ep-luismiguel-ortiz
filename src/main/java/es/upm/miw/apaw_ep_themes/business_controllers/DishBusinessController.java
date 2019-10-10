package es.upm.miw.apaw_ep_themes.business_controllers;

import es.upm.miw.apaw_ep_themes.daos.DishDao;
import es.upm.miw.apaw_ep_themes.documents.Dish;
import es.upm.miw.apaw_ep_themes.dtos.DishBasicDto;
import es.upm.miw.apaw_ep_themes.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DishBusinessController {

    private DishDao dishDao;

    @Autowired
    public DishBusinessController(DishDao dishDao) {
        this.dishDao = dishDao;
    }

    public DishBasicDto read(String id) {
        return new DishBasicDto(this.findDishByIdAssured(id));
    }

    private Dish findDishByIdAssured(String id) {
        return this.dishDao.findById(id).orElseThrow(() -> new NotFoundException("Dish id: " + id));
    }
}
