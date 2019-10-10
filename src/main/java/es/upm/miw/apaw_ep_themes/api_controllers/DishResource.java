package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.business_controllers.DishBusinessController;
import es.upm.miw.apaw_ep_themes.dtos.DishBasicDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(DishResource.DISHES)
public class DishResource {

    public static final String DISHES = "/dishes";
    public static final String ID_ID = "/{id}";

    private DishBusinessController dishBusinessController;

    @Autowired
    public DishResource(DishBusinessController dishBusinessController) {
        this.dishBusinessController = dishBusinessController;
    }

    @GetMapping(value = ID_ID)
    public DishBasicDto read(@PathVariable String id) {
        return this.dishBusinessController.read(id);
    }
}
