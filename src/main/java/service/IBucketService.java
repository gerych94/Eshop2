package service;

import model.Bucket;

/**
 * Created by Vitaliy on 07.08.2015.
 */
public interface IBucketService {


    void addBucket(Bucket bucket);

    Bucket getBucket(int id);

}
