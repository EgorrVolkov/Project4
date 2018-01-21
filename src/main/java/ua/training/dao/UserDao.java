package ua.training.dao;

import ua.training.entity.User;

import java.sql.SQLException;

public interface UserDao extends CrudDao<User, Long> {
    User findByLogin(String login) throws SQLException;
    String getRoleNameByUserId(Long userId) throws SQLException;
}
