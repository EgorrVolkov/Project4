package ua.training.dao.factory;

import ua.training.dao.RoleDao;
import ua.training.dao.UserDao;

import java.sql.Connection;

public abstract class DaoFactory {

    public abstract RoleDao createRoleDao();

    public abstract UserDao createUserDao();

    public static DaoFactory getDaoFactory(Connection connection) {
        return MySqlDaoFactory.getInstance(connection);
    }
}
