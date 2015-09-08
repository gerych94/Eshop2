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
    public void register(String name,String login,String phone,String email,String password) {
        Client client=new Client(name,login,phone,email,password);
         userDao.create(client);
    }



    @Override
    public void remove(int id) {
           userDao.delete(id);
    }

    @Override
    public Client findByLogin(String login) {
        try {

            return userDao.search(login);
        }catch (Exception e){
            System.out.println("user doesn't exist");
        }
         return null;
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
    public List<Client> showAllClients() {
        List<Client> clientList=null;
        try{
             clientList=userDao.findAll();
            for (Client c:clientList){
                System.out.println(c.toString());
            }
        }catch (Exception e){
            System.out.println("set is Empty");
        }
    return clientList;
    }

}
