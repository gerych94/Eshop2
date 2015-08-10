package service;

import model.Product;
import model.ProductType;

import java.util.List;

/**
 * Created by Vitaliy on 05.08.2015.
 */
public interface IProductService {


    void add(Product product);

    void buy(int id);

    void buy(String name);

    void findProduct(String name);
    Product findOne(int id);
    void findAll();
}
