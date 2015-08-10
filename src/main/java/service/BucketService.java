package service;

import dao.IBucketDao;
import model.Bucket;

/**
 * Created by Vitaliy on 07.08.2015.
 */
public class BucketService implements IBucketService {

    private IBucketDao iBucketDao;

    public BucketService(IBucketDao iBucketDao){
        this.iBucketDao=iBucketDao;
    }


    @Override
    public void addBucket(Bucket bucket) {
        iBucketDao.add(bucket);
    }

    @Override
    public Bucket getBucket(int id) {
        return iBucketDao.get(id);
    }
}
