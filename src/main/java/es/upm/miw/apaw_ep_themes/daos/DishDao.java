package es.upm.miw.apaw_ep_themes.daos;

import es.upm.miw.apaw_ep_themes.documents.Dish;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DishDao extends MongoRepository<Dish, String> {
}
