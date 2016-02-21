package dao;

import model.Admin;
import utils.ConnectionJPA;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * Created by Vitaliy on 17.08.2015.
 */
public class AdminDaoJPA implements IAdminDao {

    private EntityManager entityManager;

    public AdminDaoJPA(){
        this.entityManager= ConnectionJPA.getEntityManagerFactory().createEntityManager();
    }

    @Override
    public Admin validation(String login, String password) {
        entityManager.getTransaction().begin();
        Query query=entityManager.createQuery("from Admin a where login='"+login+"' and password='"+password+"'");
        Admin admin=(Admin)query.getSingleResult();
        entityManager.getTransaction().commit();
        return admin;
    }

    @Override
    public void add(Admin admin) {
        entityManager.getTransaction().begin();
        entityManager.persist(admin);
        entityManager.getTransaction().commit();
    }

    @Override
    public Admin getAdmin() {
        entityManager.getTransaction().begin();
        Admin admin=entityManager.find(Admin.class,1);
        entityManager.getTransaction().commit();
        return admin;
    }

}
