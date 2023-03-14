package repository;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    static List<Product> products;

    static {
        products = new ArrayList<>();
        products.add(new Product(1, "Acer", 20000000, "https://cdn.tgdd.vn/Files/2019/10/24/1211933/c9_800x450.jpg"));
        products.add(new Product(2, "Asus", 25000000, "https://minhancomputercdn.com/media/product/10444_asus_vivobook_15x_oled_a1503za_l1422w_2.jpg"));
        products.add(new Product(3, "Macbook", 30000000, "https://maytinhvui.com/wp-content/uploads/2021/02/Hinh-nen-mac-book-thumb.jpg"));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public void update(int id, Product product) {
        products.remove(id);
        products.add(product);
    }

    @Override
    public void remove(int id) {
        for (Product product:products){
            if (product.getId()==id){
                products.remove(product);
                return;
            }
        }
    }

    @Override
    public Product display(int id) {
        Product product=null;
        for (Product product1:products){
            if (product1.getId()==id){
                product=product1;
            }
        }
        return product;
    }

    @Override
    public List<Product> findProduct(String name) {
        List<Product> productList=new ArrayList<>();
        for (Product product:products){
            if (product.getName().equals(name)){
                productList.add(product);
            }
        }
        return productList;
    }
}
