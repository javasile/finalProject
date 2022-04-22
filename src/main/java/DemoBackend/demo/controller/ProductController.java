package DemoBackend.demo.controller;

import DemoBackend.demo.model.Product;
import DemoBackend.demo.service.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api")
//@RequiredArgsConstructor
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("/all")
//    @ResponseStatus(OK)
//    public List<Product> findAll() {
//        return productService.getAllProduct();
//    }
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(productService.getAllProduct());
    }

    @GetMapping(value = "/product/{id}")
    public Product getProductById(@PathVariable("id") Integer id) {
        return productService.getProductById(id);
    }

    @PutMapping("/editProduct")
    public void addProduct(@RequestBody Product product) {
        productService.updateProduct(product);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
    }

    @PatchMapping("/updateProduct")
    public void updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
    }

    @PostMapping("/newProduct")
    public void saveProduct(@RequestBody Product product) {
         productService.addProduct(product);
    }
}
