package dao;

import model.Client;

import java.util.List;

/**
 * Created by Vitaliy on 22.07.2015.
 */
public interface IUserDao {

    void create(Client client);


    void delete(int id);

    Client search(String login);
    Client search(int id);

    List<Client> findAll();



}
