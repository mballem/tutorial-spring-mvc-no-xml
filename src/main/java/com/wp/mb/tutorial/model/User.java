package com.wp.mb.tutorial.model;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Marcio Ballem
 * Date: 10/10/12
 * Time: 14:56
 * To change this template use File | Settings | File Templates.
 */
public class User implements Serializable {

    private long id;
    private String name;
    private String login;
    private String pass;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
