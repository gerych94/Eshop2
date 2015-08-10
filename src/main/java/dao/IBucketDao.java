package dao;

import model.Bucket;

/**
 * Created by Vitaliy on 07.08.2015.
 */
public interface IBucketDao {


    void add(Bucket bucket);

    Bucket get(int id);

}
