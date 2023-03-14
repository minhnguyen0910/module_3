package model;

public class Product {
   private int id;
   private String name;
   private double price;
   private String image;
   private String productDetails;
   private String producer;

    public Product() {
    }

    public Product(int id, String name, double price, String image, String productDetails,String producer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.productDetails=productDetails;
        this.producer=producer;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(String productDetails) {
        this.productDetails = productDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
