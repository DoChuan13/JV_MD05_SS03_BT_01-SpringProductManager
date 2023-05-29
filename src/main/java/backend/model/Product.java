package backend.model;

public class Product {
    private int id;
    private String productName;
    private float price;
    private String description;
    private String manufacture;

    public Product() {
    }

    public Product(int id, String productName, float price, String description, String manufacture) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.manufacture = manufacture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", manufacture='" + manufacture + '\'' +
                '}';
    }
}
