package DemoBackend.demo.service;

import DemoBackend.demo.model.Product;

import java.util.List;


public interface ProductService {

    List<Product> getAllProduct();

    Product getProductById(Integer id);

    void addProduct(Product product);

    Product updateProduct(Product product);

    void deleteProduct(Integer id);
}
