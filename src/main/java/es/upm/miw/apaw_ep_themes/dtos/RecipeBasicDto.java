package es.upm.miw.apaw_ep_themes.dtos;

import es.upm.miw.apaw_ep_themes.documents.Recipe;

import java.util.List;

public class RecipeBasicDto {

    private String id;

    private List<String> steps;

    public RecipeBasicDto() {
        // Empty for framework
    }

    public RecipeBasicDto(Recipe recipe) {
        this.id = recipe.getId();
        this.steps = recipe.getSteps();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getSteps() {
        return steps;
    }

    public void setSteps(List<String> steps) {
        this.steps = steps;
    }

    @Override
    public String toString() {
        return "RecipeBasicDto{" +
                "id='" + id + '\'' +
                '}';
    }
}
