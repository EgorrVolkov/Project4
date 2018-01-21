package ua.training.dao.factory;

import ua.training.dao.*;
import ua.training.dao.impl.*;

import java.sql.Connection;

public class MySqlDaoFactory extends DaoFactory {
    private Connection connection;

    private MySqlDaoFactory(Connection connection) {
        this.connection = connection;
    }

    @Override
    public RoleDao createRoleDao() {
        return RoleDaoImpl.getInstance(connection);
    }

    @Override
    public UserDao createUserDao() {
        return UserDaoImpl.getInstance(connection);
    }

    public static MySqlDaoFactory getInstance(Connection connection) {
        return new MySqlDaoFactory(connection);
    }

}
