package DemoBackend.demo.service;

import DemoBackend.demo.model.Product;
import DemoBackend.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;


    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }


    @Override
    public Product getProductById(Integer id) {
        return productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found!"));
    }

    @Override
    public Product addProduct(@Valid Product product) {

        productRepository.findById(product.getId()).orElseThrow(() -> new IllegalArgumentException("Product already exists!"));
        return productRepository.save(product);
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
