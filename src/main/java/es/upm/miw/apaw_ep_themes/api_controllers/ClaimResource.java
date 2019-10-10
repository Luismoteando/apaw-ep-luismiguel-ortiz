package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.business_controllers.ClaimBusinessController;
import es.upm.miw.apaw_ep_themes.dtos.ClaimPatchDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ClaimResource.CLAIMS)
public class ClaimResource {

    public static final String CLAIMS = "/claims";
    public static final String ID_ID = "/{id}";

    private ClaimBusinessController claimBusinessController;

    @Autowired
    public ClaimResource(ClaimBusinessController claimBusinessController) {
        this.claimBusinessController = claimBusinessController;
    }

    @PatchMapping(value = ID_ID)
    public void patch(@PathVariable String id, @RequestBody ClaimPatchDto claimPatchDto) {
        claimPatchDto.validate();
        this.claimBusinessController.patch(id, claimPatchDto);
    }
}
