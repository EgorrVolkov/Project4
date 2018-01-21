package ua.training.dao;

import ua.training.entity.User;

import java.sql.SQLException;

public interface UserDao extends CrudDao<User, Long> { // TODO ?
    User findByLogin(String login) throws SQLException;
}
