package ua.training.dao;

import ua.training.entity.Role;

import java.sql.SQLException;
import java.util.List;

public interface RoleDao extends CrudDao<Role, Long> {
    Role findByName(String value) throws SQLException;

    List<Role> findByUser(Long userId) throws SQLException;
}
