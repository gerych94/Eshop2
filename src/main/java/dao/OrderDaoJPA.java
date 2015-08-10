package dao;

import model.Order;
import model.OrderStatus;
import utils.ConnectionJPA;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * Created by Vitaliy on 07.08.2015.
 */
public class OrderDaoJPA implements IOrderDao {


    private EntityManager entityManager;

    public OrderDaoJPA(){
        this.entityManager= ConnectionJPA.getEntityManagerFactory().createEntityManager();
    }

    @Override
    public void add(Order order) {
        entityManager.getTransaction().begin();
        entityManager.persist(order);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateStatus(Order order) {
          entityManager.getTransaction().begin();
        Query query=entityManager.createQuery("update Order o set orderStatus='"+ OrderStatus.DONE+"'"+
                "where o.id_Order="+String.valueOf(order.getId_Order()));
        query.executeUpdate();
        entityManager.getTransaction().commit();
    }

    @Override
    public Order get(int id) {
        entityManager.getTransaction().begin();
        Order order=entityManager.find(Order.class,id);
        entityManager.getTransaction().commit();
        return order;
    }
}
