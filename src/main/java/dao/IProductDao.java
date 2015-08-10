package dao;

import model.Product;

import java.util.List;

/**
 * Created by Vitaliy on 05.08.2015.
 */
public interface IProductDao {

    void add(Product product);
    void delete(int id);
    void delete(String name);
    Product findOne(int id);

    List<Product> findOne(String name);

    List<Product> findAll();
}
