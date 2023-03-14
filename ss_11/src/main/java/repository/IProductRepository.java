package repository;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    void save(Product product);
    void update(int id, Product product);
    void remove(int id);
    Product display(int id);
    List<Product> findProduct(String name);
}
