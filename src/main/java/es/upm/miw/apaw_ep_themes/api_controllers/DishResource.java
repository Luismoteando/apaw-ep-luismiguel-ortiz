package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.business_controllers.DishBusinessController;
import es.upm.miw.apaw_ep_themes.dtos.DishDto;
import es.upm.miw.apaw_ep_themes.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(DishResource.DISHES)
public class DishResource {

    public static final String DISHES = "/dishes";
    public static final String ID_ID = "/{id}";
    public static final String SEARCH = "/search";

    private DishBusinessController dishBusinessController;

    @Autowired
    public DishResource(DishBusinessController dishBusinessController) {
        this.dishBusinessController = dishBusinessController;
    }

    @GetMapping(value = ID_ID)
    public DishDto read(@PathVariable String id) {
        return this.dishBusinessController.read(id);
    }

    @GetMapping(value = SEARCH)
    public List<DishDto> find(@RequestParam String q) {
        if (!"glutenFree".equals(q.split(":")[0])) {
            throw new BadRequestException("query param q is incorrect, missing 'glutenFree:'");
        }
        return this.dishBusinessController.findByGlutenFree(Boolean.parseBoolean(q.split(":")[1]));
    }
}
