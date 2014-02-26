package com.wp.mb.tutorial.dao;

import com.wp.mb.tutorial.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Marcio Ballem
 * Date: 10/10/12
 * Time: 14:59
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class UserDAO implements IUserDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        createTable();
    }

    @Override
    public void save(User user) {
        String sql =
                "insert into USERS (name, login, pass) " +
                "values (?,?,?)";

        jdbcTemplate.update(sql, user.getName(), user.getLogin(), user.getPass());
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("select * from Users", new UserMapper());
    }

    private static final class UserMapper implements RowMapper<User> {

        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId((Long) rs.getObject("id"));
            user.setName(rs.getString("name"));
            user.setLogin(rs.getString("login"));
            user.setPass(rs.getString("pass"));
            return user;
        }
    }

    private void createTable() {
        String sql =
                "CREATE TABLE IF NOT EXISTS USERS ("+
                "  id bigint(10) NOT NULL AUTO_INCREMENT," +
                "  name varchar(25) NOT NULL," +
                "  login varchar(25) NOT NULL UNIQUE," +
                "  pass varchar(8) NOT NULL," +
                "  PRIMARY KEY (ID)" +
                ");";

        jdbcTemplate.execute(sql);
    }
}
