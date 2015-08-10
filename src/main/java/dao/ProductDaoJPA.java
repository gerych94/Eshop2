package dao;

import model.Product;
import utils.ConnectionJPA;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Vitaliy on 05.08.2015.
 */
public class ProductDaoJPA implements IProductDao {

    private EntityManager entityManager;

    public ProductDaoJPA(){
        this.entityManager= ConnectionJPA.getEntityManagerFactory().createEntityManager();
    }
    @Override
    public void add(Product product) {
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(int id) {
       entityManager.getTransaction().begin();
        try {
            Product product=entityManager.find(Product.class,id);
            entityManager.remove(product);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            System.out.println("product doesn't exist");
        }


    }

    @Override
    public void delete(String name) {
          entityManager.getTransaction().begin();
        try{
            Query query=entityManager.createQuery("from Product p where p.name='"+name+"'");
            Product product=(Product)query.getSingleResult();
            entityManager.remove(product);
        }catch (Exception e){
            System.out.println("product doesn't exist");
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public Product findOne(int id) {
        entityManager.getTransaction().begin();

            Product product=entityManager.find(Product.class,id);
            entityManager.getTransaction().commit();
            return product;

    }

    @Override
    public List<Product> findOne(String name) {
        entityManager.getTransaction().begin();


            Query query=entityManager.createQuery("from Product p where p.name='"+name+"'");
            List<Product> productList=query.getResultList();
            entityManager.getTransaction().commit();
            return productList;

    }

    @Override
    public List<Product> findAll() {
        entityManager.getTransaction().begin();
        try {
            Query query=entityManager.createQuery("from Product");
            List<Product> productList=query.getResultList();
            entityManager.getTransaction().commit();
            return productList;
        }catch (Exception e){
            System.out.println("productList doesn't exist");
        }

        return null;
    }
}
