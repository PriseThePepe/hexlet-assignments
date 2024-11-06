package exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.data.domain.Sort;

import java.util.Comparator;
import java.util.List;

import exercise.model.Product;
import exercise.repository.ProductRepository;
import exercise.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductRepository productRepository;

    // BEGIN
    @GetMapping
    public List<Product> index(@RequestParam(required = false) Integer min,
                               @RequestParam(required = false) Integer max) {
        List<Product> products;
        if(min!=null&& max!=null) {
            products = productRepository.findByPriceBetween(min,max);
        } else if (min != null) {
            products = productRepository.findByPriceGreaterThan(min);
        } else if (max != null) {
            products = productRepository.findByPriceLessThan(max);
        }
        else
            products = productRepository.findAll();
        products.sort(Comparator.comparing(Product::getPrice));
        return products;
    }
    // END

    @GetMapping(path = "/{id}")
    public Product show(@PathVariable long id) {

        var product =  productRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));

        return product;
    }
}
