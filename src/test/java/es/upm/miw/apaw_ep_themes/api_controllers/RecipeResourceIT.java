package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.ApiTestConfig;
import es.upm.miw.apaw_ep_themes.dtos.RecipeBasicDto;
import es.upm.miw.apaw_ep_themes.dtos.RecipeCreationDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

@ApiTestConfig
public class RecipeResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    RecipeBasicDto createRecipe(List<String> steps) {
        return this.webTestClient
                .post().uri(RecipeResource.RECIPES)
                .body(BodyInserters.fromObject(new RecipeCreationDto(steps)))
                .exchange()
                .expectStatus().isOk()
                .expectBody(RecipeBasicDto.class)
                .returnResult().getResponseBody();
    }

    @Test
    void testCreate() {
        RecipeBasicDto recipeBasicDto = this.createRecipe(Arrays.asList(
                "Cut tomato into slices.",
                "Cut fresh cheese into slices.",
                "Dress with olive oil extra virgin.",
                "Garnish with basil leaves."
        ));
        assertFalse(recipeBasicDto.getSteps().isEmpty());
    }


    @Test
    void testCreateStepsException() {
        RecipeCreationDto recipeCreationDto = new RecipeCreationDto(new ArrayList<>());
        this.webTestClient
                .post().uri(RecipeResource.RECIPES)
                .body(BodyInserters.fromObject(recipeCreationDto))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }
}
