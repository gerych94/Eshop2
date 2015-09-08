package service;

import dao.IAdminDao;
import model.Admin;

/**
 * Created by Vitaliy on 17.08.2015.
 */
public class AdminService implements IAdminService {


    private IAdminDao iAdminDao;

    public AdminService(IAdminDao iAdminDao){
        this.iAdminDao=iAdminDao;
    }
    @Override
    public Admin signIn(String login, String password) {
        return iAdminDao.validation(login,password);
    }

    @Override
    public void register(Admin admin) {
        iAdminDao.add(admin);
    }
}
