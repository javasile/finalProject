package DemoBackend.demo.repository;

import DemoBackend.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAllProducts();
    Optional<Product> findProductById();
    Optional<Product> findProductByIdAndName();

}
