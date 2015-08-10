package service;

import dao.IUserDao;
import model.Client;

import java.util.List;

/**
 * Created by Vitaliy on 23.07.2015.
 */
public class UserService implements IUserService {
    IUserDao userDao;

    public UserService(IUserDao userDao){
        this.userDao=userDao;
    }

    @Override
    public void register(Client client) {
         userDao.create(client);
    }



    @Override
    public void remove(int id) {
           userDao.delete(id);
    }

    @Override
    public void findByLogin(String login) {
        try {
            System.out.println(userDao.search(login).toString());

        }catch (Exception e){
            System.out.println("user doesn't exist");
        }

    }

    @Override
    public Client findById(int id_client) {
        try {
           return userDao.search(id_client);
        }catch (Exception e){
            System.out.println("user doesn't exist");
        }
        return null;
    }

    @Override
    public void showAllClients() {
        try{
            List<Client> clientList=userDao.findAll();
            for (Client c:clientList){
                System.out.println(c.toString());
            }
        }catch (Exception e){
            System.out.println("set is Empty");
        }
    }
}
