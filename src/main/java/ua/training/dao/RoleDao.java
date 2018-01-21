package ua.training.dao;

import ua.training.entity.Role;

import java.sql.SQLException;

public interface RoleDao extends CrudDao<Role, Long> { // TODO ?
    Role findByUser(Long userId) throws SQLException;
}
