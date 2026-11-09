package es.storeapp.business.repositories;

import es.storeapp.business.entities.*;
import java.text.MessageFormat;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class OrderLineRepository extends AbstractRepository<OrderLine>{

    private static final String FIND_BY_USER_AND_PRODUCT_QUERY = "SELECT COUNT(o) FROM OrderLine o WHERE o.order.state = es.storeapp.business.entities.OrderState.COMPLETED AND o.order.user.id = :userId AND o.product.id = :productId";

    public boolean findIfUserBuyProduct(Long userId, Long productId) {
        Query query = entityManager.createQuery(FIND_BY_USER_AND_PRODUCT_QUERY);
        query.setParameter("userId", userId);
        query.setParameter("productId", productId);
        return ((Number) query.getSingleResult()).longValue() > 0;
    }
    
}
