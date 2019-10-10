package es.upm.miw.apaw_ep_themes.business_controllers;

import es.upm.miw.apaw_ep_themes.daos.ClaimDao;
import es.upm.miw.apaw_ep_themes.documents.Claim;
import es.upm.miw.apaw_ep_themes.dtos.ClaimPatchDto;
import es.upm.miw.apaw_ep_themes.exceptions.BadRequestException;
import es.upm.miw.apaw_ep_themes.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ClaimBusinessController {

    private ClaimDao claimDao;

    @Autowired
    public ClaimBusinessController(ClaimDao claimDao) {
        this.claimDao = claimDao;
    }

    public void patch(String id, ClaimPatchDto claimPatchDto) {
        Claim claim = this.findClaimByIdAssured(id);
        switch (claimPatchDto.getPath()) {
            case "processed":
                claim.setProcessed(Boolean.parseBoolean(claimPatchDto.getNewValue()));
                break;
            default:
                throw new BadRequestException("ClaimPatchDto is invalid");
        }
        this.claimDao.save(claim);
    }

    private Claim findClaimByIdAssured(String id) {
        return this.claimDao.findById(id).orElseThrow(() -> new NotFoundException("Claim id: " + id));
    }
}
