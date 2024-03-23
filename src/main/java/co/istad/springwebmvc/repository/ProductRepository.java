package co.istad.springwebmvc.repository;

import co.istad.springwebmvc.dto.ProductResponse;
import co.istad.springwebmvc.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product , Integer> {
    Product findProductByUuid(String Uuid) ;
    Boolean existsByName(String name);
    Boolean existsByUuid(String Uuid);
    List<Product> findProductByNameAndStatus (String name , Boolean status);

}
