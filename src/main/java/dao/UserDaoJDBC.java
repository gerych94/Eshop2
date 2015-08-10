package dao;

import model.Client;
import utils.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vitaliy on 22.07.2015.
 */
public class UserDaoJDBC implements IUserDao {


    private Connection connection;
    private PreparedStatement preparedStatement;
    private List<Client> clientList;

    public UserDaoJDBC() {
        connection = ConnectionFactory.getConnection();
        preparedStatement = null;
    }

    @Override
    public void create(Client client) {
        try {
            preparedStatement = connection.prepareStatement("INSERT  INTO clients(name,login,phone,email,password)" +
                    " VALUES (?,?,?,?,?)");
            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getLogin());
            preparedStatement.setString(3, client.getPhone());
            preparedStatement.setString(4, client.getEmail());
            preparedStatement.setString(5, client.getPassword());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM clients WHERE id_client=" + String.valueOf(id));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Client search(String login) {
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM clients");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                if (resultSet.getString("login").equals(login)) {
                    return new Client(resultSet.getString("name"), resultSet.getString("login"), resultSet.getString("phone"), resultSet.getString("email"), resultSet.getString("password"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Client search(int id) {

        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM clients");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                if (Integer.valueOf(resultSet.getString("id_client")) == id) {
                    return new Client(resultSet.getString("name"), resultSet.getString("login"), resultSet.getString("phone"), resultSet.getString("email"), resultSet.getString("password"));
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Client> findAll() {
        ResultSet resultSet=null;
        clientList=new ArrayList<>();
        try {
            preparedStatement=connection.prepareStatement("SELECT * FROM clients");
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                clientList.add(new Client(resultSet.getString("name"), resultSet.getString("login"), resultSet.getString("phone"), resultSet.getString("email"), resultSet.getString("password")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clientList;
    }
}
