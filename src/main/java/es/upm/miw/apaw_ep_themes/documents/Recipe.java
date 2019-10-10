package es.upm.miw.apaw_ep_themes.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class Recipe {

    @Id
    private String id;

    private ArrayList<String> steps;

    private ArrayList<Ingredient> ingredients;

    public Recipe(List<String> steps) {
        this.steps = new ArrayList<>();
        this.ingredients = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public ArrayList<String> getSteps() {
        return steps;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id='" + id + '\'' +
                ", steps=" + steps +
                ", ingredients=" + ingredients +
                '}';
    }
}
