package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.ApiTestConfig;
import es.upm.miw.apaw_ep_themes.dtos.RecipeBasicDto;
import es.upm.miw.apaw_ep_themes.dtos.RecipeCreationDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.ArrayList;

@ApiTestConfig
public class RecipeResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    String createRecipe() {
        ArrayList<String> steps = new ArrayList<>();
        steps.add("Cut tomato into slices.");
        steps.add("Dress with olive oil extra virgin.");
        return this.webTestClient
                .post().uri(RecipeResource.RECIPES)
                .body(BodyInserters.fromObject(new RecipeCreationDto(steps)))
                .exchange()
                .expectStatus().isOk()
                .expectBody(RecipeBasicDto.class)
                .returnResult().getResponseBody().getId();
    }

    @Test
    void testCreate() {
        this.createRecipe();
    }
}
