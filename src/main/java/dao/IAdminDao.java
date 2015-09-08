package dao;

import model.Admin;

/**
 * Created by Vitaliy on 17.08.2015.
 */
public interface IAdminDao {


    Admin validation(String login,String password);

    void add(Admin admin);
}
