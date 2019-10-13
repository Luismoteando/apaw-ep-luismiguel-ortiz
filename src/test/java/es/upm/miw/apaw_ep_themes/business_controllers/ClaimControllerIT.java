package es.upm.miw.apaw_ep_themes.business_controllers;

import es.upm.miw.apaw_ep_themes.TestConfig;
import es.upm.miw.apaw_ep_themes.daos.ClaimDao;
import es.upm.miw.apaw_ep_themes.dtos.ClaimPatchDto;
import es.upm.miw.apaw_ep_themes.exceptions.BadRequestException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertThrows;

@TestConfig
public class ClaimControllerIT {

    @Autowired
    private ClaimBusinessController claimBusinessController;

    @Autowired
    private ClaimDao claimDao;

    @Test
    void testPatchException() {
        String id = this.claimDao.findAll().get(0).getId();
        ClaimPatchDto claimPatchDto = new ClaimPatchDto("localDateTime", "13/10/19");
        assertThrows(BadRequestException.class, () -> this.claimBusinessController.patch(id, claimPatchDto));
    }
}
