package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.ApiTestConfig;
import es.upm.miw.apaw_ep_themes.daos.DishDao;
import es.upm.miw.apaw_ep_themes.dtos.DishDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@ApiTestConfig
public class DishResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private DishDao dishDao;

    @Test
    void testRead() {
        String id = this.dishDao.findAll().get(0).getId();
        DishDto dishDto = this.webTestClient
                .get().uri(DishResource.DISHES + DishResource.ID_ID, id)
                .exchange()
                .expectStatus().isOk()
                .expectBody(DishDto.class)
                .returnResult().getResponseBody();
        assertEquals("Tomato and fresh cheese salad", dishDto.getName());
    }

    @Test
    void testSearch() {
        List<DishDto> dishDtos = this.webTestClient
                .get().uri(uriBuilder ->
                        uriBuilder.path(DishResource.DISHES + DishResource.SEARCH)
                                .queryParam("q", "glutenFree:true")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(DishDto.class)
                .returnResult().getResponseBody();
        assertFalse(dishDtos.isEmpty());
    }

    @Test
    void testSearchException() {
        this.webTestClient
                .get().uri(uriBuilder ->
                uriBuilder.path(DishResource.DISHES + DishResource.SEARCH)
                        .queryParam("q", "lactose:false")
                        .build())
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }
}
