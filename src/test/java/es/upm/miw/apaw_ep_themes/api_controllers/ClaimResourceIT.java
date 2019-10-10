package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.ApiTestConfig;
import es.upm.miw.apaw_ep_themes.daos.ClaimDao;
import es.upm.miw.apaw_ep_themes.documents.Claim;
import es.upm.miw.apaw_ep_themes.dtos.ClaimPatchDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@ApiTestConfig
public class ClaimResourceIT {

    @Autowired
    private ClaimDao claimDao;

    @Autowired
    private WebTestClient webTestClient;

    private Claim claim;

    @BeforeEach
    void before() {
        this.claim = new Claim("The food was cold.");
        this.claimDao.save(claim);
    }

    @Test
    void testPatchProcessed() {
        String id = this.claimDao.findById(claim.getId()).get().getId();
        this.webTestClient
                .patch().uri(ClaimResource.CLAIMS + ClaimResource.ID_ID, id)
                .body(BodyInserters.fromObject(new ClaimPatchDto("processed", "true")))
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testPatchProcessedException() {
        String id = this.claimDao.findById(claim.getId()).get().getId();
        this.webTestClient
                .patch().uri(ClaimResource.CLAIMS + ClaimResource.ID_ID, id)
                .body(BodyInserters.fromObject(new ClaimPatchDto(null, "true")))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void testDelete() {
        String id = this.claimDao.findById(claim.getId()).get().getId();
        this.webTestClient
                .delete().uri(ClaimResource.CLAIMS + ClaimResource.ID_ID, id)
                .exchange()
                .expectStatus().isOk();
    }
}
