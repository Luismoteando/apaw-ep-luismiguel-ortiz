package es.upm.miw.apaw_ep_themes.daos;

import es.upm.miw.apaw_ep_themes.documents.Ingredient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IngredientDao extends MongoRepository<Ingredient, String> {
}

