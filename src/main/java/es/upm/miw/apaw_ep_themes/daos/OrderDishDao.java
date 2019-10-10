package es.upm.miw.apaw_ep_themes.daos;

import es.upm.miw.apaw_ep_themes.documents.OrderDish;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderDishDao extends MongoRepository<OrderDish, String> {
}