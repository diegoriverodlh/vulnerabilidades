package es.storeapp.business.repositories;

import es.storeapp.business.entities.Comment;

import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class CommentRepository extends AbstractRepository<Comment>{

    private static final String COUNT_BY_USER_AND_PRODUCT_QUERY = "SELECT COUNT(c) FROM Comment c WHERE c.user.id = :userId AND c.product.id = :productId";
    
    private static final String FIND_BY_USER_AND_PRODUCT_QUERY = "SELECT c FROM Comment c WHERE c.user.id = :userId AND c.product.id = :productId";
    
    public Integer countByUserAndProduct(Long userId, Long productId) {
        Query query = entityManager.createQuery(COUNT_BY_USER_AND_PRODUCT_QUERY);
        query.setParameter("userId", userId);
        query.setParameter("productId", productId);
        return ((Number) query.getSingleResult()).intValue();
    }
    
    public Comment findByUserAndProduct(Long userId, Long productId) {
        Query query = entityManager.createQuery(FIND_BY_USER_AND_PRODUCT_QUERY);
        query.setParameter("userId", userId);
        query.setParameter("productId", productId);
        return (Comment) query.getSingleResult();
    }
    
}
