package service;

import model.Client;

import java.util.List;

/**
 * Created by Vitaliy on 23.07.2015.
 */
public interface IUserService {



       void register(Client client);


       void remove(int id);
       void findByLogin(String login);
       Client findById(int id_client);

       void showAllClients();
}
