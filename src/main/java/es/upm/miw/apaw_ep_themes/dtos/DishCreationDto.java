package es.upm.miw.apaw_ep_themes.dtos;

import es.upm.miw.apaw_ep_themes.exceptions.BadRequestException;

public class DishCreationDto {

    String name;

    boolean glutenFree;

    public DishCreationDto() {
        //Empty for framework
    }

    public DishCreationDto(String name, boolean glutenFree) {
        this.name = name;
        this.glutenFree = glutenFree;
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

    public void validate() {
        if (this.name == null) {
            throw new BadRequestException("Incomplete DishCreationDto");
        }
    }

    @Override
    public String toString() {
        return "DishCreationDto{" +
                "name='" + name + '\'' +
                ", glutenFree=" + glutenFree +
                '}';
    }
}
