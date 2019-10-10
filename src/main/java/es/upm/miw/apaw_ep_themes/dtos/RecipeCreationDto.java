package es.upm.miw.apaw_ep_themes.dtos;

import es.upm.miw.apaw_ep_themes.exceptions.BadRequestException;

import java.util.List;

public class RecipeCreationDto {

    private List<String> steps;

    public RecipeCreationDto() {
        // Empty for framework
    }

    public RecipeCreationDto(List<String> steps) {
        this.steps = steps;
    }

    public List<String> getSteps() {
        return steps;
    }

    public void setSteps(List<String> steps) {
        this.steps = steps;
    }

    public void validate() {
        if (this.steps.isEmpty()) {
            throw new BadRequestException("Incomplete RecipeCreationDto");
        }
    }

    @Override
    public String toString() {
        return "RecipeCreationDto{" +
                "steps=" + steps +
                '}';
    }
}
