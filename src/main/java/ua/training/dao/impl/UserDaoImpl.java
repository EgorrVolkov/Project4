package ua.training.dao.impl;

import ua.training.dao.AbstractDao;
import ua.training.dao.UserDao;
import ua.training.dao.util.QueryBuilder;
import ua.training.entity.User;
import ua.training.entity.proxy.UserProxy;

import java.sql.*;
import java.util.List;

import static ua.training.util.constant.table.UserConstants.*;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {

    private UserDaoImpl(Connection connection) {
        super(TABLE, connection);
    }

    @Override
    public User findByLogin(String login) throws SQLException {
        String query = new QueryBuilder()
                .selectAll()
                .from()
                .table(TABLE)
                .where()
                .condition(TABLE, LOGIN)
                .build();
        return getEntityByQuery(query, login);
    }

    @Override
    public void setUserRole(Long userId, Long roleId) {
        String query = new QueryBuilder()
                .insert()
                .into()
                .table(USER_ROLE_TABLE)
                .insertValues(new String[]{USER_COLUMN, ROLE_COLUMN})
                .build();
        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setLong(1, userId);
            statement.setLong(2, roleId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> findByRole(Long roleId) throws SQLException { // TODO implement via QueryBuilder!
        String query = "SELECT * FROM user \n" +
                "INNER JOIN user_role ON user_role.id = user.role_id\n" +
                "where user_role.id = ?";
        return getEntityListByQuery(query, roleId);
    }

    public static UserDaoImpl getInstance(Connection connection) {
        return new UserDaoImpl(connection);
    }

    @Override
    protected String[] getParameterNames() {
        return new String[]{FIRST_NAME, LAST_NAME, LOGIN, EMAIL, PASSWORD, ROLE_ID};
    }

    @Override
    protected void setEntityParameters(User user, PreparedStatement statement) throws SQLException {
        statement.setString(1, user.getFirstName());
        statement.setString(2, user.getLastName());
        statement.setString(3, user.getLogin());
        statement.setString(4, user.getEmail());
        statement.setString(5, user.getPassword());
        statement.setInt(6, DEFAULT_ROLE_ID);
    }

    @Override
    protected User getEntityFromResultSet(ResultSet resultSet) throws SQLException {
        Long id = Long.valueOf(resultSet.getString(ID));
        String firstName = resultSet.getString(FIRST_NAME);
        String lastName = resultSet.getString(LAST_NAME);
        String login = resultSet.getString(LOGIN);
        String email = resultSet.getString(EMAIL);
        String password = resultSet.getString(PASSWORD);
        return new UserProxy.UserBuilder()
                .setId(id)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setLogin(login)
                .setEmail(email)
                .setPassword(password)
                .buildUserProxy();
    }
}
