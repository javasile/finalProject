package DemoBackend.demo.service;

import DemoBackend.demo.model.Product;
import DemoBackend.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

//import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
//@Validated
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }


    @Override
    public Product getProductById(Integer id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product not found!"));
    }

    @Override
    public void addProduct( Product product) {
        Optional<Product> productop = productRepository.findById(product.getId());
        if(productop.isPresent())
            throw new IllegalArgumentException("Product already exists!");

             productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        this.getProductById(product.getId());
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        this.getProductById(id);
        productRepository.deleteById(id);
    }
//    private void checkProduct(String message) {
//        throw new IllegalArgumentException(message);
//
//    }

}
