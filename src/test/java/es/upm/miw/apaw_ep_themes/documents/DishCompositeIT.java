package es.upm.miw.apaw_ep_themes.documents;

import es.upm.miw.apaw_ep_themes.TestConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class DishCompositeIT {

    private Dish dish;

    private DishComposite dishComposite;

    @BeforeEach
    void before() {
        dish = new Dish("chocolate brownie", false, null);
        dishComposite = new DishComposite();
        dishComposite.add(dish);
    }

    @Test
    void testIsLeaf() {
        assertFalse(dish.isComposite());
    }

    @Test
    void testIsComposite() {
        assertTrue(dishComposite.isComposite());
    }

    @Test
    void testRemoveDish() {
        dishComposite.remove(dish);
        assertTrue(dishComposite.getDishes().isEmpty());
    }
}
