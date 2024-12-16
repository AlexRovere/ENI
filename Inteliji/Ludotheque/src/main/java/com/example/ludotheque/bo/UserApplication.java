package com.example.ludotheque.bo;

public class UserApplication {
    private int id;
    private String login;
    private String password;
    private String roles;

    public UserApplication(int id,String login, String password, String roles) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.roles = roles;
    }

    public UserApplication(String login, String password, String roles) {
        this.login = login;
        this.password = password;
        this.roles = roles;
    }

    public UserApplication() {
    }

    @Override
    public String toString() {
        return "UserApplication{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", roles='" + roles + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
