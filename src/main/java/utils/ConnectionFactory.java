package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Vitaliy on 22.07.2015.
 */
public class ConnectionFactory {

    private static final String URL="jdbc:mysql://localhost:3306/ehop2";
    private static final String USER="root";
    private static final String PASSWORD="1111";


    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
      public static Connection getConnection(){
          try {
              return DriverManager.getConnection(URL,USER,PASSWORD);
          } catch (SQLException e) {
              e.printStackTrace();
          }
          return null;
      }



}
