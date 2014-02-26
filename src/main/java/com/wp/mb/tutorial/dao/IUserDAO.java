package com.wp.mb.tutorial.dao;

import com.wp.mb.tutorial.model.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Marcio Ballem
 * Date: 10/10/12
 * Time: 14:58
 * To change this template use File | Settings | File Templates.
 */
public interface IUserDAO {
    void save(User user);

    List<User> findAll();
}
