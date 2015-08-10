package dao;

import model.Bucket;
import utils.ConnectionJPA;

import javax.persistence.EntityManager;

/**
 * Created by Vitaliy on 07.08.2015.
 */
public class BucketDaoJPA implements IBucketDao {

    private EntityManager entityManager;


    public BucketDaoJPA(){
        this.entityManager= ConnectionJPA.getEntityManagerFactory().createEntityManager();
    }

    @Override
    public void add(Bucket bucket) {
        entityManager.getTransaction().begin();
        entityManager.persist(bucket);
        entityManager.getTransaction().commit();
    }

    @Override
    public Bucket get(int id) {
        entityManager.getTransaction().begin();
        Bucket bucket=entityManager.find(Bucket.class,id);
        entityManager.getTransaction().commit();
        return bucket;
    }
}
