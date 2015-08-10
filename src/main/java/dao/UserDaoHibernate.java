package dao;

import model.Client;
import org.hibernate.Query;
import org.hibernate.Session;
import utils.ConnectionHibernate;

import java.util.List;

/**
 * Created by Vitaliy on 24.07.2015.
 */
public class UserDaoHibernate implements IUserDao {

    private Session session;

    public UserDaoHibernate(){
              session= ConnectionHibernate.getSessionFactory().openSession();
    }


    @Override
    public void create(Client client) {
           session.beginTransaction();
        session.save(client);
           session.getTransaction().commit();
    }

    @Override
    public void delete(int id) {
        session.beginTransaction();
        try {
            Client client=(Client)session.get(Client.class,id);
            session.delete(client);
        }catch (Exception exeption){
            System.out.println("user doesn't exist");
        }
         session.getTransaction().commit();
    }

    @Override
    public Client search(String login) {
        session.beginTransaction();
            List<Client> list=(List<Client>)session.createCriteria(Client.class).list();
            for (Client c:list){
                if(c.getLogin().equals(login)){
                    return c;
                }
            }
          session.getTransaction().commit();
        return null;
    }

    @Override
    public Client search(int id) {
        session.beginTransaction();
        Client client=(Client)session.get(Client.class,id);
        return client;
    }

    @Override
    public List<Client> findAll() {
        session.beginTransaction();
        List<Client> list=session.createCriteria(Client.class).list();
        session.getTransaction().commit();
        return list;
    }
}
