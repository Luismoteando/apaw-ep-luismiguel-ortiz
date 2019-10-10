package es.upm.miw.apaw_ep_themes.dtos;

import es.upm.miw.apaw_ep_themes.documents.Dish;

public class DishBasicDto {

    String id;

    String name;

    boolean glutenFree;

    public DishBasicDto() {
        //Empty for framework
    }

    public DishBasicDto(Dish dish) {
        this.id = dish.getId();
        this.name = dish.getName();
        this.glutenFree = dish.isGlutenFree();
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGlutenFree() {
        return glutenFree;
    }

    public void setGlutenFree(boolean glutenFree) {
        this.glutenFree = glutenFree;
    }

    @Override
    public String toString() {
        return "DishDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", glutenFree=" + glutenFree +
                '}';
    }
}
