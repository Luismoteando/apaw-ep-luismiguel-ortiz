package es.upm.miw.apaw_ep_themes.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Ingredient {

    @Id
    private String id;

    private String name;

    private double portion;

    private String unit;

    public Ingredient(String name, double portion, String unit) {
        this.name = name;
        this.portion = portion;
        this.unit = unit;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getPortion() {
        return this.portion;
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", portion=" + portion +
                ", unit='" + unit + '\'' +
                '}';
    }
}
