package utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Vitaliy on 04.08.2015.
 */
public class ConnectionJPA {

    private static EntityManagerFactory entityManagerFactory=null;

    public static EntityManagerFactory getEntityManagerFactory(){
        if(entityManagerFactory==null){
            entityManagerFactory= Persistence.createEntityManagerFactory("my-unit");
        }
        return entityManagerFactory;
    }
}
