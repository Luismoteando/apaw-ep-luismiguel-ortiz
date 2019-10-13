package es.upm.miw.apaw_ep_themes.daos;

import es.upm.miw.apaw_ep_themes.TestConfig;
import es.upm.miw.apaw_ep_themes.documents.Claim;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class ClaimDaoIT {

    @Autowired
    private ClaimDao claimDao;

    private Claim claim;

    @Test
    void testRead() {
        claim = this.claimDao.findAll().get(0);
        assertTrue(claim.getLocalDateTime().isBefore(LocalDateTime.now()) &&
                claim.isProcessed() == false);
    }
}
