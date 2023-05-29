package backend.service;

import backend.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceIMPL implements IProductService {
    private static final List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Macbook", 2400, "Laptop", "Apple"));
        productList.add(new Product(2, "Galaxy", 1400, "Mobile", "Samsung"));
        productList.add(new Product(3, "Iphone", 1400, "Mobile", "Apple"));
        productList.add(new Product(4, "XPS", 2000, "Laptop", "Dell"));
        productList.add(new Product(5, "Windows", 400, "Software", "Microsoft"));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public Product findById(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void save(Product product) {
        Product current = findById(product.getId());
        if (current == null) {
            productList.add(product);
        } else {
            int index = productList.indexOf(current);
            productList.set(index, product);
        }
    }

    @Override
    public void deleteById(int id) {
        Product current = findById(id);
        if (current != null) {
            productList.remove(current);
        }
    }

    @Override
    public int generateLinearId() {
        int id = 0;
        if (productList.size() != 0) {
            for (Product product : productList) {
                if (product.getId() > id) {
                    id = product.getId();
                }
            }
        }
        return ++id;
    }
}
