package dao;

import model.Order;

/**
 * Created by Vitaliy on 07.08.2015.
 */
public interface IOrderDao {


    void add(Order order);

    void updateStatus(Order order);

    Order get(int id);

}
