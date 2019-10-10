package es.upm.miw.apaw_ep_themes.dtos;

import es.upm.miw.apaw_ep_themes.exceptions.BadRequestException;

public class ClaimPatchDto {

    private String path;

    private String newValue;

    public ClaimPatchDto() {
        //Empty for framework
    }

    public ClaimPatchDto(String path, String newValue) {
        this.path = path;
        this.newValue = newValue;
    }

    public String getPath() {
        return path;
    }

    public String getNewValue() {
        return newValue;
    }

    public void validate() {
        if (this.path == null || this.path.isEmpty()) {
            throw new BadRequestException("Incomplete ClaimPatchDto");
        }
    }

    @Override
    public String toString() {
        return "ClaimPatchDto{" +
                "path='" + path + '\'' +
                ", newValue='" + newValue + '\'' +
                '}';
    }
}
