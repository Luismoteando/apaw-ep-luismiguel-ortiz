package es.upm.miw.apaw_ep_themes.dtos;

import es.upm.miw.apaw_ep_themes.exceptions.BadRequestException;

public class IngredientCreationDto {

    private String name;

    private double portion;

    private String unit;

    public IngredientCreationDto() {
        //Empty for framework
    }

    public IngredientCreationDto(String name, double portion, String unit) {
        this.name = name;
        this.portion = portion;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPortion() {
        return portion;
    }

    public void setPortion(double portion) {
        this.portion = portion;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void validate() {
        if (this.name == null || this.portion <= 0 || this.unit == null) {
            throw new BadRequestException("Incomplete IngredientCreationDto");
        }
    }

    @Override
    public String toString() {
        return "IngredientCreationDto{" +
                "name='" + name + '\'' +
                ", portion=" + portion +
                ", unit='" + unit + '\'' +
                '}';
    }
}
