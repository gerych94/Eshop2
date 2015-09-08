package service;

import model.Admin;

/**
 * Created by Vitaliy on 17.08.2015.
 */
public interface IAdminService {

    Admin signIn(String login,String password);

    void register(Admin admin);
}
