package service;

import model.Order;

/**
 * Created by Vitaliy on 07.08.2015.
 */
public interface IOrderService {

    void addOrder(Order order);

    void buy(Order order);

    Order getOrder(int id);
}
