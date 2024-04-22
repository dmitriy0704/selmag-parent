package my.home.catalogue.repository;

import my.home.catalogue.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends CrudRepository<Product, Integer> {
//    List<Product> findAll();
//    Product save(Product product);
//    Optional<Product> findById(Integer productId);
//    void deleteById(Integer id);

//    @Query(value = "select p from Product p where p.title ilike :filter") //JPQL запрос
//    @Query(value = "select * from catalogue.t_product where c_title ilike :filter", nativeQuery = true) //SQL запрос
//    @Query(name = "Product.findAllByTitleLikeIgnoringCase") //именнованый запрос

    Iterable<Product> findAllByTitleLikeIgnoreCase(@Param("filter") String filter);
}
