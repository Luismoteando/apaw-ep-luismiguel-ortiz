package es.upm.miw.apaw_ep_themes.documents;

import java.util.ArrayList;
import java.util.List;

public class DishComposite extends DishComponent {

    private List<Dish> dishes;

    public DishComposite() {
        this.dishes = new ArrayList<>();
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    @Override
    public void add(Dish dish) {
        this.dishes.add(dish);
    }

    @Override
    public void remove(Dish dish) {
        this.dishes.remove(dish);
    }

    @Override
    public boolean isComposite() {
        return true;
    }
}
