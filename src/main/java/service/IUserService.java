package service;

import model.Client;

import java.util.List;

/**
 * Created by Vitaliy on 23.07.2015.
 */
public interface IUserService {



       void register(String name,String login,String phone,String email,String password);


       void remove(int id);
       Client findByLogin(String login);
       Client findById(int id_client);

       List<Client> showAllClients();
}
