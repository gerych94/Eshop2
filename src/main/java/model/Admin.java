package model;

import javax.persistence.*;

/**
 * Created by Vitaliy on 17.08.2015.
 */
@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int admin_id;
    @Column
    private String login;
    @Column
    private String password;

    public Admin(){
    }

    public Admin(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "admin_id=" + admin_id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
