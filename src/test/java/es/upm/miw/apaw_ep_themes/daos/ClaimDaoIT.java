package es.upm.miw.apaw_ep_themes.daos;

import es.upm.miw.apaw_ep_themes.TestConfig;
import es.upm.miw.apaw_ep_themes.documents.Claim;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class ClaimDaoIT {

    @Autowired
    private ClaimDao claimDao;

    private Claim claim;

    @BeforeEach
    void before() {
        this.claim = new Claim("The food was cold.");
        this.claimDao.save(claim);
    }

    @Test
    void testRead() {
        Claim databaseClaim = this.claimDao.findById(claim.getId()).orElseGet(Assertions::fail);
        assertTrue(databaseClaim.getLocalDateTime().isBefore(LocalDateTime.now()) &&
                databaseClaim.isProcessed() == false);
    }
}
