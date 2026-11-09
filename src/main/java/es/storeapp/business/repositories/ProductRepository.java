package es.storeapp.business.repositories;

import es.storeapp.business.entities.Product;

import java.text.MessageFormat;
import java.util.Set;
import java.util.List;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository extends AbstractRepository<Product> {
    
    private static final String FIND_BY_CATEGORY_QUERY = "SELECT p FROM Product p WHERE p.category.name = :category";
    private static final java.util.Set<String> ALLOWED_ORDER_COLUMNS = java.util.Set.of("price","name","rating");
    
    @SuppressWarnings("unchecked")
    public List<Product> findByCategory(String category, String orderColumn) {
        Query query = entityManager.createQuery(MessageFormat.format(FIND_BY_CATEGORY_QUERY,
                category, orderColumn));
        return (List<Product>) query.getResultList();
    }
    
}
