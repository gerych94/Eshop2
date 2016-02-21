package service;

import dao.IOrderDao;
import model.Order;



/**
 * Created by Vitaliy on 07.08.2015.
 */

public class OrderService implements IOrderService {

    private IOrderDao iOrderDao;

    public OrderService(IOrderDao iOrderDao){
        this.iOrderDao=iOrderDao;
    }

    @Override
    public void addOrder(Order order) {
        iOrderDao.add(order);
    }

    @Override
    public void buy(Order order) {
       iOrderDao.updateStatus(order);
    }

    @Override
    public Order getOrder(int id) {
      return  iOrderDao.get(id);
    }
}
