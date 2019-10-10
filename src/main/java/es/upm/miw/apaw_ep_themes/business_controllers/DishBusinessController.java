package es.upm.miw.apaw_ep_themes.business_controllers;

import es.upm.miw.apaw_ep_themes.daos.DishDao;
import es.upm.miw.apaw_ep_themes.documents.Dish;
import es.upm.miw.apaw_ep_themes.dtos.DishDto;
import es.upm.miw.apaw_ep_themes.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class DishBusinessController {

    private DishDao dishDao;

    @Autowired
    public DishBusinessController(DishDao dishDao) {
        this.dishDao = dishDao;
    }

    public DishDto read(String id) {
        return new DishDto(this.findDishByIdAssured(id));
    }

    private Dish findDishByIdAssured(String id) {
        return this.dishDao.findById(id).orElseThrow(() -> new NotFoundException("Dish id: " + id));
    }

    public List<DishDto> findByGlutenFree(boolean glutenFree) {
        return this.dishDao.findAll().stream()
                .filter(dish -> dish.isGlutenFree() == glutenFree)
                .map(DishDto::new)
                .collect(Collectors.toList());
    }
}
