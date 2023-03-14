package service;

import model.Product;
import repository.IProductRepository;
import repository.ProductRepository;

import java.util.List;

public class ProductService implements IProductService {
    IProductRepository products = new ProductRepository();

    @Override
    public List<Product> findAll() {
        return products.findAll();
    }

    @Override
    public void save(Product product) {
        products.save(product);
    }

    @Override
    public void update(int id, Product product) {
        products.update(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);

    }

    @Override
    public Product display(int id) {
        return products.display(id);
    }

    @Override
    public List<Product> findProduct(String name) {
        return products.findProduct(name);
    }
}
