package es.upm.miw.apaw_ep_themes.daos;

import es.upm.miw.apaw_ep_themes.documents.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecipeDao extends MongoRepository<Recipe, String> {
}