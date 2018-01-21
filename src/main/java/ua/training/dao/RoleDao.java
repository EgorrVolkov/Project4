package ua.training.dao;

import ua.training.entity.Role;

import java.sql.SQLException;

public interface RoleDao extends CrudDao<Role, Long> {
    Role findByName(String value) throws SQLException;

    Role findByUser(Long userId) throws SQLException;
}
