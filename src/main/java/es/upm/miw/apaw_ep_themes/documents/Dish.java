package es.upm.miw.apaw_ep_themes.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Dish {

    @Id
    String id;

    String name;

    boolean glutenFree;

    @DBRef
    Recipe recipe;

    public Dish(String name, boolean glutenFree, Recipe recipe) {
        this.name = name;
        this.glutenFree = glutenFree;
        this.recipe = recipe;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isGlutenFree() {
        return glutenFree;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", glutenFree=" + glutenFree +
                ", recipe=" + recipe +
                '}';
    }
}
