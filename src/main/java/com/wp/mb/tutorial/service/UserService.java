package com.wp.mb.tutorial.service;

import com.wp.mb.tutorial.dao.IUserDAO;
import com.wp.mb.tutorial.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Marcio Ballem
 * Date: 10/10/12
 * Time: 14:59
 * To change this template use File | Settings | File Templates.
 */
@Service
public class UserService {

    private final IUserDAO dao;

    @Autowired
    public UserService(IUserDAO dao) {
        this.dao = dao;
    }

    public void save(User user) {
        dao.save(user);
    }

    public List<User> findAll() {
        return dao.findAll();
    }
}
