package es.upm.miw.apaw_ep_themes.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class Recipe {

    @Id
    private String id;

    private List<String> steps;

    private ArrayList<Ingredient> ingredients;

    public Recipe(List<String> steps) {
        this.steps = steps;
        this.ingredients = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public List<String> getSteps() {
        return steps;
    }

    public List<Ingredient> getIngredients() {
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
