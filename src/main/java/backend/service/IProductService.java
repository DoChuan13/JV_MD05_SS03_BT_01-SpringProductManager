package backend.service;

import backend.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    Product findById(int id);

    void save(Product product);

    void deleteById(int id);

    int generateLinearId();
}
