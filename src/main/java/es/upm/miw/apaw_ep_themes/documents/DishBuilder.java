package es.upm.miw.apaw_ep_themes.documents;

public class DishBuilder {

    private String name;

    private boolean glutenFree;

    private Recipe recipe;

    public DishBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public DishBuilder setGlutenFree(boolean glutenFree) {
        this.glutenFree = glutenFree;
        return this;
    }

    public DishBuilder setRecipe(Recipe recipe) {
        this.recipe = recipe;
        return this;
    }

    public Dish createDish() {
        return new Dish(name, glutenFree, recipe);
    }
}