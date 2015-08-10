package dao;

import model.Client;
import utils.ConnectionJPA;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Vitaliy on 04.08.2015.
 */
public class UserDaoJPA implements IUserDao{

    private EntityManager entityManager;

    public UserDaoJPA(){
        this.entityManager= ConnectionJPA.getEntityManagerFactory().createEntityManager();
    }
    @Override
    public void create(Client client) {
       entityManager.getTransaction().begin();
        entityManager.persist(client);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(int id) {
        entityManager.getTransaction().begin();
        Client client=entityManager.find(Client.class,id);
        entityManager.remove(client);
        entityManager.getTransaction().commit();
    }

    @Override
    public Client search(String login) {
        entityManager.getTransaction().begin();
        Query query=entityManager.createQuery("from Client c where login='" +login +"'");
        Client client=(Client)query.getSingleResult();
        entityManager.getTransaction().commit();
        return client;
    }

    @Override
    public Client search(int id) {
        entityManager.getTransaction().begin();
        Client client=entityManager.find(Client.class,id);
        entityManager.getTransaction().commit();
        return client;
    }

    @Override
    public List<Client> findAll() {
        entityManager.getTransaction().begin();
        Query query=entityManager.createQuery("from Client");
        List<Client> clientList=query.getResultList();
        entityManager.getTransaction().commit();
        return clientList;
    }
}
