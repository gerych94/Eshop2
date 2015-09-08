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
    public List<Product> findProduct(String name) {
        List<Product> productList=null;
         try {
            productList=productDao.findOne(name);
              }catch (Exception e){
             System.out.println("productList doesn't exist");
           }
        return productList;
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
    public List<Product> findAll() {
         List<Product> productList=null;
        productList=productDao.findAll();

        return productList;
    }
}
