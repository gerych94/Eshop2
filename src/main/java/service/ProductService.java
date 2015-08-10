package service;

import dao.IProductDao;
import model.Product;
import model.ProductType;

import java.util.List;

/**
 * Created by Vitaliy on 05.08.2015.
 */
public class ProductService implements IProductService {
    private IProductDao productDao;

    public ProductService(IProductDao productDao){
        this.productDao=productDao;
    }

    @Override
    public void add(Product product) {
        productDao.add(product);
    }

    @Override
    public void buy(int id) {


     productDao.delete(id);
    }

    @Override
    public void buy(String name) {
        productDao.delete(name);
    }

    @Override
    public void findProduct(String name) {
        List<Product> productList=productDao.findOne(name);

try {
    for (Product p:productList){
        System.out.println(p.toString());
    }
}catch (Exception e){
    System.out.println("productList doesn't exist");
}


    }

    @Override
    public Product findOne(int id) {
        try {
            return productDao.findOne(id);
        }catch (Exception e){
            System.out.println("product doesn't exist");
        }
            return null;
    }

    @Override
    public void findAll() {
         List<Product> productList=productDao.findAll();
        for (Product p:productList){
            System.out.println(p.toString());
        }
    }
}
