package es.upm.miw.apaw_ep_themes.business_controllers;

import es.upm.miw.apaw_ep_themes.TestConfig;
import es.upm.miw.apaw_ep_themes.dtos.RecipeCreationDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.test.StepVerifier;

import java.util.Arrays;

@TestConfig
public class RecipeControllerIT {

    @Autowired
    private RecipeBusinessController recipeBusinessController;

    @Test
    void testPublisher() {
        StepVerifier
                .create(recipeBusinessController.publisher())
                .then(() -> recipeBusinessController.create(new RecipeCreationDto(
                        Arrays.asList(
                                "Melt the chocolate and butter in short intervals.",
                                "Add the sugar and a pinch of salt to the mixture.")
                )))
                .expectNext("New recipe available")
                .thenCancel()
                .verify();
    }
}
