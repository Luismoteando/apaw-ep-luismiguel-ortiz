package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.ApiTestConfig;
import es.upm.miw.apaw_ep_themes.dtos.IngredientBasicDto;
import es.upm.miw.apaw_ep_themes.dtos.IngredientCreationDto;
import es.upm.miw.apaw_ep_themes.dtos.IngredientPatchDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ApiTestConfig
class IngredientResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    IngredientBasicDto createIngredient(String name) {
        IngredientCreationDto ingredientCreationDto =
                new IngredientCreationDto(name, 1.0, "lbs");
        return this.webTestClient
                .post().uri(IngredientResource.INGREDIENTS)
                .body(BodyInserters.fromObject(ingredientCreationDto))
                .exchange()
                .expectStatus().isOk()
                .expectBody(IngredientBasicDto.class)
                .returnResult().getResponseBody();
    }

    @Test
    void testCreate() {
        IngredientBasicDto ingredientBasicDto = createIngredient("tomato");
        assertEquals("tomato", ingredientBasicDto.getName());
    }

    @Test
    void testCreateIngredientException() {
        IngredientCreationDto ingredientCreationDto =
                new IngredientCreationDto(null, -0.5, null);
        this.webTestClient
                .post().uri(IngredientResource.INGREDIENTS)
                .body(BodyInserters.fromObject(ingredientCreationDto))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void testPatchPortion() {
        String id = createIngredient("potato").getId();
        this.webTestClient
                .patch().uri(IngredientResource.INGREDIENTS + IngredientResource.ID_ID, id)
                .body(BodyInserters.fromObject(new IngredientPatchDto("portion", "2.0")))
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testPatchPortionException() {
        String id = createIngredient("potato").getId();
        this.webTestClient
                .patch().uri(IngredientResource.INGREDIENTS + IngredientResource.ID_ID, id)
                .body(BodyInserters.fromObject(new IngredientPatchDto(null, "2.0")))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }
}
